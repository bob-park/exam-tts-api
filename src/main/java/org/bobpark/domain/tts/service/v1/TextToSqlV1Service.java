package org.bobpark.domain.tts.service.v1;

import static com.google.common.base.Preconditions.*;
import static org.bobpark.domain.tts.model.v1.TextToSqlV1Response.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;

import org.bobpark.domain.aws.bedrock.provider.BedrockProvider;
import org.bobpark.domain.tts.model.TextToSqlRequest;
import org.bobpark.domain.tts.model.TextToSqlResponse;
import org.bobpark.domain.tts.model.v1.TextToSqlV1Request;
import org.bobpark.domain.tts.service.TextToSqlService;

@Slf4j
@RequiredArgsConstructor
@Service
public class TextToSqlV1Service implements TextToSqlService {

    private final BedrockProvider provider;

    @Override
    public TextToSqlResponse textToSql(TextToSqlRequest request) {

        TextToSqlV1Request v1Request = (TextToSqlV1Request)request;

        checkArgument(StringUtils.isNotBlank(v1Request.query()), "query must be provided.");

        String sql = provider.textToSql(v1Request.query());

        return from(sql);
    }
}
