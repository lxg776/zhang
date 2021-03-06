

create table f_user_identificaion
(
   user_id              int unsigned not null comment '编号',
   real_name            varchar(20) comment '真实姓名',
   sex                  tinyint(4) default 0 comment '性别(0:未知,1:男,2:女)',
   idcard_type          varchar(11) comment '证件类型',
   idcard_no            varchar(30) comment '证件号码',
   cellphone            varchar(11) comment '手机号码',
   primary key (user_id)
);


create table f_user_account
(
   user_id              int unsigned not null comment '编号',
   user_name            varchar(100) comment '用户名',
   user_password        varchar(100) comment '用户密码',
   birthdate            timestamp comment '出生年月',
   income_monthly       varchar(100) comment '月收入',
   income_year          varchar(100) comment '年收入',
   house_state          varchar(100) comment '房屋状况',
   interest             varchar(200) comment '兴趣爱好',
   speciality           varchar(200) comment '特长优点',
   tags			            varchar(200) comment '标签',
   height               float comment '身高',
   profession           varchar(100) comment '职业',
   friend_require       varchar(255) comment '对另一半得要求',
   declaration          varchar(255) comment '交友宣言',
   primary key (user_id)

)

create table f_greeting_temp
(
   id                   int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
   content              varchar(255) comment '问候内容',
   sort                 int(4) comment '排序',
   create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   show_status       tinyint(4) default 1 comment '显示状态(0:不显示,1:显示)',
   primary key (id)
)





create table f_sms_message
(
   id                   int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
   phone_no             varchar(100) comment '手机号',
   operation            varchar(100) comment '操作',
   appid                varchar(100) comment '应用id',
   sms_code                 varchar(100) comment '短信验证码',
   create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
)


create table f_user_living_status
(
   user_id              int unsigned not null comment '编号',
   smoking_status       tinyint(4) default 0 comment '抽烟状况(0:不抽,1:偶尔抽,2:经常抽)',
   drinking_status      tinyint(4) default 0 comment '饮酒状况(0:不喝,1:偶尔喝,2:经常喝)',
   cooking              tinyint(4) default 0 comment '厨艺(0:不下厨,1:厨艺有待提高,2:上得了厅堂，3.饭店大厨级别)',
   live_with_parents    varchar(100) comment '与父母同住情况',
   favorite_date    varchar(100) comment '喜欢怎么样的约会',
   favorite_music    varchar(100) comment '喜欢的音乐',
   favorite_film    varchar(100) comment '喜欢的电影',
   favorite_sports    varchar(100) comment '喜欢的运动',
   favorite_pet    varchar(100) comment '喜欢的运动',
   primary key (user_id)
)

select uc.*,base.*,ic.*,zo.* from ucenter_user as uc
left join f_user_base_msg as base on uc.user_id = base.user_id
left join ucenter_identificaion as ic on uc.user_id = ic.user_id
left join f_user_request as zo on uc.user_id = zo.user_id
where uc.user_id=4


create table f_user_request
(
   user_id              int unsigned not null comment '用户编号',
   sex                  varchar(10) comment '性别',
   height               varchar(20) comment '身高要求',
   shape                varchar(20) comment '体型要求',
   age                  varchar(50) comment '年龄要求',
   income_monthly       varchar(50) comment '月收入',
   income_year          varchar(50) comment '年收入',
   house_state          varchar(50) comment '房屋状况',
   education            varchar(50) comment '学历',
   marital_status       varchar(50) comment '婚姻状况',
   house_status         varchar(50) comment '房屋状况',
   car_status           varchar(50) comment '车辆状况',
   job                  varchar(50) comment '工作状况',
   friend_require       varchar(255) comment '对另一半得要求',
   drink_status         varchar(50) comment '饮酒情况',
   child_status         varchar(50) comment '孩子情况',
   smoke_status         varchar(50) comment '抽烟情况',
   living_status        varchar(50) comment '是否与父母同住',
   primary key (user_id)

);
alter table f_user_base_msg  add avatar varchar(200);

