/**
 * Created by Thor on 2017/2/15.
 * happy coding - 1203!
 */

var POPUP = function () {
    var showGoodsHandleModal = function (id, content, title, submitFunction, submitContent, handleFunction) {
        $.getJSON("/goods/goodsDetail?id=" + id, function (result) {
            if (GLOBAL.SUCCESS_CODE == result.code) {
                var data = result.data;

                //清空数据
                $('#mainTable > tbody').empty();
                //展示数据
                $.each(data, function (index, item) {
                    var images = item.images;
                    var image = '';

                    if (images != null) {
                        image = images.split(",")[0];
                    }

                    var tdStyle = 'global-right-td-content';
                    if (index % 2 == 0) {
                        tdStyle = 'global-left-td-content';
                        $('#mainTable').append('<tr></tr>');
                    }

                    $('#mainTable').find('tr:last').append(template('dataTemplate', {data: item, image: image, tdStyle: tdStyle}));
                });

                //如果只有一项的话，table宽度设置成50%
                if (data.length == 1) {
                    $('#mainTable').attr('style', 'width: 50%');
                }
            }
        });

        $('#goodsHandleContent').html(content);
        if (undefined != title) {
            $('#goodsHandleLabel').html(title);
        }
        if (undefined != submitFunction) {
            $('#submit').unbind().click(function () {
                submitFunction();
            });
        }
        if (undefined != submitContent) {
            $('#submit').html(submitContent);
        }

        if (undefined != handleFunction) {
            handleFunction();
        }

        $('#goodsHandleModal').modal('show');
    };

    var closeModal = function (modal) {
        if (undefined == modal) {
            $('#myModal').modal('hide');
        } else {
            $(modal).modal('hide');
        }
    };

    return {
        init: function () {
        },
        showGoodsHandleModal: function (content, title, submitFunction, handleFunction) {
            showGoodsHandleModal(content, title, submitFunction, handleFunction);
        },
        showModalInTime: function (content, title, submitFunction, handleFunction, time, modal) {
            showModal(content, title, submitFunction, handleFunction);
            window.setTimeout(function () {
                if (undefined == modal) {
                    $('#myModal').modal('hide');
                } else {
                    $(modal).modal('hide');
                }
            }, time);
        },
        closeModal: function (modal) {
            closeModal(modal);
        }
    };
}();

POPUP.init();
