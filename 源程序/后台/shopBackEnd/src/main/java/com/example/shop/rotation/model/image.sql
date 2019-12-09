-- auto Generated on 2019-11-21 14:02:50 
-- DROP TABLE IF EXISTS `image`; 
CREATE TABLE `image`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `img_src` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'imgSrc',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`image`';
