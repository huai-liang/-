-- auto Generated on 2019-11-01 19:15:39 
-- DROP TABLE IF EXISTS `car`; 
CREATE TABLE `car`(

    `phone` VARCHAR (50) NOT NULL  COMMENT '手机号码',
    `title` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '题目',
    `image_src` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '图片路径',
     `price` decimal NOT NULL  COMMENT '价格',
     `num` int NOT NULL  COMMENT '数量',
    PRIMARY KEY (`phone`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`car`';
