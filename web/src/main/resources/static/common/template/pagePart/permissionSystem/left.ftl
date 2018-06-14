<style type="text/css">
    .left-navigate {
        width: 12%;
        color: #333C4A;
        float: left;
    }

    .model-title {
        font-size: 18px;
    }

    .left-navigate-btn {
        margin-bottom: 10px;
        cursor: pointer;
        text-align: left;
        padding-left: 10px;
    }

    .left-navigate-btn:hover {
        color: #FE7A00;
    }

    .active {
        color: #FE7A00;
        border-left: 2px solid #FE7A00;
    }
</style>

<div class="left-navigate">
    <div style="width: 80%">
        <div class="text-align-left">
            <span class="model-title">账户权限中心</span>
            <hr/>
        </div>
        <div id="permissionMenu" class="left-navigate-btn" onclick="location.href='/manage/permissionSystem/permissionMenuPage?loginId=${loginId}'">
            菜单配置
        </div>
        <div id="permissionFunction" class="left-navigate-btn" onclick="location.href='/manage/permissionSystem/permissionFunctionPage?loginId=${loginId}'">
            功能配置
        </div>
        <div id="role" class="left-navigate-btn" onclick="location.href='/manage/permissionSystem/rolePage?loginId=${loginId}'">
            角色管理
        </div>
        <div id="user" class="left-navigate-btn" onclick="location.href='/manage/permissionSystem/userPage?loginId=${loginId}'">
            用户管理
        </div>
    </div>
</div>

<input id="loginId" type="hidden" value="${loginId}">
