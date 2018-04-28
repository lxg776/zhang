<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->
    <%@include file="/common/h5/css-link.jsp"%>

    <title>支付成功</title>
    <!-- start: CSS -->
</head>

<body>
<header class="aui-bar aui-bar-nav" style="position: fixed;">

    <div class="aui-title" id="demo">开通会员</div>
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>

</header>

<div style="padding-top: 2.25rem;padding-bottom: 2.25rem;background: #ffffff">

    <%--page4--%>

    <div  id="page4" class="aui-content aui-margin-b-15">

        <ul class="aui-list aui-media-list">
            <%--个人资料--%>
            <li class="aui-list-item">
                     <div class="aui-media-list-item-inner">
                         你还未开通会员
                    </div>
                </div>
            </li>
        </ul>
    </div>

</div>
<script  language="JavaScript">
    $("#backBtn").click(function(){
        window.location.href="${ctx}/u/index";
    });

</script>

</body>

</html>
