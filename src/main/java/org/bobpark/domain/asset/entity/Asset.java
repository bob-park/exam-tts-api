package org.bobpark.domain.asset.entity;

import static com.google.common.base.Preconditions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

import org.apache.commons.lang3.StringUtils;

import com.malgn.common.entity.BaseEntity;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "assets")
public class Asset extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal videoFps;
    private Long videoDuration;

    @Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "asset")
    private List<AssetFile> files = new ArrayList<>();

    @Builder
    private Asset(Long id, String title, String description, BigDecimal videoFps, Long videoDuration) {

        checkArgument(StringUtils.isNotBlank(title), "title must be provided.");

        this.id = id;
        this.title = title;
        this.description = description;
        this.videoFps = videoFps;
        this.videoDuration = videoDuration;
    }
}
