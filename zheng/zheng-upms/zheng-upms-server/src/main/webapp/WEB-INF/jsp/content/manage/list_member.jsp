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
				<li><i class="icon-home"></i> <a href="index.html">数据表</a> <i
						class="icon-angle-right"></i></li>
				<li><a href="#">字段列表</a></li>
			</ul>




				<fieldset>
					<legend>用户查询</legend>
					<div class="control-group">




						<div class="controls">
							<span style="display:inline-block;width: 70px;">用户名</span>

							<input type="text" class="span3 typeahead"
								   name="userName"  data-provide="typeahead" value="${userName}">

						</div>

						<div class="controls">
							<span style="display:inline-block;width: 70px;">昵称</span>

							<input type="text" class="span3 typeahead"
								   name="nikename"  data-provide="typeahead" value="${nikename}" >

						</div>

						<div class="controls">
							<span style="display:inline-block;width: 70px;">婚姻状态</span>
							<select id="maritalStatus" name="maritalStatus" class="chzn-select">
								<option value="不限">不限</option>
								<option value="未婚" <c:if test="${maritalStatus =='未婚'}">  selected </c:if> >未婚</option>
								<option value="离异" <c:if test="${maritalStatus =='离异'}">  selected </c:if> >离异</option>

							</select>
						</div>


						<div class="control-group">
							<span style="display:inline-block;width: 70px;">查询城市</span>

							<div class="controls">
									<input type="checkbox" id="optionsCheckbox2" name="queryCity"  value="search" onchange="cityShow(this)" >
							</div>
						</div>

						<div id="citydiv" style="display: none;">
						<div class="controls">
							<span style="display:inline-block;width: 70px;">省</span>
							<select class="chzn-select" id="province">

							</select>
						</div>

						<div class="controls">
							<span style="display:inline-block;width: 70px;">市</span>


							<select name="fromCityId" class="chzn-select" id="citys">

							</select>
						</div>

						<div class="controls">
							<span style="display:inline-block;width: 70px;">区/县</span>


							<select name="fAreasId"  class="chzn-select" id="areas">

							</select>
						</div>
						</div>
					</div>




					<div class="control-group">
						<button  class="btn btn-primary" id="queryBtn">查询</button>
						<button  class="btn btn-primary">复位</button>
					</div>
				</fieldset>



			<!-- 新闻栏目 -->
			<div class="box span6" style="width: 1200px;">
				<div class="box-header">
					<h2>
						<i class="halflings-icon white align-justify"></i><span
							class="break"></span>会员管理
					</h2>
					<div class="box-icon">
						<a href="${ctx}/manage/member/editUser" style="color: #FFF">添加</a>
					</div>
				</div>
				<div class="box-content">
					<table class="table table-bordered" >
						<thead>
						<tr>
							<th style="width: 100px;">userId</th>
							<th style="width: 200px;">用户名</th>
							<th style="width: 200px;">昵称</th>
							<th style="width: 200px;">性别</th>
							<th style="width: 200px;">身高</th>
							<th style="width: 200px;">婚恋状态</th>
							<th style="width: 200px;">职业</th>
							<th style="width: 200px;">注册时间</th>
							<th style="width: 600px;">操作</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="item" items="${page.dataList}" >
							<tr>
								<td style="width: 100px;">${item.userId}</td>

								<td style="width: 200px;">
									<a href="${ctx}/manage/member/userDetail?userId=${item.userId}" style="color: #0033FF">${item.userName}</a>
								</td>

								<td style="width: 200px;">
									<a href="${ctx}/manage/member/userDetail?userId=${item.userId}" style="color: #0033FF">${item.fUserBaseMsg.nikename}</a>
								</td>

								<c:if test="${item.sex == 0}">	<td style="width: 200px;">未知</td></c:if>
								<c:if test="${item.sex == 1}"><td style="width: 200px;">男</td></c:if>
								<c:if test="${item.sex == 2}"><td style="width: 200px;">女</td></c:if>
								<c:if test="${item.sex == null}"><td style="width: 200px;"></td></c:if>
								<th style="width: 200px;">${item.fUserBaseMsg.height}cm</th>

								<th style="width: 200px;">${item.fUserBaseMsg.maritalStatus}</th>
								<th style="width: 200px;">${item.fUserBaseMsg.profession}</th>
								<td style="width: 200px;"><fmt:formatDate value="${item.createTime}" pattern="yyyy/MM/dd  HH:mm:ss" /></td>
								<td style="width: 600px;"><a href="${ctx}/manage/member/editUser?id=${item.userId}" style="color: #0033FF">编辑用户信息</a>
									/<a href="${ctx}/manage/member/editBaseMsg?userId=${item.userId}" style="color: #0033FF">编辑基本资料</a><br/><a href="${ctx}/manage/member/editIdentific?userId=${item.userId}" style="color: #0033FF">编辑认证信息</a>/<a href="${ctx}/manage/member//userMemberList?userId=${item.userId}" style="color: #0033FF">设置会员</a>/
								<a href="${ctx}/manage/member/editRequestMsg?userId=${item.userId}" style="color: #0033FF">编辑择偶要求</a>/<a href="${ctx}/manage/member/editLivingStatus?userId=${item.userId}" style="color: #0033FF">编辑生活状态</a>/<a href="${ctx}/manage/member/editUserSetting?userId=${item.userId}" style="color: #0033FF">用户设置</a>/<a href="${ctx}/manage/member/delUser?id=${item.userId}" style="color: #0033FF">删除</a>
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

