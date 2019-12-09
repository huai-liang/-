-- auto Generated on 2019-11-08 19:05:26 
-- DROP TABLE IF EXISTS `order`; 
CREATE TABLE `order`(
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `phone` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'phone',
    `goods_id` BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'goodsId',
    PRIMARY KEY (`goods_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`order`';
