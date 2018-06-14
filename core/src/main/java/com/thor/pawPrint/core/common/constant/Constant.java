package com.thor.pawPrint.core.common.constant;

/**
 * 基本公共常量
 * Created by Thor on 2017/2/6.
 * happy coding - 1203!
 */
public interface Constant {
    //**************************************** session attribute ****************************************//
    String USER_ID = "userId";

    //**************************************** 分页 ****************************************//
    Long DEFAULT_PAGE_NUM = 1L;

    Long DEFAULT_PAGE_SIZE = 20L;

    //**************************************** 金额 ****************************************//
    Integer DECIMAL_DIGITS = 2;

    //**************************************** 特殊字符串 ****************************************//
    String STRING_EMPTY = "";
    String STRING_SPACE = " ";

    //**************************************** 分割字符串 ****************************************//
    String SPLIT_STR_COMMA = ",";
    String SPLIT_STR_AND = "&";
    String SPLIT_STR_BAR = "-";
    String SPLIT_STR_NEW_LINE = "\n";

    //**************************************** 随机数区间 ****************************************//
    Integer RANDOM_MIN = 1111;
    Integer RANDOM_MAX = 9999;

    //**************************************** 数据格式 ****************************************//
    String DATA_XML = "xml";

    //**************************************** 线程大小 ****************************************//
    Integer CORE_POOL_SIZE = 10;

    //**************************************** 通用字符串 ****************************************//
    String TRUE_STRING = "true";
    String FALSE_STRING = "false";

    //**************************************** NUMBER 前缀 ****************************************//
    String PREFIX_ORDER = "OR";
    String PREFIX_SHOPPING_CART = "SC";

    //**************************************** 系统默认值 ****************************************//
    String DEFAULT_IMAGE = "/common/img/flower_big.png";

}
