-- begin COMPCOMP_FOO
create table COMPCOMP_FOO (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    LIMIT_ integer,
    --
    primary key (ID)
)^
-- end COMPCOMP_FOO
