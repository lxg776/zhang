<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->

    <%@include file="/common/h5/css-link.jsp"%>
    <link id="bootstrap-style" href="${ctx}/aui/css/aui-pull-refresh.css" rel="stylesheet">
    <title>首页</title>
    <!-- start: CSS -->


</head>

<body>
<header class="aui-bar aui-bar-nav" style="position: fixed;">

    <div class="aui-title" id="demo">靖西婚恋网</div>




</header>

<div style="padding-top: 2.25rem;padding-bottom: 2.25rem;background: ffffff">

    <div  id="page1" class="aui-content aui-margin-b-15">
        <ul class="aui-list aui-media-list" id="listUser">
            <li class="aui-list-header">
                每日推荐
            </li>

            <c:forEach var="item" items="${recommendUserList}" >
                <li class="aui-list-item">
                    <a href="javascript:;" onclick="viewUser(${item.userId})">
                    <div class="aui-media-list-item-inner">
                        <div class="aui-list-item-media" style="width: 7rem; height: 7rem;">
                            <img src="${ctx}/aui/image/mm.jpeg" >
                        </div>
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-text">
                                <div class="aui-list-item-title">${item.fUserBaseMsg.nikename}</div>

                                <div class="aui-list-item-right aui-greed">实名</div>
                            </div>
                            <div class="aui-list-item-text">
                                <div class="aui-list-item-text">25岁</div>
                                <div class="aui-list-item-text">${item.fUserBaseMsg.profession}</div>
                                <div class="aui-list-item-text">${item.fUserBaseMsg.height}cm</div>
                            </div>

                            <div class="aui-list-item-text" style="color: #0a0c0e">
                                择偶条件:我想找寻靖西<c:if test="${not empty item.fUserRequest.age}">年龄在${item.fUserRequest.age}岁,</c:if>
                                <c:if test="${not empty item.fUserRequest.height}">身高${item.fUserRequest.height}cm，</c:if>
                                <c:if test="${not empty item.fUserRequest.incomeMonthly}">月收入
                                    ${item.fUserRequest.incomeMonthly}元</c:if>的<c:if test="${item.sex == 1}">男性</c:if><c:if test="${item.sex == 2}">女性</c:if>
                            </div>
                        </div>
                    </div>
                    </a>

                    <div class="aui-info" style="padding-top:0">
                        <div class="aui-info-item">
                            <a href="#">打招呼</a>
                        </div>
                        <div class="aui-info-item">
                            <a href="javascript:;"  <c:if test="${fUserSetting.msgSendStatus == 0}">aui-popup-for="top-left" </c:if>
                               <c:if test="${fUserSetting.msgSendStatus == 1}">onclick="sendMsg(${item.userId})"</c:if>
                            >发信息</a>
                        </div>

                        <div class="aui-info-item" style="padding-right: 10px;">
                            <a href="javascript:;"  onclick="helpContact(${item.userId})" >帮我联系她</a>
                        </div>

                    </div>

                </li>
            </c:forEach>
        </ul>
    </div>


    <%--page2--%>

    <div  id="page2" class="aui-content aui-margin-b-15 aui-hide">

        <section class="aui-content">
            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    靖西龙潭烧烤<small>2016年7月12日</small>
                </div>
                <div class="aui-card-list-content">
                    <img src="${ctx}/aui/image/l2.png" />
                </div>
                <div class="aui-card-list-footer">


                    <div>报名费用:100元/人</div>

                    <div>单身交友</div>
                </div>

            </div>

            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    靖西龙潭烧烤<small>2016年7月12日</small>
                </div>
                <div class="aui-card-list-content">
                    <img src="${ctx}/aui/image/l2.png" />
                </div>
                <div class="aui-card-list-footer">


                    <div>报名费用:100元/人</div>

                    <div>单身交友</div>
                </div>

            </div>

            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    靖西龙潭烧烤<small>2016年7月12日</small>
                </div>
                <div class="aui-card-list-content">
                    <img src="${ctx}/aui/image/l2.png" />
                </div>
                <div class="aui-card-list-footer">


                    <div>报名费用:100元/人</div>

                    <div>单身交友</div>
                </div>

            </div>

            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    靖西龙潭烧烤<small>2016年7月12日</small>
                </div>
                <div class="aui-card-list-content">
                    <img src="${ctx}/aui/image/l2.png" />
                </div>
                <div class="aui-card-list-footer">


                    <div>报名费用:100元/人</div>

                    <div>单身交友</div>
                </div>

            </div>

            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    靖西龙潭烧烤<small>2016年7月12日</small>
                </div>
                <div class="aui-card-list-content">
                    <img src="${ctx}/aui/image/l2.png" />
                </div>
                <div class="aui-card-list-footer">


                    <div>报名费用:100元/人</div>

                    <div>单身交友</div>
                </div>

            </div>

            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    星歌会相亲交友<small>2016年7月12日</small>
                </div>
                <div class="aui-card-list-content">
                    <img src="${ctx}/aui/image/l2.png" />
                </div>
                <div class="aui-card-list-footer">


                    <div>报名费用:150元/人</div>

                    <div>单身交友</div>
                </div>

            </div>
        </section>
    </div>

    <%--page3--%>

    <div  id="page3" class="aui-content aui-margin-b-15 aui-hide">

        <div class="aui-tab" id="tab">
            <div class="aui-tab-item aui-active">收件箱</div>
            <div class="aui-tab-item">谁看过我</div>
        </div>


        <ul id="page3_p1" class="aui-list aui-media-list">
            <%--item--%>
            <c:forEach var="item" items="${msgList}" >
                <li class="aui-list-item" >
                    <a href="javascript:;" onclick="getMsgList(${item.fromUserId})">
                    <div class="aui-media-list-item-inner">

                        <div class="aui-list-item-media" style="width: 6.0rem; height: 6.0rem;">
                            <img src="${ctx}/aui/image/mm.jpeg" >
                            <c:if test="${item.unReadCount > 0}">
                            <div class="aui-badge" style="left: 82%; top: 5%">

                                    ${item.unReadCount}</div></c:if>

                        </div>
                        <div class="aui-list-item-inner">
                            <div class="aui-list-item-text">
                                <div class="aui-list-item-title">${item.fUserBaseMsg.nikename}</div>
                                <div class="aui-list-item-right"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd hh:mm" /></div>
                            </div>

                            <div class="aui-list-item-text" style="color:#757575;font-size: 14px;">
                                广西靖西市，30岁，${item.fUserBaseMsg.height}cm，${item.fUserBaseMsg.monthIncome}元
                            </div>
                        </div>
                    </div>
                    </a>
                </li>

            </c:forEach>
        </ul>


        <ul id="page3_p2" class="aui-list aui-media-list aui-hide">
            <%--item--%>
            <c:forEach var="item" items="${viewRecordList}" >
            <li class="aui-list-item">
                <a href="javascript:;" onclick="viewUser(${item.fUserId})">
                <div class="aui-media-list-item-inner">

                    <div class="aui-list-item-media" style="width: 6.0rem; height: 6.0rem;">
                        <img src="${ctx}/aui/image/mm.jpeg" >
                    </div>

                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-title">${item.fwUserBaseMsg.nikename}</div>
                            <div class="aui-list-item-right">${item.viewTime}</div>
                        </div>

                        <div class="aui-list-item-text" style="color:#757575;font-size: 14px;">
                            广西靖西市，30岁，${item.fwUserBaseMsg.height}cm，${item.fwUserBaseMsg.monthIncome}元
                        </div>
                    </div>
                </div>
                </a>
            </li>
            </c:forEach>



        </ul>



    </div>


    <%--page4--%>

    <div  id="page4" class="aui-content aui-margin-b-15 aui-hide">





        <ul class="aui-list aui-media-list">
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">

                    <div class="aui-list-item-media" style="width: 6.0rem; height: 6.0rem;">
                        <img src="${ctx}/aui/image/mm.jpeg" >
                    </div>
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-title">${modle.fUserBaseMsg.nikename}</div>
                            <div class="aui-list-item-right">访问次数99</div>
                        </div>

                        <div class="aui-list-item-text" style="color:#757575;font-size: 14px;">
                            广西靖西市，30岁，${modle.fUserBaseMsg.height}cm，${modle.fUserBaseMsg.monthIncome}元
                        </div>
                    </div>
                </div>
            </li>

            <div class="aui-card-list">
                <div class="aui-card-list-header">
                    相册
                    <div class="aui-list-item-right"><a href="/u/editPhoto" style="font-size: 0.7rem;">编辑</a></div>
                </div>
                <div class="aui-card-list-content-padded aui-border-b aui-border-t">
                    <div class="aui-row aui-row-padded">
                        <c:if test="${list == null}">
                            <c:forEach var="item" items="${userImages}">
                                <div class="aui-col-xs-4">
                                    <img src="${imageBase}${item.imagePath}"/>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>

            </div>

            <%--个人资料--%>
            <li class="aui-list-item">
                <div class="aui-media-list-item-inner">
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-text">
                            <div class="aui-list-item-title">个人资料</div>
                            <div class="aui-list-item-right"><a href="/u/editGrzl" style="font-size: 0.7rem;">编辑</a></div>
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
    <div class="aui-list-item-title">${modle.fUserBaseMsg.monthIncome}元</div>
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
                <div class="aui-list-item-right"><a href="/u/editZobz" style="font-size: 0.7rem;">编辑</a></div>
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
                <div class="aui-list-item-title">${modle.fUserRequest.incomeMonthly}元</div>
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
                <div class="aui-list-item-right"><a href="/u/editShzk" style="font-size: 0.7rem;">编辑</a></div>
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
                <div class="aui-list-item-right"><a href="/u/editXqhh" style="font-size: 0.7rem;">编辑</a></div>
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
<ul style="margin-top: 16px">

    <p><div class="aui-btn aui-btn-block aui-btn-outlined" id="logoutBtn" style="color: red;">注销登录</div></p>

