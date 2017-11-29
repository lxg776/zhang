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
                    <form action="editRequestMsg" method="post" class="form-horizontal">

                        <input type="hidden"
                               name="keyword" value="${keyword}" >

                        <input type="hidden"
                               name="userId" value="${modle.userId}" >


                       <fieldset>
                            <div class="control-group">
                                <label class="control-label" for="typeahead">要求身高(cm) </label>
                                <div class="controls">
                                <select id="sg" name="height">
                                    <option value="不限">不限</option>
                                    <option value="140~150"  <c:if test="${modle.height =='140~150' }"> selected="selected" </c:if>  >140~150</option>
                                    <option value="150~160"  <c:if test="${modle.height =='150~160' }"> selected="selected" </c:if>  >150~160</option>
                                    <option value="160~170" <c:if test="${modle.height =='160~170' }"> selected="selected" </c:if>  >160~170</option>
                                    <option value="170~185" <c:if test="${modle.height =='170~185' }"> selected="selected" </c:if>  >170~185</option>
                                    <option value="185以上" <c:if test="${modle.height =='185以上' }"> selected="selected" </c:if>  >185以上</option>
                                </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">体型要求</label>
                                <div class="controls">
                                    <select id="tz" name="shape">
                                        <option value="不限"  <c:if test="${modle.shape =='不限' }"> selected="selected" </c:if>  >不限</option>
                                        <option value="偏瘦" <c:if test="${modle.shape =='偏瘦' }"> selected="selected" </c:if> >偏瘦</option>
                                        <option value="一般"  <c:if test="${modle.shape =='一般' }"> selected="selected" </c:if> >一般</option>
                                        <option value="偏胖"  <c:if test="${modle.shape =='偏胖' }"> selected="selected" </c:if>  >偏胖</option>
                                        <option value="强壮"  <c:if test="${modle.shape =='强壮' }"> selected="selected" </c:if> >强壮</option>
                                    </select>
                                </div>
                            </div>

                           <div class="control-group">
                               <label class="control-label" for="typeahead">年龄要求</label>
                               <div class="controls">
                                   <select id="nl" name="age">
                                       <option value="不限"  <c:if test="${modle.age =='不限' }"> selected="selected" </c:if> >不限</option>
                                       <option value="20~28岁" <c:if test="${modle.age =='20~28岁' }"> selected="selected" </c:if>  >20~28岁</option>
                                       <option value="29~35岁" <c:if test="${modle.age =='29~35岁' }"> selected="selected" </c:if> >28~35岁</option>
                                       <option value="36~45岁" <c:if test="${modle.age =='36~45岁' }"> selected="selected" </c:if> >35~45岁</option>
                                       <option value="45岁以上" <c:if test="${modle.age =='45岁以上' }"> selected="selected" </c:if> >45岁以上</option>
                                   </select>
                               </div>
                           </div>


                           <div class="control-group">
                               <label class="control-label" for="typeahead">学历要求</label>
                               <div class="controls">
                                   <select id="xl" name="education">
                                       <option value="不限" <c:if test="${modle.education =='不限' }"> selected="selected" </c:if> >不限</option>
                                       <option value="高中以上" <c:if test="${modle.education =='高中以上' }"> selected="selected" </c:if> >高中以上</option>
                                       <option value="大专以上" <c:if test="${modle.education =='大专以上' }"> selected="selected" </c:if> >大专以上</option>
                                       <option value="本科以上" <c:if test="${modle.education =='本科以上' }"> selected="selected" </c:if> >本科以上</option>
                                       <option value="研究生"  <c:if test="${modle.education =='研究生' }"> selected="selected" </c:if> >研究生</option>
                                   </select>
                               </div>
                           </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">月薪(元)</label>
                                <div class="controls">
                                    <select id="ysr" name="incomeMonthly">
                                        <option value="3000以下" <c:if test="${modle.incomeMonthly =='3000以下' }"> selected="selected" </c:if>  >3000以下</option>
                                        <option value="3000~5000" <c:if test="${modle.incomeMonthly =='3000~5000' }"> selected="selected" </c:if> >3000~5000</option>
                                        <option value="5000~8000" <c:if test="${modle.incomeMonthly =='5000~8000' }"> selected="selected" </c:if> >5000~8000</option>
                                        <option value="8000~12000" <c:if test="${modle.incomeMonthly =='8000~12000' }"> selected="selected" </c:if>  >8000~12000</option>
                                        <option value="12000以上" <c:if test="${modle.incomeMonthly =='12000以上' }"> selected="selected" </c:if>  >12000以上</option>
                                    </select>
                                </div>
                            </div>

                           <div class="control-group">
                               <label class="control-label" for="typeahead">婚姻状况 </label>
                               <div class="controls">
                                   <select id="hyq" name="maritalStatus">
                                       <option value="不限" <c:if test="${modle.maritalStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                                       <option value="未婚" <c:if test="${modle.maritalStatus =='未婚' }"> selected="selected" </c:if>  >未婚</option>
                                       <option value="离异" <c:if test="${modle.maritalStatus =='离异' }"> selected="selected" </c:if> >离异</option>

                                   </select>
                               </div>
                           </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">与对方父母同住</label>
                                <div class="controls">
                                    <select id="lving" name="livingStatus">
                                        <option value="看情况" <c:if test="${modle.maritalStatus =='看情况' }"> selected="selected" </c:if> >看情况</option>
                                        <option value="不介意与对方父母同住" <c:if test="${modle.maritalStatus =='不介意与对方父母同住' }"> selected="selected" </c:if> >不介意与对方父母同住</option>
                                        <option value="不希望与对方父母同住" <c:if test="${modle.maritalStatus =='不希望与对方父母同住' }"> selected="selected" </c:if> >不希望与对方父母同住</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">要求对方购房情况</label>
                                <div class="controls">
                                    <select id="gfqk" name="houseStatus">
                                        <option value="不限" <c:if test="${modle.houseStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                                        <option value="购有房屋" <c:if test="${modle.houseStatus =='购有房屋' }"> selected="selected" </c:if> >购有房屋</option>

                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">要求对方购车情况</label>
                                <div class="controls">
                                    <select id="rw" name="carStatus">
                                        <option value="不限" <c:if test="${modle.carStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                                        <option value="购有车辆" <c:if test="${modle.carStatus =='购有车辆' }"> selected="selected" </c:if>  >购有车辆</option>
                                    </select>
                                </div>
                            </div>







                            <div class="control-group">
                                <label class="control-label" for="typeahead">工作要求 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="job" value="${modle.job}" data-provide="typeahead">
                                </div>
                            </div>





                            <div class="control-group">
                                <label class="control-label" for="typeahead">抽烟要求 </label>
                                <div class="controls">
                                    <select id="cy" name="smokeStatus">
                                        <option value="不限" <c:if test="${modle.smokeStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                                        <option value="不抽" <c:if test="${modle.smokeStatus =='不抽' }"> selected="selected" </c:if> >不抽</option>
                                        <option value="偶尔抽" <c:if test="${modle.smokeStatus =='偶尔抽' }"> selected="selected" </c:if> >偶尔抽</option>
                                        <option value="经常抽" <c:if test="${modle.smokeStatus =='经常抽' }"> selected="selected" </c:if> >经常抽</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">喝酒要求 </label>
                                <div class="controls">
                                    <select id="yj" name="drinkStatus">
                                        <option value="不限" <c:if test="${modle.drinkStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                                        <option value="不喝" <c:if test="${modle.drinkStatus =='不喝' }"> selected="selected" </c:if> >不喝</option>
                                        <option value="偶尔喝" <c:if test="${modle.drinkStatus =='偶尔喝' }"> selected="selected" </c:if> >偶尔喝</option>
                                        <option value="经常喝" <c:if test="${modle.drinkStatus =='经常喝' }"> selected="selected" </c:if>  >经常喝</option>
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
</body>
</html>
