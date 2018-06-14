# 商品表
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id`                       INT(32)        NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create`               DATETIME       NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify`               DATETIME       NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `code`                     VARCHAR(128)   NOT NULL
  COMMENT '编码: ',
  `chinese_name`             VARCHAR(128)   NOT NULL
  COMMENT '中文名称',
  `english_name`             VARCHAR(128)   NOT NULL
  COMMENT '英文名称',
  `latin_name`               VARCHAR(128)   NOT NULL
  COMMENT '拉丁文名称',
  `sales_name`               VARCHAR(128)   NOT NULL
  COMMENT '销售名称',
  `images`                   TEXT           NOT NULL
  COMMENT '商品图片, 逗号分开',
  `origin`                   VARCHAR(128)   NOT NULL
  COMMENT '产地',
  `color`                    VARCHAR(128)   NOT NULL
  COMMENT '颜色',
  `branches_length`          VARCHAR(64)    NOT NULL
  COMMENT '枝条长度',
  `unit_price`               DECIMAL(10, 2) NOT NULL
  COMMENT '单价',
  `specs`                    VARCHAR(128)   NOT NULL DEFAULT ''
  COMMENT '规格: 10支/扎',
  `inventory`                INT(10)        NOT NULL DEFAULT 1
  COMMENT '库存',
  `is_shelves`               CHAR(1)        NOT NULL DEFAULT '1'
  COMMENT '是否上架: 1是 0下架',
  `country_of_origin`        VARCHAR(128)   NOT NULL DEFAULT ''
  COMMENT '原产地',
  `distribution`             VARCHAR(128)   NOT NULL DEFAULT ''
  COMMENT '分布',
  `other_name`               VARCHAR(128)   NOT NULL DEFAULT ''
  COMMENT '别称',
  `curing_description`       VARCHAR(256)   NOT NULL DEFAULT ''
  COMMENT '养护说明',
  `distribution_description` VARCHAR(256)   NOT NULL DEFAULT ''
  COMMENT '配送说明',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`code`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '商品表';

# 销售主题表
DROP TABLE IF EXISTS `sales_theme`;
CREATE TABLE `sales_theme` (
  `id`         INT(32)      NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create` DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify` DATETIME     NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `code`       VARCHAR(128) NOT NULL
  COMMENT '编码',
  `sales_name` VARCHAR(128) NOT NULL
  COMMENT '销售名称',
  `image`      VARCHAR(128) NOT NULL
  COMMENT '销售主题图片',
  `goods_ids`  VARCHAR(516) NOT NULL
  COMMENT '商品ID字符串，英文逗号分割',
  `is_shelves` CHAR(1)      NOT NULL DEFAULT '1'
  COMMENT '是否上架: 1是 0下架',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`code`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '销售主题表';

# 购物车表
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id`          INT(32)        NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create`  DATETIME       NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify`  DATETIME       NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `number`      VARCHAR(20)    NOT NULL
  COMMENT '购物号：SC201702181131121234',
  `user_id`     INT(32)        NOT NULL
  COMMENT '用户ID',
  `goods_id`    INT(32)        NOT NULL
  COMMENT '商品ID',
  `num`         INT(10)        NOT NULL
  COMMENT '商品数量',
  `unit_price`  DECIMAL(10, 2) NOT NULL
  COMMENT '商品单价',
  `total_price` DECIMAL(10, 2) NOT NULL
  COMMENT '商品总价',
  `status`      VARCHAR(16)    NOT NULL
  COMMENT '状态：',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_number` (`number`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '购物车表';

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

# 订单表
DROP TABLE IF EXISTS `user_order`;
CREATE TABLE `user_order` (
  `id`                    INT(32)        NOT NULL AUTO_INCREMENT
  COMMENT '数据库自增ID',
  `gmt_create`            DATETIME       NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据创建时间',
  `gmt_modify`            DATETIME       NOT NULL DEFAULT '1970-01-01 00:00:01'
  COMMENT '数据修改时间',

  `number`                VARCHAR(20)    NOT NULL
  COMMENT '订单号：OR201702181131121234',
  `user_id`               INT(32)        NOT NULL
  COMMENT '用户ID',
  `shopping_cart_numbers` VARCHAR(420)   NOT NULL
  COMMENT '多个购物号合并支付，最多20笔',
  `total_price`           DECIMAL(10, 2) NOT NULL
  COMMENT '订单总价',
  `actual_paid_money`     DECIMAL(10, 2)
  COMMENT '实付金额',
  `pay_way`               VARCHAR(16)
  COMMENT '付款方式',
  `gmt_pay`               DATETIME
  COMMENT '付款时间',
  `trade_no`              VARCHAR(128)
  COMMENT '第三方支付流水号',
  `status`                VARCHAR(16)    NOT NULL
  COMMENT '状态',

  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_number` (`number`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '订单表';

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

