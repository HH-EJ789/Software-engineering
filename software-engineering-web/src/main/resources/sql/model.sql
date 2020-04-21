CREATE TABLE `Order` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`order_num` char(100) NOT NULL COMMENT '订单号',
`create_time` char(100) NULL COMMENT '创建时间',
`pay_time` char(100) NULL COMMENT '付款时间',
`complete_time` char(100) NULL COMMENT '完成时间',
`order_amount` decimal(10,5) NULL COMMENT '订单金额',
`real_amount` decimal(10,5) NULL COMMENT '实付款',
`order_remark` char(100) NULL COMMENT '订单备注',
`address_id` char(100) NULL COMMENT '收货地址 id',
`coupon_id` char(100) NULL COMMENT '空或者优惠卷 id',
`is_cancel` int NULL DEFAULT 0 COMMENT '订单是否取消（默认0，取消1）',
PRIMARY KEY (`id`, `order_num`) 
);
CREATE TABLE `ReceiveGoodsAddress` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`receive_name` char(100) NULL COMMENT '收件人',
`phone_num` char(100) NULL COMMENT '手机号',
`address` char(200) NULL COMMENT '收货地址',
`member_id` char(32) NULL COMMENT '用户 id',
PRIMARY KEY (`id`) 
);
CREATE TABLE `BuyGoods` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`order_num` char(100) NULL COMMENT '订单号',
`goods_id` int NULL COMMENT '商品 id',
`num` int NULL COMMENT '商品数量',
`total_price` decimal(10,5) NULL COMMENT '商品总金额',
PRIMARY KEY (`id`) 
);
CREATE TABLE `Member` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`member_id` char(32) NOT NULL COMMENT '用户 id',
`password` char(32) NULL COMMENT '密码',
`member_name` char(20) NULL COMMENT '用户名',
PRIMARY KEY (`id`, `member_id`) 
);
CREATE TABLE `Goods` (
`id` int NOT NULL COMMENT '主键',
`goods_id` int NOT NULL COMMENT '商品 id',
`goods_name` char(20) NULL COMMENT '商品名',
`goods_info` char(250) NULL COMMENT '商品信息',
`price` decimal(10,5) NULL COMMENT '单价',
`shop_id` int NULL COMMENT '店铺 id',
`is_check` int NULL DEFAULT 0 COMMENT '是否通过审核（默认0，通过1）',
PRIMARY KEY (`id`, `goods_id`) 
);
CREATE TABLE `Shop` (
`id` int NOT NULL COMMENT '主键',
`shop_id` int NOT NULL COMMENT '店铺 id',
`shop_name` char(20) NULL COMMENT '店铺名称',
`shop_info` char(250) NULL COMMENT '店铺信息',
PRIMARY KEY (`id`, `shop_id`) 
);
CREATE TABLE `Admin` (
`id` int NOT NULL COMMENT '主键',
`admin_id` char(32) NULL COMMENT '管理员id',
`password` char(32) NULL COMMENT '密码',
`admin_name` char(20) NULL COMMENT '管理员姓名',
PRIMARY KEY (`id`) 
);
CREATE TABLE `Coupon` (
`id` int NOT NULL COMMENT '主键',
`coupon_id` char(100) NOT NULL COMMENT '优惠卷 id',
`value` decimal(10,5) NULL COMMENT '面值',
`member_id` char(32) NULL COMMENT '用户 id',
`is_use` int NULL COMMENT '使用状态（未使用0，已使用1）',
PRIMARY KEY (`id`, `coupon_id`) 
);
CREATE TABLE `Finance` (
`id` int NOT NULL COMMENT '主键',
`shop_id` int NULL COMMENT '店铺 id',
`turnover` decimal(10,5) NULL COMMENT '营业额',
PRIMARY KEY (`id`) 
);
CREATE TABLE `ShoppingCart` (
`id` int NOT NULL COMMENT '主键',
`member_id` char(32) NULL COMMENT '用户 id',
`goods_id` int NULL COMMENT '商品id',
`num` int NULL COMMENT '商品数量',
`is_order` int NULL DEFAULT 0 COMMENT '是否下单（默认0，已下单1）',
PRIMARY KEY (`id`) 
);
CREATE TABLE `Favorite` (
`id` int NOT NULL COMMENT '主键',
`member_id` char(32) NULL COMMENT '用户 id',
`goods_id` int NULL COMMENT '商品 id',
`time` char(100) NULL COMMENT '收藏时间',
`is_cancel` int NULL DEFAULT 0 COMMENT '是否取消收藏（默认0，已取消1）',
PRIMARY KEY (`id`) 
);

ALTER TABLE `Order` ADD CONSTRAINT `fk_Order_ReceiveGoodsAddress_1` FOREIGN KEY (`address_id`) REFERENCES `ReceiveGoodsAddress` (`id`);
ALTER TABLE `Order` ADD CONSTRAINT `fk_Order_BuyGoods_1` FOREIGN KEY (`order_num`) REFERENCES `BuyGoods` (`order_num`);
ALTER TABLE `Member` ADD CONSTRAINT `fk_Member_ReceiveGoodsAddress_1` FOREIGN KEY (`member_id`) REFERENCES `ReceiveGoodsAddress` (`member_id`);
ALTER TABLE `Goods ` ADD CONSTRAINT `fk_Goods _BuyGoods_1` FOREIGN KEY (`goods_id`) REFERENCES `BuyGoods` (`goods_id`);
ALTER TABLE `Shop` ADD CONSTRAINT `fk_Shop_Goods _1` FOREIGN KEY (`shop_id`) REFERENCES `Goods ` (`shop_id`);
ALTER TABLE `Member` ADD CONSTRAINT `fk_Member_Coupon_1` FOREIGN KEY (`member_id`) REFERENCES `Coupon` (`member_id`);
ALTER TABLE `Coupon` ADD CONSTRAINT `fk_Coupon_Order_1` FOREIGN KEY (`coupon_id`) REFERENCES `Order` (`coupon_id`);
ALTER TABLE `Finance` ADD CONSTRAINT `fk_Finance_Shop_1` FOREIGN KEY (`shop_id`) REFERENCES `Shop` (`shop_id`);
ALTER TABLE `ShoppingCart` ADD CONSTRAINT `fk_ShoppingCart_Member_1` FOREIGN KEY (`member_id`) REFERENCES `Member` (`member_id`);
ALTER TABLE `ShoppingCart` ADD CONSTRAINT `fk_ShoppingCart_Goods _1` FOREIGN KEY (`goods_id`) REFERENCES `Goods ` (`goods_id`);
ALTER TABLE `Favorite` ADD CONSTRAINT `fk_GoodsCollect_Member_1` FOREIGN KEY (`member_id`) REFERENCES `Member` (`member_id`);
ALTER TABLE `Favorite` ADD CONSTRAINT `fk_GoodsCollect_Goods _1` FOREIGN KEY (`goods_id`) REFERENCES `Goods ` (`goods_id`);

