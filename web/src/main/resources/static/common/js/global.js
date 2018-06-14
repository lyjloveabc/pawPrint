/**
 * 全局JS
 * Created by Thor on 2017/2/9.
 * happy coding - 1203!
 */

var GLOBAL = function () {
    //常量
    var START_PAGE_NUM = 1;
    var PAGE_SIZE = 10;
    var RESULT_JSON_NO_DATA = '{code: "00030100", msg: "没有数据", data: null}';
    var SUCCESS_CODE = '111111';
    var NO_DATA_MSG = '没有数据';

    var init = function () {
    };

    return {
        init: function () {
            init();
        },
        TIMESTAMP: new Date().getTime(),
        START_PAGE_NUM: START_PAGE_NUM,
        PAGE_SIZE: PAGE_SIZE,
        RESULT_JSON_NO_DATA: RESULT_JSON_NO_DATA,
        SUCCESS_CODE: SUCCESS_CODE,
        NO_DATA_MSG: NO_DATA_MSG
    }
}();

GLOBAL.init();
