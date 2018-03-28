<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<jsp:useBean id="dateValue" class="java.util.Date"/>

<!DOCTYPE html>
<html lang="en">
<head>

	<!-- start: Meta -->
	<%@include file="/common/meta.jsp"%>
	<!-- end: Mobile Specific -->
	<title>订单列表</title>
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
        var listUrl = "${ctx}" + "/manage/member/list?pageNum=";
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
				<li><i class="icon-home"></i> <a href="index.html">订管管理</a> <i
						class="icon-angle-right"></i></li>
				<li><a href="#">订单列表</a></li>
			</ul>

			<!-- 新闻栏目 -->
			<div class="box span6" style="width: 800px;">
				<div class="box-header">
					<h2>
						<i class="halflings-icon white align-justify"></i><span
							class="break"></span>订单列表
					</h2>
					<div class="box-icon">
						<a href="${ctx}/manage/member/editUser" style="color: #FFF">添加</a>
					</div>
				</div>
				<div class="box-content">
					<table class="table table-bordered">
						<thead>
						<tr>

							<th style="width: 200px;">订单编号</th>
							<th style="width: 100px;">用户</th>
							<th style="width: 120px;">商品名称</th>
							<th style="width: 100px;">商品价格</th>
							<th style="width: 100px;">下单时间</th>
							<th style="width: 100px;">状态</th>
							<th style="width: 200px;">操作</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="item" items="${page.dataList}" >
							<tr>
								<td style="width: 100px;">${item.id}</td>
								<td style="width: 120px;">${item.userName}</td>
								<td style="width: 100px;">${item.productName}</td>
								<td style="width: 100px;"><fmt:formatNumber type="number" value="${item.amount/100 }" pattern="0.00" maxFractionDigits="2"/></td>
								<td style="width: 200px;">
									<jsp:setProperty name="dateValue" property="time" value="${item.ctime}"/>
									<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
													value="${dateValue}" />
								</td>



								public final static byte STATUS_CREATE = '1';//订单创建
								public final static byte STATUS_PAY = '2';//订单支付，但未完成更改资料
								public final static byte ORDER_FINISH = '2';//订单完成，未完成更改资料
								public final static byte ORDER_CANCEL = '3';//订单取消

								<td style="width: 100px;">
									<c:if test="${item.status == '1'}">
										未付款
									</c:if>

									<c:if test="${item.status == '2'}">
										待完成（更改资料）
									</c:if>

									<c:if test="${item.status == '3'}">
										完成
									</c:if>

									<c:if test="${item.status == '4'}">
										订单取消
									</c:if>
								</td>

								<td style="width: 200px;">
									操作</td>
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
