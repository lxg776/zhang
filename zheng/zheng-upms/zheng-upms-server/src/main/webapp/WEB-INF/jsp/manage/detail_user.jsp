<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- start: Meta -->
    <%@include file="/common/meta.jsp"%>
    <!-- end: Mobile Specific -->
    <title>管理后台</title>
    <%@include file="/common/css-link01.jsp"%>
    <link id="base-style" href="${ctx}/aui/css/aui.css" rel="stylesheet">

    <!-- start: CSS -->
    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link id="ie-style" href="css/ie.css" rel="stylesheet">
    <![endif]-->
    <!--[if IE 9]>
    <link id="ie9style" href="css/ie9.css" rel="stylesheet">
    <![endif]-->
    <!-- start: Favicon -->
    <!-- end: Favicon -->
    <script type="text/javascript">
        var listUrl = "${ctx}" + "/manage/activity/list?pageNum=";
        function getDataList(pageNum) {
            window.location.href = listUrl + pageNum;
        }
    </script>
</head>

<body>
<!-- start: Header -->
<%@ include file="/common/ui/m-navbar.jsp"%>
<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <%@ include file="m-left.jsp"%>
        <!-- end: Main Menu -->

        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>
                    You need to have <a href="" target="_blank">JavaScript</a> enabled
                    to use this site.
                </p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span10">


            <ul class="breadcrumb">
                <li><i class="icon-home"></i> <a href="index.html">数据表</a> <i
                        class="icon-angle-right"></i></li>
                <li><a href="#">用户详情</a></li>
            </ul>

            <!-- 新闻栏目 -->

                <div class="box-content">
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
        </div>
    </div>
</div>





<div class="common-modal modal fade" id="common-Modal1" tabindex="-1"
     role="dialog" aria-hidden="true">
    <div class="modal-content">
        <ul class="list-inline item-details">
            <li><a href="http://sc.chinaz.com">Admin templates</a></li>
            <li><a href="http://sc.chinaz.com">Bootstrap themes</a></li>
        </ul>
    </div>
</div>

<div class="clearfix"></div>

<footer>

    <p>
			<span style="text-align: left; float: left">Copyright &copy;
				2016.Company name All rights reserved.<a target="_blank"
                                                         href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
			</span>
    </p>
</footer>
<!-- start: JavaScript-->
<%@ include file="/common/s.jsp"%>
</body>
</html>
