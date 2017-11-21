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
                    <form action="editBaseMsg" method="post" class="form-horizontal">

                        <input type="hidden"
                               name="keyword" value="${keyword}" >

                        <input type="hidden"
                               name="userId" value="${modle.userId}" >

                        <fieldset>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">昵称 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="nikename" value="${modle.nikename}" data-provide="typeahead">

                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">出生年月 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="birthDate" value="${modle.birthDate}" data-provide="typeahead">
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">身高(cm) </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="height" value="${modle.height}" data-provide="typeahead">
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">性格类型 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="disposition" value="${modle.disposition}" data-provide="typeahead">
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">体型</label>
                                <div class="controls">
                                    <select id="tz" name="shape">
                                        <option value="偏瘦" <c:if test="${modle.shape=='偏瘦'}"> selected="selected"</c:if>  >偏瘦</option>
                                        <option value="一般" <c:if test="${modle.shape=='一般'}"> selected="selected"</c:if>  >一般</option>
                                        <option value="偏胖" <c:if test="${modle.shape=='偏胖'}"> selected="selected"</c:if> >偏胖</option>
                                        <option value="强壮" <c:if test="${modle.shape=='强壮'}"> selected="selected"</c:if>  >强壮</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">年收入</label>
                                <div class="controls">
                                    <select id="nsr" name="yearIncome">
                                        <option value="5w以下"  <c:if test="${modle.yearIncome=='5w以下'}"> selected="selected"</c:if> >5w以下</option>
                                        <option value="5w~10w" <c:if test="${modle.yearIncome=='5w~10w'}"> selected="selected"</c:if> >5w~10w</option>
                                        <option value="10w~15w" <c:if test="${modle.yearIncome=='10w~15w'}"> selected="selected"</c:if> >5w~10w</option>>10w~15w</option>
                                        <option value="15w~20w" <c:if test="${modle.yearIncome=='15w~20w'}"> selected="selected"</c:if> >15w~20w</option>
                                        <option value="20w~50w" <c:if test="${modle.yearIncome=='20w~50w'}"> selected="selected"</c:if> >20w~50w</option>
                                        <option value="50w以上" <c:if test="${modle.yearIncome=='50w以上'}"> selected="selected"</c:if> >50w以上</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">月薪(元)</label>
                                <div class="controls">
                                    <select id="ysr" name="monthIncome">
                                        <option value="3000以下" <c:if test="${modle.monthIncome=='3000以下'}"> selected="selected"</c:if>  >3000以下</option>
                                        <option value="3000~5000"  <c:if test="${modle.monthIncome=='3000~5000'}"> selected="selected"</c:if>  >3000~5000</option>
                                        <option value="5000~8000" <c:if test="${modle.monthIncome=='5000~8000'}"> selected="selected"</c:if>  >5000~8000</option>
                                        <option value="8000~12000" <c:if test="${modle.monthIncome=='8000~12000'}"> selected="selected"</c:if> >8000~12000</option>
                                        <option value="12000以上" <c:if test="${modle.monthIncome=='12000以上'}"> selected="selected"</c:if> >12000以上</option>
                                    </select>
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">房屋状况</label>
                                <div class="controls">
                                    <select id="rw" name="houseStatus">
                                        <option value="未购房" <c:if test="${modle.houseStatus=='未购房'}"> selected="selected"</c:if> >未购房</option>
                                        <option value="已经购房" <c:if test="${modle.houseStatus=='已经购房'}"> selected="selected"</c:if>  >已经购房</option>
                                        <option value="与父母同住" <c:if test="${modle.houseStatus=='与父母同住'}"> selected="selected"</c:if> >与父母同住</option>
                                    </select>
                                </div>
                            </div>



                            <div class="control-group">
                                <label class="control-label" for="typeahead">职业 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="profession" value="${modle.profession}" data-provide="typeahead">
                                </div>
                            </div>


                            <div class="control-group">
                                <label class="control-label" for="typeahead">单位性质 </label>
                                <div class="controls">
                                    <select id="dw" name="unitProperty">
                                        <option value="私营企业" <c:if test="${modle.unitProperty=='私营企业'}"> selected="selected"</c:if>  >私营企业</option>
                                        <option value="国有企业" <c:if test="${modle.unitProperty=='国有企业'}"> selected="selected"</c:if>  >国有企业</option>
                                        <option value="事业单位" <c:if test="${modle.unitProperty=='事业单位'}"> selected="selected"</c:if>  >事业单位</option>
                                        <option value="国家行政机关" <c:if test="${modle.unitProperty=='国家行政机关'}"> selected="selected"</c:if> >国家行政机关</option>
                                    </select>
                                </div>
                            </div>




                            <div class="control-group">
                                <label class="control-label" for="typeahead">工作地点 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="workPlace" value="${modle.workPlace}" data-provide="typeahead">
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">婚姻状况</label>
                                <div class="controls">
                                    <select id="hyin" name="maritalStatus">
                                        <option value="未婚" <c:if test="${modle.maritalStatus=='未婚'}"> selected="selected"</c:if>  >未婚</option>
                                        <option value="离婚" <c:if test="${modle.maritalStatus=='离婚'}"> selected="selected"</c:if>  >离婚</option>
                                        <option value="结婚" <c:if test="${modle.maritalStatus=='结婚'}"> selected="selected"</c:if>  >结婚</option>
                                    </select>
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">是否有孩子 </label>
                                <div class="controls">
                                    <select id="hy" name="childrenStatus">
                                        <option value="没有" <c:if test="${modle.childrenStatus=='没有'}"> selected="selected"</c:if> >没有</option>
                                        <option value="有" <c:if test="${modle.childrenStatus=='有'}"> selected="selected"</c:if>  >有</option>
                                    </select>
                                </div>
                            </div>



                            <div class="control-group">
                                <label class="control-label" for="typeahead">内心独白</label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="soliloquy" value="${modle.soliloquy}" data-provide="typeahead">

                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="typeahead">交友宣言 </label>
                                <div class="controls">
                                    <input type="text" class="span6 typeahead" id="typeahead"
                                           name="declaration" value="${modle.declaration}" data-provide="typeahead">

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
