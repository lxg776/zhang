<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->
    <%@include file="/common/h5/css-link.jsp"%>

    <title>支付失败</title>
    <!-- start: CSS -->
</head>

<body>
<header class="aui-bar aui-bar-nav" style="position: fixed;">

    <div class="aui-title" id="demo">支付失败</div>
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>

</header>

<div style="padding-top: 2.25rem;padding-bottom: 2.25rem;background: #ffffff">

    <%--page4--%>

    <div  id="page4" class="aui-content aui-margin-b-15">

        <ul class="aui-list aui-media-list">
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">


                    <div class="aui-list-item-inner" style="text-align: center;">
                        <div style="margin: 2px auto; width: 40px;"><img src="${ctx}/image/pay_fail_icon.png" style="width: 40px;height: 40px;"></div>

                        <h1 style="color: #c9302c">支付失败<h1>
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
