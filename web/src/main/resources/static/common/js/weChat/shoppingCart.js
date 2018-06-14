/**
 * Created by Thor on 2017/2/17.
 * happy coding - 1203!
 */

var SHOPPING_CART = function () {
    var init = function () {
        $('#tabBarShoppingCart').addClass('weui-bar__item_on');
        $('#tabBarShoppingCart').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');

        $.getJSON("/shoppingCart/userShoppingCarts", function (result) {
            if (GLOBAL.SUCCESS_CODE == result.code) {
                var data = result.data;
                var totalAmount = 0;

                //清空数据
                $('#mainTable > tbody').empty();

                //展示数据
                $.each(data, function (index, item) {
                    totalAmount += item.unitPrice;
                    $('#mainTable').append(template('dataTemplate', {data: item}));
                });

                $('#shoppingCartNum').text(data.length);
                $('#totalAmount').text(totalAmount.toFixed(2));
            }
        });
    };

    var toSettlement = function () {
        var shoppingCartNumbers = '';

        $.each($('#mainTable').find('input[type=hidden]'), function (index, item) {
            shoppingCartNumbers += $(item).val() + ',';
        });

        var param = {
            'shoppingCartNumbers': shoppingCartNumbers.substr(0, shoppingCartNumbers.length - 1)
        };

        $.ajax({
            type: 'GET',
            url: '/userOrder/add',
            data: param,
            async: false,
            beforeSend: function (request) {
                request.setRequestHeader("timestamp", GLOBAL.TIMESTAMP);
            },
            success: function (result) {
                if (GLOBAL.SUCCESS_CODE == result.code) {
                    var data = result.data;

                }
            }
        });
    };

    return {
        init: function () {
            init();
        },
        toSettlement: function () {
            toSettlement();
        }
    }
}();

SHOPPING_CART.init();
