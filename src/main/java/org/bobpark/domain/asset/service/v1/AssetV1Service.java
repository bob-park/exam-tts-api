package org.bobpark.domain.asset.service.v1;

import static org.bobpark.domain.asset.model.v1.AssetV1Response.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malgn.common.exception.NotFoundException;
import com.malgn.common.model.Id;

import org.bobpark.domain.asset.entity.Asset;
import org.bobpark.domain.asset.model.AssetResponse;
import org.bobpark.domain.asset.repository.AssetRepository;
import org.bobpark.domain.asset.service.AssetService;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AssetV1Service implements AssetService {

    private final AssetRepository assetRepository;

    @Override
    public AssetResponse getAsset(Id<Asset, Long> assetId) {

        Asset asset =
            assetRepository.findById(assetId.getValue())
                .orElseThrow(() -> new NotFoundException(assetId));

        return from(asset);
    }
}
