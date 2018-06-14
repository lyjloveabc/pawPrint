/**
 * 自定义提示框
 * Created by luoyanjie on 2016/01/06.
 */

var MY_MODAL = function () {
    var showModal = function (content, title, submitFunction, submitContent, handleFunction) {
        $('#myModalContent').html(content);
        if (undefined != title) {
            $('#myModalLabel').html(title);
        }
        if (undefined != submitFunction) {
            $('#submit').unbind().click(function () {
                submitFunction();
            });
        }
        if (undefined != submitContent) {
            $('#submit').html(submitContent);
        }
        $('select').select2();

        if (undefined != handleFunction) {
            handleFunction();
        }

        $('#myModal').modal('show');
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
        showModal: function (content, title, submitFunction, handleFunction) {
            showModal(content, title, submitFunction, handleFunction);
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