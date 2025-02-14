package org.bobpark.domain.asset.model.v1;

import lombok.Builder;

import com.malgn.common.type.asset.AssetFileType;

import org.bobpark.domain.asset.entity.AssetFile;
import org.bobpark.domain.asset.model.AssetFileResponse;

@Builder
public record AssetFileV1Response(Long id,
                                  AssetFileType fileType,
                                  String filePath,
                                  Long fileSize)
    implements AssetFileResponse {

    public static AssetFileResponse from(AssetFile assetFile) {
        return AssetFileV1Response.builder()
            .id(assetFile.getId())
            .fileType(assetFile.getFileType())
            .filePath(assetFile.getFilePath())
            .fileSize(assetFile.getFileSize())
            .build();
    }

}
