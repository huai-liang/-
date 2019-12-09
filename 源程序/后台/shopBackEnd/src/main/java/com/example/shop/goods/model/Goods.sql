-- auto Generated on 2019-11-04 13:57:31 
-- DROP TABLE IF EXISTS `goods`; 
CREATE TABLE `goods`(
    `title` VARCHAR (50) NOT NULL  COMMENT 'title',
    `image_src` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'imageSrc',
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`goods`';
