CREATE TABLE `Member` (
`member_id` int(10) ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '用户 id',
`password` char(32) NULL COMMENT '密码',
`member_name` char(20) NULL COMMENT '用户名',
`wechat_id` char(30) NULL COMMENT '微信号',
`phone_num` char(11) NULL COMMENT '手机号码',
`register_time` char(100) NULL COMMENT '注册时间',
`latest_login_time` char(100) NULL COMMENT '最近登录时间',
PRIMARY KEY (`member_id`) 
);
CREATE TABLE `InfoSort` (
`sort_id` int(4) ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '信息分类 id',
`sort_name` char(20) NULL COMMENT '分类名称',
PRIMARY KEY (`sort_id`) 
);
CREATE TABLE `Info` (
`info_id` int(6) ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '信息 id',
`sort_id` int(4) NULL COMMENT '信息分类 id',
`public_member_id` int(10) NULL COMMENT '发布用户 id',
`good_name` char(20) NULL COMMENT '物品名称',
`good_description` char(200) NULL COMMENT '物品描述',
`status` tinyint NULL DEFAULT 0 COMMENT '发布状态（发布中0，交换完成1，取消交换-1）',
`scan_num` int NULL COMMENT '浏览量',
`deal_member_id` int(10) NULL COMMENT '成交用户 id',
PRIMARY KEY (`info_id`) 
);
CREATE TABLE `request_exchange` (
`request_id` int(8) NOT NULL COMMENT '请求 id',
`request_member_id` int(10) NULL COMMENT '请求用户 id',
`info_id` int(6) NULL COMMENT '信息 id',
`status` tinyint NULL DEFAULT 0 COMMENT '请求状态（请求中0，成交1，拒绝-1）',
PRIMARY KEY (`request_id`) 
);
CREATE TABLE `Admin` (
`admin_id` char(32) NOT NULL COMMENT '管理员id',
`password` char(32) NULL COMMENT '密码',
`admin_name` char(20) NULL COMMENT '管理员姓名',
PRIMARY KEY (`admin_id`) 
);

ALTER TABLE `request_exchange` ADD CONSTRAINT `fk_request_exchange_Info_1` FOREIGN KEY (`info_id`) REFERENCES `Info` (`info_id`);
ALTER TABLE `Info` ADD CONSTRAINT `fk_Info_Member_1` FOREIGN KEY (`public_member_id`) REFERENCES `Member` (`member_id`);
ALTER TABLE `Info` ADD CONSTRAINT `fk_Info_Member_2` FOREIGN KEY (`deal_member_id`) REFERENCES `Member` (`member_id`);
ALTER TABLE `Info` ADD CONSTRAINT `fk_Info_InfoSort_1` FOREIGN KEY (`sort_id`) REFERENCES `InfoSort` (`sort_id`);
ALTER TABLE `request_exchange` ADD CONSTRAINT `fk_request_exchange_Member_1` FOREIGN KEY (`request_member_id`) REFERENCES `Member` (`member_id`);

