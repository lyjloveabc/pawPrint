# 积分等级表
DROP TABLE IF EXISTS `integral_level`;
CREATE TABLE `integral_level` (
  `id`         INT(32)  NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create` DATETIME NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify` DATETIME NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `integral`   INT(10)  NOT NULL DEFAULT ''
  COMMENT '用户积分',

  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '积分等级表';

