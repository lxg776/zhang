<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->
    <%@include file="/common/h5/css-link.jsp"%>

    <title>首页</title>
    <!-- start: CSS -->
    <style type="text/css">
        #demo {
            background-color: #e0e0e0;
        }
    </style>

</head>

<body>
<header class="aui-bar aui-bar-nav">
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">个人资料</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 0.5rem;">
    <form method="post" action="/h5/txGrzl" id="regForm">
    <ul class="aui-list aui-form-list">


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    昵称
                </div>

                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写昵称" name="nikename" value="${modle.nikename}">
                </div>
            </div>
        </li>


        <li class="aui-list-item">   <div class="aui-list-item-label" style="font-size: 10px;color: #757575;"><label>(注册后不能修改) </label></div></li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    生日
                </div>

                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写生日" name="birthDate" value="${modle.birthDate}">
                </div>
            </div>
        </li>
        <li class="aui-list-item">   <div class="aui-list-item-label" style="font-size: 10px;color: #757575;"><label>(注册后不能修改) </label></div></li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    身高(cm)
                </div>
                <div class="aui-list-item-input">
                    <input type="number" placeholder="填写身高" name="height" value="${modle.height}" />
                </div>
            </div>
        </li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    婚姻
                </div>

                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="maritalStatus" <c:if test="${modle.maritalStatus=='未婚'}"> checked</c:if> >未婚</label>
                    <label><input class="aui-radio" type="radio" name="maritalStatus"  <c:if test="${modle.maritalStatus=='离异'}"> checked</c:if> >离异</label>
                    <label><input class="aui-radio" type="radio" name="maritalStatus" <c:if test="${modle.maritalStatus=='丧偶'}"> checked</c:if>  >丧偶</label>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    是否有孩子
                </div>

                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="childrenStatus" <c:if test="${modle.maritalStatus=='没有'}"> checked</c:if> >没有</label>
                    <label><input class="aui-radio" type="radio" name="childrenStatus"  <c:if test="${modle.maritalStatus=='有'}"> checked</c:if> >有</label>
                </div>
            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    职业
                </div>

                <div class="aui-list-item-input">
                    <input type="text" placeholder="填写职业" name="profession" value="${modle.profession}">
                </div>
            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    单位性质
                </div>
                <div class="aui-list-item-input">
                    <select id="dw" name="unitProperty">
                        <option value="私营企业" <c:if test="${modle.unitProperty=='私营企业'}"> selected="selected"</c:if>  >私营企业</option>
                        <option value="国有企业" <c:if test="${modle.unitProperty=='国有企业'}"> selected="selected"</c:if>  >国有企业</option>
                        <option value="事业单位" <c:if test="${modle.unitProperty=='事业单位'}"> selected="selected"</c:if>  >事业单位</option>
                        <option value="国家行政机关" <c:if test="${modle.unitProperty=='国家行政机关'}"> selected="selected"</c:if> >国家行政机关</option>
                    </select>
                </div>
            </div>
        </li>





        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    学历
                </div>

                <div class="aui-list-item-input">
                    <select id="xl" name="education">
                        <option value="大专" <c:if test="${modle.education=='大专'}"> selected="selected"</c:if>  >大专</option>
                        <option value="本科" <c:if test="${modle.education=='本科'}"> selected="selected"</c:if>  >本科</option>
                        <option value="研究生" <c:if test="${modle.education=='研究生'}"> selected="selected"</c:if> >研究生</option>
                        <option value="中专" <c:if test="${modle.education=='中专'}"> selected="selected"</c:if>  >中专</option>
                        <option value="高中" <c:if test="${modle.education=='高中'}"> selected="selected"</c:if>  >高中</option>
                    </select>
                </div>
            </div>
        </li>



        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    月收入（元）
                </div>

                <div class="aui-list-item-input">
                    <select name="monthIncome">
                        <option value="3000以下" <c:if test="${modle.monthIncome=='3000以下'}"> selected="selected"</c:if>  >3000以下</option>
                        <option value="3000~5000"  <c:if test="${modle.monthIncome=='3000~5000'}"> selected="selected"</c:if>  >3000~5000</option>
                        <option value="5000~8000" <c:if test="${modle.monthIncome=='5000~8000'}"> selected="selected"</c:if>  >5000~8000</option>
                        <option value="8000~12000" <c:if test="${modle.monthIncome=='8000~12000'}"> selected="selected"</c:if> >8000~12000</option>
                        <option value="12000以上" <c:if test="${modle.monthIncome=='12000以上'}"> selected="selected"</c:if> >12000以上</option>
                    </select>
                </div>
            </div>
        </li>




        <div class="aui-card-list">
            <div class="aui-card-list-header" style="color: #757575; font-size: 14px;">
                相册
            </div>
            <div class="aui-card-list-content-padded aui-border-b aui-border-t">
                <div class="aui-row aui-row-padded">
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l1.png" />
                    </div>
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l2.png" />
                    </div>
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l3.png" />
                    </div>
                </div>
            </div>

        </div>



    </ul>
    </form>
</div>


<div class="aui-content-padded">

    <div class="aui-btn aui-btn-info aui-btn-block" id="regBtn" style="margin-top: 1rem;">下一步</div>


</div>








<%@ include file="/common/h5/js.jsp" %>


<script src="${ctx}/aui/script/aui-dialog.js"></script>

<script language="JavaScript">


    var dialog = new auiDialog();


    $("#backBtn").click(function(){
        window.history.back();
    });
    $("#regBtn").click(function(){
        tijiao();
    });


    function tijiao() {


        if ($("input[name='birthDate']").val() == "") {
            msg("请填您的出生日期");
            $("input[name='birthDate']").focus();
            return
        }



        if ($("input[name='height']").val() == "") {
            msg("请填写您的身高");
            $("input[name='height']").focus();
            return
        }


        $("#regForm").submit();



    }

    function msg(msg) {
        dialog.alert({
            title:"提示",
            msg:msg,
            buttons:['确定']
        },function(ret){
            // console.log(ret)
        })
    }
</script>

</body>


</html>
