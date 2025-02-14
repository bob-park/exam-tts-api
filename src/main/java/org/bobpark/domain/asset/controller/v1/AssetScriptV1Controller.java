package org.bobpark.domain.asset.controller.v1;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.bobpark.domain.asset.model.AssetScriptResponse;
import org.bobpark.domain.asset.model.v1.CreateAssetScriptV1Request;
import org.bobpark.domain.asset.service.v1.AssetScriptV1Service;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "v1/assets/{assetId:\\d+}/scripts")
public class AssetScriptV1Controller {

    private final AssetScriptV1Service assetScriptService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "")
    public AssetScriptResponse createScript(@PathVariable long assetId,
        @RequestBody CreateAssetScriptV1Request createRequest) {
        return assetScriptService.createScript(assetId, createRequest);
    }

}
