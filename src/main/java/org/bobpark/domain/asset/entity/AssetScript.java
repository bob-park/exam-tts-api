package org.bobpark.domain.asset.entity;

import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.ObjectUtils.*;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.apache.commons.lang3.StringUtils;

import com.malgn.common.entity.BaseEntity;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "assets_scripts")
public class AssetScript extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AssetScriptType type;

    // TODO 추후 entity 로 변경
    private Long assetId;

    private Long inPoint;
    private Long outPoint;

    private String contents;
    private String description;

    @Builder
    private AssetScript(AssetScriptType type, Long assetId, Long inPoint, Long outPoint, String contents,
        String description) {

        checkArgument(isNotEmpty(type), "type must be provided.");
        checkArgument(isNotEmpty(assetId), "assetId must be provided.");
        checkArgument(isNotEmpty(inPoint), "inPoint must be provided.");
        checkArgument(isNotEmpty(outPoint), "outPoint must be provided.");
        checkArgument(StringUtils.isNotBlank(contents), "contents must be provided.");

        checkArgument(outPoint >= inPoint, "outPoint must be greater than or equal to inPoint.");

        this.type = type;
        this.assetId = assetId;
        this.inPoint = inPoint;
        this.outPoint = outPoint;
        this.contents = contents;
        this.description = description;
    }

}
