package org.bobpark.domain.asset.model;

import org.bobpark.domain.asset.entity.AssetScriptType;

public interface CreateAssetScriptRequest {

    AssetScriptType type();

    Long inPoint();

    Long outPoint();

    String contents();
}
