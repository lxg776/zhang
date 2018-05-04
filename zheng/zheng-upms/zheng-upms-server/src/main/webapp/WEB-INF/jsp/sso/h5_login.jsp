<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->

    <%@include file="/common/h5/css-link.jsp"%>

    <title>首页</title>
    <!-- start: CSS -->
    <style type="text/css">
        #demo {
            background-color: #e0e0e0;
        }
    </style>



</head>

<body>
<header class="aui-bar aui-bar-nav">
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">婚恋墙</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 1rem;">
    <ul class="aui-list aui-form-list">

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label-icon">
                    <i class="aui-iconfont aui-icon-mobile"></i>
                </div>
                <div class="aui-list-item-input">
                    <input type="text" id="username" name="username" placeholder="手机号码">
                </div>
            </div>
        </li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label-icon">
                    <i class="aui-iconfont aui-icon-lock"></i>
                </div>
                <div class="aui-list-item-input">
                    <input type="password" id="password"  name="password"  placeholder="密码">
                </div>

            </div>
        </li>
    </ul>

</div>


<div class="aui-content-padded">
    <p><div class="aui-btn aui-btn-info aui-btn-block" id="login-bt">登 录</div></p>
    <p><div class="aui-btn aui-btn-primary aui-btn-block"  id="reg_btn" style="margin-top: 1rem;">注 册</div></div>
</div>








<%@ include file="/common/h5/js.jsp" %>

<script>var BASE_PATH = '${basePath}';</script>
<script>var BACK_URL = '${param.backurl}';</script>
<script src="${ctx}/aui/script/login.js"></script>

<script language="JavaScript">


    $("#reg_btn").click(function(){
        window.location.href='http://127.0.0.1:9991/h5/reg';
    });


    $("#backBtn").click(function(){
        window.history.back();
    });


</script>

<c:if test="${param.forceLogout == 1}">
    alert('您已被强制下线！');
    top.location.href = '${basePath}/sso/login';
</c:if>

</body>


</html>
