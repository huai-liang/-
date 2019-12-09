-- auto Generated on 2019-11-21 15:49:28 
-- DROP TABLE IF EXISTS `imagetitle`; 
CREATE TABLE `imagetitle`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `title` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'title',
    `img_src` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'imgSrc',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`imagetitle`';
