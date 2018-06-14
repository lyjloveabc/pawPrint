# 心灵鸡汤软文表
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id`             INT(32)      NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create`     DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify`     DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `openid`         VARCHAR(64)  NOT NULL
  COMMENT '用户的标识，对当前公众号唯一',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_openid` (`openid`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '心灵鸡汤软文表';