create table f_message
(
   id                   int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
   from_user_id         int(10) unsigned NOT NULL comment '发送者ID',
   to_user_id           int(10) unsigned NOT NULL  comment '接受者ID',
   msg_content          varchar(255) comment '消息内容',
   msg_state            tinyint(4) default 0 comment '抽烟状况(0:未读,1:已读)',
   create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);
select count(id) as unReadcount ,base.*  from f_message as m left join f_user_base_msg as base on m.from_user_id = base.user_id where to_user_id =6 and msg_state = 0  group by m.from_user_id order by m.create_time desc;

create table f_user_view_record
(
   id             int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
   f_user_id             int(10) unsigned NOT NULL  COMMENT '访问人id',
   b_user_id             int(10) unsigned NOT NULL  COMMENT '被访问人id',
   view_time          timestamp default CURRENT_TIMESTAMP comment '访问时间',
   primary key (id)
)
create table f_user_images
(
   id                  int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
   user_id             int(10) unsigned NOT NULL  COMMENT '用户id',
   imnage_path         varchar(255) comment '图片的地址',
   key                 varchar(10)  comment '关键字',
   create_time          timestamp default CURRENT_TIMESTAMP comment '注册时间',
   primary key (id)
);



create table f_contact
(
   id                  int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
   f_user_id             int(10) unsigned NOT NULL  COMMENT '来自用户',
   t_user_id             int(10) unsigned NOT NULL  COMMENT '要求联系的用户',
   contact_count      int(10) unsigned  DEFAULT 1 COMMENT '联系次数',
   both_status       tinyint(4) default 0 comment '双方状况(0:不是双方,1双方都要去联系对方)',
   remarks             text COMMENT '备注',
   create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
   primary key (id)
);





create table f_user_setting
(
   user_id              int unsigned not null comment '编号',
   show_index_page             tinyint(4) default 0 comment '首页能否显示(0:能,1:不能)',
   show_base_msg            tinyint(4) default 0 comment '基本信息能否显示(0:能,1:不能)',
   show_friend_request            tinyint(4) default 0 comment '择偶要求能否显示(0:能,1:不能)',
   show_living_status            tinyint(4) default 0 comment '生活状况能否显示(0:能,1:不能)',
   show_favorite            tinyint(4) default 0 comment '生活状况能否显示(0:能,1:不能)',
   msg_read_status      tinyint(4) default 0  comment '能否查看收件箱(0:不能,1:可以)',
   msg_send_status      tinyint(4) default 0  comment '能否发送邮件(0:不能,1:可以)',
   view_msg_status      tinyint(4) default 1  comment '能否访问用户资料(0:不能,1:可以)',
   hongniang_status     tinyint(4) default 0  comment '是否开通红娘服务(0:不能,1:可以)',
   historyview_status   tinyint(4) default 1  comment '能否查看访问记录(0:不能,1:可以)',
   primary key (user_id)
);


create table f_user_order
(
   id                  int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
   user_id              int unsigned not null comment '用户id',
   pay_in_order_id              int unsigned not null comment '订单id',
   primary key (id)
);


create table f_activity
(
  activity_id   int unsigned not null auto_increment comment '活动编号',
  title  varchar(102) comment '标题',
  content text comment '内容',
  sign_time varchar(50) comment '报名时间',
  sign_end_time varchar(50)  comment '报名截止时间',
  activity_time varchar(50)  comment '活动时间',
  sponsor varchar(100) comment '主办方',
  link_man varchar(50) comment '联系人',
  sign_cost varchar(50) comment '报名费用',
  link_address varchar(50) comment '联系地址',
   link_phone varchar(50) comment '联系电话',
  activity_address varchar(50) comment '活动地址',
  attention text comment '注意事项',
  show_status varchar(100) comment '显示标识',
  ctime bigint(20) DEFAULT NULL COMMENT '创建时间',
  cover_image VARCHAR (100) comment '封面图片',
  primary key (activity_id)
)