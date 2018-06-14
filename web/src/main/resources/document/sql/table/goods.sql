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

