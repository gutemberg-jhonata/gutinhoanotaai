create table category (
    id varchar(36) not null,
    name varchar(20) not null,
    created_at datetime not null,
    updated_at datetime,
    
    primary key (id)
);

alter table category add constraint uk_category unique (name);
