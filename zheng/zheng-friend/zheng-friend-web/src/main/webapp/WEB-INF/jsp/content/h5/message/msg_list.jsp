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
    <div class="aui-title">${fromUser.nikename}</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;padding-bottom: 52.5px;">


    <section class="aui-chat" id="chatList">
        <c:forEach var="item" items="${msgList}">
            <c:if test="${not empty item.showDate}">
                <div class="aui-chat-header">${item.showDate}</div>
            </c:if>
        <div class="aui-chat-item   <c:if test="${item.showFla == '0'}"> aui-chat-left </c:if>  <c:if test="${item.showFla == '1'}"> aui-chat-right </c:if> ">
            <div class="aui-chat-media">
                <img src="${imageBase}${item.fUserBaseMsg.avatar}" />
            </div>
            <div class="aui-chat-inner">
                <div class="aui-chat-name">${item.fUserBaseMsg.nikename} </div>
                <div class="aui-chat-content">
                    <div class="aui-chat-arrow"></div>
                        ${item.msgContent}
                </div>

            </div>
        </div>
        </c:forEach>
    </section>
</div>


<div id="item"  style="display: none">
    <div class="aui-chat-header">${currentDate}</div>
    <div class="aui-chat-item aui-chat-right">
        <div class="aui-chat-media">
            <img src="${imageBase}${fromUser.avatar}" />
        </div>
        <div class="aui-chat-inner">
            <div class="aui-chat-name">${fromUser.nikename} </div>
            <div class="aui-chat-content">
                <div class="aui-chat-arrow"></div>
                #msgContent
            </div>
        </div>
    </div>
</div>

<footer class="aui-bar aui-bar-tab" id="footer">
    <p><div class="aui-btn aui-btn-info aui-btn-block" aui-popup-for="top-left" >发送消息</div></p>
</footer>


<%--发送消息窗口--%>


<%--上传头像--%>
<div class="aui-popup aui-popup-top-left" style="width: 95%;" id="top-left">
    <div class="aui-popup-content">
<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;">


    <ul class="aui-list aui-media-list" id="listUser">


        <form id="sendForm" action="/m/sendMsg" method="post">
            <input name="toUserId" type="hidden" value="${toUser.userId}"/>
            <input name="backUrl" type="hidden" value="${backUrl}">
            <li class="aui-list-item">
                <div class="aui-list-item-input" style="padding: 1rem;">
                    <textarea placeholder="消息内容"  name="msgContent" id="msgContent" style="height: 200px;"></textarea>
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
    </div>
</div>


<%@ include file="/common/h5/js.jsp" %>
<script type="text/javascript" src="${ctx}/aui/script/aui-popup.js" ></script>
<script type="text/javascript" src="${ctx}/aui/script/aui-dialog.js"></script>
<script language="JavaScript">
    var popup = new auiPopup();

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
           // window.history.back();


        })
    }

    //提交
    function tijiao() {

        if ($("#msgContent").val() == "") {
            msg("请填写件信息");
            $("#msgContent").focus();
            return
        }

        toUserId = $("input[name='toUserId']").val();
        backUrl = $("input[name='backUrl']").val();
        msgContent = $("#msgContent").val();

        data = "toUserId="+toUserId+"&backUrl="+backUrl+"&msgContent="+msgContent;
        //获取签名数据并上传图片
        url = "/m/sendMsg";

        $.ajax({
            url: url,
            type: "POST",
            dataType: "json", //指定服务器返回的数据类型
            data:data,
            success: function (data) {
                addMsgView(msgContent);

                msg(data.message);
            }
        });
        popup.hide();
        $("#msgContent").val("");

        //$("#sendForm").submit();
    }

    //显示信息视图
    function addMsgView(msgContent) {
        tempHtml = $("#item").html().toString();
        tempHtml = tempHtml.replace("#msgContent",msgContent);
        $("#chatList").append(tempHtml);

        $("#chatList").scrollTop($("#chatList")[0].scrollHeight);
    }



</script>



</body>


</html>
