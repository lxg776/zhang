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

    <link href="/editor/themes/default/css/ueditor.css" rel="stylesheet" >


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
                <li><a href="#">活动管理</a></li>
                <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">活动信息</a></li>

            </ul>
            <div class="box span12" style="width: 800px;">

                <div class="box-header" data-original-title>
                    <h2>
                        <i class="halflings-icon white edit"></i><span class="break"></span>编辑活动
                    </h2>

                </div>
                <!-- 新闻栏目 -->
                <div class="box-content">
                    <form action="doEdit" method="post" class="form-horizontal">

                        <input type="hidden"
                               name="keyword" value="${keyword}" />

                        <input type="hidden"
                               name="activityId" value="${modle.activityId}" />


                        <fieldset>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">活动标题 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="title" value="${modle.title}" data-provide="typeahead">


                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">封面图片 </label>
                                <div class="controls">
                                    <%--<input type="text" class="span6 typeahead" --%>
                                    <%--name="title" value="${modle.title}" data-provide="typeahead">--%>
                                        <input type="hidden" class="span6 typeahead" id="coverImage"
                                               name="coverImage" value="${modle.coverImage}" data-provide="typeahead">
                                    <img id="headImg"


                                    <c:if test="${not empty modle.coverImage}">
                                         src="${imageBase}${modle.coverImage}"
                                    </c:if>
                                         style="width: 200px; height:px;">
                                        <a href="javascript:void(0);" onclick="getImage();">上传</a>
                                </div>
                                <input id="inputImage" type="file" placeholder="选择图片"  accept="image/*" style="display: none;" />
                            </div>
                            <div class="control-group">
                                <label class="control-label">活动时间</label>
                                <div class="controls date form_datetime" data-date-format="yyyy-mm-dd HH:ii" data-link-field="dtp_activityTime">
                                    <input size="16" name="activityTime" type="text" value="${modle.activityTime}" id="dtp_activityTime" >
                                    <span class="add-on"><i class="icon-remove"></i></span>
                                    <span class="add-on"><i class="icon-th"></i></span>
                                </div>

                            </div>


                            <div class="control-group">
                                <label class="control-label">报名开始时间</label>
                                <div class="controls date form_datetime" data-date-format="yyyy-mm-dd HH:ii" data-link-field="dtp_signTime">
                                    <input size="16" type="text" name="signTime" value="${modle.signTime}" id="dtp_signTime" >
                                    <span class="add-on"><i class="icon-remove"></i></span>
                                    <span class="add-on"><i class="icon-th"></i></span>
                                </div>

                            </div>





                            <div class="control-group">
                                <label class="control-label">报名截止时间</label>
                                <div class="controls date form_datetime" data-date-format="yyyy-mm-dd HH:ii" data-link-field="dtp_signEndTime">
                                    <input size="16" name="signEndTime" type="text" value="${modle.signEndTime}" id="dtp_signEndTime" >
                                    <span class="add-on"><i class="icon-remove"></i></span>
                                    <span class="add-on"><i class="icon-th"></i></span>
                                </div>

                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead"> 报名电话</label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="linkPhone" value="${modle.linkPhone}"


                                           pattern="^1[3|4|5|7|8][0-9]{9}$"
                                           data-bv-regexp-message="手机格式错误"
                                           data-provide="typeahead" />

                                </div>
                            </div>




                            <div class="control-group">
                                <label class="control-label" for="typeahead">报名费用 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="signCost" value="${modle.signCost}" data-provide="typeahead">

                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">主办方 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="sponsor" value="${modle.sponsor}" data-provide="typeahead">

                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">联系人 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="linkMan" value="${modle.linkMan}" data-provide="typeahead">

                                </div>
                            </div>





                            <div class="control-group">
                                <label class="control-label" for="typeahead">显示操作 </label>
                                <div class="controls">
                                    <select id="selectError3" name="showStatus">
                                        <option value="show">显示</option>
                                        <option value="hidden">隐藏</option>

                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">活动内容 </label>


                                <div class="controls">
                                           <div id="modleContent" style="display: none">
                                               ${modle.content}
                                           </div>

                                    <script id="editor" style="width:600px;height:400px;" name="content" > </script>
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
                                <script type="text/javascript" src="${ctx}/webuploader/dist/webuploader.js"></script>
                        <script type="text/javascript" src="/js/uploadImg.js" charset="UTF-8"></script>
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

    function getImage() {
        document.getElementById('inputImage').click();
    }



</script>
                                    <script type="text/javascript" charset="utf-8" src="/editor/ueditor.config.js"></script>
                                    <script type="text/javascript" charset="utf-8" src="/editor/ueditor.all.js"> </script>
                                    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
                                    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
                                    <script type="text/javascript" charset="utf-8" src="/editor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

   // var ue = UE.getEditor('editor');

    var basePath = "${ctx}";
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action) {
        if (action == '/manage/ue/images') {
            return basePath + '/manage/ue/images';
        } else {
            return this._bkGetActionUrl.call(this, action);
        }
    }
   $(document).ready(function(){

       var proinfo=$("#modleContent").html();
       ue.ready(function() {//编辑器初始化完成再赋值
             ue.setContent(proinfo);  //赋值给UEditor
       });

   });

   //    UE.Editor.prototype.getActionUrl = function(action) {
//        if (action == '/manage/ue/images') {
//            return basePath + 'manage/ue/images';
//        } else {
//            return this._bkGetActionUrl.call(this, action);
//        }
//    }

//    $.ajax({
//        url:'http://127.0.0.1:2222//manage/ue/dispatch?action=config',
//        type:'GET', //GET
//
//
//        success:function(data,textStatus,jqXHR){
//            console.log(data)
//
//        },
//        error:function(xhr,textStatus){
//            console.log('错误')
//
//        },
//
//    })


</script>
</body>
</html>
