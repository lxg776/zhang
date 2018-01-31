/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/26 23:13:39                           */
/*==============================================================*/


/*==============================================================*/
/* Table: ucenter_oauth                                         */
/*==============================================================*/
create table ucenter_oauth
(
   oauth_id             int unsigned not null auto_increment comment '编号',
   name                 varchar(20) comment '认证方式名称',
   primary key (oauth_id)
);

alter table ucenter_oauth comment '认证方式表';

/*==============================================================*/
/* Table: ucenter_user                                          */
/*==============================================================*/
create table ucenter_user
(
   user_id              int unsigned not null auto_increment comment '编号',
   user_name            varchar(20) not null comment '昵称',
   password             varchar(32) comment '密码(MD5(密码+盐))',
   salt                 varchar(32) comment '盐',
   nickname             varchar(20) comment '昵称',
   sex                  tinyint(4) default 0 comment '性别(0:未知,1:男,2:女)',
   avatar               varchar(100) comment '头像',
   create_time          timestamp default CURRENT_TIMESTAMP comment '注册时间',
   create_ip            varchar(50) comment '注册IP地址',
   last_login_time      timestamp comment '最后登录时间',
   last_login_ip        varchar(50) comment '最后登录IP地址',
   primary key (user_id)
);

create table f_user_base_msg
(
   user_id              int unsigned not null comment '编号',
   nikename             varchar(50)  comment '昵称',
   birth_date           varchar(50) comment '出生年月',
   height               float comment '身高',
   shape                varchar(20)  comment '体型',
   year_income          varchar(20)  comment '年收入',
   month_income         varchar(20) comment '月薪',
   education            varchar(100) comment '教育',
   disposition          varchar(100) comment '性格',
   profession           varchar(20) comment '职业',
   unit_property        varchar(20) comment '单位性质',
   work_unit            varchar(20) comment '工作单位',
   work_place           varchar(20) comment '工作地点',
   house_status         varchar(20) comment '房屋状况',
   car_status           varchar(50) comment '车辆状况',
   marital_status       varchar(20) comment '婚姻状况',
   children_status      varchar(20) comment '孩子状况',
   soliloquy            VARCHAR(255) comment '内心独白',
   declaration          varchar(255) comment '交友宣言',
   primary key (user_id)
);







create table f_member_type
(
   id                   int unsigned not null auto_increment comment '编号',
   name                 varchar(50)  comment '类型名称',
   info                 text comment '类型简介',
   info_img             varchar(100) comment '简介图片',
   msg_read_status      tinyint(4) unsigned comment '能否查看收件箱(0:不能,1:可以)',
   msg_send_status      tinyint(4) unsigned comment '能否发送邮件(0:不能,1:可以)',
   view_msg_status      tinyint(4) unsigned comment '能否访问用户资料(0:不能,1:可以)',
   hongniang_status      tinyint(4) unsigned comment '是否开通红娘服务(0:不能,1:可以)',
   historyview_status   tinyint(4) unsigned comment '能否查看访问记录(0:不能,1:可以)',
   show_status          tinyint(4) default 1  comment '是否显示(0:不能,1:可以)';
   level                int unsigned DEFAULT 10 comment '等级',
   price                float  comment '开通价格',
   service_days         int  comment '服务天数',
   create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);

create table f_user_member_rel
(
   id                   int unsigned not null auto_increment comment '编号',
   user_id              int unsigned not null comment '用户id',
   member_type_id       int unsigned not null comment '会员类型id',
   beg_time             varchar(50)  comment '开始时间',
   end_time             varchar(50)  comment '结束时间',
   end_status           tinyint(4) unsigned comment '终止状态(0:没有终止,1:终止)',
   create_time          timestamp default CURRENT_TIMESTAMP comment '操作时间',
   level                int unsigned DEFAULT 10 comment '等级',
   primary key (id)
)



alter table ucenter_user  add user_name varchar(32) not Null;
alter table ucenter_user  ADD UNIQUE (user_name);


create table ucenter_identificaion
(
   user_id              int unsigned not null comment '编号',
   real_name            varchar(20) comment '真实姓名',
   idcard_type          varchar(11) comment '证件类型',
   idcard_no            varchar(30) comment '证件号码',
   idcard_imgs         varchar(255) comment '证件图片',
   cellphone            varchar(11) comment '手机号码',
   primary key (user_id)
);



alter table ucenter_user comment '用户表';

/*==============================================================*/
/* Table: ucenter_user_details                                  */
/*==============================================================*/
create table ucenter_user_details
(
   user_id              int unsigned not null comment '编号',
   signature            varchar(300) comment '个性签名',
   real_name            varchar(20) comment '真实姓名',
   birthday             timestamp comment '出生日期',
   question             varchar(100) comment '帐号安全问题',
   answer               varchar(100) comment '帐号安全答案',
   primary key (user_id)
);

alter table ucenter_user_details comment '用户详情表';

/*==============================================================*/
/* Table: ucenter_user_log                                      */
/*==============================================================*/
create table ucenter_user_log
(
   user_log_id          int unsigned not null auto_increment comment '编号',
   user_id              int unsigned comment '用户编号',
   content              varbinary(100) comment '内容',
   ip                   varchar(20) comment '操作IP地址',
   agent                varbinary(200) comment '操作环境',
   create_time          timestamp default CURRENT_TIMESTAMP comment '操作时间',
   primary key (user_log_id)
);

alter table ucenter_user_log comment '用户操作日志表';

/*==============================================================*/
/* Table: ucenter_user_oauth                                    */
/*==============================================================*/
create table ucenter_user_oauth
(
   user_oauth_id        int unsigned not null auto_increment comment '编号',
   user_id              int unsigned not null comment '帐号编号',
   oauth_id             int unsigned not null comment '认证方式编号',
   open_id              varbinary(50) not null comment '第三方ID',
   status               tinyint(4) unsigned comment '绑定状态(0:解绑,1:绑定)',
   create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   primary key (user_oauth_id)
);

alter table ucenter_user_oauth comment '用户认证方式表';

alter table ucenter_user_details add constraint FK_Reference_41 foreign key (user_id)
      references ucenter_user (user_id) on delete restrict on update restrict;

alter table ucenter_user_log add constraint FK_Reference_44 foreign key (user_id)
      references ucenter_user (user_id) on delete restrict on update restrict;

alter table ucenter_user_oauth add constraint FK_Reference_42 foreign key (user_id)
      references ucenter_user (user_id) on delete restrict on update restrict;

alter table ucenter_user_oauth add constraint FK_Reference_43 foreign key (oauth_id)
      references ucenter_oauth (oauth_id) on delete restrict on update restrict;