</ul>


</div>

</div>
<footer class="aui-bar aui-bar-tab" id="footer">
    <div class="aui-bar-tab-item aui-active" tapmode>
        <i class="aui-iconfont aui-icon-home"></i>
        <div class="aui-bar-tab-label">首页</div>
    </div>
    <div class="aui-bar-tab-item" tapmode>
        <i class="aui-iconfont aui-icon-star"></i>
        <div class="aui-bar-tab-label">活动</div>
    </div>
    <div class="aui-bar-tab-item" tapmode>
        <div class="aui-badge">99</div>
        <i class="aui-iconfont aui-icon-comment"></i>
        <div class="aui-bar-tab-label">消息</div>
    </div>
    <div class="aui-bar-tab-item" tapmode>
        <div class="aui-dot"></div>
        <i class="aui-iconfont aui-icon-my"></i>
        <div class="aui-bar-tab-label">我的</div>
    </div>
</footer>


<div id="tempUser"  style="display: none">
    <li class="aui-list-item">
        <div class="aui-media-list-item-inner">
            <div class="aui-list-item-media" style="width: 7rem; height: 7rem;">
                <img src="${ctx}/aui/image/mm.jpeg" >
            </div>
            <div class="aui-list-item-inner">
                <div class="aui-list-item-text">
                    <div class="aui-list-item-title">#nikename</div>

                    <div class="aui-list-item-right aui-greed">实名</div>
                </div>
                <div class="aui-list-item-text">
                    <div class="aui-list-item-text">#age岁</div>
                    <div class="aui-list-item-text">#profession</div>
                    <div class="aui-list-item-text">#heightcm</div>
                </div>

                <div class="aui-list-item-text" style="color: #0a0c0e">
                    择偶条件:我想找寻靖西#zo
                </div>
            </div>
        </div>
        <div class="aui-info" style="padding-top:0">
            <div class="aui-info-item">
                <a href="#">打招呼</a>
            </div>
            <div class="aui-info-item">
                <a href="javascript:;"  <c:if test="${fUserSetting.msgSendStatus == 0}">aui-popup-for="top-left" </c:if>
                   <c:if test="${fUserSetting.msgSendStatus == 1}">onclick="sendMsg(#toUser)"</c:if>
                   >发信息</a>
            </div>

            <div class="aui-info-item" style="padding-right: 10px;">
                <a href="#">帮我联系她</a>
            </div>

        </div>
    </li>

