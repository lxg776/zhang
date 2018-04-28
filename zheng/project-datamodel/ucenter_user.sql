/*
 Navicat MySQL Data Transfer

 Source Server         : zheng
 Source Server Version : 50169
 Source Host           : 222.83.250.251
 Source Database       : web6_gxbs_net

 Target Server Version : 50169
 File Encoding         : utf-8

 Date: 04/14/2018 18:58:51 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cpw_user`
-- ----------------------------
DROP TABLE IF EXISTS `cpw_user`;
CREATE TABLE `cpw_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码(MD5(密码+盐))',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(4) DEFAULT '0' COMMENT '性别(0:未知,1:男,2:女)',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `create_ip` varchar(50) DEFAULT NULL COMMENT '注册IP地址',
  `last_login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后登录时间',
  `last_login_ip` varchar(50) DEFAULT NULL COMMENT '最后登录IP地址',
  `user_name` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='用户表';


create table cpw_news
(
   id                   int unsigned not null comment '编号',
   title            varchar(100) comment '标题',
   create        varchar(100) comment '创建时间',
   cover            varchar(100) comment '',
   link       varchar(100) comment '链接',
   begin          varchar(100) comment '开始时间',
   end          varchar(100) comment '房屋状况',
   timeState             varchar(200) comment '兴趣爱好',
   author           varchar(200) comment '特长优点',
   source			            varchar(200) comment '标签',
   origin               varchar(200) comment '身高',
   content           text comment '职业',
   bootContent       varchar(255) comment 'bootContent',
   bootType          varchar(255) comment 'bootType',
   readCount          varchar(255) comment '浏览次数',
   primary key (id)

)


-- ----------------------------
--  Records of `cpw_user`
-- ----------------------------
BEGIN;
INSERT INTO `cpw_user` VALUES ('4', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', 'liangxg', '2', null, '2017-11-15 20:51:32', null, '2017-11-15 20:51:32', null, 'test02'), ('6', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', '20180115/tsXdTsqGkD3B9Hu4IQdl4et8LPguZ17R.png', '2018-01-15 21:42:37', '127.0.0.1', '2018-01-15 21:42:37', null, '18825208133'), ('7', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', 'hcn', '1', null, '2017-12-08 21:08:51', null, '2017-12-08 21:08:51', null, 'hcn'), ('8', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', 'liaxia520', '2', null, '2017-12-11 18:59:44', null, '2017-12-11 18:59:44', null, 'liaxia520'), ('9', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', '', '1', null, '2017-12-19 18:06:45', null, '2017-12-19 18:06:45', null, 'test991'), ('14', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', '', '1', null, '2017-12-19 19:39:00', '127.0.0.1', '2017-12-19 19:39:00', null, '18825208144'), ('15', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', '', '2', null, '2017-12-21 21:39:33', '127.0.0.1', '2017-12-21 21:39:33', null, '18825208143'), ('16', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', '', '2', null, '2017-12-21 22:47:50', '127.0.0.1', '2017-12-21 22:47:50', null, '18825208145'), ('17', '18A03C2D5E44E32C9476E6D09AB300E2', 'friend', 'liangxg', '1', null, '2017-12-21 22:50:54', '127.0.0.1', '2017-12-21 22:50:54', null, '18825208155'), ('18', '', 'friend', '', '1', null, '2017-12-21 23:01:49', '127.0.0.1', '2017-12-21 23:01:49', null, '18825208141'), ('19', '', 'friend', '', '2', null, '2017-12-21 23:02:38', '127.0.0.1', '2017-12-21 23:02:38', null, '18825208142'), ('20', '', 'friend', '', '1', null, '2017-12-21 23:23:04', '127.0.0.1', '2017-12-21 23:23:04', null, '18825208112'), ('21', '', 'friend', '', '1', null, '2017-12-21 23:25:14', '127.0.0.1', '2017-12-21 23:25:14', null, '18825208113'), ('22', '', 'friend', '', '1', null, '2017-12-21 23:30:55', '127.0.0.1', '2017-12-21 23:30:55', null, '18825207133'), ('23', '', 'friend', 'haha123', '2', null, '2017-12-22 21:10:52', '127.0.0.1', '2017-12-22 21:10:52', null, '18825208433'), ('24', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 17:37:47', '127.0.0.1', '2017-12-23 17:37:47', null, '18825209133'), ('25', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 17:54:58', '127.0.0.1', '2017-12-23 17:54:58', null, '18825204133'), ('26', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 20:03:38', '127.0.0.1', '2017-12-23 20:03:38', null, '18825204233'), ('27', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 20:21:01', '127.0.0.1', '2017-12-23 20:21:01', null, '18825205233'), ('28', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 20:38:01', '127.0.0.1', '2017-12-23 20:38:01', null, '18825206233'), ('29', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 21:20:11', '127.0.0.1', '2017-12-23 21:20:11', null, '18825206234'), ('30', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 21:24:04', '127.0.0.1', '2017-12-23 21:24:04', null, '18825206235'), ('31', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 22:46:27', '127.0.0.1', '2017-12-23 22:46:27', null, '18825208199'), ('32', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 22:06:32', '127.0.0.1', '2017-12-23 22:06:32', null, '18825206339'), ('33', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 22:12:23', '127.0.0.1', '2017-12-23 22:12:23', null, '18825206312'), ('34', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 22:14:57', '127.0.0.1', '2017-12-23 22:14:57', null, '18825206313'), ('35', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-23 22:22:17', '127.0.0.1', '2017-12-23 22:22:17', null, '18823418133'), ('36', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, null, '2017-12-24 20:44:39', '127.0.0.1', '2017-12-24 20:44:39', null, '18987908976'), ('37', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', null, '2017-12-24 21:43:10', '127.0.0.1', '2017-12-24 21:43:10', null, '18825201249'), ('38', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', null, '2018-01-14 17:22:45', '127.0.0.1', '2018-01-14 17:22:45', null, 'test9981'), ('39', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', '20180115/OniLCS4lIbT01yJtiZvYNoLJZ07wqIZJ.png', '2018-01-15 21:26:50', '127.0.0.1', '2018-01-15 21:26:50', null, 'test9982'), ('40', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180115/XhawGxRbs7vebuBY8IFKyGjRvcSjQpUV.png', '2018-01-15 21:37:04', '127.0.0.1', '2018-01-15 21:37:04', null, '18825201233'), ('41', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', '20180204/6rCv9KWdweUZqaSSpgRViYxbxbGF4oxk.jpg', '2018-02-04 14:28:03', '127.0.0.1', '2018-02-04 14:28:03', null, '13471627642'), ('43', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', null, '2018-02-04 15:04:03', '127.0.0.1', '2018-02-04 15:04:03', null, '13471627643'), ('45', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', '20180204/YK0u1J2rG7OqtNuY9CIJh6pHL9XUGZwj.png', '2018-02-04 15:59:16', '127.0.0.1', '2018-02-04 15:59:16', null, '13471627644'), ('47', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180204/rZg2dB2lXFmYaMcujf3ncm6j2QR12pch.png', '2018-02-04 16:24:51', '127.0.0.1', '2018-02-04 16:24:51', null, '13471627645'), ('49', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180204/p3PPwFnhWp5eC2z9RAJr45xCDLwu4Kcz.png', '2018-02-04 16:44:51', '127.0.0.1', '2018-02-04 16:44:51', null, '13471627646'), ('51', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180204/LPfZm8YDmoX4n7oBJ8u0KDXd17xmMXbr.png', '2018-02-04 16:54:47', '127.0.0.1', '2018-02-04 16:54:47', null, '13471627647'), ('53', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/XoYQvJoIN2A0Ruf7o56OYROIEH6Oy83X.png', '2018-02-06 20:38:24', '127.0.0.1', '2018-02-06 20:38:24', null, '13471627648'), ('55', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/Lju3ZX55LbkJHMXu36WuXSOR2zZ68MdY.png', '2018-02-06 20:43:03', '127.0.0.1', '2018-02-06 20:43:03', null, '13471627649'), ('57', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/YKUTUh2vCTlL38DoCkJ0kNJSPq6Og5xm.jpg', '2018-02-06 20:45:47', '127.0.0.1', '2018-02-06 20:45:47', null, '13471627651'), ('59', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/tWtFa0JZewr43R48iPUbqvuaZ22nChMP.png', '2018-02-06 20:57:05', '127.0.0.1', '2018-02-06 20:57:05', null, '13471627652'), ('61', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/kO9uP3Ue3zorjgT7tr4KlLSabafF8D5i.jpg', '2018-02-06 21:02:06', '127.0.0.1', '2018-02-06 21:02:06', null, '13471627653'), ('63', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/LVxYZt3PTv8gTHtjJ05P8bm51X3GkJMy.png', '2018-02-06 21:04:48', '127.0.0.1', '2018-02-06 21:04:48', null, '13471627654'), ('65', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/gZLsjxZgQn20GjupzeBr5kQEBkmKSvsC.png', '2018-02-06 21:09:41', '127.0.0.1', '2018-02-06 21:09:41', null, '13471627655'), ('67', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/ENaPTzjSAGbpAsArL9j0Mm3GOF64sVcn.jpg', '2018-02-06 21:12:31', '127.0.0.1', '2018-02-06 21:12:31', null, '13471627656'), ('69', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', null, '2018-02-06 21:16:19', '127.0.0.1', '2018-02-06 21:16:19', null, '13471627657'), ('71', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/8HMHyKHSnHdYOuBuOJnDZgGsghsKa0ev.jpg', '2018-02-06 21:18:14', '127.0.0.1', '2018-02-06 21:18:14', null, '13471627658'), ('73', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/ps5GZ4pKuRvwLmo6iTfQScltwlmb1GKr.jpg', '2018-02-06 21:24:07', '127.0.0.1', '2018-02-06 21:24:07', null, '13471627660'), ('75', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180206/ApnyA1WLb49tLaGmHjFTqoldpki43vwi.png', '2018-02-06 21:47:46', '127.0.0.1', '2018-02-06 21:47:46', null, '13471627662'), ('77', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', null, '2018-03-16 11:09:51', '127.0.0.1', '2018-03-16 11:09:51', null, '19089898881'), ('79', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', null, '2018-03-16 11:11:57', '127.0.0.1', '2018-03-16 11:11:57', null, '19089898882'), ('81', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, null, '20180316/x57TKoDaSOyDUz4RIgWIM5MnozZgb2za.png', '2018-03-16 11:16:51', '127.0.0.1', '2018-03-16 11:16:51', null, '19289898881'), ('83', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', null, '2018-03-16 11:25:32', '127.0.0.1', '2018-03-16 11:25:32', null, '13477779999'), ('85', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180319/JrmnI0wHImA4yFGeOQuUqXh8BdQT6EBK.png', '2018-03-19 16:35:50', '127.0.0.1', '2018-03-19 16:35:50', null, '15964661111'), ('87', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', null, '2018-03-19 16:41:58', '127.0.0.1', '2018-03-19 16:41:58', null, '17779998565'), ('89', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', null, '2018-03-19 16:46:43', '127.0.0.1', '2018-03-19 16:46:43', null, '19089898888'), ('91', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '1', '20180319/f6ClsDSrEnsy5ooftHB5Ie45wLP3CZmg.png', '2018-03-19 16:54:29', '127.0.0.1', '2018-03-19 16:54:29', null, '17779998564'), ('93', '41EB42EC3918B0F55DD1F9771BD11421', 'friend', null, '2', null, '2018-03-21 15:15:37', '127.0.0.1', '2018-03-21 15:15:37', null, '19089898884');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
