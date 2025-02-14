package org.bobpark.domain.asset.controller.v1;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.common.model.Id;

import org.bobpark.domain.asset.entity.Asset;
import org.bobpark.domain.asset.model.AssetResponse;
import org.bobpark.domain.asset.service.v1.AssetV1Service;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/assets")
public class AssetV1Controller {

    private final AssetV1Service assetService;

    @GetMapping(path = "{assetId:\\d+}")
    public AssetResponse getAsset(@PathVariable long assetId) {
        return assetService.getAsset(Id.of(Asset.class, assetId));
    }

}
