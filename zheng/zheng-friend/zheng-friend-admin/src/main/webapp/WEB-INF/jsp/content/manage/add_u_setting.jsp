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
    <link id="ie-style" href="${ctx}/webuploader-0.1.5/css/webuploader.css" rel="stylesheet">

    <link id="ie-style" href="${ctx}/webuploader-0.1.5/examples/image-upload/style.css" rel="stylesheet">


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
                <li><a href="#">用户设置</a></li>

            </ul>
            <div class="box span12" style="width: 800px;">

                <div class="box-header" data-original-title>
                    <h2>
                        <i class="halflings-icon white edit"></i><span class="break"></span>用户设置
                    </h2>

                </div>
                <!-- 新闻栏目 -->
                <div class="box-content">
                    <form action="editUserSetting"" method="post" class="form-horizontal">
                        <input type="hidden"
                               name="keyword" value="${keyword}" >

                        <input type="hidden"
                               name="userId" value="${modle.userId}" >

                        <fieldset>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">首页能否显示 </label>
                                <div class="controls">
                                    <select id="chouyan" name="showIndexPage">
                                        <option value="0" <c:if test="${modle.showIndexPage =='0' }"> selected="selected" </c:if> >能</option>
                                        <option value="1" <c:if test="${modle.showIndexPage =='1' }"> selected="selected" </c:if> >不能</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">基本信息能否显示</label>
                                <div class="controls">
                                    <select id="basemsg" name="showBaseMsg">
                                        <option value="0" <c:if test="${modle.showBaseMsg =='0' }"> selected="selected" </c:if> >能</option>
                                        <option value="1" <c:if test="${modle.showBaseMsg =='1' }"> selected="selected" </c:if> >不能</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">择偶要求能否显示</label>
                                <div class="controls">
                                    <select id="zheou" name="showFriendRequest">
                                        <option value="0" <c:if test="${modle.showFriendRequest =='0' }"> selected="selected" </c:if> >能</option>
                                        <option value="1" <c:if test="${modle.showFriendRequest =='1' }"> selected="selected" </c:if> >不能</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">生活状况能否显示</label>
                                <div class="controls">
                                    <select id="living" name="showLivingStatus">
                                        <option value="0" <c:if test="${modle.showLivingStatus =='0' }"> selected="selected" </c:if> >能</option>
                                        <option value="1" <c:if test="${modle.showLivingStatus =='1' }"> selected="selected" </c:if> >不能</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">兴趣爱好能否显示</label>
                                <div class="controls">
                                    <select id="showFavorite" name="showFavorite">
                                        <option value="0" <c:if test="${modle.showFavorite =='0' }"> selected="selected" </c:if> >能</option>
                                        <option value="1" <c:if test="${modle.showFavorite =='1' }"> selected="selected" </c:if> >不能</option>
                                    </select>
                                </div>
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

        $.each(mImgsArray,function(index,value){
            orgImgs="";
            if(value!=path){
                if(orgImgs&&orgImgs.length>0){
                    orgImgs = orgImgs +","+value;
                }else{
                    orgImgs = value;
                }
                $("#imgs").val(orgImgs);
            }
        });
        $(id).remove();
    }


</script>
<script type="text/javascript" src="${ctx}/webuploader-0.1.5/dist/webuploader.js"></script>
<script type="text/javascript" src="${ctx}/webuploader-0.1.5/examples/image-upload/upload.js"></script>


</body>
</html>
