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

    <div class="aui-title">靖西婚恋网</div>

</header>


<section class="aui-content" style="padding-left: 2rem;">
    <div class="aui-info">
        <div class="aui-info-item" style="font-size: 18px; color: #212121;">实名认证</div>
    </div>


    <div class="aui-info" style="margin: 0px; padding: 0px;">

        <div class="aui-info-item">会员信息真实可靠</div>
    </div>


    <div class="aui-info">
        <div class="aui-info-item" style="font-size: 18px; color: #212121;">智能匹配</div>
    </div>


    <div class="aui-info" style="margin: 0px; padding: 0px;">

        <div class="aui-info-item">为您推荐合适对象，成功率高</div>
    </div>

    <div class="aui-info">
        <div class="aui-info-item" style="font-size: 18px; color: #212121;">单身交友活动</div>
    </div>


    <div class="aui-info" style="margin: 0px; padding: 0px;">

        <div class="aui-info-item">扩大你的圈子，找到另一半</div>
    </div>
</section>


<div class="aui-content-padded">

    <p><div class="aui-btn aui-btn-info aui-btn-block" id="login_btn">登 录</div></p>
    <p><div class="aui-btn aui-btn-primary aui-btn-block" style="margin-top: 1rem;" id="reg_btn">注 册</div></div>


</div>








<%@ include file="/common/h5/js.jsp" %>

<script language="JavaScript">

    $("#login_btn").click(function(){
        window.location.href='http://upms.zhangshuzheng.cn:9998/sso/login?backurl=http%3A%2F%2F127.0.0.1%3A9991%2Fu%2Findex';
    });
    $("#reg_btn").click(function(){
        window.location.href='/h5/reg';
    });


</script>



</body>


</html>
