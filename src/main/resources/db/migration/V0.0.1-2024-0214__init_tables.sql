-- category
create table categories
(
    id                 bigserial               not null primary key,
    name               varchar(200)            not null,
    description        text,
    created_date       timestamp default now() not null,
    created_by         varchar(50)             not null,
    last_modified_date timestamp,
    last_modified_by   varchar(50)
);

-- assets
create table assets
(
    id                 bigserial               not null primary key, -- 고유 아이디
    category_id        bigint                  not null,             -- 카테고리 아이디
    title              varchar(100)            not null,             -- 영상 제목
    description        text,                                         -- 설명
    video_fps          numeric(5, 2),                                -- video fps
    video_duration     bigint    default 0     not null,             -- video duration (s)
    created_date       timestamp default now() not null,
    created_by         varchar(50)             not null,
    last_modified_date timestamp,
    last_modified_by   varchar(50),

    foreign key (category_id) references categories (id)
);

create table assets_files
(
    id                 bigserial               not null primary key, -- 고유 아이디
    asset_id           bigint                  not null,
    file_type          varchar(20)             not null,
    file_path          varchar(500)            not null,
    file_size          bigint    default 0     not null,
    created_date       timestamp default now() not null,
    created_by         varchar(50)             not null,
    last_modified_date timestamp,
    last_modified_by   varchar(50),

    foreign key (asset_id) references assets (id)
);

create table assets_scripts
(
    id                 bigserial               not null primary key, -- 아이디
    type               varchar(50)             not null,             -- 구분
    asset_id           bigint                  not null,             -- 애셋 아이디
    in_point           bigint    default 0     not null,             -- 이벤트 시작 지점
    out_point          bigint    default 0     not null,             -- 이벤트 종료 지점
    contents           varchar(500)            not null,             -- 이벤트 내용 format: {team name} {uniform number} {player name} {event}
    description        text,                                         -- 이벤트 설명
    created_date       timestamp default now() not null,
    created_by         varchar(50)             not null,
    last_modified_date timestamp,
    last_modified_by   varchar(50),

    foreign key (asset_id) references assets (id)
);


