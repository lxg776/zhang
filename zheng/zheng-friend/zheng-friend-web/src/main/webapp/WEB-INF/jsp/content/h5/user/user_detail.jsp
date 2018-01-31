<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->
    <%@include file="/common/h5/css-link.jsp"%>

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

    <%--page4--%>

    <div  id="page4" class="aui-content aui-margin-b-15">

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
</body>

<%@ include file="/common/h5/js.jsp" %>




<script type="text/javascript">




    $("#backBtn").click(function(){
        window.history.back();
    });



</script>


</body>
</html>
