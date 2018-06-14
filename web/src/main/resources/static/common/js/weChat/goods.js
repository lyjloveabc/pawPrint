/**
 * Created by Thor on 2017/2/14.
 * happy coding - 1203!
 */

var GOODS = function () {
    var init = function () {
        $('#tabBarSalesTheme').addClass('weui-bar__item_on');
        $('#tabBarSalesTheme').siblings('.weui-bar__item_on').removeClass('weui-bar__item_on');

        var goodsIds = $('#goodsIds').val();
        $.getJSON("/goods/goodsInSalesTheme?goodsIds=" + goodsIds, function (result) {
            if (GLOBAL.SUCCESS_CODE == result.code) {
                var data = result.data;

                //清空数据
                $('#mainTable > tbody').empty();

                //展示数据
                $.each(data, function (index, item) {
                    var tdStyle = 'global-right-td-content';
                    if (index % 2 == 0) {
                        tdStyle = 'global-left-td-content';
                        $('#mainTable').append('<tr></tr>');
                    }

                    $('#mainTable').find('tr:last').append(template('dataTemplate', {data: item, tdStyle: tdStyle}));
                });

                //如果只有一项的话，table宽度设置成50%
                if (data.length == 1) {
                    $('#mainTable').attr('style', 'width: 50%');
                }
            }
        });
    };

    var gotoGoodsDetailPageByGoodsId = function (id) {
        location.href = '/goods/goodsDetailPage?id=' + id;
    };

    var showGoodsHandleModal = function (id) {
        $.getJSON("/goods/goodsDetail?id=" + id, function (result) {
            if (GLOBAL.SUCCESS_CODE == result.code) {
                var data = result.data;

                $('.modal-content').html(template('goodsHandleModalTemplate', {data: data}));

                $('#goodsHandleModal').modal('show');
            }
        });
    };

    var changeNum = function (dom, type, unitPrice, inventory) {
        var goodsNumDom = $(dom).parent().find('input[type=text]');
        var goodsNum = Number($.trim(goodsNumDom.val()));
        var totalPriceNum = parseFloat($('#totalPrice').text());

        var newGoodsNum;
        var newTotalPriceNum;

        if ('+' == type) {
            newGoodsNum = goodsNum + 1;

            if (newGoodsNum > inventory) {
                return false;
            }

            newTotalPriceNum = totalPriceNum + unitPrice;
        } else {
            newGoodsNum = goodsNum - 1;

            if (newGoodsNum <= 0) {
                return false;
            }

            newTotalPriceNum = totalPriceNum - unitPrice;
        }

        goodsNumDom.val(newGoodsNum);
        $('#totalPrice').text(newTotalPriceNum.toFixed(2));
    };

    var changeInputNum = function (dom, unitPrice, inventory) {
        var goodsNum = $.trim($(dom).val());
        var goodsNumNew = goodsNum;

        if (goodsNum == '' || isNaN(goodsNum)) {
            goodsNumNew = 1;
        } else if (goodsNum > inventory) {
            goodsNumNew = inventory;
        }

        $(dom).val(goodsNumNew);
        $('#totalPrice').text((goodsNumNew * unitPrice).toFixed(2));
    };

    var addShoppingCart = function (goodsId) {
        var param = {
            'goodsId': goodsId,
            'num': $.trim($('#myModalContent').find('input[type=text]').val())
        };

        $.ajax({
            type: 'GET',
            url: '/shoppingCart/add',
            data: param,
            async: false,
            beforeSend: function (request) {
                request.setRequestHeader("timestamp", GLOBAL.TIMESTAMP);
            },
            success: function (result) {
                if (GLOBAL.SUCCESS_CODE == result.code) {
                    alert('购物车添加成功！');
                }
            }
        });
    };

    var buyNow = function () {

    };

    return {
        init: function () {
            init();
        },
        gotoGoodsDetailPageByGoodsId: function (id) {
            gotoGoodsDetailPageByGoodsId(id);
        },
        showGoodsHandleModal: function (id) {
            showGoodsHandleModal(id);
        },
        changeNum: function (dom, type, unitPrice, inventory) {
            changeNum(dom, type, unitPrice, inventory);
        },
        changeInputNum: function (dom, unitPrice, inventory) {
            changeInputNum(dom, unitPrice, inventory);
        },
        addShoppingCart: function (goodsId) {
            addShoppingCart(goodsId);
        },
        buyNow: function () {
            buyNow();
        }
    }
}();

GOODS.init();
