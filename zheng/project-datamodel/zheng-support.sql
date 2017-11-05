/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/26 23:13:39                           */
/*==============================================================*/



create table support_user_msg
(
   user_id              int unsigned not null auto_increment comment '编号',
   read_name             varchar(32) comment '真实姓名',
   id_card                 varchar(32) comment '身份证',
   nickname             varchar(20) comment '昵称',
   phone_num             int(11)  comment '手机号码',
   email               varchar(100) comment '邮箱',
   create_time          timestamp default CURRENT_TIMESTAMP comment '注册时间',
   primary key (user_id)
);


create table f_require_condition
(
  user_id   int unsigned not null auto_increment comment '编号',
  r_sex  varchar(32) comment '性别',
  r_age  varchar(32) comment '年龄',
  r_height varchar(32) comment '身高',
  r_shape varchar(32) comment '体型',
  r_education varchar(50) comment '学历',
  r_profession varchar(50) comment '职业',
  r_workarea varchar(50) comment '工作区域',
  r_workarea varchar(50) comment '工作区域',
  r_marital_status varchar(50) comment '婚姻状况',
  r_child_status varchar(50) comment '孩子状况',
  r_is_smoking varchar(50) comment '是否抽烟',
  r_is_drink varchar(50) comment '是否喝酒',
   primary key (user_id)
)



create table f_activity
(
  activity_id   int unsigned not null auto_increment comment '活动编号',
  title  varchar(32) comment '标题',
  context text comment '内容',
  sign_time varchar(50) comment '报名时间',
  activity_time varchar(50) comment '活动时间',
  link_man varchar(50) comment '联系人',
  link_address varchar(50) comment '联系地址',
  activity_address varchar(50) comment '活动地址',
  attention text comment '注意事项',
  people_num varchar(100) comment '活动人数',
  primary key (activity_id)
)

create table f_user_activity
(
  id   int unsigned not null auto_increment comment '活动编号',
  activity_id  int unsigned ,
  user_id  int unsigned ,
  status int comment '审核状态',
  createTime TIMESTAMP comment '创建时间',
  fee_status varchar(50) comment '缴费情况',
  primary key (id)
)

create table f_view_record
(
  id   int unsigned not null auto_increment comment '活动编号',
  q_user_id  int unsigned ,
  b_user_id  int unsigned ,
  viewTime TIMESTAMP comment '创建时间',
  fee_status varchar(50) comment '缴费情况',
  primary key (id)
)