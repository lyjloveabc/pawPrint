<#escape x as x!""><!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>商品详情</title>

    <#include "common/template/resource/css/mobile/mobileCss.ftl"/>

    <style type="text/css">
        /*START TouchSlide*/
        .focus {
            width: 100%;
            height: 320px;
            margin: 0 auto;
            position: relative;
            overflow: hidden;
        }

        .focus .hd {
            width: 100%;
            height: 11px;
            position: absolute;
            z-index: 1;
            bottom: 5px;
            text-align: center;
        }

        .focus .hd ul {
            display: inline-block;
            height: 11px;
            padding: 3px 5px;
            background-color: rgba(255, 255, 255, 0.7);
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            font-size: 0;
            vertical-align: top;
        }

        .focus .hd ul li {
            display: inline-block;
            width: 5px;
            height: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            background: #8C8C8C;
            margin: 0 5px;
            vertical-align: top;
            overflow: hidden;
        }

        .focus .hd ul .on {
            background: #FE6C9C;
        }

        .focus .bd {
            position: relative;
            z-index: 0;
        }

        .focus .bd li img {
            width: 100%;
            height: 320px;
            background: url(/common/img/loading.gif) center center no-repeat;
        }

        .focus .bd li a {
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0); /* 取消链接高亮 */
        }

        /*END TouchSlide*/

        .panel-content {
            min-height: 180px;
            padding: 20px;
        }
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
            <div class="mobile-panel-content-full-screen">
                <div>
                <#--***************************** START 以下编写具体内容*****************************-->
                    <div id="focus" class="focus">
                        <div class="hd">
                            <ul></ul>
                        </div>
                        <div class="bd">
                            <ul>
                                <#if goodsDetail.imageArray?? && goodsDetail.imageArray?size != 0 >
                                    <#list goodsDetail.imageArray as image>
                                        <li><a href="#"><img _src="${image}"/></a></li>
                                    </#list>
                                <#else>
                                </#if>
                            </ul>
                        </div>
                    </div>

                    <div class="panel-content">
                        <table class="global-width-100 global-text-align-center">
                            <tr >
                                <td colspan="2" class="global-middle-font-size global-font-weight-bold global-conspicuous">${goodsDetail.salesName}</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    ￥
                                    <span class="global-font-weight-bold global-font-size-26px">${goodsDetail.unitPrice}</span>
                                </td>
                            </tr>
                            <tr>
                                <td>编码：</td>
                                <td>${goodsDetail.code}</td>
                            </tr>
                            <tr>
                                <td>中文名称：</td>
                                <td>${goodsDetail.chineseName}</td>
                            </tr>
                            <tr>
                                <td>英文名称：</td>
                                <td>${goodsDetail.englishName}</td>
                            </tr>
                            <tr>
                                <td>拉丁文名称：</td>
                                <td>${goodsDetail.latinName}</td>
                            </tr>
                            <tr>
                                <td>产地：</td>
                                <td>${goodsDetail.origin}</td>
                            </tr>
                            <tr>
                                <td>颜色：</td>
                                <td>${goodsDetail.color}</td>
                            </tr>
                            <tr>
                                <td>枝条长度：</td>
                                <td>${goodsDetail.branchesLength}</td>
                            </tr>
                            <tr>
                                <td>规格：</td>
                                <td>${goodsDetail.specs}</td>
                            </tr>
                            <tr>
                                <td>库存：</td>
                                <td>${goodsDetail.inventory}</td>
                            </tr>
                            <tr>
                                <td>原产地：</td>
                                <td>${goodsDetail.countryOfOrigin}</td>
                            </tr>
                            <tr>
                                <td>别称：</td>
                                <td>${goodsDetail.otherName}</td>
                            </tr>
                        </table>
                    </div>

                    <div class="mobile-goods-bottom">
                        <div class="global-float-left">
                            <div style="padding-top: 4px">
                                <input type="button" value="-" class="mobile-countCon1 global-font-size-26px"
                                       onclick="GOODS.changeNum(this, '-', '{{data.inventory}}')">
                                <input type="text" value="1" class="mobile-countCon3 global-width-40px"
                                       oninput="GOODS.changeInputNum(this)">
                                <input type="button" value="+" class="mobile-countCon2"
                                       onclick="GOODS.changeNum(this, '+', '{{data.inventory}}')">
                            </div>
                        </div>
                        <div class="global-float-left" style="">
                            <p style="color:#fff;">
                                ￥
                                <span id="totalAmount" class="global-font-size-26px" style="color:#fff100;">
                                ${goodsDetail.unitPrice}
                                </span>
                            </p>
                        </div>
                        <div class="global-float-left" style="height: 30px">
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
    <div>
        <img src="">
    </div>
</script>

<#--单独用到的js文件-->
<script src="/common/plugin/touchSlide/TouchSlide.1.1.js" type="text/javascript"></script>
<script type="text/javascript">
    TouchSlide({
        slideCell: "#focus",
        titCell: ".hd ul", //开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
        mainCell: ".bd ul",
        effect: "left",
        autoPlay: false,//自动播放
        autoPage: true, //自动分页
        switchLoad: "_src" //切换加载，真实图片路径为"_src"
    });
</script>


</html>
</#escape>
