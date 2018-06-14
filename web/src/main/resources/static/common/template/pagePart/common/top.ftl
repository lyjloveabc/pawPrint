<style type="text/css">
    .top-total{
        height: 70px;
        margin-bottom: 20px;
    }

    .top-first {
        height: 100%;
        border-bottom: 1px solid #d6e5ec;
        border-right: 1px solid #d6e5ec;
    }

    .top-logo {
        width: 70px;
        height: 100%;
        border-left: 1px solid #d6e5ec;
        border-right: 1px solid #d6e5ec;
        float: left;
    }

    .top-logo-image {
        width: 36px;
        height: 36px;
        margin-top: 17px;
    }

    .top-content {
        padding-top: 12.5px;
        padding-bottom: 15px;
    }

    .top-search {
        margin-left: 260px;
    }

    .top-search-input {
        width: 700px;
        height: 45px;
        padding: 0 10px;
        border: 2px solid #0BC6E4;
        border-right: none;
        font-size: 20px;
        float: left;
    }

    .top-search-img {
        float: left;
        cursor: pointer;
        padding: 12px 20px;
        border: 2px solid #0BC6E4;
        border-left: none;
        background-color: #0BC6E4;
        color: white;
    }
</style>

<#include "pagePart/common/header.ftl"/>

<div class="top-total">
    <div class="top-first">
        <div class="top-logo text-align-center">
            <a href="">
                <img src="/img/manage/screw.ico" class="top-logo-image">
            </a>
        </div>

        <div class="top-content">
            <div class="top-search">
                <input type="text" class="top-search-input" placeholder="" value="">
                <div class="top-search-img" onclick="alert('1')">
                    搜索
                </div>
            </div>
        </div>
    </div>

</div>