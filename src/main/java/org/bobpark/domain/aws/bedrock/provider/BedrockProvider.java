package org.bobpark.domain.aws.bedrock.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import org.apache.commons.lang3.StringUtils;

import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.ContentBlock;
import software.amazon.awssdk.services.bedrockruntime.model.ConversationRole;
import software.amazon.awssdk.services.bedrockruntime.model.ConverseResponse;
import software.amazon.awssdk.services.bedrockruntime.model.Message;

import com.malgn.common.exception.ServiceRuntimeException;

import org.bobpark.configure.aws.properties.AwsBedrockProperties;

@Slf4j
@RequiredArgsConstructor
@Component
public class BedrockProvider {

    public static final String DEFAULT_TEMPLATE = """
        Create a PosrgreSQL query with the following requirements:
        
        1. Follow proper SQL syntax.
        2. Use the syntax "OFFSET start LIMIT count" for pagination.
        3. "SELECT" clause, Please only whildcard.
        4. "FROM" clause, Please only table name.
        5. If you exceed one word in the like grammar, please separate it.
        6. Ensure the query does not have any syntax errors and is fully compatible with standard SQL conventions.
        7. Format as one line.
        8. remove semicolon end of query.
        9. NEVER ADD EXPLANATIONS COMMENTS IT'S DANGEROUS.
        10. Similar words are as follows.
        [
            {
                "words": ["득점"],
                "similarWords": ["성공"]
            }
        ]
        
        
        Schema:
        [
            {
                "database": "tts",
                "table_name": "assets",
                "description": "경기 영상 정보",
                "columns": [
                    {
                        "name": "id",
                        "type": "bigint",
                        "description": "애셋 아이디"
                    },
                    {
                        "name": "title",
                        "type": "string",
                        "description": "경기 영상 제목",
                        "format": "{home team name} vs {away team name} ({yyyy.MM.dd})"
                    }
                ]
             },
            {
                "database": "tts",
                "table_name": "assets_scripts",
                "description": "경기 이벤트 정보",
                "columns": [
                    {
                        "name": "id",
                        "type": "bigint",
                        "description": "고유 아이디"
                    },
                    {
                        "name": "in_point",
                        "type": "bigint",
                        "description": "이벤트 시작 지점 (frame 단위)"
                    },
                    {
                        "name": "out_point",
                        "type": "bigint",
                        "description": "이벤트 종료 지점 (frame 단위)"
                    },
                    {
                        "name": "contents",
                        "type": "string",
                        "description": "이벤트 내용",
                        "format": "{team name} {uniform number} {player name} {event}"
                    },
                    {
                        "name": "asset_id",
                        "type": "bigint",
                        "description": "경기 영상 아이디",
                        "foreignKey": {
                            "table": "assets",
                            "column": "id"
                        }
                    }
                ]
             }
        ]
        
        User Instruction: {{naturalLanguageQuery}}
        """;

    private final AwsBedrockProperties properties;
    private final BedrockRuntimeClient client;

    public String textToSql(String natualQuery) {

        String messageBuilder = StringUtils.replace(DEFAULT_TEMPLATE, "{{naturalLanguageQuery}}", natualQuery);

        log.debug("message: \n{}", messageBuilder);

        Message message =
            Message.builder()
                .content(ContentBlock.fromText(messageBuilder))
                .role(ConversationRole.USER)
                .build();

        try {
            ConverseResponse response =
                client.converse(request -> request
                    .modelId(properties.modelId())
                    .messages(message)
                    .inferenceConfig(config -> config
                        .maxTokens(512)
                        .temperature(0.5F)
                        .topP(0.9F)));

            return response.output().message().content().get(0).text();

        } catch (SdkClientException e) {
            log.error("SdkClientException: {}", e.getMessage());
            throw new ServiceRuntimeException(e);
        }

    }

}
