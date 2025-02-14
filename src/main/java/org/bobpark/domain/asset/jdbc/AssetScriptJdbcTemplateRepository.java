package org.bobpark.domain.asset.jdbc;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import org.bobpark.domain.asset.model.AssetScriptResponse;
import org.bobpark.domain.asset.model.v1.AssetScriptV1Response;

@Slf4j
@RequiredArgsConstructor
@Component
public class AssetScriptJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<AssetScriptResponse> rowMapper = (rs, rowNum) ->
        AssetScriptV1Response.builder()
            .id(rs.getLong("id"))
            .assetId(rs.getLong("asset_id"))
            .inPoint(rs.getLong("in_point"))
            .outPoint(rs.getLong("out_point"))
            .contents(rs.getString("contents"))
            .description(rs.getString("description"))
            .build();

    public List<AssetScriptResponse> executeQuery(String sql) {
        return jdbcTemplate.query(sql, rowMapper);
    }

}
