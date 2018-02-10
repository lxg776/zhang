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
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">兴趣爱好</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;">

    <form id="regForm" action="/u/txXqhh" method="post">
    <ul class="aui-list aui-form-list">



        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的音乐
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写"  name="favoriteMusic" value="${modle.favoriteMusic}" >
                </div>


            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的电影
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写"  name="favoriteFilm" value="${modle.favoriteFilm}" >
                </div>


            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的运动
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写"  name="favoriteSports" value="${modle.favoriteSports}" >
                </div>


            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的宠物
                </div>
                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写"  name="favoritePet" value="${modle.favoritePet}" >
                </div>


            </div>
        </li>




    </ul>
    </form>
</div>


<div class="aui-content-padded">

    <div class="aui-btn aui-btn-info  aui-btn-block" style="margin-top: 1rem;" id="regBtn">完成</div>


</div>








<%@ include file="/common/h5/js.jsp" %>

<script src="${ctx}/aui/script/aui-dialog.js"></script>

<script language="JavaScript">


    var dialog = new auiDialog();


    $("#backBtn").click(function(){
        window.history.back();
    });
    $("#regBtn").click(function(){
        tijiao();
    });


    function tijiao() {

        $("#regForm").submit();
    }

    function msg(msg) {
        dialog.alert({
            title:"提示",
            msg:msg,
            buttons:['确定']
        },function(ret){
            // console.log(ret)
        })
    }
</script>


</body>


</html>
