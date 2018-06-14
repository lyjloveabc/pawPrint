# 微信配置、数据表
DROP TABLE IF EXISTS `we_chat_config`;
CREATE TABLE `we_chat_config` (
  `id`               INT(32)      NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create`       DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify`       DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `app_id`           VARCHAR(128) NOT NULL DEFAULT ''
  COMMENT 'AppID(应用ID)',
  `app_secret`       VARCHAR(128) NOT NULL DEFAULT ''
  COMMENT 'AppSecret(应用密钥)',
  `url`              VARCHAR(512) NOT NULL DEFAULT ''
  COMMENT '微信配置的服务器地址，必须以http://或https://开头，分别支持80端口和443端口',
  `token`            VARCHAR(32)  NOT NULL DEFAULT ''
  COMMENT '微信发送的Token验证，必须为英文或数字，长度为3-32字符',
  `encoding_AES_key` VARCHAR(43)  NOT NULL DEFAULT ''
  COMMENT '消息加密密钥由43位字符组成，可随机修改，字符范围为A-Z，a-z，0-9',
  `access_token`     VARCHAR(512) NOT NULL DEFAULT ''
  COMMENT '微信的accessToken',
  `is_using`         CHAR(1)      NOT NULL DEFAULT ''
  COMMENT '微信当前正在使用这个配置: 1当前正在使用 0不是',

  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '微信配置、数据表';

