<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->
    <%@include file="/common/h5/css-link.jsp"%>

    <title>活动详情</title>
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
    <div class="aui-title">活动详情</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 0.5rem;">
    <section class="aui-content-padded">
       <h1>${modle.title}</h1>
        <div style="position: relative; height: 16px;font-size:14px;"  >
        <div style="position: absolute; left: 0px;">活动时间:${modle.activityTime}</div>
            <div style="position: absolute; right: 2px;">主办方:${modle.sponsor}</div>
        </div>
        <div class="aui-content" style="padding-top: 16px;">
            ${modle.content}
        </div>
    </section>
    
</div>





<%@ include file="/common/h5/js.jsp" %>





<script type="text/javascript">

    $("#backBtn").click(function(){
        window.history.back();
    });
    $(document).ready(function(){



    });

</script>
</body>


</html>