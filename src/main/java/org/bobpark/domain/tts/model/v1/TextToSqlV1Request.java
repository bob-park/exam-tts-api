package org.bobpark.domain.tts.model.v1;

import org.bobpark.domain.tts.model.TextToSqlRequest;

public record TextToSqlV1Request(String query)
    implements TextToSqlRequest {
}
