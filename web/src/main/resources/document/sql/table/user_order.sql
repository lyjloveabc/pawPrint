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

