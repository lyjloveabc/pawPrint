# 中国区划 表
DROP TABLE IF EXISTS `chinese_region`;
CREATE TABLE `chinese_region` (
  `id`         INT(32)     NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create` DATETIME    NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify` DATETIME    NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `parent_id`  INT(32)     NOT NULL DEFAULT '0'
  COMMENT '父级ID',
  `name`       VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '名称',
  `level`      CHAR(1)     NOT NULL DEFAULT '1'
  COMMENT '等级: 1省 2市 3区县 4镇街道',

  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '中国区划 表';

