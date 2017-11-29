<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/taglibs.jsp"%>
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
	var listUrl = "${ctx}" + "/news/newsList?pageNum=";
	function getDataList(pageNum) {
		pageLink =  listUrl + pageNum;
		nodeId = "${nodeId}";
		keyWord = "${keyWord}";
		if (nodeId.length != 0) {
			pageLink = pageLink+"&&nodeId="+nodeId;
		}
		if (keyWord.length != 0) {
			pageLink = pageLink+"&&keyWord="+keyWord;
		}
		window.location.href = pageLink;
	}
	
	
	var baseUrl = "${ctx}" + "/news/newsList";
	
	function searchNews(){
			  searchText = $("#searchText").val();
			  keyWord="";
			 if (searchText.length != 0) {
				 keyWord  = "keyWord="+searchText;
				 
			 }
			  nodeId ="";
			 $(".chosen-select option").each(function(){
				 if($(this).is(':checked')) {
					 if(nodeId.length == 0){
						 nodeId =  $(this).val();
					 }else{
						 nodeId = nodeId+","+ $(this).val();
					 }
				 }
			});
			 
			 
			 url=""; 
			if (nodeId.length != 0) {
				url = "nodeId="+nodeId;
			}
			
			if(url.length != 0&&keyWord.length!=0){
				url=url+"&&"+keyWord;
			}else{
				url=url+keyWord;
			} 
			
			if(url.length != 0){
				url = baseUrl +"?"  + url;
				window.location.href = url;
			}
			
			
	}
</script>

</head>

<body>
	<!-- start: Header -->
	<%@ include file="/WEB-INF/jsp/content/ui/m-navbar.jsp"%>
	<!-- start: Header -->

	<div class="container-fluid-full">
		<div class="row-fluid">

			<!-- start: Main Menu -->
			<%@ include file="/WEB-INF/jsp/content/ui/m-left.jsp"%>
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
					<li><i class="icon-home"></i> <a href="index.html">首页</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="#">新闻列表</a></li>

				</ul>

				<!-- 新闻栏目 -->
				<div class="box span6" style="width: 1100px;">
					<div class="box-header">
						<h2>
							<i class="halflings-icon white align-justify"></i><span
								class="break"></span>新闻栏目
						</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting" style="color: #FFF">备用</a>

						</div>
					</div>
					<div class="box-content">

						<form class="form-horizontal">
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="selectError1">内容标签</label>
									<div class="controls">
										<select class="chosen-select" name="nodeIdsArray"
											data-placeholder="选择节点" multiple>
											<c:forEach items="${nodeList}" var="item">
												<option value="${item.id}"
													<c:if test="${item.selectValue ==1}">selected="selected"</c:if>>${item.nodeName}/
													${item.id} /</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="selectError3">查询类型</label>
									<div class="controls">
										<select id="selectError3">
											<option>id</option>
											<option>标题</option>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="appendedInputButton">查询内容</label>
									<div class="controls">
										<div class="input-append">
											<input id="searchText" size="16" type="text" value="${keyWord}">
											<button class="btn" type="button" onclick="searchNews();">Search</button>
										</div>
									</div>
								</div>
						</form>
						</fieldset>

						<table class="table table-bordered table-striped table-condensed">
							<thead>
								<tr>
									<th style="text-align: center; min-width: 100px;">选择</th>
									<th style="text-align: center; min-width: 100px;">id</th>
									<th style="text-align: center; min-width: 800px;">内容</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="item" items="${page.dataList}">
									<tr>
										<td style="text-align: center; vertical-align: middle;"><span
											class=""><div class="checker"
													id="uniform-inlineCheckbox1">
													<span><input type="checkbox" id="inlineCheckbox1"
														value="option1"></span>
												</div></span></td>
										<td style="text-align: center; vertical-align: middle;">${item.id}</td>
										<td><div class="newsItem">
												<div class="title">
													<a href="#">${item.title}</a>
												</div>
												<c:if
													test="${item.imgList!= null && fn:length(item.imgList) > 0}">
													<ul class="imageList">
														<c:forEach items="${item.imgList}" var="url">

															<li><img src="${url}" /></li>
														</c:forEach>
													</ul>
												</c:if>

											</div>
											<div style="padding-top: 8px; clear: both;">
												<div class="sp">${item.pubTime}</div>
												<div class="sp">来源：${item.source}</div>
												<div class="sp">
													<a href="${item.sourceUrl}" target="_blank">原文地址</a>
												</div>
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<c:if test="${page.dataFla == true}">
							<%@include file="/common/c_pagination.jsp"%>
						</c:if>
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

	<script type="text/javascript">
		$(".chosen-select").chosen({
			no_results_text : "没有找到结果！",//搜索无结果时显示的提示
			search_contains : true, //关键字模糊搜索，设置为false，则只从开头开始匹配
			allow_single_deselect : true, //是否允许取消选择
			max_selected_options : 6
		//当select为多选时，最多选择个数
		});
	</script>

</body>
</html>
