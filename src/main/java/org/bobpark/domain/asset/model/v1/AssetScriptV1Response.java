package org.bobpark.domain.asset.model.v1;

import java.time.LocalDateTime;

import lombok.Builder;

import org.bobpark.domain.asset.entity.AssetScript;
import org.bobpark.domain.asset.entity.AssetScriptType;
import org.bobpark.domain.asset.model.AssetScriptResponse;

@Builder
public record AssetScriptV1Response(Long id,
                                    AssetScriptType type,
                                    Long assetId,
                                    Long inPoint,
                                    Long outPoint,
                                    String contents,
                                    String description,
                                    LocalDateTime createdDate,
                                    String createdBy,
                                    LocalDateTime lastModifiedDate,
                                    String lastModifiedBy)
    implements AssetScriptResponse {

    public static AssetScriptResponse from(AssetScript script) {
        return AssetScriptV1Response.builder()
            .id(script.getId())
            .type(script.getType())
            .assetId(script.getAssetId())
            .inPoint(script.getInPoint())
            .outPoint(script.getOutPoint())
            .contents(script.getContents())
            .description(script.getDescription())
            .createdDate(script.getCreatedDate())
            .createdBy(script.getContents())
            .lastModifiedDate(script.getLastModifiedDate())
            .lastModifiedBy(script.getLastModifiedBy())
            .build();
    }
}
