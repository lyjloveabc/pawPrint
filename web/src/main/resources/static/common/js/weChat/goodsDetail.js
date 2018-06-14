/**
 * Created by Thor on 2017/2/24.
 * happy coding - 1203!
 */

var GOODS_DETAIL = function () {
    var init = function () {
        $.getJSON("/salesTheme/allSalesTheme", function (result) {
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

    return {
        init: function () {
            init();
        }
    }
}();

GOODS_DETAIL.init();
