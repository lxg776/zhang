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
                <li><a href="#">生活状况</a></li>

            </ul>
            <div class="box span12" style="width: 800px;">

                <div class="box-header" data-original-title>
                    <h2>
                        <i class="halflings-icon white edit"></i><span class="break"></span>生活状况
                    </h2>

                </div>
                <!-- 新闻栏目 -->
                <div class="box-content">
                    <form action="editLivingStatus" method="post" class="form-horizontal">

                        <input type="hidden"
                               name="keyword" value="${keyword}" >

                        <input type="hidden"
                               name="userId" value="${modle.userId}" >


                       <fieldset>
                            <div class="control-group">
                                <label class="control-label" for="typeahead">抽烟状况 </label>
                                <div class="controls">
                                <select id="chouyan" name="smokingStatus">
                                    <option value="0" <c:if test="${modle.smokingStatus =='0' }"> selected="selected" </c:if> >不抽</option>
                                    <option value="1" <c:if test="${modle.smokingStatus =='1' }"> selected="selected" </c:if>>偶尔抽</option>
                                    <option value="2" <c:if test="${modle.smokingStatus =='2' }"> selected="selected" </c:if>>经常抽</option>
                                </select>
                                </div>
                            </div>

                           <div class="control-group">
                               <label class="control-label" for="typeahead">饮酒状况 </label>
                               <div class="controls">
                                   <select id="hej" name="drinkingStatus">
                                       <option value="0" <c:if test="${modle.drinkingStatus =='0' }"> selected="selected" </c:if> >不喝</option>
                                       <option value="1" <c:if test="${modle.drinkingStatus =='1' }"> selected="selected" </c:if> >偶尔喝</option>
                                       <option value="2" <c:if test="${modle.drinkingStatus =='2' }"> selected="selected" </c:if> >经常喝</option>
                                   </select>
                               </div>
                           </div>


                           <div class="control-group">
                               <label class="control-label" for="typeahead"> 厨艺</label>
                               <div class="controls">
                                   <select id="chuyi" name="cooking">
                                       <option value="0" <c:if test="${modle.cooking =='0' }"> selected="selected" </c:if> >不下厨</option>
                                       <option value="1" <c:if test="${modle.cooking =='1' }"> selected="selected" </c:if> >厨艺有待提高</option>
                                       <option value="2" <c:if test="${modle.cooking =='2' }"> selected="selected" </c:if> >上得了厅堂</option>
                                       <option value="3" <c:if test="${modle.cooking =='3' }"> selected="selected" </c:if> >饭店大厨级别</option>
                                   </select>
                               </div>
                           </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">与父母同住</label>
                                <div class="controls">
                                    <select id="tz" name="liveWithParents">
                                        <option value="不与父母同住"  <c:if test="${modle.liveWithParents =='不与父母同住' }"> selected="selected" </c:if>  >不与父母同住</option>
                                        <option value="与父母同住"  <c:if test="${modle.liveWithParents =='与父母同住' }"> selected="selected" </c:if>  >与父母同住</option>
                                        <option value="看情况"  <c:if test="${modle.liveWithParents =='看情况' }"> selected="selected" </c:if>  >看情况</option>
                                    </select>
                                </div>
                            </div>

                           <div class="control-group">
                               <label class="control-label" for="typeahead">喜欢怎么样的约会</label>
                               <div class="controls">
                                   <select id="yh" name="favoriteDate">
                                       <option value="公园散步/爬山"  <c:if test="${modle.favoriteDate =='公园散步' }"> selected="selected" </c:if> >公园散步</option>
                                       <option value="奶茶/咖啡厅"  <c:if test="${modle.favoriteDate =='奶茶/咖啡厅' }"> selected="selected" </c:if> >奶茶/咖啡厅</option>
                                       <option value="电影院" <c:if test="${modle.favoriteDate =='电影院' }"> selected="selected" </c:if> >电影院</option>
                                       <option value="酒吧" <c:if test="${modle.favoriteDate =='酒吧' }"> selected="selected" </c:if> >酒吧</option>
                                   </select>
                               </div>
                           </div>


                           <div class="control-group">
                               <label class="control-label" for="typeahead">喜欢的音乐 </label>
                               <div class="controls">
                                   <input type="text" class="span6 typeahead" id="typeahead"
                                          name="favoriteMusic" value="${modle.favoriteMusic}" data-provide="typeahead">
                               </div>
                           </div>


                           <div class="control-group">
                               <label class="control-label" for="typeahead">喜欢的音乐 </label>
                               <div class="controls">
                                   <input type="text" class="span6 typeahead" id="typeahead"
                                          name="favoriteFilm" value="${modle.favoriteFilm}" data-provide="typeahead">
                               </div>
                           </div>


                           <div class="control-group">
                               <label class="control-label" for="typeahead">喜欢的运动 </label>
                               <div class="controls">
                                   <input type="text" class="span6 typeahead" id="typeahead"
                                          name="favoriteSports" value="${modle.favoriteSports}" data-provide="typeahead">
                               </div>
                           </div>


                           <div class="control-group">
                               <label class="control-label" for="typeahead">喜欢的宠物 </label>
                               <div class="controls">
                                   <input type="text" class="span6 typeahead" id="typeahead"
                                          name="favoritePet" value="${modle.favoritePet}" data-provide="typeahead">
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
