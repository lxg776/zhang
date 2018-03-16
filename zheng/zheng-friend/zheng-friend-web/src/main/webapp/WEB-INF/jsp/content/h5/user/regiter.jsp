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
    <!-- start: CSS -->
    <style type="text/css">
        #demo {
            background-color: #e0e0e0;
        }

        .delete {
            position: absolute;
            top: 0px;
            right: 0px;
            width: 12px;
            height: 12px;
        }

        .webuploader-container {
            position: relative;
        }
        .webuploader-element-invisible {
            position: absolute !important;
            clip: rect(1px 1px 1px 1px); /* IE6, IE7 */
            clip: rect(1px,1px,1px,1px);
        }
        .webuploader-pick {
            position: relative;
            display: inline-block;
            cursor: pointer;
            background: #00b7ee;
            padding: 10px 15px;
            color: #fff;
            text-align: center;
            border-radius: 3px;
            overflow: hidden;
        }
        .webuploader-pick-hover {
            background: #00a2d4;
        }

        .webuploader-pick-disable {
            opacity: 0.6;
            pointer-events:none;
        }

        /* ------------ */
        #wrapper {
            width: 96%;
            margin: 0 auto;

            margin: 1em;
            width: auto;
        }

        #container {
            border: 1px solid #dadada;
            color: #838383;
            font-size: 12px;
            margin-top: 10px;
            background-color: #FFF;
        }

        #uploader .queueList {
            margin: 20px;
        }

        .element-invisible {
            position: absolute !important;
            clip: rect(1px 1px 1px 1px); /* IE6, IE7 */
            clip: rect(1px,1px,1px,1px);
        }

        #uploader .placeholder {
            border: 3px dashed #e6e6e6;
            min-height: 238px;
            padding-top: 158px;
            text-align: center;
            background: url(${ctx}/aui/image/image.png) center 93px no-repeat;
            color: #cccccc;
            font-size: 18px;
            position: relative;
        }

        #uploader .placeholder .webuploader-pick {
            font-size: 18px;
            background: #00b7ee;
            border-radius: 3px;
            line-height: 44px;
            padding: 0 30px;
            color: #fff;
            display: inline-block;
            margin: 20px auto;
            cursor: pointer;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
        }

        #uploader .placeholder .webuploader-pick-hover {
            background: #00a2d4;
        }

        #uploader .placeholder .flashTip {
            color: #666666;
            font-size: 12px;
            position: absolute;
            width: 100%;
            text-align: center;
            bottom: 20px;
        }
        #uploader .placeholder .flashTip a {
            color: #0785d1;
            text-decoration: none;
        }
        #uploader .placeholder .flashTip a:hover {
            text-decoration: underline;
        }

        #uploader .placeholder.webuploader-dnd-over {
            border-color: #999999;
        }

        #uploader .placeholder.webuploader-dnd-over.webuploader-dnd-denied {
            border-color: red;
        }

        #uploader .filelist {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        #uploader .filelist:after {
            content: '';
            display: block;
            width: 0;
            height: 0;
            overflow: hidden;
            clear: both;
        }

        #uploader .filelist li {
            width: 110px;
            height: 110px;
            background: url(${ctx}/aui/image/bg.png) no-repeat;
            text-align: center;
            margin: 0 8px 20px 0;
            position: relative;
            display: inline;
            float: left;
            overflow: hidden;
            font-size: 12px;
        }

        #uploader .filelist li p.log {
            position: relative;
            top: -45px;
        }

        #uploader .filelist li p.title {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            overflow: hidden;
            white-space: nowrap;
            text-overflow : ellipsis;
            top: 5px;
            text-indent: 5px;
            text-align: left;
        }

        #uploader .filelist li p.progress {
            position: absolute;
            width: 100%;
            bottom: 0;
            left: 0;
            height: 8px;
            overflow: hidden;
            z-index: 50;
        }
        #uploader .filelist li p.progress span {
            display: none;
            overflow: hidden;
            width: 0;
            height: 100%;
            background: #1483d8 url(${ctx}/aui/image/progress.png) repeat-x;

            -webit-transition: width 200ms linear;
            -moz-transition: width 200ms linear;
            -o-transition: width 200ms linear;
            -ms-transition: width 200ms linear;
            transition: width 200ms linear;

            -webkit-animation: progressmove 2s linear infinite;
            -moz-animation: progressmove 2s linear infinite;
            -o-animation: progressmove 2s linear infinite;
            -ms-animation: progressmove 2s linear infinite;
            animation: progressmove 2s linear infinite;

            -webkit-transform: translateZ(0);
        }

        @-webkit-keyframes progressmove {
            0% {
                background-position: 0 0;
            }
            100% {
                background-position: 17px 0;
            }
        }
        @-moz-keyframes progressmove {
            0% {
                background-position: 0 0;
            }
            100% {
                background-position: 17px 0;
            }
        }
        @keyframes progressmove {
            0% {
                background-position: 0 0;
            }
            100% {
                background-position: 17px 0;
            }
        }

        #uploader .filelist li p.imgWrap {
            position: relative;
            z-index: 2;
            line-height: 110px;
            vertical-align: middle;
            overflow: hidden;
            width: 110px;
            height: 110px;

            -webkit-transform-origin: 50% 50%;
            -moz-transform-origin: 50% 50%;
            -o-transform-origin: 50% 50%;
            -ms-transform-origin: 50% 50%;
            transform-origin: 50% 50%;

            -webit-transition: 200ms ease-out;
            -moz-transition: 200ms ease-out;
            -o-transition: 200ms ease-out;
            -ms-transition: 200ms ease-out;
            transition: 200ms ease-out;
        }

        #uploader .filelist li img {
            width: 100%;
        }

        #uploader .filelist li p.error {
            background: #f43838;
            color: #fff;
            position: absolute;
            bottom: 0;
            left: 0;
            height: 28px;
            line-height: 28px;
            width: 100%;
            z-index: 100;
        }

        #uploader .filelist li .success {
            display: block;
            position: absolute;
            left: 0;
            bottom: 0;
            height: 40px;
            width: 100%;
            z-index: 200;
            background: url(${ctx}/aui/image/success.png) no-repeat right bottom;
        }

        #uploader .filelist div.file-panel {
            position: absolute;
            height: 0;
            filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='#80000000', endColorstr='#80000000')\0;
            background: rgba( 0, 0, 0, 0.5 );
            width: 100%;
            top: 0;
            left: 0;
            overflow: hidden;
            z-index: 300;
        }

        #uploader .filelist div.file-panel span {
            width: 24px;
            height: 24px;
            display: inline;
            float: right;
            text-indent: -9999px;
            overflow: hidden;
            background: url(${ctx}/aui/image/icons.png) no-repeat;
            margin: 5px 1px 1px;
            cursor: pointer;
        }

        #uploader .filelist div.file-panel span.rotateLeft {
            background-position: 0 -24px;
        }
        #uploader .filelist div.file-panel span.rotateLeft:hover {
            background-position: 0 0;
        }

        #uploader .filelist div.file-panel span.rotateRight {
            background-position: -24px -24px;
        }
        #uploader .filelist div.file-panel span.rotateRight:hover {
            background-position: -24px 0;
        }

        #uploader .filelist div.file-panel span.cancel {
            background-position: -48px -24px;
        }
        #uploader .filelist div.file-panel span.cancel:hover {
            background-position: -48px 0;
        }

        #uploader .statusBar {
            height: 63px;
            border-top: 1px solid #dadada;
            padding: 0 20px;
            line-height: 63px;
            vertical-align: middle;
            position: relative;
        }

        #uploader .statusBar .progress {
            border: 1px solid #1483d8;
            width: 198px;
            background: #fff;
            height: 18px;
            position: relative;
            display: inline-block;
            text-align: center;
            line-height: 20px;
            color: #6dbfff;
            position: relative;
            margin-right: 10px;
        }
        #uploader .statusBar .progress span.percentage {
            width: 0;
            height: 100%;
            left: 0;
            top: 0;
            background: #1483d8;
            position: absolute;
        }
        #uploader .statusBar .progress span.text {
            position: relative;
            z-index: 10;
        }

        #uploader .statusBar .info {
            display: inline-block;
            font-size: 14px;
            color: #666666;
        }

        #uploader .statusBar .btns {
            position: absolute;
            top: 10px;
            right: 20px;
            line-height: 40px;
        }

        #filePicker2 {
            display: inline-block;
            float: left;
        }

        #uploader .statusBar .btns .webuploader-pick,
        #uploader .statusBar .btns .uploadBtn,
        #uploader .statusBar .btns .uploadBtn.state-uploading,
        #uploader .statusBar .btns .uploadBtn.state-paused {
            background: #ffffff;
            border: 1px solid #cfcfcf;
            color: #565656;
            padding: 0 18px;
            display: inline-block;
            border-radius: 3px;
            margin-left: 10px;
            cursor: pointer;
            font-size: 14px;
            float: left;
        }
        #uploader .statusBar .btns .webuploader-pick-hover,
        #uploader .statusBar .btns .uploadBtn:hover,
        #uploader .statusBar .btns .uploadBtn.state-uploading:hover,
        #uploader .statusBar .btns .uploadBtn.state-paused:hover {
            background: #f0f0f0;
        }

        #uploader .statusBar .btns .uploadBtn {
            background: #00b7ee;
            color: #fff;
            border-color: transparent;
        }
        #uploader .statusBar .btns .uploadBtn:hover {
            background: #00a2d4;
        }

        #uploader .statusBar .btns .uploadBtn.disabled {
            pointer-events: none;
            opacity: 0.6;
        }

    </style>


