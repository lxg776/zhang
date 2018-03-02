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
    <form  id="regForm" action="${ctx}/u/txZobz" method="post" >
    <ul class="aui-list aui-form-list">

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    性别
                </div>
                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="sex"  value="1" checked>男</label>
                    <label><input class="aui-radio" type="radio" name="sex" value="2" >女</label>
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
                        <option value="不限">不限</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                        <option value="32">32</option>
                        <option value="33">33</option>
                        <option value="34">34</option>
                        <option value="35">35</option>
                        <option value="36">36</option>
                        <option value="37">37</option>
                        <option value="38">38</option>
                        <option  value="39">39</option>
                        <option  value="40">40</option>

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
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                        <option value="32">32</option>
                        <option value="33">33</option>
                        <option value="34">34</option>
                        <option value="35">35</option>
                        <option value="36">36</option>
                        <option value="37">37</option>
                        <option value="38">38</option>
                        <option  value="39">39</option>
                        <option  value="40">40</option>
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
                    <input type="number" placeholder="不限" name="height_min">
                </div>
            </div>

            <div class="aui-list-item-inner">
                <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 110px;">
                    身高（以下）
                </div>

                <div class="aui-list-item-input">
                    <input type="number" placeholder="不限" name="height_max">
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
                            <option value="3000以下" <c:if test="${modle.incomeMonthly =='3000以下' }"> selected="selected" </c:if>  >3000以下</option>
                            <option value="3000~5000" <c:if test="${modle.incomeMonthly =='3000~5000' }"> selected="selected" </c:if> >3000~5000</option>
                            <option value="5000~8000" <c:if test="${modle.incomeMonthly =='5000~8000' }"> selected="selected" </c:if> >5000~8000</option>
                            <option value="8000~12000" <c:if test="${modle.incomeMonthly =='8000~12000' }"> selected="selected" </c:if>  >8000~12000</option>
                            <option value="12000以上" <c:if test="${modle.incomeMonthly =='12000以上' }"> selected="selected" </c:if>  >12000以上</option>
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

    <div class="aui-btn aui-btn-info  aui-btn-block" style="margin-top: 1rem;" id="regBtn">下一步</div>


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
