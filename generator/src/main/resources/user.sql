drop table if exists users;
create table users (
    id bigint auto_increment comment '主键id' primary key,
    user_name     varchar(32)  null comment '用户名',
    sex int(3) not null default 1 check(sex in (1,2)) comment '性别',
    note varchar(256) null comment '笔记'
)engine = InnoDB default charset = utf8;