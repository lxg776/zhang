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
<header class="aui-bar aui-bar-nav" style="position: fixed">
    <a class="aui-pull-left aui-btn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">兴趣爱好</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;">
    <ul class="aui-list aui-form-list">



        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的运动
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写">
                </div>


            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的音乐
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写">
                </div>


            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的电影
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写">
                </div>


            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的宠物
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写">
                </div>


            </div>
        </li>



    </ul>

</div>


<div class="aui-content-padded">

    <div class="aui-btn aui-btn-info  aui-btn-block" style="margin-top: 1rem;">下一步</div>


</div>








<%@ include file="/common/h5/js.jsp" %>


</body>


</html>
