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

