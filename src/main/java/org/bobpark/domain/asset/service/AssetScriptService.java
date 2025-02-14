package org.bobpark.domain.asset.service;

import java.util.List;

import org.bobpark.domain.asset.model.AssetScriptResponse;
import org.bobpark.domain.asset.model.CreateAssetScriptRequest;
import org.bobpark.domain.tts.model.TextToSqlRequest;

public interface AssetScriptService {

    AssetScriptResponse createScript(long assetId, CreateAssetScriptRequest createRequest);

    List<AssetScriptResponse> textToSql(TextToSqlRequest request);

}
