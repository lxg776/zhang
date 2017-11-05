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
                <li><a href="#">择偶要求</a></li>

            </ul>
            <div class="box span12" style="width: 800px;">

                <div class="box-header" data-original-title>
                    <h2>
                        <i class="halflings-icon white edit"></i><span class="break"></span>择偶要求
                    </h2>

                </div>
                <!-- 新闻栏目 -->
                <div class="box-content">
                    <form action="saveField" method="post" class="form-horizontal">
                        <fieldset>






                            <div class="control-group">
                                <label class="control-label" for="typeahead">要求身高(cm) </label>
                                <select id="sg" name="keyWord">
                                    <option value="online">不限</option>
                                    <option value="online">140~155</option>
                                    <option value="cn">155~165</option>
                                    <option value="en">165~175</option>
                                    <option value="en">175~185</option>
                                    <option value="en">185以上</option>
                                </select>
                            </div>





                            <div class="control-group">
                                <label class="control-label" for="typeahead">体型要求</label>
                                <div class="controls">
                                    <select id="tz" name="keyWord">
                                        <option value="online">不限</option>
                                        <option value="online">偏瘦</option>
                                        <option value="cn">一般</option>
                                        <option value="en">偏胖</option>
                                        <option value="en">强壮</option>
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
                                <label class="control-label" for="typeahead">与对方父母同住</label>
                                <div class="controls">
                                    <select id="rw" name="keyWord">
                                        <option value="online">不介意与对方父母同住</option>
                                        <option value="cn">不希望与对方父母同住</option>
                                        <option value="cn">看情况</option>

                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">要求对方购房情况</label>
                                <div class="controls">
                                    <select id="rw" name="keyWord">
                                        <option value="online">不限</option>
                                        <option value="cn">购有房屋</option>
                                        <option value="cn">可以共同购置房屋</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">要求对方购车情况</label>
                                <div class="controls">
                                    <select id="rw" name="keyWord">
                                        <option value="online">不限</option>
                                        <option value="cn">购有车辆</option>
                                    </select>
                                </div>
                            </div>





                            <div class="control-group">
                                <label class="control-label" for="typeahead"> 要求对方工作性质</label>
                                <div class="controls">
                                    <select id="dw" name="keyWord">
                                        <option value="online">不限</option>
                                        <option value="online">个体经营</option>
                                        <option value="online">政府，事业单位，公务员</option>
                                        <option value="cn">私营企业</option>
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
