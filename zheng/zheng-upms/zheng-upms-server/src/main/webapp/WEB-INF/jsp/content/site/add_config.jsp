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
					<li><a href="#">配置</a></li>
					<i class="icon-angle-right"></i>
					</li>
					<li><a href="#">编辑</a></li>
				</ul>
				<div class="box span12" style="width: 1000px;">

					<div class="box-header" data-original-title>
						<h2>
							<i class="halflings-icon white edit"></i><span class="break"></span>配置
						</h2>

					</div>
					<!-- 新闻栏目 -->
					<div class="box-content">
						<form action="saveConfig" method="post" class="form-horizontal">
							<fieldset>

								<c:if test="${vo.id!=null}">

									<div class="control-group">
										<label class="control-label" for="typeahead">id </label> <label
											class="control-label" for="typeahead">${vo.id}
										</label>
									</div>
								</c:if>

								<div class="control-group">
									<label class="control-label" for="typeahead">别名 </label>
									<div class="controls">
										<input type="text" class="span6 typeahead" id="typeahead"
											name="alias" value="${vo.alias}"
											data-provide="typeahead">

									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="typeahead">配置 </label>
									<div class="controls">
										<textarea name="configJsonText" rows="10" cols="30" style="width: 700px; height: 600px;">${vo.configJsonText}</textarea>
										

									</div>
								</div>
								<input type="hidden" name="id" value="${vo.id}"> <input
									type="hidden" name="keyWord" value="${vo.keyWord}">

								<div class="form-actions">
									<button type="submit" class="btn btn-primary">保存</button>
									<button type="reset" class="btn">取消</button>
								</div>
							</fieldset>
						</form>

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
