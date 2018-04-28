<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->
    <%@include file="/common/h5/css-link.jsp"%>
    <link rel="stylesheet" href="${ctx}/viewerjs/dist/viewer.min.css">
    <title>用户详情</title>
    <!-- start: CSS -->
</head>

<body>
<header class="aui-bar aui-bar-nav" style="position: fixed;">

    <div class="aui-title" id="demo">用户详情</div>
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>

</header>

<div style="padding-top: 2.25rem;padding-bottom: 2.25rem;background: #ffffff">



    <div  id="page4" class="aui-content aui-margin-b-15">

        <ul class="aui-list aui-media-list" >
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">

                    <div class="aui-list-item-media" style="width: 6.0rem; height: 6.0rem;" >
                        <c:if test="${not empty modle.avatar}">
                            <img src="${imageBase}${modle.avatar}" >
                        </c:if>
                        <c:if test="${empty modle.avatar}">
                            <c:if test="${modle.sex == 1}">
                                <img src="${ctx}/image/default_man_icon.png" >
                            </c:if>
                            <c:if test="${modle.sex == 2}">
                                <img src="${ctx}/image/default_woman_icon.png" >

                            </c:if>
                        </c:if>
                    </div>
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-title">${modle.fUserBaseMsg.nikename}</div>
                            <div class="aui-list-item-right"></div>
                        </div>

                        <div class="aui-list-item-text" style="color:#757575;font-size: 14px;">
                            广西靖西市，30岁，${modle.fUserBaseMsg.height}cm，${modle.fUserBaseMsg.monthIncome}
                        </div>
                    </div>

                </div>
                <div class="aui-info" style="padding-top:0">
                    <div class="aui-info-item">
                        <a href="javascript:;"  onclick="sendGreetToUser(${modle.userId})">打招呼</a>
                    </div>
                    <div class="aui-info-item">
                        <a href="javascript:;"  <c:if test="${fUserSetting.msgSendStatus == 0}">aui-popup-for="top-left" </c:if>
                           <c:if test="${fUserSetting.msgSendStatus == 1}">onclick="getMsgList(${modle.userId})"</c:if>
                        >发信息</a>
                    </div>

                    <div class="aui-info-item" style="padding-right: 10px;">
                        <a href="javascript:;"  onclick="helpContact(${modle.userId})" >帮我联系她</a>
                    </div>

                </div>

            </li>

            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    相册

                </div>
                <div class="aui-card-list-content-padded aui-border-b aui-border-t">
                    <div class="aui-row aui-row-padded">
                        <ul id="images">


                        <c:if test="${list == null}">
                            <c:forEach var="item" items="${userImages}">
                                <li class="aui-col-xs-4">
                                    <img src="${imageBase}${item.imagePath}"/>
                                </li>
                            </c:forEach>
                        </c:if>
                        </ul>
                    </div>
                </div>

            </div>

            <%--个人资料--%>
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-title">个人资料</div>

                        </div>
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-left">昵称</div>
                            <div class="aui-list-item-title">${modle.fUserBaseMsg.nikename}</div>
                        </div>

                        <div class="aui-list-item-text">
                            <div class="aui-list-item-left">年龄</div>
                        <div class="aui-list-item-title">26岁</div>
                    </div>

                    <div class="aui-list-item-text">
                        <div class="aui-list-item-left"">学历</div>
                    <div class="aui-list-item-title">${modle.fUserBaseMsg.education}</div>

                </div>

                <div class="aui-list-item-text">
                    <div class="aui-list-item-left"">身高</div>
                <div class="aui-list-item-title">${modle.fUserBaseMsg.height}cm</div>
    </div>

    <div class="aui-list-item-text">
        <div class="aui-list-item-left"">月收入</div>
    <div class="aui-list-item-title">${modle.fUserBaseMsg.monthIncome}</div>
</div>



<div class="aui-list-item-text">
    <div class="aui-list-item-left"">体型</div>
<div class="aui-list-item-title">${modle.fUserBaseMsg.shape}</div>
</div>

<div class="aui-list-item-text">
    <div class="aui-list-item-left"">婚姻状况</div>
