# 收货地址表
DROP TABLE IF EXISTS `shipping_address`;
CREATE TABLE `shipping_address` (
  `id`            INT(32)     NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create`    DATETIME    NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify`    DATETIME    NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `openid`        VARCHAR(64) NOT NULL
  COMMENT '用户的标识，对当前公众号唯一',

  `province_id`   INT(32)     NOT NULL DEFAULT ''
  COMMENT '省ID',
  `province_name` VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '省名称',
  `city_id`       INT(32)     NOT NULL DEFAULT ''
  COMMENT '市ID',
  `city_name`     VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '市名称',
  `district_id`   INT(32)     NOT NULL DEFAULT ''
  COMMENT '区、县ID',
  `district_name` VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '区、县名称',
  `street_id`     INT(32)     NOT NULL DEFAULT ''
  COMMENT '镇、街道ID',
  `street_name`   VARCHAR(64) NOT NULL DEFAULT ''
  COMMENT '镇、街道名称',
  `is_default`    CHAR(1)     NOT NULL DEFAULT ''
  COMMENT '1: 默认 2:非',

  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '收货地址表';

