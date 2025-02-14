package org.bobpark.domain.asset.model;

import org.bobpark.domain.asset.entity.AssetScriptType;

import com.malgn.common.model.CommonResponse;

public interface AssetScriptResponse extends CommonResponse {

    Long id();

    AssetScriptType type();

    // TODO 추후 DTO 로 변경
    Long assetId();

    Long inPoint();

    Long outPoint();

    String contents();

    String description();

}