<script src="${ctx}/js/city_list.js"></script>

<script language="JavaScript">

    $(document).ready(function(){
        initCityData(true);
    });

    var  dProvinceId="450000";
    var  dcityid = "451000";
    var  dAreaid = "451025";

    ctx = "${ctx}";

    //获取区县
    $("#province").change(function () {//当选择城市的下拉选的时候，区域进行联动
        getCityList($("#province").val(),"","",true);
    });

    //获取区县
    $("#citys").change(function () {//当选择城市的下拉选的时候，区域进行联动
        getAreasList($("#citys").val(),"",true);
    });




    areaFla ="";


    function cityShow(target){

        if(target.checked){
            $("#citydiv").show();
            areaFla = "true";
            //alert(target.value);
        }else{
            // do something
            $("#citydiv").hide();
            areaFla ="false";
        }
    }

    function seacher(url){

        userName = $("input[name='userName']").val();
        nikename = $("input[name='nikename']").val();
        maritalStatus = $("select[name='maritalStatus']").val();


        data = "";
        if(userName.length != 0){
            data = "userName="+userName;
        }
        if(nikename.length != 0){
            if(data.length!=0){
                data = data+"&nikename="+nikename;
            }else{
                data = "nikename="+nikename;
            }
        }
        if(maritalStatus.length != 0&&maritalStatus != '不限'){
            if(data.length!=0){
                data = data+"&maritalStatus="+maritalStatus;
            }else{
                data = "maritalStatus="+maritalStatus;
            }
        }

        if(areaFla == "true"){
            fromCityId = $("select[name='fromCityId']").val();
            if(fromCityId.length != 0) {
            if(data.length!=0){
                data = data+"&fromCityId="+fromCityId;
            }else{
                data = "fromCityId="+fromCityId;
            }
            }
            fAreasId = $("select[name='fAreasId']").val();
            if(fAreasId.length != 0) {
                if(data.length!=0){
                    data = data+"&fAreasId="+fAreasId;
                }else{
                    data = "fAreasId="+fAreasId;
                }
            }



		}


        window.location.href = url + data;
    }



    $("#queryBtn").click(function () {
        seacher("${ctx}/manage/member/list?");
    });


</script>

</body>
</html>
