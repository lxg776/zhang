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
        var listUrl = "${ctx}" + "/manage/member/auditingList?pageNum=";
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
                        <span style="display:inline-block;width: 70px;">审核状态</span>
                        <select id="idcardStatus" name="idcardStatus" class="chzn-select">
                            <option value="不限">不限</option>
                            <option value="0" <c:if test="${idcardStatus =='2'}">  selected </c:if> >审核通过</option>
                            <option value="1" <c:if test="${idcardStatus =='1'}">  selected </c:if> >审核不通过</option>
                        </select>
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
                            class="break"></span>审核列表
                    </h2>
                    <div class="box-icon">
                        <a href="${ctx}/manage/member/editUser" style="color: #FFF">添加</a>
                    </div>
                </div>
                <div class="box-content">
                    <table class="table table-bordered" >
                        <thead>
                        <tr>

                            <th style="width: 200px;">用户名</th>
                            <th style="width: 200px;">年龄</th>
                            <th style="width: 200px;">性别</th>
                            <th style="width: 200px;">身高</th>
                            <th style="width: 200px;">身份证</th>
                            <th style="width: 300px;">身份证图片</th>
                            <th style="width: 200px;">注册时间</th>
                            <th style="width: 200px;">审核状态</th>
                            <th style="width: 600px;">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${page.dataList}" >
                            <tr>
                                <td style="width: 200px;">
                                    <a href="${ctx}/manage/member/userDetail?userId=${item.userId}" style="color: #0033FF">${item.userName}</a>
                                </td>

                                <td style="width: 200px;">
                                    ${item.age}
                                </td>

                                <c:if test="${item.sex == 0}">	<td style="width: 200px;">未知</td></c:if>
                                <c:if test="${item.sex == 1}"><td style="width: 200px;">男</td></c:if>
                                <c:if test="${item.sex == 2}"><td style="width: 200px;">女</td></c:if>
                                <c:if test="${item.sex == null}"><td style="width: 200px;"></td></c:if>
                                <th style="width: 200px;">${item.fUserBaseMsg.height}cm</th>
                                <th style="width: 200px;">${item.ucenterIdentificaion.idcardNo}</th>
                                <th style="width: 300px;">
                                    <c:forEach var="it" items="${item.idcardImgs}" varStatus="go" >
                                        <div class="imgDiv" id="imgDiv${go.index}">
                                            <img src="${imageBase}${it}"  d-value="${it}"/>
                                        </div>
                                    </c:forEach>
                                </th>
                                <td style="width: 200px;"><fmt:formatDate value="${item.createTime}" pattern="yyyy/MM/dd  HH:mm:ss" /></td>
                                <c:if test="${item.fUserSetting.idcardStatus == 0}"><td style="width: 200px;">审核通过</td></c:if>
                                <c:if test="${item.fUserSetting.idcardStatus == 1}"><td style="width: 200px;">审核不通过</td></c:if>
                                <c:if test="${empty item.fUserSetting.idcardStatus}"><td style="width: 200px;">未设置</td></c:if>



                                <td style="width: 600px;"><a href="${ctx}/manage/member/editUser?id=${item.userId}" style="color: #0033FF">
                                    通过审核
                                </a>/
                                    <a href="${ctx}/manage/member/editUser?id=${item.userId}" style="color: #0033FF">
                                        不通过审核
                                    </a>
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
        idcardStatus = $("select[name='idcardStatus']").val();


        data = "";
        if(userName.length != 0){
            data = "userName="+userName;
        }

        if(idcardStatus.length != 0&&idcardStatus != '不限'){
            if(data.length!=0){
                data = data+"&idcardStatus="+idcardStatus;
            }else{
                data = "idcardStatus="+idcardStatus;
            }
        }



        window.location.href = url + data;
    }



    $("#queryBtn").click(function () {
        seacher("${ctx}/manage/member/auditingList?");
    });


</script>

</body>
</html>