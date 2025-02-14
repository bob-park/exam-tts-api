package org.bobpark.domain.asset.service.v1;

import static org.bobpark.domain.asset.model.v1.AssetScriptV1Response.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.bobpark.domain.asset.entity.AssetScript;
import org.bobpark.domain.asset.model.AssetScriptResponse;
import org.bobpark.domain.asset.model.CreateAssetScriptRequest;
import org.bobpark.domain.asset.model.v1.CreateAssetScriptV1Request;
import org.bobpark.domain.asset.repository.AssetScriptRepository;
import org.bobpark.domain.asset.service.AssetScriptService;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class AssetScriptV1Service implements AssetScriptService {

    private final AssetScriptRepository assetScriptRepository;

    @Transactional
    @Override
    public AssetScriptResponse createScript(long assetId, CreateAssetScriptRequest createRequest) {

        CreateAssetScriptV1Request createV1Request = (CreateAssetScriptV1Request)createRequest;

        AssetScript createdAssetScript =
            AssetScript.builder()
                .assetId(assetId)
                .type(createV1Request.type())
                .inPoint(createV1Request.inPoint())
                .outPoint(createV1Request.outPoint())
                .contents(createV1Request.contents())
                .description(createV1Request.description())
                .build();

        createdAssetScript = assetScriptRepository.save(createdAssetScript);

        log.debug("created asset script: {}", createdAssetScript);

        return from(createdAssetScript);
    }
}
