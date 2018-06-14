<#escape x as x!"">
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>PageTemplate</title>

    <#include "common/template/resource/css/mobile/mobileCss.ftl"/>

    <style type="text/css">

    </style>

</head>
<body ontouchstart>

<#--页面-->
<div class="page__bd global-height-100">

<#--页面tab-->
    <div class="weui-tab">

    <#--页面panel-->
        <div class="weui-tab__panel">
        <#--panel公共顶部-->
            <#include "common/template/pagePart/weChat/top.ftl"/>

        <#--panel内容，真正展示的页面主体内容-->
            <div class="mobile-panel-content">
                <div>
                <#--***************************** START 以下编写具体内容*****************************-->
                    <input id="goodsIds" type="hidden" value="${goodsIds}"/>
                    <table id="mainTable" class="global-width-100"></table>

                <#--***************************** END 以下编写具体内容*****************************-->
                </div>
            <#--panel内容，真正展示的页面主体内容的公共底部-->
                <#include "common/template/pagePart/weChat/mobilePnelFooter.ftl"/>
            </div>
        </div>

    <#--页面tab的tabbar-->
        <#include "common/template/pagePart/weChat/bottom.ftl"/>
    </div>
</div>

<#--点击购物车的弹出框-->
<div id="goodsHandleModal" class="modal fade global-opacity-85" tabindex="-1" role="dialog"
     aria-labelledby="goodsHandleLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content"></div>
    </div>
</div>

</body>

    <#include "common/template/resource/js/mobile/mobileJs.ftl"/>

<#--用到的模板-->
<script type="text/html" id="dataTemplate">
    <td class="{{tdStyle}}">
        <div class="global-square-img-div global-margin-bottom-10px">
            <a href="javascript: GOODS.gotoGoodsDetailPageByGoodsId('{{data.id}}')">
                <img src="{{data.imageArray[0]}}" class="global-square-img" onerror="this.src='/common/img/flower_big.png';"/>
            </a>
        </div>
        <div class="global-float-left">
            <a href="javascript: GOODS.showGoodsHandleModal('{{data.id}}')">
                <img src="/common/img/full_shopping_cart.ico" width="16px">
            </a>
            <span>&nbsp;</span>
        </div>
        <div class="global-doNotWrap-ellipsis global-width-100px global-small-font-size global-float-left">
            {{data.salesName}}
        </div>
    </td>
</script>
<script type="text/html" id="goodsHandleModalTemplate">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
            &times;
        </button>
        <h4 id="myModalLabel" class="modal-title global-small-font-size global-conspicuous">
            {{data.salesName}}
        </h4>
    </div>
    <div id="myModalContent" class="modal-body">
        <table style="width: 100%">
            <tr>
                <td>
                    {{data.specs}}
                </td>
                <td rowspan="3">
                    <div style="text-align: center">
                        <span class="global-conspicuous">￥</span>
                        <span id="totalPrice" class="global-font-size-20px global-font-weight-bold">{{data.unitPrice}}</span>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    {{data.code}}
                </td>
            </tr>
            <tr>
                <td>
                    (库存{{data.inventory}})
                </td>
            </tr>
            <tr>
                <td>
                    购买数量
                </td>
                <td>
                    <div class="countBox1" style="margin:0 auto;">
                        <input type="button" value="-" class="mobile-countCon1 global-font-size-26px"
                               onclick="GOODS.changeNum(this, '-', {{data.unitPrice}}, {{data.inventory}})">
                        <input id="" type="text" value="1" class="mobile-countCon3 global-width-40px"
                               oninput="GOODS.changeInputNum(this, {{data.unitPrice}}, {{data.inventory}})">
                        <input type="button" value="+" class="mobile-countCon2"
                               onclick="GOODS.changeNum(this, '+', {{data.unitPrice}}, {{data.inventory}})">
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="GOODS.addShoppingCart('{{data.id}}')">
            加入购物车
        </button>
        <button id="submit" type="button" class="btn btn-primary" onclick="GOODS.buyNow('{{data.id}}')">
            立即购买
        </button>
    </div>
</script>

<#--单独用到的js文件-->
<script src="/common/js/weChat/goods.js" type="text/javascript"></script>

</html>
</#escape>
