create database mq_mall;
use mq_mall;
create table sec_kill
(
    sec_kill_id bigint       not null auto_increment comment '商品库存id',
    name        varchar(120) not null comment '商品名称',
    number      int          not null comment '库存数量',
    start_time  timestamp    not null default current_timestamp comment '秒杀开始时间',
    end_time    timestamp    not null default current_timestamp comment '秒杀结束时间',
    create_time timestamp    not null default current_timestamp comment '创建时间',
    primary key (sec_kill_id),
    key idx_start_time (start_time),
    key idx_end_time (end_time),
    key idx_create_time (create_time)
) engine = InnoDB
  auto_increment = 1000
  default charset = utf8 comment ='秒杀库存表';
insert into sec_kill(name, number, start_time, end_time)
values ('1000元秒杀iPhoneXS', 100, '2019-07-16 00:00:00', '2019-07-17 00:00:00'),
       ('500元秒杀iPad2', 200, '2019-07-16 00:00:00', '2019-10-16 00:00:00'),
       ('300元秒杀小米9', 300, '2019-07-16 00:00:00', '2019-07-17 00:00:00'),
       ('200元秒杀红米Note3', 400, '2019-09-16 00:00:00', '2019-09-17 00:00:00');

create table success_killed
(
    sec_kill_id bigint      not null comment '秒杀商品id',
    user_phone  bigint      not null comment '用户手机号',
    state       tinyint     not null default 0 comment '-1:无效 0:成功 1:已付款 2:已发货',
    state_info   varchar(10) not null default '成功' comment '状态描述',
    create_time timestamp   not null default current_timestamp comment '创建时间',
    primary key (sec_kill_id, user_phone),
    key idx_create_time (create_time)
) engine = InnoDB
  default charset = utf8 comment ='秒杀成功明细表';