<div class="aui-list-item-title">${modle.fUserBaseMsg.maritalStatus}</div>
</div>

</div>
</div>
</li>
<li class="aui-list-item">
    <div class="aui-media-list-item-inner">
        <div class="aui-list-item-inner">
            <div class="aui-list-item-text">
                <div class="aui-list-item-title">择偶条件</div>

            </div>
            <div class="aui-list-item-text">
                <div class="aui-list-item-left">年龄</div>
                <div class="aui-list-item-title">${modle.fUserRequest.age}岁</div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">身高</div>
                <div class="aui-list-item-title">${modle.fUserRequest.height}cm</div>
            </div>


            <div class="aui-list-item-text">
                <div class="aui-list-item-left">月收入</div>
                <div class="aui-list-item-title">${modle.fUserRequest.incomeMonthly}</div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">学历</div>
                <div class="aui-list-item-title">${modle.fUserRequest.education}</div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">婚姻</div>
                <div class="aui-list-item-title">${modle.fUserRequest.maritalStatus}</div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">住房情况</div>
                <div class="aui-list-item-title">${modle.fUserRequest.houseStatus}</div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">购车情况</div>
                <div class="aui-list-item-title">${modle.fUserRequest.carStatus}</div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">体型</div>
                <div class="aui-list-item-title">${modle.fUserRequest.shape}</div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">有无小孩</div>
                <div class="aui-list-item-title">${modle.fUserRequest.childStatus}</div>
            </div>



        </div>


    </div>

</li>

<li class="aui-list-item">
    <div class="aui-media-list-item-inner">
        <div class="aui-list-item-inner">
            <div class="aui-list-item-text">
                <div class="aui-list-item-title">生活状态</div>

            </div>
            <div class="aui-list-item-text">
                <div class="aui-list-item-left">抽烟状况</div>
                <div class="aui-list-item-title">
                    <c:if test="${modle.fUserLivingStatus.smokingStatus == 0 }">不抽</c:if>
                    <c:if test="${modle.fUserLivingStatus.smokingStatus == 1 }">偶尔抽</c:if>
                    <c:if test="${modle.fUserLivingStatus.smokingStatus == 2 }">经常抽</c:if>
                </div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">饮酒状况</div>
                <div class="aui-list-item-title">
                    <c:if test="${modle.fUserLivingStatus.drinkingStatus == 0 }">不喝</c:if>
                    <c:if test="${modle.fUserLivingStatus.drinkingStatus == 1 }">偶尔喝</c:if>
                    <c:if test="${modle.fUserLivingStatus.drinkingStatus == 2 }">经常喝</c:if>
                </div>
            </div>


            <div class="aui-list-item-text">
                <div class="aui-list-item-left">厨艺</div>
                <div class="aui-list-item-title">
                    <c:if test="${modle.fUserLivingStatus.cooking == 0 }">不下厨</c:if>
                    <c:if test="${modle.fUserLivingStatus.cooking == 1 }">厨艺有待提高</c:if>
                    <c:if test="${modle.fUserLivingStatus.cooking == 2 }">上得了厅堂</c:if>
                    <c:if test="${modle.fUserLivingStatus.cooking == 3 }">饭店大厨级别</c:if>
                </div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">与父母同住</div>
                <div class="aui-list-item-title">
                    ${modle.fUserLivingStatus.liveWithParents}
                </div>
            </div>

        </div>


    </div>

</li>

<li class="aui-list-item">
    <div class="aui-media-list-item-inner">
        <div class="aui-list-item-inner">
            <div class="aui-list-item-text">
                <div class="aui-list-item-title">兴趣爱好</div>

            </div>
            <div class="aui-list-item-text">
                <div class="aui-list-item-left">喜欢的音乐</div>
                <div class="aui-list-item-title">
                    ${modle.fUserLivingStatus.favoriteMusic}
                </div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">喜欢的电影</div>
                <div class="aui-list-item-title">
                    ${modle.fUserLivingStatus.favoriteFilm}
                </div>
            </div>


            <div class="aui-list-item-text">
                <div class="aui-list-item-left">喜欢的运动</div>
                <div class="aui-list-item-title">
                    ${modle.fUserLivingStatus.favoriteSports}
                </div>
            </div>

            <div class="aui-list-item-text">
                <div class="aui-list-item-left">喜欢的宠物</div>
                <div class="aui-list-item-title">
                    ${modle.fUserLivingStatus.favoritePet}
                </div>
            </div>
        </div>


    </div>

