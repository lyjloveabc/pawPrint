<#escape x as x!"">
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>联系我们</title>

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
                    <table style="width: 100%;text-align: center;margin-top: 16px;">
                        <tr>
                            <td colspan="2" style="padding-bottom: 50px">
                                <div style="margin-bottom: 20px">
                                    <span class="global-font-size-26px">联系我们</span>
                                </div>
                                <div>
                                    <a href="">
                                        <img src="${user.headimgurl}" width="100" height="100" onerror="this.src='/common/img/flower.ico';"/>
                                    </a>
                                </div>
                                <div style="text-align: left;">
                                    <span class="global-desalination">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        Monoceros麒麟座,为您带来全球最优质的花材、资材。
                                    </span>
                                </div>
                                <div>
                                    <span>
                                        河北存朵商贸有限公司
                                    </span>
                                </div>
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

<#--用到的模板-->
<script type="text/html" id="dataTemplate">

</script>

<#--单独用到的js文件-->
<script src="" type="text/javascript"></script>

</html>
</#escape>
