

create table f_user_details
(
   user_id              int unsigned not null comment '编号',
   real_name            varchar(20) comment '真实姓名',
   sex                  tinyint(4) default 0 comment '性别(0:未知,1:男,2:女)',
   idcard_type          varchar(11) comment '证件类型',
   idcard_no            varchar(30) comment '证件号码',
   cellphone            varchar(11) comment '手机号码',
   nickname             varchar(100) comment '昵称',
   birthdate            timestamp comment '出生年月',	
   income_monthly       varchar(100) comment '月收入',
   income_year          varchar(100) comment '年收入',
   house_state          varchar(100) comment '房屋状况',
   interest             varchar(200) comment '兴趣爱好',
   speciality           varchar(200) comment '特长优点',
   tags			varchar(200) comment '标签',
   height               float comment '身高',
   profession           varchar(100) comment '职业',
   friend_require       varchar(255) comment '对另一半得要求', 
   declaration          varchar(255) comment '交友宣言',	
   primary key (user_id)
);
create table f_activity
(
  activity_id   int unsigned not null auto_increment comment '活动编号',
  title  varchar(32) comment '标题',
  context text comment '内容',
  sign_time varchar(50) comment '报名时间',
  sign_end_time timestamp comment '报名截止时间',
  activity_time timestamp comment '活动时间',
  sponsor varchar(100) comment '主办方',
  link_man varchar(50) comment '联系人',
  sign_cost varchar(50) comment '报名费用',
  link_address varchar(50) comment '联系地址',
  activity_address varchar(50) comment '活动地址',
  attention text comment '注意事项',
  show_status varchar(100) comment '显示标识',
  primary key (activity_id)
)