</head>

<body>
<header class="aui-bar aui-bar-nav">
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">靖西婚恋网</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 1rem;">

    <form method="post" action="/h5/reg" id="regForm">

    <ul class="aui-list aui-form-list">

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    我是
                </div>
                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="sex" value="1" >男生</label>
                    <label><input class="aui-radio" type="radio" name="sex" value="2" >女生</label>
                </div>
            </div>
        </li>

        <li class="aui-list-item">   <label class="aui-list-item-label" style="font-size: 18px;color: #212121;">出生日期 </label></li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">


                <div class="aui-list-item-input">
                    <select style="font-size: 14px; width: 80px;" id="selYear">

                    </select>
                </div>

                <div class="aui-list-item-label" style="color: #757575; font-size: 12px; width: 30px;">
                    年
                </div>
            </div>

            <div class="aui-list-item-inner">


                <div class="aui-list-item-input">
                    <select name="fromCityId" style="font-size: 14px;width: 80px;" id="selMonth">

                    </select>
                </div>

                <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 30px;">
                    月
                </div>
            </div>

            <div class="aui-list-item-inner">


                <div class="aui-list-item-input" >
                    <select name="fromCityId"  style="font-size: 14px;width: 80px;" id="selDay">

                    </select>
                </div>

                <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 30px;">
                    日
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
                    <select style="font-size: 14px; width: 100px;" id="province">

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
                    <select name="fAreasId"  style="font-size: 14px;width: 100px;" id="areas">

                    </select>
                </div>
            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">

                <div class="aui-list-item-input">
                    <input type="text" name="userName" placeholder="手机号码">
                </div>

                <div class="aui-list-item-label">
                    <a href="javascript:;"  onclick="gegSms()"  id="sMSCodeBtn" >获取验证码</a>
                    <label id="showTimeLabel" style="display: none">60s</label>
                </div>
            </div>
        </li>
        <input type="hidden"  name="birthDay" value="">
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="text" name="msgCode" placeholder="验证码">
                </div>
            </div>
        </li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="text" name="realName" placeholder="真实姓名">
                </div>
            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="text" name="idCard" placeholder="身份证号码">
                </div>
            </div>
        </li>
        <%--<input id="imgs" type="hidden" name="idCardImgs"  />--%>
        <input id="imgs" type="hidden" name="idCardImgs" value="wtf.jpeg"  />
        <div class="aui-card-list">
            <div class="aui-card-list-header" style="color: #757575; font-size: 14px;">
                为保证注册的真实性需上传身份证图
            </div>
            <div id="wrapper">
                <div id="container">
                    <!--头部，相册选择和格式选择-->

                    <div id="uploader">
                        <div class="queueList">
                            <div id="dndArea" class="placeholder">
                                <div id="filePicker"></div>

                            </div>
                        </div>
                        <div class="statusBar" style="display:none;">
                            <div class="progress">
                                <span class="text">0%</span>
                                <span class="percentage"></span>
                            </div><div class="info"></div>
                            <div class="btns">
                                <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="password" name="password" placeholder="密码">
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-input">
                    <input type="password" name="rePassword" placeholder="确认密码">
                </div>
            </div>
        </li>

    </ul>
    </form>
