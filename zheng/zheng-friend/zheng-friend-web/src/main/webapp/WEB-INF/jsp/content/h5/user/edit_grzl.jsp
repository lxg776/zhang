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

        .avatar-wrapper {
            width: 95%;
            margin-top: 4px;
            box-shadow: inset 0 0 5px rgba(0,0,0,.25);
            background-color: #fcfcfc;
            overflow: hidden;
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

    <link rel="stylesheet" href="${ctx}/cropper/cropper.css">
</head>

<body>
<header class="aui-bar aui-bar-nav">
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">个人资料</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 0.5rem;">
    <form method="post" id="regForm">
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

        <li class="aui-list-item" style="padding-top: 1rem; padding-bottom: 1rem;">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    头像
                </div>

                <div class="aui-list-item-input">

                        <img id="headImg"


                        <c:if test="${not empty user.avatar}">
                             src="${imageBase}${user.avatar}"
                        </c:if>

                             style="width: 5rem; height: 5rem;">


                </div>

                <div class="aui-btn aui-btn-info" aui-popup-for="top-left" style="margin-right: 2rem;">修改头像</div>
            </div>
        </li>
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
                    婚姻
                </div>

                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="maritalStatus" value="未婚" <c:if test="${modle.maritalStatus=='未婚'}"> checked</c:if> >未婚</label>
                    <label><input class="aui-radio" type="radio" name="maritalStatus" value="离异" <c:if test="${modle.maritalStatus=='离异'}"> checked</c:if> >离异</label>
                    <label><input class="aui-radio" type="radio" name="maritalStatus" value="丧偶" <c:if test="${modle.maritalStatus=='丧偶'}"> checked</c:if>  >丧偶</label>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    是否有孩子
                </div>

                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="childrenStatus" value="没有" <c:if test="${modle.childrenStatus=='没有'}"> checked</c:if> >没有</label>
                    <label><input class="aui-radio" type="radio" name="childrenStatus"  value="有"  <c:if test="${modle.childrenStatus=='有'}"> checked</c:if> >有</label>
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

        <input type="hidden" id="avatar"  name="avatar" />


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
                <div class="aui-list-item-right">
                    <div class="aui-btn aui-btn-info" id="uploadPhotoBtn" style="margin-right: 0.2rem;">上传相片</div>

                </div>
            </div>
            <div class="aui-card-list-content-padded aui-border-b aui-border-t">
                <div class="aui-row aui-row-padded" id="photoDiv">
                            <c:if test="${list == null}">
                                <c:forEach var="item" items="${userImages}">
                                    <div class="aui-col-xs-4">
                                        <div style="text-align: right">  <i class="aui-iconfont aui-icon-close photo-delete" photo-id="${item.imagePath}" fla="exist"></i></div>
                                        <img src="${imageBase}${item.imagePath}"/>
                                    </div>

                                </c:forEach>
                            </c:if>
                </div>
            </div>

        </div>



    </ul>
        <input type="hidden" id="deletePhoto" name="deletePhoto" />
        <input type="hidden" id="addPhoto" name="addPhoto" />

        <div class="aui-content-padded">

            <div class="aui-btn aui-btn-info aui-btn-block" id="regBtn" style="margin-top: 1rem;">保存</div>


        </div>

    </form>

    <input type="file" name="file" id="myfile"  multiple="multiple" style="display: none;">

    <%--上传头像--%>
    <div class="aui-popup aui-popup-top-left" style="width: 95%;display: none;" id="top-left">

        <div class="aui-popup-content">
            <div class="aui-content aui-margin-b-15" style="margin-top: 0.5rem;">

                <ul class="aui-list aui-form-list">
                    <li class="aui-list-header">修改头像</li>
                <li class="aui-list-item">
                    <div class="aui-list-item-inner">
                        <div class="aui-list-item-input">
                            <p><div class="aui-btn aui-btn-primary" id="selectImage">选择图片</div></p>
                            <input id="inputImage" type="file" placeholder="选择图片"  accept="image/*" style="display: none;" />
                        </div>
                    </div>



                </li>

                    <li class="aui-list-item">
                        <div class="avatar-wrapper" style="padding: 0.2rem;">
                            <img id="image"  style="max-width: 100%; display: none; overflow: hidden;"/>
                        </div>
                    </li>

                </ul>

                <div class="aui-content-padded">
                    <div class="aui-btn aui-btn-info aui-btn-block" id="saveCropper" style="margin-top: 1rem;">保存</div>
                </div>
            </div>
        </div>

    </div>








</div>




<div id="photoItem"  style="display:none;">

    <div class="aui-col-xs-4">
        <div style="text-align: right">  <i class="aui-iconfont aui-icon-close photo-delete" photo-id="#photo-id"></i></div>
        <img src="#src"/>
    </div>
    
</div>





<%@ include file="/common/h5/js.jsp" %>


<script src="${ctx}/webuploader/dist/webuploader.js"></script>
<script type="text/javascript" src="${ctx}/aui/script/aui-dialog.js"></script>
<script type="text/javascript" src="${ctx}/cropper/cropper.js"></script>
<script type="text/javascript" src="${ctx}/aui/script/aui-popup.js" ></script>


<script type="text/javascript" src="${ctx}/cropper/main.js"></script>

<script type="text/javascript">


    $(document).ready(function(){



        $("#backBtn").click(function(){
            window.history.back();
        });
        $("#regBtn").click(function(){
            tijiao();
        });
        $("#selectImage").click(function(){

            document.getElementById('inputImage').click();
        });

        $("#top-left").hide();





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

            $("#regForm").attr('action',"/u/editGrzl");    //通过jquery为action属性赋值
            $("#regForm").submit();



        }
        var dialog = new auiDialog();
        function msg(msg) {
            dialog.alert({
                title:"提示",
                msg:msg,
                buttons:['确定']
            },function(ret){
                // console.log(ret)
            })
        }



        $("#uploadPhotoBtn").click(function () {
            document.getElementById('myfile').click();

        });






        $("#photoFile").change(function () {
            var files = this.files;
            // if (!$image.data('cropper')) {
            //     return;
            // }
            if (files && files.length) {
                uploader.addFile(files);
                } else {
                    window.alert('Please choose an image file.');
                }

        });





    });

</script>

<script type="text/javascript" src="${ctx}/js/grzl_upload.js"></script>



</body>


</html>
