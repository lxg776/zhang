<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <%@include file="/common/meta.jsp" %>
    <!-- end: Mobile Specific -->
    <title>管理后台</title>
    <%@include file="/common/css-link01.jsp" %>
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
    <link id="ie-style" href="${ctx}/webuploader/css/webuploader.css" rel="stylesheet">

    <link id="ie-style" href="${ctx}/webuploader/examples/image-upload/style.css" rel="stylesheet">


    <style type="text/css">
        .imgDiv {
            display: inline-block;
            position: relative;
        }

        .imgDiv .delete {
            position: absolute;
            top: 0px;
            right: 0px;
            width: 12px;
            height: 12px;
        }
    </style>

</head>

<body>
<!-- start: Header -->
<%@ include file="/common/ui/m-navbar.jsp" %>

<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <%@ include file="m-left.jsp" %>
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
                <li><a href="#">会员管理</a></li>
                <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">认证信息</a></li>

            </ul>
            <div class="box span12" style="width: 800px;">

                <div class="box-header" data-original-title>
                    <h2>
                        <i class="halflings-icon white edit"></i><span class="break"></span>认证信息
                    </h2>

                </div>
                <!-- 新闻栏目 -->
                <div class="box-content">
                    <form action="editIdentific" method="post" class="form-horizontal">
                        <input type="hidden"
                               name="keyword" value="${keyword}" >

                        <input type="hidden"
                               name="userId" value="${modle.userId}" >

                        <fieldset>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">真实姓名 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="realName" value="${modle.realName}" data-provide="typeahead">

                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">手机号码 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="cellphone" value="${modle.cellphone}" data-provide="typeahead">

                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">证件类型 </label>
                                <div class="controls">
                                    <select id="selectError4" name="idcardType">
                                        <option value="idcard">身份证</option>
                                        <option value="other">其他证件</option>

                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">证件号码 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="idcardNo" value="${modle.idcardNo}" data-provide="typeahead">

                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead"> 证件图片</label>
                                <div class="controls">
                                            <c:forEach var="item" items="${imgs}" varStatus="go" >
                                                <div class="imgDiv" id="imgDiv${go.index}">
                                                    <img src="${imageBase}${item}"  d-value="${item}"/>
                                                    <a href="javascript:void(0);" onclick="deleteImageByName(${go.index},'${item}')">
                                                        <img src="${ctx}/bootstrap/img/close-button.png" class="delete" />
                                                    </a>
                                                </div>
                                            </c:forEach>
                                </div>

                            </div>

                            <div class="control-group">


                                <label class="control-label" for="typeahead">证件上传 </label>

                                <div class="controls">
                                    <div id="wrapper">
                                        <div id="container">
                                            <!--头部，相册选择和格式选择-->

                                            <div id="uploader">
                                                <div class="queueList">
                                                    <div id="dndArea" class="placeholder">
                                                        <div id="filePicker"></div>
                                                        <p>或将照片拖到这里，单次最多可选2张</p>
                                                    </div>
                                                </div>
                                                <div class="statusBar" style="display:none;">
                                                    <div class="progress">
                                                        <span class="text">0%</span>
                                                        <span class="percentage"></span>
                                                    </div><div class="info"></div>
                                                    <div class="btns">
                                                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <input id="imgs" type="hidden" name="idcardImgs"  value="${modle.idcardImgs}" />
                                </div>



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

    <div class="common-modal modal fade" id="common-Modal1" tabindex="-1"
         role="dialog" aria-hidden="true">
        <div class="modal-content">
            <ul class="list-inline item-details">
                <li><a href="http://sc.chinaz.com">Admin templates</a></li>
                <li><a href="http://sc.chinaz.com">Bootstrap themes</a></li>
            </ul>
        </div>
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
<%@ include file="/common/s.jsp" %>
<script language="JavaScript">

    function deleteImageByName(index,path) {
        id = "#imgDiv".concat(index);
        imgs =   $("#imgs").val();
        mImgsArray = imgs.split(",");
        orgImgs="";
        $.each(mImgsArray,function(index,value){
            if(value!=path){
                if(orgImgs&&orgImgs.length>0){
                    orgImgs = orgImgs +","+value;
                }else{
                    orgImgs = value;
                }

            }
        });
        $("#imgs").val(orgImgs);
       $(id).remove();
    }


</script>
<script type="text/javascript" src="${ctx}/webuploader/dist/webuploader.js"></script>
<script type="text/javascript" src="${ctx}/webuploader/examples/image-upload/upload.js"></script>


</body>
</html>
