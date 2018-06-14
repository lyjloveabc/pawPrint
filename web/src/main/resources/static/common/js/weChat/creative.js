/**
 * Created by Thor on 2017/2/24.
 * happy coding - 1203!
 */

var CREATIVE = function () {
    var init = function () {
        $('#tabBarCreative').addClass('weui-bar__item_on');
        $('#tabBarCreative').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
    };

    return {
        init: function () {
            init();
        }
    };
}();

CREATIVE.init();