</li>

</ul>
</div>
</div>



<%--会员弹出框--%>
<div class="aui-popup aui-popup-bottom-left" style="width: 95%;display: none;" id="top-buttom">

    <div class="aui-popup-content">
        <div class="aui-content aui-margin-b-15" style="margin-top: 0.5rem;">

            <ul class="aui-list aui-media-list">

                <li class="aui-list-item">
                    <div class="aui-list-item-text">
                        <div class="aui-list-item-title">问候语</div>

                        <div class="aui-list-item-right" style="padding-right: 16px;"><i class="aui-iconfont aui-icon-close"  id="greetingCloseBtn"></i></div>
                    </div>
                    <div class="aui-list-item-inner">


                        <input type="hidden" id="gtoUserId" />
                        <c:forEach items="${greetingTempList}" var="item">
                            <div class="aui-list-item-input" style="margin-top: 10px;">
                                <label><input class="aui-radio" type="radio" name="greeting" value="${item.id}" checked>&nbsp;&nbsp;&nbsp;${item.content}</label>
                            </div>
                        </c:forEach>
                    </div>
                </li>
            </ul>

            <div class="aui-content-padded">
                <div class="aui-btn aui-btn-info aui-btn-block" id="greetingBtn" style="margin-top: 1rem;">发送</div>
            </div>
        </div>
    </div>

</div>

</body>

<%@ include file="/common/h5/js.jsp" %>

<script type="text/javascript" src="${ctx}/aui/script/aui-dialog.js"></script>
<script type="text/javascript" src="${ctx}/aui/script/aui-popup.js" ></script>
<script src="${ctx}/viewerjs/dist/viewer.min.js"></script>
<script type="text/javascript">


    var popup = new auiPopup();

    $("#backBtn").click(function(){
        window.history.back();
    });

    function helpContact(userId) {

        $.ajax({
            type: "GET",
            url: "${ctx}/u/helpContact",
            data: "tUserId="+userId,
            async:false,
            success: function(data){
                msg(data.message);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){

            }
        });

    }


    $("#ktBtn").click(function () {
        createOrder();
    });

    $("#greetingBtn").click(function () {
        sendGreeting();
    });


    $("#greetingCloseBtn").click(function () {
        popup.hide();
    });
    $("#payCloseBtn").click(function () {
        popup.hide();
    });


    //发送问候语
    function  sendGreetToUser(toUid) {
        $("#gtoUserId").val(toUid);
        showPopDiv = document.getElementById("top-buttom");
        if(showPopDiv){
            if(showPopDiv.className.indexOf("aui-popup-in") > -1 || document.querySelector(".aui-popup-in")){
                popup.hide(showPopDiv);
            }else{
                popup.show(showPopDiv);
            }
        }else{
            return;
        }




    }


    //发送问候语
    function sendGreeting() {
        var greetingId = $("input[name='greeting']").val();
        var friendId = $("#gtoUserId").val();
        popup.hide();
        $.ajax({
            type: "POST",
            url: "${ctx}/m/sendGreeting",
            data: "greetingId="+greetingId+"&friendId="+friendId,
            success: function(data){
                msg(data.message);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                popup.hide();
            }
        });


    }

    var dialog = new auiDialog();
    function msg(msg) {
        dialog.alert({
            title:"提示",
            msg:msg,
            buttons:['确定']
        },function(ret){
            // console.log(ret)
        })
    }

    function  sendMsg(toUid) {

        backUrl = window.location.href;
        url = "${ctx}/m/sendMsg?uid="+toUid+"&backUrl="+backUrl;
        window.location.href = url;
    }

    //获取消息列表
    function getMsgList(fromUserId) {
        url = "${ctx}/m/msgList?fromUserId="+fromUserId;
        window.location.href= url;
        // console.log("wtf");
    }

    // View a list of images
    var viewer = new Viewer(document.getElementById('images'));


</script>


</body>
</html>
