<#escape x as x!"">
<!DOCTYPE html>
<html lang="zh-cmn-Hans" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>用户中心</title>

    <#include "common/template/resource/css/mobile/mobileCss.ftl"/>

    <style type="text/css">
        a {
            color: #000;
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
            <div class="mobile-panel-content">
                <div>
                <#--***************************** START 以下编写具体内容*****************************-->
                    <table style="width: 100%;text-align: center;margin-top: 16px;">
                        <tr>
                            <td colspan="2" style="padding-bottom: 50px">
                                <div style="margin-bottom: 20px">
                                    <span class="global-font-size-26px">用户中心</span>
                                </div>
                                <div>
                                    <a href="">
                                        <img src="${user.headimgurl}" width="100" height="100" onerror="this.src='/common/img/panda.ico';"/>
                                    </a>
                                </div>
                                <div>
                                    <span class="global-desalination">普通会员</span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;padding-bottom: 10px;">
                                <a href="/shoppingCart/shoppingCartPage">
                                    <div style="background-color: #6effe5;padding: 5px;width: 90%;;margin: 0 auto">
                                        <img src="/common/img/full_shopping_cart.ico" width="20" height="20"/>
                                    </div>
                                </a>
                            </td>
                            <td style="padding-bottom: 10px;">
                                <div style="background-color: #ffd8d8;padding: 5px;width: 90%;margin: 0 auto">
                                    <img src="/common/img/favorite.ico" width="20" height="20"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%; padding: 5px">
                                <a href="">我的账户</a>
                            </td>
                            <td>
                                <a href="">我的订单</a>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%; padding: 5px">
                                <a href="">我的积分</a>
                            </td>
                            <td>
                                <a href="">我的优惠券</a>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%; padding: 5px">
                                <a href="">我的消息</a>
                            </td>
                            <td>
                                <a href="/contactUs/contactUsPage">联系我们</a>
                            </td>
                        </tr>
                    </table>
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

<#--单独用到的js文件-->
<script src="/common/js/weChat/userCenter.js" type="text/javascript"></script>

</html>
</#escape>
