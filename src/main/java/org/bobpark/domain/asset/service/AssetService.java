package org.bobpark.domain.asset.service;

import com.malgn.common.model.Id;

import org.bobpark.domain.asset.entity.Asset;
import org.bobpark.domain.asset.model.AssetResponse;

public interface AssetService {

    AssetResponse getAsset(Id<Asset, Long> assetId);

}
