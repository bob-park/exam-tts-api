package org.bobpark.domain.asset.model.v1;

import lombok.Builder;

import org.bobpark.domain.asset.entity.AssetScriptType;
import org.bobpark.domain.asset.model.CreateAssetScriptRequest;

@Builder
public record CreateAssetScriptV1Request(AssetScriptType type,
                                         Long inPoint,
                                         Long outPoint,
                                         String contents,
                                         String description)
    implements CreateAssetScriptRequest {
}