</div>



<%--会员弹出框--%>
<div class="aui-popup aui-popup-top-left" style="width: 95%;display: none;" id="top-left">

    <div class="aui-popup-content">
        <div class="aui-content aui-margin-b-15" style="margin-top: 0.5rem;">

            <ul class="aui-list aui-media-list">

                <li class="aui-list-item">
                    <div class="aui-list-item-inner">

                        <div class="aui-list-item-input" style="margin-bottom: 8px;">
                            <label>开通的会员类型</label>
                        </div>
                        <c:forEach items="${typeList}" var="item">
                            <div class="aui-list-item-input" style="margin-top: 10px;">
                                <label><input class="aui-radio" type="radio" name="mTypeId" value="${item.id}" checked>&nbsp;&nbsp;&nbsp;${item.name}(${item.serviceDays}天)<span style="color: red;">¥${item.price}</span></label>
                            </div>
                        </c:forEach>

                    </div>
                </li>

                <li class="aui-list-item">
                    <div class="aui-list-item-inner">

                        <div class="aui-list-item-input" style="margin-bottom: 8px;">
                            <label>支付方式</label>
                        </div>

                        <div class="aui-list-item-input" style="margin-top: 10px; position: relative; height: 85px;" >
                            <label><input class="aui-radio" style="left: 4px; top: 30px; position: absolute"  type="radio" name="payVendorId" value="1" checked> <img src="${ctx}/aui/image/wx_pay_icon.png" style="width: 187px; left: 48px; position: absolute" /></label>

                        </div>
                        <div class="aui-list-item-input" style="margin-top: 10px; position: relative; height: 85px;" >
                            <label><input class="aui-radio" style="left: 4px; top: 30px; position: absolute"  type="radio" name="payVendorId" value="2"  checked> <img src="${ctx}/aui/image/zfb_pay_icon.png" style="width: 187px; left: 48px; position: absolute" /></label>

                        </div>
                    </div>
                </li>
            </ul>

            <div class="aui-content-padded">
                <div class="aui-btn aui-btn-info aui-btn-block" id="ktBtn" style="margin-top: 1rem;">立即开通</div>
            </div>
        </div>
    </div>

