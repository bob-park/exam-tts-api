package org.bobpark.domain.tts.service;

import org.bobpark.domain.tts.model.TextToSqlRequest;
import org.bobpark.domain.tts.model.TextToSqlResponse;

public interface TextToSqlService {

    TextToSqlResponse textToSql(TextToSqlRequest request);

}
