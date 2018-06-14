/**
 * Created by Thor on 2017/2/24.
 * happy coding - 1203!
 */

var USER_ORDER = function () {
    var init = function () {
        $('#tabBarUserCenter').addClass('weui-bar__item_on');
        $('#tabBarUserCenter').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');

    };

    return {
        init: function () {
            init();
        }
    }
}();

USER_ORDER.init();
