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
