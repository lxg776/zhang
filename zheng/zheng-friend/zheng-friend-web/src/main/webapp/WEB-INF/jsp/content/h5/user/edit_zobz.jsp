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
<header class="aui-bar aui-bar-nav" style="position: fixed">
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">择偶条件</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;">
    <form  id="regForm" action="${ctx}/u/editZobz" method="post" >
        <ul class="aui-list aui-form-list">

            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        性别
                    </div>
                    <div class="aui-list-item-input">
                        <label><input class="aui-radio" type="radio" name="sex" value="1" <c:if test="${modle.sex=='1'}">checked</c:if> >男</label>
                        <label><input class="aui-radio" type="radio" name="sex" value="2" <c:if test="${modle.sex=='2'}">checked</c:if> >女</label>
                    </div>
                </div>
            </li>

            <li class="aui-list-item">   <label class="aui-list-item-label" style="font-size: 18px;color: #212121;">地区 </label></li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label" style="color: #757575; font-size: 12px; width: 30px;">
                        省
                    </div>

                    <div class="aui-list-item-input">
                        <select name="fromProvinceId"  style="font-size: 14px; width: 100px;" id="province">

                        </select>
                    </div>
                </div>

                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 30px;">
                        市
                    </div>

                    <div class="aui-list-item-input">
                        <select name="fromCityId" style="font-size: 14px;width: 80px;" id="citys">

                        </select>
                    </div>
                </div>

                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 30px;">
                        区/县
                    </div>

                    <div class="aui-list-item-input" >
                        <select name="fromAreaId"  style="font-size: 14px;width: 100px;" id="areas">

                        </select>
                    </div>
                </div>
            </li>





            <li class="aui-list-item">   <div class="aui-list-item-label" style="font-size: 18px;color: #212121;">年龄（岁） </label></li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label" style="color: #757575; font-size: 12px; width: 110px;">
                        年龄（以上）
                    </div>

                    <div class="aui-list-item-input">
                        <select name="age_min">

                            <option value="不限" >不限</option>
                        <c:forEach begin="20" end="40" step="1" var="item" >

                            <option value="${item}"    <c:if test="${item == age_min}">selected</c:if> >${item}</option>

                        </c:forEach>


                        </select>
                    </div>
                </div>

                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 110px;">
                        年龄（以下）
                    </div>

                    <div class="aui-list-item-input">
                        <select name="age_max">
                            <option value="不限">不限</option>

                            <c:forEach begin="20" end="40" step="1" var="item" >
                                <option value="${item}"    <c:if test="${item == age_max}">selected</c:if> >${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </li>



            <li class="aui-list-item">   <div class="aui-list-item-label" style="font-size: 18px;color: #212121;">身高（cm） </label></li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label" style="color: #757575; font-size: 12px; width: 110px;">
                        身高（以上）
                    </div>

                    <div class="aui-list-item-input">
                        <input type="number" placeholder="不限" name="height_min" value="${height_min}">
                    </div>
                </div>

                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 110px;">
                        身高（以下）
                    </div>

                    <div class="aui-list-item-input">
                        <input type="number" placeholder="不限" name="height_max" value="${height_max}">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        婚姻
                    </div>

                    <div class="aui-list-item-input">
                        <label><input class="aui-radio" type="radio" name="maritalStatus"  value="未婚" <c:if test="${modle.maritalStatus =='不限' }"> checked </c:if> >不限</label>
                        <label><input class="aui-radio" type="radio" name="maritalStatus"  value="未婚" <c:if test="${modle.maritalStatus =='未婚' }"> checked </c:if> >未婚</label>
                        <label><input class="aui-radio" type="radio" name="maritalStatus" <c:if test="${modle.maritalStatus =='离异' }"> checked </c:if> value="离异">离异</label>
                        <label><input class="aui-radio" type="radio" name="maritalStatus" <c:if test="${modle.maritalStatus =='丧偶' }"> checked </c:if> value="丧偶" >丧偶</label>
                    </div>
                </div>
            </li>


            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        体型
                    </div>

                    <div class="aui-list-item-input">
                        <select name="shape">
                            <option value="不限"  <c:if test="${modle.shape =='不限' }"> selected="selected" </c:if>  >不限</option>
                            <option value="偏瘦" <c:if test="${modle.shape =='偏瘦' }"> selected="selected" </c:if> >偏瘦</option>
                            <option value="一般"  <c:if test="${modle.shape =='一般' }"> selected="selected" </c:if> >一般</option>
                            <option value="偏胖"  <c:if test="${modle.shape =='偏胖' }"> selected="selected" </c:if>  >偏胖</option>
                            <option value="强壮"  <c:if test="${modle.shape =='强壮' }"> selected="selected" </c:if> >强壮</option>
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
                        <select name="education">
                            <option value="不限" <c:if test="${modle.education =='不限' }"> selected="selected" </c:if> >不限</option>
                            <option value="高中以上" <c:if test="${modle.education =='高中以上' }"> selected="selected" </c:if> >高中以上</option>
                            <option value="大专以上" <c:if test="${modle.education =='大专以上' }"> selected="selected" </c:if> >大专以上</option>
                            <option value="本科以上" <c:if test="${modle.education =='本科以上' }"> selected="selected" </c:if> >本科以上</option>
                            <option value="研究生"  <c:if test="${modle.education =='研究生' }"> selected="selected" </c:if> >研究生</option>
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
                        <select id="ysr" name="incomeMonthly">
                            <option value="3000元以下" <c:if test="${modle.incomeMonthly =='3000元以下' }"> selected="selected" </c:if>  >3000元以下</option>
                            <option value="3000元~5000元" <c:if test="${modle.incomeMonthly =='3000元~5000元' }"> selected="selected" </c:if> >3000元~5000元</option>
                            <option value="5000元~8000元" <c:if test="${modle.incomeMonthly =='5000元~8000元' }"> selected="selected" </c:if> >5000元~8000元</option>
                            <option value="8000元~12000元" <c:if test="${modle.incomeMonthly =='8000元~12000元' }"> selected="selected" </c:if>  >8000元~12000元</option>
                            <option value="12000元以上" <c:if test="${modle.incomeMonthly =='12000元以上' }"> selected="selected" </c:if>  >12000元以上</option>
                        </select>
                    </div>
                </div>
            </li>


            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        单位性质
                    </div>
                    <div class="aui-list-item-input">

                        <select id="zy" name="job">
                            <option value="不限" <c:if test="${modle.job =='不限' }"> selected="selected" </c:if>  >不限</option>
                            <option value="事业单位" <c:if test="${modle.job =='事业单位' }"> selected="selected" </c:if> >事业单位</option>
                            <option value="国有企业" <c:if test="${modle.job =='国有企业' }"> selected="selected" </c:if> >国有企业</option>
                            <option value="公务员/政府机关" <c:if test="${modle.job =='公务员/政府机关' }"> selected="selected" </c:if>  >公务员/政府机关</option>
                            <option value="个体经营" <c:if test="${modle.job =='个体经营' }"> selected="selected" </c:if>  >个体经营</option>
                        </select>
                    </div>
                </div>
            </li>




            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        是否有孩子
                    </div>

                    <div class="aui-list-item-input">
                        <label><input class="aui-radio" type="radio" name="childStatus" value="不限"   <c:if test="${modle.childStatus =='不限' }"> checked </c:if> >不限</label>
                        <label><input class="aui-radio" type="radio" name="childStatus" value="没有" <c:if test="${modle.childStatus =='没有' }"> checked </c:if>  >没有</label>
                        <label><input class="aui-radio" type="radio" name="childStatus" value="有" <c:if test="${modle.childStatus =='有' }"> checked </c:if>  >有</label>
                    </div>
                </div>
            </li>


            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        与对方父母同住
                    </div>

                    <div class="aui-list-item-input">
                        <select id="lving" name="livingStatus">
                            <option value="看情况" <c:if test="${modle.livingStatus =='看情况' }"> selected="selected" </c:if> >看情况</option>
                            <option value="不介意与对方父母同住" <c:if test="${modle.livingStatus =='不介意与对方父母同住' }"> selected="selected" </c:if> >不介意与对方父母同住</option>
                            <option value="不希望与对方父母同住" <c:if test="${modle.livingStatus =='不希望与对方父母同住' }"> selected="selected" </c:if> >不希望与对方父母同住</option>
                        </select>
                    </div>
                </div>
            </li>


            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        要求对方购房情况
                    </div>

                    <div class="aui-list-item-input" style="padding-left: 16px;">
                        <select id="gfqk" name="houseStatus">
                            <option value="不限" <c:if test="${modle.houseStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                            <option value="购有房屋" <c:if test="${modle.houseStatus =='购有房屋' }"> selected="selected" </c:if> >购有房屋</option>
                        </select>
                    </div>
                </div>
            </li>


            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        要求对方购车情况
                    </div>

                    <div class="aui-list-item-input" style="padding-left: 16px;">
                        <select id="rw" name="carStatus">
                            <option value="不限" <c:if test="${modle.carStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                            <option value="购有车辆" <c:if test="${modle.carStatus =='购有车辆' }"> selected="selected" </c:if>  >购有车辆</option>
                        </select>
                    </div>
                </div>
            </li>


            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        是否喝酒
                    </div>

                    <div class="aui-list-item-input">
                        <select id="yj" name="drinkStatus">
                            <option value="不限" <c:if test="${modle.drinkStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                            <option value="不喝" <c:if test="${modle.drinkStatus =='不喝' }"> selected="selected" </c:if> >不喝</option>
                            <option value="偶尔喝" <c:if test="${modle.drinkStatus =='偶尔喝' }"> selected="selected" </c:if> >偶尔喝</option>
                            <option value="经常喝" <c:if test="${modle.drinkStatus =='经常喝' }"> selected="selected" </c:if>  >经常喝</option>
                        </select>
                    </div>
                </div>
            </li>

            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        是否抽烟
                    </div>

                    <div class="aui-list-item-input">
                        <select id="cy" name="smokeStatus">
                            <option value="不限" <c:if test="${modle.smokeStatus =='不限' }"> selected="selected" </c:if> >不限</option>
                            <option value="不抽" <c:if test="${modle.smokeStatus =='不抽' }"> selected="selected" </c:if> >不抽</option>
                            <option value="偶尔抽" <c:if test="${modle.smokeStatus =='偶尔抽' }"> selected="selected" </c:if> >偶尔抽</option>
                            <option value="经常抽" <c:if test="${modle.smokeStatus =='经常抽' }"> selected="selected" </c:if> >经常抽</option>
                        </select>
                    </div>
                </div>
</div>
</li>


</ul>
</form>
</div>


<div class="aui-content-padded">

    <div class="aui-btn aui-btn-info  aui-btn-block" style="margin-top: 1rem;" id="regBtn">完成</div>


</div>








<%@ include file="/common/h5/js.jsp" %>

<script src="${ctx}/aui/script/aui-dialog.js"></script>
<script src="${ctx}/js/city_list.js"></script>

<script language="JavaScript">


    var dialog = new auiDialog();


    $("#backBtn").click(function(){
        window.history.back();
    });
    $("#regBtn").click(function(){
        tijiao();
    });



    $(document).ready(function(){
        initCityData(true);
    });

    var  dProvinceId="450000";
    var  dcityid = "451000";
    var  dAreaid = "451025";

    ctx = "${ctx}";

    //获取区县
    $("#province").change(function () {//当选择城市的下拉选的时候，区域进行联动
        getCityList($("#province").val(),"","",true);
    });

    //获取区县
    $("#citys").change(function () {//当选择城市的下拉选的时候，区域进行联动
        getAreasList($("#citys").val(),"",true);
    });


    function tijiao() {


        var age_min = $("select[name='age_min']").val();
        var age_max = $("select[name='age_max']").val();


        if((age_min !="不限")||(age_max !="不限")){
            if(parseFloat(age_min)>parseFloat(age_max)){
                msg("年龄的范围填错了");
                return;
            }
        }

        var height_min = $("input[name='height_min']").val();
        var height_max = $("input[name='height_max']").val();


        if((height_min !="不限")||(height_max !="不限")){
            if(parseFloat(height_min)>parseFloat(height_max)){
                msg("身高的范围填错了");
                return;
            }
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