</div>

</body>

<%@ include file="/common/h5/js.jsp" %>

<script type="text/javascript" src="${ctx}/aui/script/aui-tab.js" ></script>


<script src="${ctx}/aui/script/aui-scroll.js"></script>
<script type="text/javascript" src="${ctx}/aui/script/aui-popup.js" ></script>
<script type="text/javascript" src="${ctx}/aui/script/aui-dialog.js"></script>

<script type="text/javascript">



        apiready = function(){
            api.parseTapmode();
        }

        var popup = new auiPopup();


        $("#logoutBtn").click(function () {
            window.location.href = "/u/logout";
        });



        var tab = new auiTab({
            element:document.getElementById("footer")
        },function(ret){
            if(ret.index==1){
                $("#page1").removeClass("aui-hide");
                $("#page2").addClass("aui-hide");
                $("#page3").addClass("aui-hide");
                $("#page4").addClass("aui-hide");

                $('body,html').animate({scrollTop:0},100);




            }else if(ret.index==2){
                $("#page1").addClass("aui-hide");
                $("#page2").removeClass("aui-hide");
                $("#page3").addClass("aui-hide");
                $("#page4").addClass("aui-hide");

                $('body,html').animate({scrollTop:0},100);
            }else if(ret.index==3){
                $("#page1").addClass("aui-hide");
                $("#page2").addClass("aui-hide");
                $("#page3").removeClass("aui-hide");
                $("#page4").addClass("aui-hide");

                $('body,html').animate({scrollTop:0},100);
            }else if(ret.index==4){
                $("#page1").addClass("aui-hide");
                $("#page2").addClass("aui-hide");
                $("#page3").addClass("aui-hide");
                $("#page4").removeClass("aui-hide");

                $('body,html').animate({scrollTop:0},100);
            }
        });


        var tab = new auiTab({
            element:document.getElementById("tab"),
        },function(ret){
            if(ret.index==1){
                $("#page3_p1").removeClass("aui-hide");
                $("#page3_p2").addClass("aui-hide");
            }else if(ret.index==2){
                $("#page3_p1").addClass("aui-hide");
                $("#page3_p2").removeClass("aui-hide");
            }


        });


        var scroll = new auiScroll({
            listen:true,
            distance:200 //判断到达底部的距离，isToBottom为true
        },function(ret){
            if(ret.isToBottom){
              //  document.getElementById("demo").textContent = "已到达底部";
                loadMoreUser();
            }else{

            }

        });

        var pageSize =15;
        var currentPage =1;
        <c:if test="${not empty pageSize}">
        pageSize = ${pageSize}
            </c:if>







            function loadMoreUser() {
                var userloadFla = false;

                userCount = $("#listUser").children(".aui-list-item").length;
                //document.getElementById("demo").textContent = "滚动高度："+userCount;
                pageNum = parseInt((userCount-1)/pageSize)+2;

                if(!userloadFla&&(pageNum>currentPage)){
                    $.ajax({
                        type: "GET",
                        url: "/u/loadRecommendUserList",
                        data: "pageNum="+pageNum,
                        async:false,
                        success: function(data){
                            userloadFla=true;
                            currentPage = data.data.pageNum;
                            if(data.code==1){
                                htmlString = ""
                                $.each(data.data.dataList, function(i, value) {
                                    htmlString =htmlString + getUserHtml(value);
                                });
                                $("#listUser").append(htmlString);
                            }else{
                                msg(data.message);
                            }
                        },
                        error:function(XMLHttpRequest, textStatus, errorThrown){
                            userloadFla=true;
                        }
                    });
                }
            }

        function helpContact(userId) {

            $.ajax({
                type: "GET",
                url: "/u/helpContact",
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

        function  createOrder() {

            var payVendorId = $("input[name='payVendorId']").val();
            var  mTypeId = $("input[name='mTypeId']").val();



            $.ajax({
                type: "POST",
                url: "/u/createOrder",
                data: "payVendorId="+payVendorId+"&mTypeId="+mTypeId,
                async:false,
                success: function(data){

                    payUrl  = data.data.payUrl;

                    window.location.href = payUrl;

                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    userloadFla=true;
                }
            });


        }


        function getUserHtml(item) {
            tempHtml = $("#tempUser").html().toString();
            tempHtml = tempHtml.replace("#nikename",item.fUserBaseMsg.nikename);
            tempHtml = tempHtml.replace("#profession",item.fUserBaseMsg.profession);
            tempHtml = tempHtml.replace("#height",item.fUserBaseMsg.height);
            tempHtml = tempHtml.replace("#height",item.fUserBaseMsg.height);
            tempHtml = tempHtml.replace("#zo",getUserRequest(item));
            tempHtml = tempHtml.replace("#toUser",item.userId);
            console.log(tempHtml);
            return tempHtml;
        }

        function getUserRequest(item) {
            tempHtml = "";
            if(item.fUserRequest.age){
                tempHtml = tempHtml +"年龄在"+item.fUserRequest.age+"岁,";
            }
            if(item.fUserRequest.height){
                tempHtml = tempHtml +"身高"+item.fUserRequest.height+"cm,";
            }
            if(item.fUserRequest.incomeMonthly){
                tempHtml = tempHtml +"月收入"+item.fUserRequest.incomeMonthly+"元,";
            }

            if(item.sex == '1'){
                tempHtml = tempHtml +"的男性";
            }
            if(item.sex == '2'){
                tempHtml = tempHtml +"的女性";
            }
            return tempHtml;
        }





        //获取消息列表
        function getMsgList(fromUserId) {
            url = "/m/msgList?fromUserId="+fromUserId;
            window.location.href= url;
            // console.log("wtf");
        }



        function  sendMsg(toUid) {

            backUrl = window.location.href;
            url = "/m/sendMsg?uid="+toUid+"&backUrl="+backUrl;
            window.location.href = url;
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


    function  viewUser(uid) {
        url = "/u/userDetail?uid="+uid;
        window.location.href = url;
    }


</script>























</html>
