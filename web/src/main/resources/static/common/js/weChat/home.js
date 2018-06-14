/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */

var HOME = function () {
    var init = function () {
        $('#tabBarHome').addClass('weui-bar__item_on');
        $('#tabBarHome').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');
    };

    return {
        init: function () {
            init();
        }
    }
}();

HOME.init();
