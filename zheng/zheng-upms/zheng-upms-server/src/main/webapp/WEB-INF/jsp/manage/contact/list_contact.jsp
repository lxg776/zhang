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
        var listUrl = "${ctx}" + "/manage/contact/list?pageNum=";
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
        <%@ include file="../m-left.jsp"%>
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
                <li><a href="#">帮忙联系</a></li>
            </ul>

            <!-- 新闻栏目 -->
            <div class="box span6" style="width: 1200px;">
                <div class="box-header">
                    <h2>
                        <i class="halflings-icon white align-justify"></i><span
                            class="break"></span>帮忙联系
                    </h2>
                    <div class="box-icon">
                        <a href="${ctx}/manage/activity/edit" style="color: #FFF">添加</a>

                    </div>
                </div>
                <div class="box-content">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th style="width: 100px;">id</th>
                            <th style="width: 800px;">联系人</th>
                            <th style="width: 100px;">被联系人</th>
                            <th style="width: 100px;">次数</th>
                            <th style="width: 100px;">标识</th>
                            <th style="width: 100px;">时间</th>

                            <th style="width: 100px;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${page.dataList}" >
                            <tr>
                                <td>${item.id}</td>
                                <td style="width: 200px;">
                                            <a target="_blank" href="${ctx}/manage/member/userDetail?userId=${item.fUserBaseMsg.userId}" style="color: #0033FF"> ${item.fUserBaseMsg.nikename}</a>
                                </td>
                                <td style="width: 200px;">
                                    <a target="_blank" href="${ctx}/manage/member/userDetail?userId=${item.tUserBaseMsg.userId}" style="color: #0033FF"> ${item.tUserBaseMsg.nikename}</a>
                                        </td>
                                <td style="width: 200px;">${item.contactCount}</td>

                                <th style="width: 100px;"><c:if test="${item.bothStatus == 0}">单向</c:if>
                                    <c:if test="${item.bothStatus == 1}">双向</c:if>
                                </th>
                                <td style="width: 200px;"><fmt:formatDate value="${item.createTime}" pattern="yyyy/MM/dd  HH:mm:ss" /></td>

                                <td style="width: 100px;"><a href="${ctx}/manage/contact/edit?id=${item.id}" style="color: #0033FF">编辑</a>
                                    /<a href="#" style="color: #0033FF">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <%@include file="/common/c_pagination.jsp"%>
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
