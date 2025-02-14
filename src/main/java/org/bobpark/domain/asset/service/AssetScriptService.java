package org.bobpark.domain.asset.service;

import org.bobpark.domain.asset.model.AssetScriptResponse;
import org.bobpark.domain.asset.model.CreateAssetScriptRequest;

public interface AssetScriptService {

    AssetScriptResponse createScript(long assetId, CreateAssetScriptRequest createRequest);

}
