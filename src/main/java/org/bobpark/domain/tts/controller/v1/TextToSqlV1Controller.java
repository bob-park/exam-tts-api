package org.bobpark.domain.tts.controller.v1;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.bobpark.domain.tts.model.TextToSqlResponse;
import org.bobpark.domain.tts.model.v1.TextToSqlV1Request;
import org.bobpark.domain.tts.service.v1.TextToSqlV1Service;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/tts")
public class TextToSqlV1Controller {

    private final TextToSqlV1Service ttsService;

    @GetMapping(path = "")
    public TextToSqlResponse textToSql(TextToSqlV1Request request) {
        return ttsService.textToSql(request);
    }

}
