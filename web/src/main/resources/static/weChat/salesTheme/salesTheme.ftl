<#escape x as x!"">
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>产品</title>

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
    <td class="{{tdStyle}}">
        <div class="global-square-img-div global-margin-bottom-10px">
            <a href="javascript: SALES_THEME.gotoGoodsPageByGoodsIds('{{data.goodsIds}}')">
                <img src="{{data.image}}" class="global-square-img" onerror="this.src='/common/img/flower_big.png';"/>
            </a>
        </div>
        <div class="global-text-align-center global-doNotWrap-ellipsis global-width-120px">
            {{data.salesName}}
        </div>
    </td>
</script>

<#--单独用到的js文件-->
<script src="/common/js/weChat/salesTheme.js" type="text/javascript"></script>

</html>
</#escape>
