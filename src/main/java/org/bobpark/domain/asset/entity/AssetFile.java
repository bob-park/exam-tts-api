package org.bobpark.domain.asset.entity;

import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.ObjectUtils.*;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

import org.apache.commons.lang3.StringUtils;

import com.malgn.common.entity.BaseEntity;
import com.malgn.common.type.asset.AssetFileType;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "assets_files")
public class AssetFile extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @Enumerated(EnumType.STRING)
    private AssetFileType fileType;

    private String filePath;
    private Long fileSize;

    @Builder
    private AssetFile(Long id, AssetFileType fileType, String filePath, Long fileSize) {

        checkArgument(isNotEmpty(fileType), "fileType must be provided.");
        checkArgument(StringUtils.isNotBlank(filePath), "filePath must be provided.");

        this.id = id;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }
}
