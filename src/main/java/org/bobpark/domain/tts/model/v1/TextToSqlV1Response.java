package org.bobpark.domain.tts.model.v1;

import lombok.Builder;

import org.bobpark.domain.tts.model.TextToSqlResponse;

@Builder
public record TextToSqlV1Response(String sql)
    implements TextToSqlResponse {

    public static TextToSqlV1Response from(String sql) {
        return TextToSqlV1Response.builder()
            .sql(sql)
            .build();
    }
}
