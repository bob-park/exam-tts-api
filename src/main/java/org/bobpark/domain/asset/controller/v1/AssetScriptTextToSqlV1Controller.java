package org.bobpark.domain.asset.controller.v1;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.bobpark.domain.asset.model.AssetScriptResponse;
import org.bobpark.domain.asset.service.v1.AssetScriptV1Service;
import org.bobpark.domain.tts.model.v1.TextToSqlV1Request;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/assets/scripts/tts")
public class AssetScriptTextToSqlV1Controller {

    private final AssetScriptV1Service assetScriptService;

    @GetMapping(path = "")
    public List<AssetScriptResponse> textToSql(TextToSqlV1Request request) {
        return assetScriptService.textToSql(request);
    }

}
