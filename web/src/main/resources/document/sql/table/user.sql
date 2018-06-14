# 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id`                            INT(32)      NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create`                    DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify`                    DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  # 微信返回的用户信息
  `subscribe`                     CHAR(1)      NOT NULL DEFAULT '1'
  COMMENT '用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息',
  `openid`                        VARCHAR(64)  NOT NULL
  COMMENT '用户的标识，对当前公众号唯一',
  `nickname`                      VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '用户的昵称',
  `sex`                           CHAR(1)      NOT NULL DEFAULT '0'
  COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `country`                       VARCHAR(32)  NOT NULL DEFAULT '中国'
  COMMENT '用户所在国家',
  `province`                      VARCHAR(32)  NOT NULL DEFAULT '浙江'
  COMMENT '用户所在省份',
  `city`                          VARCHAR(32)  NOT NULL DEFAULT '杭州'
  COMMENT '用户所在城市',
  `language`                      VARCHAR(16)  NOT NULL DEFAULT 'zh_CN'
  COMMENT '用户的语言，简体中文为zh_CN',
  `headimgurl`                    VARCHAR(512) NOT NULL DEFAULT ''
  COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），
  用户没有头像时该项为空。若用户更换头像，原有头像URL将失效',
  `subscribe_time`                VARCHAR(16)  NOT NULL DEFAULT ''
  COMMENT '用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间',
  `unionid`                       VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段',
  `remark`                        VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注',
  `groupid`                       VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '用户所在的分组ID',

  # 其他信息
  `mobile`                        VARCHAR(16)  NOT NULL DEFAULT ''
  COMMENT '绑定手机号',
  `email`                         VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '电子邮箱',
  `integral`                      INT(10)      NOT NULL DEFAULT 0
  COMMENT '用户积分',
  `flower_shop_name`              VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '花店名称',
  `default_shipping_address_name` VARCHAR(64)  NOT NULL DEFAULT ''
  COMMENT '默认地址全称，方便展示',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_openid` (`openid`),
  UNIQUE KEY `uk_mobile` (`mobile`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '用户表';

