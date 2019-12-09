-- auto Generated on 2019-11-20 18:55:54 
-- DROP TABLE IF EXISTS `admin`; 
CREATE TABLE `admin`(
    `name` VARCHAR (50) NOT NULL AUTO_INCREMENT COMMENT 'name',
    `password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
    PRIMARY KEY (`name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`admin`';
