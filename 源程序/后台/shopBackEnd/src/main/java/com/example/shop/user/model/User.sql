-- auto Generated on 2019-10-26 19:50:11 
-- DROP TABLE IF EXISTS `user`; 
CREATE TABLE `user`(
    `phone` BIGINT (15) NOT NULL  COMMENT '手机号码',
    `user_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户名',
    `user_pwd` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '密码',
    `address` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '地址',
    PRIMARY KEY (`phone`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`用户`';