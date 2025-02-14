package org.bobpark.domain.asset.model.v1;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;

import org.bobpark.domain.asset.entity.Asset;
import org.bobpark.domain.asset.model.AssetFileResponse;
import org.bobpark.domain.asset.model.AssetResponse;

@Builder
public record AssetV1Response(Long id,
                              String title,
                              BigDecimal videoFps,
                              Long videoDuration,
                              List<AssetFileResponse> files)
    implements AssetResponse {

    public static AssetResponse from(Asset asset) {
        return AssetV1Response.builder()
            .id(asset.getId())
            .title(asset.getTitle())
            .videoFps(asset.getVideoFps())
            .videoDuration(asset.getVideoDuration())
            .files(
                asset.getFiles().stream()
                    .map(AssetFileV1Response::from)
                    .toList())
            .build();
    }

}
