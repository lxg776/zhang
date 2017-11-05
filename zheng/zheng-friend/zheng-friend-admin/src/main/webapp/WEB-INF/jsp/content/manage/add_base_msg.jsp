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
                <li><a href="#">基本信息</a></li>

            </ul>
            <div class="box span12" style="width: 800px;">

                <div class="box-header" data-original-title>
                    <h2>
                        <i class="halflings-icon white edit"></i><span class="break"></span>基本信息
                    </h2>

                </div>
                <!-- 新闻栏目 -->
                <div class="box-content">
                    <form action="saveField" method="post" class="form-horizontal">
                        <fieldset>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">昵称 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">

                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">出生年月 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">身高(cm) </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">性格类型 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">体型</label>
                                <div class="controls">
                                    <select id="tz" name="keyWord">
                                        <option value="online">偏瘦</option>
                                        <option value="cn">一般</option>
                                        <option value="en">偏胖</option>
                                        <option value="en">强壮</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">年收入</label>
                                <div class="controls">
                                    <select id="nsr" name="keyWord">
                                        <option value="online">5w以下</option>
                                        <option value="cn">5w~10w</option>
                                        <option value="en">10w~15w</option>
                                        <option value="en">15w~20w</option>
                                        <option value="en">20w~50w</option>
                                        <option value="en">50w以上</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">月薪(元)</label>
                                <div class="controls">
                                    <select id="ysr" name="keyWord">
                                        <option value="online">3000以下</option>
                                        <option value="cn">3000~5000</option>
                                        <option value="en">5000~8000</option>
                                        <option value="en">8000~12000</option>
                                        <option value="en">12000以上</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">房屋状况</label>
                                <div class="controls">
                                    <select id="rw" name="keyWord">
                                        <option value="online">未购房</option>
                                        <option value="cn">已经购房</option>
                                        <option value="en">与父母同住</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">月薪(元)</label>
                                <div class="controls">
                                    <select id="ysr" name="keyWord">
                                        <option value="online">3000以下</option>
                                        <option value="cn">3000~5000</option>
                                        <option value="en">5000~8000</option>
                                        <option value="en">8000~12000</option>
                                        <option value="en">12000以上</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">单位性质 </label>
                                <div class="controls">
                                    <select id="dw" name="keyWord">
                                        <option value="online">私营企业</option>
                                        <option value="online">国有企业</option>
                                        <option value="cn">事业单位</option>
                                        <option value="en">国家行政机关</option>
                                        <option value="en">政府</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">职业 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">工作地点 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">婚姻状况 </label>
                                <div class="controls">
                                    <select id="hy" name="keyWord">
                                        <option value="online">未婚</option>
                                        <option value="online">离婚</option>

                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">是否有孩子 </label>
                                <div class="controls">
                                    <select id="hy" name="keyWord">
                                        <option value="online">没有</option>
                                        <option value="online">有</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">是否抽烟 </label>
                                <div class="controls">
                                    <select id="hy" name="keyWord">
                                        <option value="online">不抽</option>
                                        <option value="online">偶尔抽</option>
                                        <option value="online">经常抽</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">是否喝酒 </label>
                                <div class="controls">
                                    <select id="hy" name="keyWord">
                                        <option value="online">不喝</option>
                                        <option value="online">偶尔喝</option>
                                        <option value="online">经常喝</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">内心独白 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">

                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">交友宣言 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="show_field_name" value="{vo.show_field_name}" data-provide="typeahead">

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
</body>
</html>
