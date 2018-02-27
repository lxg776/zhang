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
    <link href="/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

</head>

<body>
<!-- start: Header -->
<%@ include file="/common/ui/m-navbar.jsp" %>

<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <%@ include file="../m-left.jsp" %>
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
                <li><a href="#">活动管理</a></li>
                <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">活动信息</a></li>

            </ul>
            <div class="box span12" style="width: 1000px;">

                <div class="box-header" data-original-title>
                    <h2>
                        <i class="halflings-icon white edit"></i><span class="break"></span>编辑红娘联系
                    </h2>

                </div>

                <!-- 新闻栏目 -->
                <div class="box-content">
                    <form action="edit" method="post" class="form-horizontal">

                        <input type="hidden"
                               name="keyword" value="${keyword}" />

                        <input type="hidden"
                               name="id" value="${modle.id}" />

                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">联系人: ${modle.fUserBaseMsg.nikename}</label>
                                <div class="controls">
                                    <label class="control-label">被联系人: ${modle.tUserBaseMsg.nikename}</label>
                                </div>
                            </div>



                            <div class="control-group">
                                <label class="control-label">备注 </label>
                                <div class="controls">
                                    <textarea name="remarks" data-provide="typeahead" style="width: 600px; height: 400px;"> ${modle.remarks}</textarea>

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


<script type="text/javascript" src="/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/bootstrap/js//locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">



    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });


</script>


</body>
</html>
