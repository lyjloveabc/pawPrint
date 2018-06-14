<#escape x as x!"">
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>购物车</title>

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
                    <table id="mainTable" class="global-width-100"></table>

                    <div class="mobile-goods-bottom">
                        <div class="global-float-left">
                            <p style="color:#fff;">
                                共
                                <span id="shoppingCartNum"></span>
                                件商品: ￥
                                <span id="totalAmount" class="global-font-size-26px" style="color:#fff100;"></span>
                            </p>
                        </div>

                        <div class="global-float-right" style="padding:3% 2%;height: 30px">
                            <a href="" style="background:#fff000;color:#000;">
                                去结算
                            </a>
                        </div>
                    </div>

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

</body>

    <#include "common/template/resource/js/mobile/mobileJs.ftl"/>

<#--用到的模板-->
<script type="text/html" id="dataTemplate">
    <tr style="height: 100px;">
        <td>
            <img src="{{data.goodsImg}}" width="90" height="90" onerror="this.src='/common/img/flower_big.png';">
        </td>
        <td style="padding-left: 5px;">
            <input type="hidden" value="{{data.shoppingCartNumber}}">
            <div>{{data.goodsSalesName}}</div>
            <div class="global-desalination">({{data.goodsColor}}) {{data.specs}}</div>
            <div>
                <div class="countBox1" style="margin:0 auto;">
                    <input type="button" value="-" class="mobile-countCon1 global-font-size-26px" onclick="GOODS.changeNum(this, '-', '{{data.inventory}}')">
                    <input type="text" value="1" class="mobile-countCon3 global-width-40px" oninput="GOODS.changeInputNum(this)">
                    <input type="button" value="+" class="mobile-countCon2" onclick="GOODS.changeNum(this, '+', '{{data.inventory}}')">
                </div>
                <div>
                    <span class="global-conspicuous">￥</span>
                    <span class="global-font-weight-bold global-font-size-20px">{{data.unitPrice}}</span>
                </div>
            </div>
        </td>
    </tr>
</script>

<#--单独用到的js文件-->
<script src="/common/js/weChat/goods.js" type="text/javascript"></script>
<script src="/common/js/weChat/shoppingCart.js" type="text/javascript"></script>

</html>
</#escape>