</div>


<div class="aui-content-padded">

    <p><div class="aui-btn aui-btn-primary aui-btn-block" style="margin-top: 1rem;" id="regBtn">完成</div></div>


</div>








<%@ include file="/common/h5/js.jsp" %>
<script src="${ctx}/aui/script/aui-dialog.js"></script>
<script src="${ctx}/js/reg_date.js"></script>
<script language="JavaScript">


    var dialog = new auiDialog();


    $("#backBtn").click(function(){
        window.history.back();
    });
    $("#regBtn").click(function(){
        tijiao();
    });


    $(document).ready(function(){
        initCityData();
    });

    var  dProvinceId="450000";
    var  dcityid = "451000";
    var  dAreaid = "451025";

    //初始化城市数据
    function initCityData(){
        $("#province").empty();

        $.ajax({
            url: "${ctx}/c/provinceList",
            type: "GET",
            dataType:'json',
            success:function(data){
                $.each(data.data.dataList,function(i,item){
                    if(item.provinceid == dProvinceId ){
                        $("#province").append(" <option value='" + item.provinceid + "'   selected='selected'> " + item.province + "</option>");
                    }else{
                        $("#province").append(" <option value='" + item.provinceid + "' > " + item.province + "</option>");
                    }
                });
            }
        });
        getCityList(dProvinceId,dcityid,dAreaid);
       // getAreasList(cityid,areaid);

    }

    //获取区县
    $("#province").change(function () {//当选择城市的下拉选的时候，区域进行联动
        getCityList($("#province").val(),"");
    });

    //获取区县
    $("#citys").change(function () {//当选择城市的下拉选的时候，区域进行联动
        getAreasList($("#citys").val(),"");
    });


    function getAreasList(cityid,defaultId) {
        $("#areas").empty();
        data = "cityid="+cityid;
        $.ajax({
            url: "${ctx}/c/areasList",
            type: "GET",
            data:data,
            dataType:'json',
            success:function(data){
                $.each(data.data.dataList,function(i,item){
                    if(defaultId&&item.areaid == defaultId ){
                        $("#areas").append(" <option value='" + item.areaid + "'   selected='selected'> " + item.area + "</option>");
                    }else{
                        $("#areas").append(" <option value='" + item.areaid + "' > " + item.area + "</option>");
                    }

                });
            }
        });
    }

    function getCityList(provinceid,defaultId,dareaid) {
        $("#citys").empty();
        data = "provinceid="+provinceid;
        $.ajax({
            url: "${ctx}/c/cityList",
            type: "GET",
            data:data,
            dataType:'json',
            success:function(data){
                $.each(data.data.dataList,function(i,item){
                    if(defaultId&&item.cityid == defaultId ){
                        $("#citys").append(" <option value='" + item.cityid + "'   selected='selected'> " + item.city + "</option>");
                        getAreasList(defaultId,dareaid);
                        return;
                    }else{
                        $("#citys").append(" <option value='" + item.cityid + "' > " + item.city + "</option>");
                        if(!defaultId&&i==0){
                            getAreasList(item.cityid,"");
                        }
                    }
                });
            }
        });
    }




    function tijiao() {


        if ($("input[name='sex']").val() == "") {
            msg("请填性别");
            $("input[name='sex']").focus();
            return
        }


        if ($("input[name='userName']").val() == "") {
            msg("请填写手机号码");
            $("input[name='userName']").focus();
            return
        }

        if(!$("input[name='userName']").val().match(/^(((1[3-9][0-9]{1})|159|153)+\d{8})$/)){
            msg("手机格式不正确");
            $("input[name='userName']").focus();
            return
        }

        if ($("input[name='realName']").val() == "") {
            msg("请填写真实姓名");
            $("input[name='realName']").focus();
            return
        }

        if ($("input[name='idCard']").val() == "") {
            msg("请填写身份证号码");
            $("input[name='idCard']").focus();
            return
        }









        if(!$("input[name='idCard']").val().match(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/)){
            msg("身份证格式不正确");
            $("input[name='idCard']").focus();
            return
        }

        if ($("input[name='idCardImgs']").val() == "") {
            msg("请上传身份图片");
            $("input[name='idCard']").focus();
            return
        }


        if ($("input[name='password']").val() == "") {
            msg("请输入密码");
            $("input[name='password']").focus();
            return
        }

        if ($("input[name='password']").val().length<6) {
            msg("密码长度必须大于六位！");
            $("input[name='password']").focus();
            return
        }


        if ($("input[name='rePassword']").val() == "") {
            msg("请输入确认密码");
            $("input[name='rePassword']").focus();
            return
        }



        if ($("input[name='password']").val() != $("input[name='rePassword']").val()) {
            msg("两次密码输入不一致!");
            $("input[name='rePassword']").focus();
            return
        }


        idCard = $("input[name='idCard']").val();
        userName = $("input[name='userName']").val();
        code = $("input[name='msgCode']").val();


        year = $("#selYear").val();
        month = $("#selMonth").val();
        day = $("#selDay").val();
        brithDay = year+"-"+month+"-"+day;
        $("input[name='birthDay']").val(brithDay);



        $.ajax({
            type: "POST",
            url: "/h5/checkUserName",
            data: "idCard="+idCard+"&userName="+userName+"&code="+code,
            async:false,
            success: function(data){
                if(data.code==1){
                    $("#regForm").submit();
                }else{
                    msg(data.message);
                }
            }
        });


    }

    //获取短信验证码
    function gegSms() {

        if ($("input[name='userName']").val() == "") {
            msg("请填写手机号码");
            $("input[name='userName']").focus();
            return
        }

        if(!$("input[name='userName']").val().match(/^(((1[3-9][0-9]{1})|159|153)+\d{8})$/)){
            msg("手机格式不正确");
            $("input[name='userName']").focus();
            return
        }

        phoneNo =$("input[name='userName']").val();
        data = "phoneNo="+phoneNo;
        $.ajax({
            type: "POST",
            url: "/h5/gegSms",
            data: data,
            success: function(data){
              showTime(60);
            }
        });


    }


    //显示倒计时
    function showTime(time) {
        if(time == 0){
            $("#sMSCodeBtn").show();
            $("#showTimeLabel").hide();
        }else{
            $("#showTimeLabel").html(time+"s");
            $("#sMSCodeBtn").hide();
            $("#showTimeLabel").show();
            window.setTimeout(function(){
                showTime(time -1);
            },1000);
        }


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


    var selYear = window.document.getElementById("selYear");
    var selMonth = window.document.getElementById("selMonth");
    var selDay = window.document.getElementById("selDay");
    // 新建一个DateSelector类的实例，将三个select对象传进去
    new DateSelector(selYear, selMonth, selDay, 1980, 1, 17);

</script>


<script src="${ctx}/webuploader/dist/webuploader.js"></script>
<script src="${ctx}/webuploader/dist/upload.js"></script>

</body>


</html>
