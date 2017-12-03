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
    <a class="aui-pull-left aui-btn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">靖西婚恋网</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 1rem;">
    <ul class="aui-list aui-form-list">

        <li class="aui-list-item">
            <div class="aui-list-item-inner">

                <div class="aui-list-item-input">
                    <input type="text" placeholder="手机号码">
                </div>

                <div class="aui-list-item-label">
                    <a href="#">获取验证码</a>
                </div>
            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="text" placeholder="验证码">
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="text" placeholder="身份证号码">
                </div>
            </div>
        </li>

        <div class="aui-card-list">
            <div class="aui-card-list-header" style="color: #757575; font-size: 14px;">
                为保证注册的真实性需上传身份证图
            </div>
            <div class="aui-card-list-content-padded aui-border-b aui-border-t">
                <div class="aui-row aui-row-padded">
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l1.png" />
                    </div>
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l2.png" />
                    </div>
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l3.png" />
                    </div>
                </div>
            </div>

        </div>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="text" placeholder="密码">
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="text" placeholder="确认密码">
                </div>
            </div>
        </li>

    </ul>

</div>


<div class="aui-content-padded">

    <p><div class="aui-btn aui-btn-primary aui-btn-block" style="margin-top: 1rem;">完成</div></div>


</div>








<%@ include file="/common/h5/js.jsp" %>


</body>


</html>
