<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="/common/h5/taglibs.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp" %>
    <!-- end: Mobile Specific -->

    <%@include file="/common/h5/css-link.jsp" %>

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
    <div class="aui-title">发送邮件</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;">


        <ul class="aui-list aui-media-list" id="listUser">
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-media" style="width: 7rem; height: 7rem;">
                        <img src="${ctx}/aui/image/mm.jpeg">
                    </div>
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-title">${toUser.fUserBaseMsg.nikename}</div>
                            <div class="aui-list-item-right aui-greed">实名</div>
                        </div>
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-text">25岁</div>
                            <div class="aui-list-item-text">${toUser.fUserBaseMsg.profession}</div>
                            <div class="aui-list-item-text">${toUser.fUserBaseMsg.height}cm</div>
                        </div>

                        <div class="aui-list-item-text" style="color: #0a0c0e">
                            择偶条件:我想找寻靖西<c:if test="${not empty toUser.fUserRequest.age}">年龄在${toUser.fUserRequest.age}岁,</c:if>
                            <c:if test="${not empty toUser.fUserRequest.height}">身高${toUser.fUserRequest.height}cm，</c:if>
                            <c:if test="${not empty toUser.fUserRequest.incomeMonthly}">月收入
                                ${toUser.fUserRequest.incomeMonthly}</c:if>的<c:if test="${toUser.sex == 1}">男性</c:if><c:if
                                test="${toUser.sex == 2}">女性</c:if>
                        </div>
                    </div>

                </div>
            </li>

            <form id="sendForm" action="/m/sendMsg" method="post">
                <input name="toUserId" type="hidden" value="${toUser.userId}"/>
                <input name="backUrl" type="hidden" value="${backUrl}">
                <li class="aui-list-item">
            <div class="aui-list-item-input" style="padding: 1rem;">
                <textarea placeholder="填写邮箱内容"  name="msgContent" id="msgContent" style="height: 200px;"></textarea>
            </div>
                </li>
                <li class="aui-list-item" style="padding-bottom: 10px;">
                <div class="aui-content-padded">
                    <div class="aui-btn aui-btn-info aui-btn-block" id="sendBtn" >发送</div>
                </div>
                </li>
            </form>
        </ul>

</div>

<%@ include file="/common/h5/js.jsp" %>
<script type="text/javascript" src="${ctx}/aui/script/aui-dialog.js"></script>
<script language="JavaScript">
    $("#backBtn").click(function(){
        window.history.back();
    });

    $("#sendBtn").click(function(){
        tijiao();
    });


    var dialog = new auiDialog();
    function msg(msg) {
        dialog.alert({
            title:"提示",
            msg:msg,
            buttons:['确定']
        },function(ret){
            window.history.back();
        })
    }

    //提交
    function tijiao() {

        if ($("input[name='msgContent']").val() == "") {
            msg("请填写邮件信息");
            $("input[name='msgContent']").focus();
            return
        }

        toUserId = $("input[name='toUserId']").val();
        backUrl = $("input[name='backUrl']").val();
        msgContent = $("input[name='msgContent']").val();

        data = "toUserId="+toUserId+"&backUrl="+backUrl+"&msgContent"+msgContent;
        //获取签名数据并上传图片
        url = "/m/sendMsg";
        $.ajax({
            url: url,
            type: "POST",
            dataType: "json", //指定服务器返回的数据类型
            data:data,
            success: function (data) {

                msg(data.message);
            }
        });



        //$("#sendForm").submit();
    }

</script>

</body>


</html>
