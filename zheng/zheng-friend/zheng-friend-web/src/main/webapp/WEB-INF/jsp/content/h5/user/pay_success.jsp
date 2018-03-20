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

    <div class="aui-title" id="demo">支付成功</div>
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
                        <div style="margin: 2px auto; width: 100px;"><img src="${ctx}/image/pay_success_icon.png" style="width: 100px;height: 100px;"></div>

                        <h1 style="color: #00B83F">支付成功<h1>
                    </div>

                </div>

            </li>



            <%--个人资料--%>
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-title" style="font-size: 18px;">订单信息</div>

                        </div>
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-left">服务名称</div>
                            <div class="aui-list-item-title">${orderName}</div>
                        </div>

                        <div class="aui-list-item-text">
                            <div class="aui-list-item-left">服务天数</div>
                            <div class="aui-list-item-title">${days}</div>
                        </div>

                        <div class="aui-list-item-text">
                            <div class="aui-list-item-left">支付金额</div>
                        <div class="aui-list-item-title">${money}</div>
                    </div>

                    <div class="aui-list-item-text">
                        <div class="aui-list-item-left">交易时间</div>
                    <div class="aui-list-item-title">${date}</div>

                  </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>

</div>


</body>
</html>
