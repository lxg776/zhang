<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->

    <%@include file="/common/h5/css-link.jsp"%>

    <title>服务协议</title>
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
    <div class="aui-title">婚恋墙服务协议</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 1rem;">
    <div id="mainCon">
        <h1 style="text-align: center;">
            服务协议<br>
        </h1>
        <p style="margin-top: 5px; margin-bottom: 5px;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎使用&nbsp;西网科技（www.zhenai.com，以下简称“西网科技”或“本网站”）。本服务协议（以下简称“协议”）是您与西网科技的运营商深圳市西网科技信息技术有限公司（以下简称“西网科技公司”或“我们）之间关于您成为西网科技会员且使用西网科技公司提供的在线婚介服务所订立的协议。&nbsp;
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本协议适用于西网科技下所有的服务、资料及信息，而且也适用于我们和您之间通过电子邮件或电话、传真等任何方式进行的任何沟通。请在使用本网站的服务之前认真阅读下述条款，特别是<strong>本协议含有免除或者限制我们责任的条款（该等条款通常含有“不负任何责任”、“无义务”等词汇），和其它限制会员权利的条款（该等条款通常含有“不得”等词汇）。</strong>除非您接受本《协议》所有条款，否则您无权注册、登录或使用本协议所涉相关服务。您的注册、登录、使用等行为将视为对本《协议》的接受，并同意接受本《协议》各项条款的约束。为免歧义，本协议中的“注册”、登录或“使用”是指您注册成为本网站会员并使用本网站提供的任何服务，或者您未注册成为本网站会员，但通过阅读、浏览、复制或以其他方式使用本网站上提供的任何信息以及以任何方式使用本网站提供之各类服务。未免歧义，除非本协议中另有说明或根据本协议上下文理解另有含义，“会员”指免费会员和付费会员。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您对本协议的接受即受全部条款的约束，包括接受西网科技公司对任一服务条款随时所做的任何修改。本《协议》可由西网科技公司随时更新，更新后的协议条款一旦公布即代替原来的协议条款，恕不再另行通知，会员可以查阅最新版协议条款。在西网科技公司修改《协议》条款后，如果会员不接受修改后的条款，请立即停止使用西网科技提供的服务，会员继续使用西网科技提供的服务将被视为已接受了修改后的协议。
        </p>
        <p>
            <br>&nbsp;&nbsp;&nbsp;&nbsp;<strong>1.服务和资格</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>1.1 服务内容。</strong>西网科技公司的服务分为线上服务和线下服务。“线上服务”是指西网科技网站上显示的全部功能及服务。“线下服务”是指西网科技授权的第三方（具体名单详见西网科技上的公示内容，我们对该名单将不时予以更新）作为“西网科技线下VIP婚介服务中心”为您提供的服务。<br>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;关于会员付费的特别提示：</strong>针对西网科技提供的在线付费服务项目，您必须成为本网站的付费会员，方能予以享受。有关当前收费服务内容及其价格说明，请在购买前仔细阅读网站服务说明页面。该服务说明页面上所载之内容构成本协议的一部分。<strong>除西网科技另有说明外，所有付费业务均不支持退费。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;1.2 注册资格。</strong>您必须年满18周岁并且是具有中国国籍的单身人士才能注册成为西网科技的会员或使用本网站。注册成为本网站之会员或使用本网站，表示您陈述并保证您已具备独立签定本协议，并遵守本协议所有条款之民事权利能力及民事行为能力。<br>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;为免歧义，此处“单身人士”系指尚未与他人缔结婚姻关系的任何具有中国国籍的公民。<br>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;在西网科技提供服务过程中，如果您的状态发生变更，已经不符合网站注册资格，请联系我们注销您的会员资格，否则由此产生的所有责任均由您自行承担。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;1.3 信息。</strong>在满足上述资格的情况下，您可以注册成为本网站的会员。要创建并维持会员账户，您必须向我们提供正确有效的信息，承诺以其真实身份注册成为西网科技的会员，并保证所提供的个人身份资料，信息真实、完整、有效，依据法律规定和本协议约定对所提供的信息承担相应的法律责任。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;a.身份认证。</strong>您授权西网科技公司（直接或通过第三方）进行我们认为验证您的身份所必须的任何查询。为更好地满足您的服务要求，这可能包括要求您提供更多信息或文件。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;b.信息授权。</strong>任何您传输至本网站或在本网站上公布的资料都将视为非机密和非专有的。<strong>您的上述传输行为表明您已同意我们对公布及以其他方式使用该类资料将不承担任何责任。</strong>同时，您也授权我们和我们指定的人员有权复制、披露、传播、整合或以其他方式使用该类数据、图像、声音、文本以及上述资料包含的其他内容，以用作商业或非商业目的，并且您同意我们有权以上述方式无偿使用该信息。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;c.信息查询和更新。您可以通过如下途径查询您的个人信息：http://profile.zhenai.com/v2/userdata/showRegInfo.do。</strong>如果您所提供的个人身份资料信息发生变更的，应当及时、有效地在西网科技网站个人信息设置中同步更新（个人信息更新链接为：http://profile.zhenai.com/v2/userdata/showRegInfo.do），西网科技有权对您更新的信息真实性和合法性进行审核。若您所提供的资料与事实不符或所提供的资料业已变更而未更新或有任何误导之嫌导致西网科技无法为您进一步提供服务，西网科技公司不因此承担任何责任。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;在您注册时，本网站将向您登记的手机发送手机验证码短信。如您通过短信无法完成验证时，请拨打我们的服务电话4001-520-520进行人工验证，否则您将无法完成注册。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;1.4 声明。</strong>您必须是会员账号的实际拥有人，仅代表您自己接受西网科技公司及西网科技的各项服务。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;2.账号安全。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;您应当采取适当措施保障注册本网站过程中所指定之用户名和密码的机密性，不应在您公开的会员档案中包含任何联系方式（包括但不限于电话号码、街道地址、姓氏、URL、电子邮件地址或即时聊天工具号码）。而且您对以您的用户名和密码进行的所有活动承担全部责任。您同意：(a) 一经发现，将未经授权使用您的用户名或密码或其他侵犯帐户安全的任何行为立即通知本网站；(b) 确保您于每次会话结束后退出您的帐户；(c)<strong>本网站对因您未遵守上述规定而给您或他人带来的任何损失不承担责任。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;当您从公共或共享计算机上访问您的帐户时，应格外小心以使其他人不能查看或记录您的密码或其他个人信息。如果您与其他人共享您的计算机，应将Microsoft.Net Passport或AOL ScreenName链接至您的西网科技帐户，您应考虑禁用自动登录功能。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;3.会员服务使用规则</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>3.1</strong>为保护本网站所有会员之利益，以及保障本网站持续经营之目的，除经我们事先书面允许之外，您不得在任何公共信息平台（包括但不限于任何网站、网页、微博、报纸、期刊、电视、电影等各种类型的媒体）或在使用任何网络软件（包括但不限于QQ、MSN等即时通讯工具）的过程中将您在本网站的ID号码或昵称与您的任何联系方式一并予以公布。一旦我们发现您存在上述行为，则我们有权独立做出判断并就此采取限制您的会员权限或取消您的会员资格等惩罚性措施。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>3.2</strong>为保护本网站所有会员之利益，以及保障本网站持续经营之目的，一旦我们发现您在本网站的ID或昵称和相应个人的联系方式被一并公布在任何其他公共信息平台（包括但不限于任何网站、网页、微博、报纸、期刊、电视、电影等各种类型的媒体）或被任何个人通过网络软件（包括但不限于QQ、MSN等即时通讯工具）所公布，无论该信息的公布是任何人所为，您在此同意完全授权我们，在您会员身份持续期间，就撤销上述公布之信息采取任何行动，在前述公布之信息得以撤销之前，我们有权以任何方式限制您在本网站的会员权利，无论该信息之公布是否是您所为。对于我们采取以上措施而给您带来的不便甚至损失，<strong>于缔结本协议时您已表示理解并同意完全免除我们因此给您造成的任何损失的赔偿责任。对于因您公布上述信息而给我们造成的损失，我们有权要求您予以赔偿。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;3.3 会员不得将本网站用作商业用途。</strong>本网站仅供会员为个人目的使用，除非经我们书面授权，不得与任何商业行为相关联。任何公司、事业单位或其他组织不能成为本网站之会员，并且任何人不应将本网站或本网站提供之任何信息及服务用作任何商业目的。任何非法和/或未经授权而使用本网站的行为，包括但不限于通过电子或其他方法，基于传送未经请求的电子邮件或未经授权的对于本网站的链接(Linking)或帧联(Framing)的目的，而收集会员的用户名和/或电子邮件地址，都将受到我们的调查，同时我们将采取适当法律措施以保护我们的权益。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;3.4  提交信息真实性声明。</strong>您必须对您在本网站公布、提交、张贴或显示的任何内容，或您通过本网站提供之服务传输给其他会员的任何内容负全部责任。您声称并保证您在任何时候公布的内容是 (a)准确真实和非误导性的 (b)未违反本协议和(c)任何情况下不会侵犯任何第三方的权利和利益。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;3.5 禁止利用本网站制作、复制、发布、传播含有下列内容的信息：</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.反对宪法所确定的基本原则的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.危害国家安全，泄露国家秘密，颠覆国家政权，破坏国家统一的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c.损害国家荣誉和利益的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d.煽动民族仇恨、民族歧视，破坏民族团结的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e.破坏国家宗教政策，宣扬邪教和封建迷信的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f.散布谣言，扰乱社会秩序，破坏社会稳定的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g.散布淫秽、色情、赌博、暴力、凶杀、恐怖或者教唆犯罪的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h.侮辱或者诽谤他人，侵害他人合法权益的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i.含有法律、行政法规禁止的其他内容的。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;3.6 禁止利用本网站发布含有以下内容的信息</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.未经允许，构建任何第三人的档案或使用其照片并在本网站发布；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.骚扰或鼓动他人对其他人进行骚扰；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c.传播或参与传播“垃圾邮件”、“连锁信”或未经请求的大量邮件或“兜售信息”；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d.宣传您知道或应当知道是错误的、误导性信息，或宣传违法活动，或宣扬辱骂、威胁、猥亵、诽谤或损害他人名誉的行为；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e.传播受知识产权法律法规保护的作品的违法的、未经授权的副本，包括但不限于提供盗版计算机程序或这些程序的链接、提供如何规避制造商所安装之副本保护设备的信息、或提供盗版音乐或这些盗版音乐文件夹的链接；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f.您不应删除本网站包含的任何他人拥有著作权、商标或其他知识产权、所有权的信息；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g.从不满18周岁的人那里索取其个人信息或照片并在本网站发布；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h.提供关于违法活动的指导性信息，如有关如何制造或购买非法武器、侵犯他人隐私、提供或制造计算机病毒的信息；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i.从其他会员处索取密码或个人标识信息，用作商业或非法之目的；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;j.未经我们事先书面许可，发布销售活动或任何其他商业活动之信息，如竞赛、赌博、交易、广告和金字塔计划。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;k.通过本网站向其他会员发布有关推销或请求其购买或出售任何产品或服务的信息，或因商业目的发布邀请其他会员参加各类团体或社会活动或其他网络的信息。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;l.其他违反法律、法规明文规定以及公共道德或者经我们单方面判断为不合适的信息。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;西网科技公司有权依据独立的判断对违反以上禁止性行为的任何人进行调查并采取适当的法律行动，包括但不限于，从本网站上删除侮辱性通信、冻结、终止该类侵犯者的会员身份。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;3.7 禁止利用本网站从事以下的活动。</strong>如果您滥用本网站提供之服务，或利用本网站从事以下不恰当或不合法的行为，本网站有权冻结、终止您会员身份，保留向您采取任何及所有必要法律行动进行索赔的权利。若相关行为涉嫌犯罪的，西网科技将依法移交司法部门处理。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.冒充任何其他人或实体；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.“跟踪”或以其他方式骚扰任何人；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c.未经我们事先特定书面同意，明示或暗示本网站支持您所做的任何声明；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d.使用任何软件机器人（Robot/Spider）、站点搜索/检索应用程序，或其他手动或自动设备或程序来检索、索引、“数据挖掘”或以任何方式转载或规避“服务”或其内容的导航结构或表示法；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e.未经该类拥有者事先同意，以任何方式张贴、散布或转载任何受保护的资料、商标或其他知识产权或所有权信息；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;f.删除本网站包含的任何他人拥有著作权、商标或其他知识产权、所有权的信息；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g.未经本网站事先书面授权，对本网站及本网站提供之任何服务的任何部分进行“帧联（Framing）”或“镜像(Mirror)”。或使用超文本标记语言元标记（Meta Tags）或代码或其他提及本网站及本网站提供之任何服务或网站的其他设备的信息，因任何目的，将任何人引导至任何其他网站；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;h.传输或张贴任何资料，只要它们构成或可能构成以下行为：可能被视为犯罪、或引起民事责任，或违反中国或世界任何其他国家/地区的法律，或侵犯第三方权利；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i.除了可适用法律所允许的范围内，修改、改编、再授权、转换、出售、逆向工程、译解、解码或以其他方式反汇编本网站及本网站提供之任何服务所使用的任何软件的任何部分，或使其他人这样做；
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;j.隐瞒您的真实婚姻状况或利用您的会员账号从事以下活动：<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·利用西网科技的会员权限向他人推销“可代其向指定客户联系”的服务；<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·将您的会员账号及密码交由其他人使用，包括但不限于转让、借用等；<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·以盈利或非盈利的目的，帮助他人传达交友及求爱信息或索取西网科技会员联系方式；<br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;·其他任何非以本人交友及求爱为目的所实施的行为。<br>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;k.出售、泄露西网科技会员信息。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>3.8</strong>您有权就本网站的其他会员有酒托茶托、花篮诈骗、情感诈骗、资料虚假等问题时向西网科技进行举报，您承诺前述举报行为均真实可信，西网科技在接到举报后会积极予以相应。但请您知悉，由于您的投诉信息可能涉嫌侵犯被投诉人的姓名权、名誉权、隐私权或其它合法权益，您应当承担投诉所产生的全部的法律责任。如您有虚假或恶意投诉，您将受到网站的严肃处理，如果因您虚假或恶意投诉而导致我们遭受任何损失的，您应就我们遭受的该等损失承担全额赔偿责任。如果由此导致任何第三方对我们提出任何权利请求的，您应保证我们不承担该等权利请求（包括适当的时候发表声明进行澄清）。如果我们先行对第三方承担责任的，我们有权对您进行追偿，您有义务在收到我们的追偿通知时全额赔偿我们的损失。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>4.隐私。</strong>&nbsp;为了达成向您提供及时、优质服务之目的，在您注册时或访问本网站网页，或使用本网站产品或服务，或参加任何形式的会员活动时，我们会收集并使用您的个人信息。这些个人信息包括但不限于：您的姓名、昵称、出生年月、性别、籍贯、行业、收入、照片、手机号码及电子邮件地址等联系方式个人信息以及网站自动接收并记录会员的浏览器和服务器日志上的信息(含会员登录所在地的IP地址、在线、无线信息、信件资料等)。本网站收集上述信息将用于：提供网站服务、改进网页内容，满足会员对某种产品、活动的需求、通知会员最新产品、活动信息、或根据法律法规要求的用途。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;您提供的上述个人信息将存储在我们的计算机上。一经缔结本协议则意味着您同意我们在您会员身份终止前，无需您事先同意即可无偿使用该等信息为您<strong>提供婚介服务</strong>或您定制的<strong>其他相关服务</strong>，包括但不限于创建兴趣、偏好和浏览模式档案或开展其它活动。您同意我们对所有会员提交的信息进行有关编排处理后形成的数据库拥有完全的知识产权。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;为了保证向您提供及时、优质的婚介服务，本网站会向您提供的电话、手机、电子邮箱拨打电话或发送短信及邮件（内容包括但不限于服务流程确认，其他会员希望与您联系、约见，活动信息和咨询、新服务或新产品的推介等、提示再次登录本网站等）。您注册为我们的会员即表示您已经明确同意接听上述电话或收到短信、邮件；如您不想接听上述电话或收到短信、邮件，请您拨打客服电话或登录本网站注销您的注册账号。如您未注销您的账户，则视为您同意接听或接受西网科技给您的电话、短信及邮件。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;您在缔结本协议时已理解并同意，您在本网站上公开发布的个人信息，任何登陆到本网站的第三人均可查看。尊重会员个人隐私是西网科技公司的一项基本政策。所以，在未经您的授权时西网科技不会公开、编辑或透露您的未在本网站上公开发布的个人信息及保存在西网科技各项服务中的非公开内容。但是为了保证向您提供及时、优质的婚介服务，我们在诚信的基础上认为透露这些信息某些情况是必要的，我们会将您的个人信息向下列第三人提供：
            (a)、您明确同意让第三方共享资料；(b)、只有透露您的个人信息，才能提供您所要求的产品和服务；(c)、为保护本网站、会员及社会公众的财产权利或人身权利；(d)、根据法律法规的规定，向司法机关提供；(e)、“隐私政策”列出的各类情况；(f)、执行软件验证服务；(g)、执行软件升级服务；(h)、网络同步服务；
            (i)、提高会员的使用安全性并提供客户支持；(j)、被搜索引擎在搜索结果中显示；(k)、<strong>因会员使用本网站特定功能或因会员有潜在婚恋服务意愿，向代表我们提供产品或服务的合作单位或授权单位（包括但不限于西网科技线下VIP婚介服务授权店）提供您的个人信息；</strong>(l)、受到黑客攻击导致会员信息泄漏的；(m)、为实现使用目的，其他有必要的情况。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;在前述情况下我们将您的个人信息提供给第三方不需要获得您事先同意。如因此给您造成任何损害您同意免除我们的相应法律责任。</strong><br>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;如果您位于中华人民共和国（为本协议之目的，本协议中所指中华人民共和国或中国，仅包括中华人民共和国大陆地区，不包括香港特别行政区、澳门特别行政区和台湾地区）境外，请注意，您提供的信息将被发送到中华人民共和国。通过成为本网站的会员，您同意:
            (a) 将您的个人信息传输到中华人民共和国；(b) 在中华人民共和国境内使用；(c) 依据我们的“隐私政策”，在服务提供和操作中将您的个人信息传输给第三方。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>5.知识产权。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>5.1</strong>西网科技公司对本网站所拥有之权利包括但不限于西网科技及其许可方受中国法律法规及世界范围内其他可适用的法律、法规或国际条约、国际惯例保护的任何资料、商标及其他知识产权和所有权。除公共领域可获得的信息或者您已获得我们书面许可的情况外，您不得复制、修改、公布、传播、执行、转载、许可使用、创建衍生作品、转移显示、出售、转售、以非法手段获取或以任何其他方式处置任何西网科技公司拥有知识产权或所有权的任何信息。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>5.2</strong>未经该类拥有者事先同意，您不能以任何方式张贴、散布或转载任何受保护的资料、商标或其他知识产权。除上述规定外，如果您相信您的作品在本网站上被以一种构成侵害知识产权的方式复制或公布，请向我们的知识产权代理提供以下全部信息：知识产权的所有人（含被授权人或所有人的代理人）的电子或实际签名；您声称受到侵犯的受保护作品之说明；您声称受侵犯资料在本网站上的位置说明；您的地址、电话号码和电子邮件地址；有关您确信该复制或公布行为未经知识产权所有者或其代理或法律批准的书面陈述；您表明以上信息是准确的而且您是知识产权所有人或所有人的代理人的书面陈述，该书面陈述需您本人签字确认方被视为有效。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>5.3</strong>您一经成为本网站之会员或使用本网站，则表示您承认西网科技公司对本网站及本网站所收集、制作、发布之各类信息拥有完全知识产权或所有权，包括但不限于各类文档、图像、数据库等，除非法律或本协议明确规定该等权利属于会员个人。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>5.4</strong>如您将各类信息公布到本网站的任何公共区域，则表示您同意，同时您自动授予，并且您陈述并保证您有权授予本网站不可撤销的、永久的、非独占的、完全免费的、世界范围的许可。在该等许可下，您同意本网站使用、复制、执行、显示并传播该内容，您也同意我们基于该内容创作衍生作品或将该内容整合到其他作品中且我们对该等衍生作品或整合作品拥有完全的知识产权；同时，在该等许可下，您已授予我们对上述许可的再许可权，即我们可以将您授予我们的许可转授给其他第三人，并且我们行使再许可权不需要再获得您的同意。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>6.服务访问。尽管我们会竭力确保本网站一天24小时都能正常使用，但我们不保证它将不会中断或没有任何错误。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;如果系统发生故障、进行维护或维修或其他超出我们控制的原因，导致对本网站的访问暂时中止，我们可能无法事先通知您，<strong>您同意在此情况下对您造成任何的损失（如有）免除我们的赔偿责任。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>7.信息储存、发送规则。</strong>您于缔结本协议时起即同意我们有权单方面制订有关本网站信息储存、发送的任何规则，包括但不限于本网站将保存的电子邮件讯息、所张贴内容或其他上载内容的保存期间、每个帐号可收发电子邮件讯息的最大数量及可收发的单个消息的大小。对于通过本网站服务存储或传送之任何信息、通讯资料和其他内容，如对您有特别意义，则我们在此建议您保存至您的个人电脑系统，如该等信息被您或我们删除或未予储存，无论有意还是无意为之，您都同意我们在此情况下不承担任何责任。您也同意，对于长时间未使用的帐号，本网站有权关闭。同时，您也同意，如同制定这些规则一样，本网站有权单方面变更上述有关信息储存、发送的规则而不需要征得您的同意或事先通知您。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;8.免责条款。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;8.1于缔结本协议时，您已同意就下列事由免除我们的法律责任：</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;a.我们会依据本协议为您提供服务，但您已理解并同意我们不保证所提供的服务将最终帮助您找到您的伴侣。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;b.您承认对于您利用本网站提供的服务或信息而从事的各类行为，包括在本网站发布各类信息，利用本网站提供之信息联系其他会员等，均为您个人行为且您个人对该类行为承担完全责任。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;c.对于会员上传的照片、资料、证件等信息，本网站已采用相关措施并已尽合理努力进行审核，但不保证其内容的正确性、合法性或可靠性，因此您在使用本网站时，可能会接触到令人不快、不适当或令人厌恶的内容。您同意在任何情况下，我们均不为会员经由本网站以张贴、发送电子邮件或其它方式传送的任何内容负责。相关责任由上传上述内容的会员负责。对于上传的信息，其它会员应以自己的独立判断来确定上传的照片的真实性、准确性，并独立承担可能产生的不利后果和责任，本网站不承担任何法律责任。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;d.对于本网站提供的各种广告信息、链接、资讯等（如有），本网站已采用相关措施并已尽合理努力进行审核；但并不就你与经由本网站所提供之信息与前述广告主、广告经营者进行的联系或进行的商业往来做出任何承诺及保证，基于前述行为完全属于您和广告主、广告经营者之间的行为，与本网站没有任何关系。对于前述商业往来所产生的任何损害或损失，本网站不承担任何责任。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;e.是否使用本网站服务下载或取得任何资料应由您自行考虑并自负风险，您同意因任何资料的下载而导致您电脑系统的任何损坏或数据丢失等后果，本网站不承担任何责任。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;f.对于会员自发组织的任何活动，或自发成立的组织的任何行为，本网站不负责任。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;8.2 责任限制。本网站和西网科技公司或任何珍爱公司关联企业，对于您或任何第三人因以任何方式连接本网站、或因使用、无法使用或使用本网站的结果可能导致的任何金钱或其他损失或损害不承担任何责任（该等损失或损害包括但不限于，任何直接的、间接的、惩罚性的或必然的损失或伤害，或任何收入、利润、信誉、数据、合同、资金使用上的任何损失，或以任何方式由任何种类的业务中断引起或与之相关的损失或伤害，无论是民事侵权行为、合同还是其他）。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;遵照以前所述，您同意，倘若您因为使用本网站或本网站提供之服务而遭受损失，且经过我们书面确认本网站应当对该损失负责的情况下，我们对您承担的赔偿责任，将不超过您已支付的会员费的金额。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>8.3</strong>会员因第三方如电信部门的通讯线路故障、技术问题、网络、电脑故障、系统不稳定性及其他各种不可抗力原因而遭受的一切损失，西网科技公司及合作单位不承担责任。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>8.4</strong>本服务同大多数互联网服务一样，受包括但不限于用户原因、网络服务质量、社会环境等因素的差异影响，可能受到各种安全问题的侵扰。会员应加强信息安全及使用者资料的保护意识，要注意加强密码保护，以免遭致损失和骚扰。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>8.5</strong>对于会员的投诉，本网站将认真核实，但不能保证最终公布的投诉处理结果的完全公正，您同意对于投诉内容和投诉处理结果，如侵犯您的隐私权、名誉权等合法权利，免除本网站的相应法律责任。
            本网站保留根据业务发展情况修改上述免责事由的权利。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;8.6在任何情况下，西网科技公司均不对任何间接性、后果性、惩罚性、偶然性、特殊性或刑罚性的损害，包括因会员使用服务而遭受的利润损失、利益损失，承担责任（即使西网科技公司已被告知该等损失的可能性亦然）。尽管本协议中可能含有相悖的规定，西网科技公司对会员承担的全部责任，无论因何原因或何种行为方式，始终不超过会员在使用西网科技服务而支付给西网科技公司的服务费用(如有) 。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;9.豁免。</strong>如果您因任何其他会员因使用本网站或其提供之服务引起的行为，向其要求索赔或进行诉讼，您同意独自进行该类索赔或诉讼，<strong>不会要求我们协助举证或者将我们列为被告，而且您将豁免我们承担由该索赔或诉讼引起的任何相关联的所有索赔、责任和损失。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;如果由于您使用本网站或其提供之服务的行为或其他相关行为，导致我们遭受索赔或诉讼，您同意就我们因此所受的全部损失进行赔偿，该等赔偿应包括但不限于我们在此索赔或者诉讼中支付的律师费及其他诉讼费用。您也同意在涉及上述任何索赔及诉讼时，尽其所能地给予配合与协助，以最大限度的降低我们的损失。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;10.违约及赔偿责任。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;10.1违约责任。</strong>您同意，如果经我们单方面判断，您违反本协议的<strong>一项或多项</strong>条款，我们有权不事先通知您而直接屏蔽您的帐户、删除被禁内容并阻止发布您的部分或全部档案。我们也有权不事先通知您而直接永久或暂时阻止您使用全部或部分服务。<strong>对于您在此情况下受到的任何损失我们不承担任何责任且我们没有义务返还您已交纳的会员费（无论全部或部分）。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;上述情况下，如果因您对本协议任一项或多项条款的违反而导致我们遭受任何损失的，您应就我们遭受的该等损失承担全额赔偿责任。如果由此导致任何第三方对我们提出任何权利请求的，您应保证我们不承担该等权利请求（包括适当的时候发表声明进行澄清）。如果我们先行对第三方承担责任的，我们有权对您进行追偿，您有义务在收到我们的追偿通知时全额赔偿我们的损失。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;10.2 赔偿责任。</strong>如果因为您通过本网站提供的服务提供、张贴、传送任何信息而导致违反本协议并进而造成我们产生损失时，您同意赔偿我们因此遭受的损失，包括但不限于合理的律师费和调查费用等。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;如果因为您侵害第三人任何权利因而导致任何第三人向我们提出索赔或请求，您同意赔偿我们因此遭受的损失，包括但不限于合理的律师费和调查费用等。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;11.本协议之生效及终止。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>11.1</strong>一旦您开始使用本网站或者成为本网站的会员，则本协议立即生效。如果您选择使用本网站或者成为本网站的会员，表示您选择开始使用本网站提供之任何信息及服务并同时接受本协议所有条款之约束。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>11.2</strong>您可以随时终止您的会员身份，您的终止行为在我们收到您书面或电子邮件通知后立即生效。您可以通过以下方式与我们联系：寄送书面邮件至深圳市南山区粤海街道海德三道航天科技广场A座19-21楼，或者通过会员服务中心（kefu@zhenai.com）向我们发送电子邮件。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;于缔结本协议时，您已知悉并同意，就前述单方面终止会员身份的行为，您并无任何权利要求，<strong>本网站亦无义务向您返还您已支付的任何费用（如有），</strong>但本网站将于收到您的书面或电子邮件通知并审查确认您的身份后撤销您在本网站上的相关信息。<strong>如您希望终止您的会员身份但未通过书面或电子邮件方式通知我们，使得您在本网站上的相关信息未能及时撤销的，您无权以任何理由就此对我们主张任何权利。</strong>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;<strong>11.3</strong>如您违反本协议之任一条款，我们有权立即终止您的会员身份（包括付费会员之身份），及访问和使用本网站的权利。您同意在上述情况下我们终止本协议并不需要通知您即可生效，<strong>对于您在此情况下受到的任何损失我们不承担任何责任且我们没有义务返还您已交纳的会员费（无论全部或部分）。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;12.不可抗力。</strong>
            您同意并认可，对于因超出我们合理控制范围的任何事件或情况，包括但不限于战争、入侵、恐怖袭击、自然灾害或其他不可抗力，<strong>以及任何技术故障的发生、电气短路、第三方侵入本网站等情况所给您造成的任何损失或损害，我们无需承担任何赔偿责任，</strong>并不被视为违反本协议。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;13.通知和送达。</strong><br>
            本协议项下所有的通知均可通过重要页面公告、电子邮件或常规的信件传送等方式进行；该等通知于发送之日视为已送达收件人。
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;14.争议及管辖</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;14.1 会员争议的解决。</strong>您理解并同意本网站仅仅是为您和其他会员的交往提供平台，但对您与其他西网科技会员的来往，无论是在网上或在现实生活中，您都须对您的行为承担全部责任。<strong>如您与其他会员产生争议，则您理解并同意本网站并没有义务监控或处理您与其他会员之间的争议。</strong>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;14.2管辖。</strong>如果因使用本网站，产生任何关于本网站或其提供之服务的争议，您同意该类争议将受中华人民共和国法律管辖，而不考虑可能产生的法律冲突。您同意，除非双方另行协商，该争议应交由深圳市南山区人民法院进行审判。
        </p>
        <p><strong>&nbsp;&nbsp;&nbsp;&nbsp;15.其他</strong>
        </p>
        <p><strong>&nbsp;&nbsp;&nbsp;&nbsp;15.1可分割性。</strong>如果本协议的任何部分被有权机关确定为无效或被协议双方认定为不可实施，那么协议的其余部分应该继续生效。就无效或不可实施之部分，我们有权单方面进行修改，使之具备法律效力且可以实施。
        </p>
        <p><strong>&nbsp;&nbsp;&nbsp;&nbsp;15.2.转让。</strong>我们有权单方面转让或转移我们在本协议项下的全部或部分权利和义务而不需要提前通知您。由于本网站提供服务有较强的人身性，您承诺放弃您转让本协议项下之权利和义务的权利。
        </p>
        <p><strong>&nbsp;&nbsp;&nbsp;&nbsp;15.3 关系。</strong>您同意不会因为本协议或使用本网站，而与本网站之间产生合资、合伙、雇佣或代理关系。
        </p>
        <p><strong>&nbsp;&nbsp;&nbsp;&nbsp;15.4权利认定。</strong>本协议构成双方对本协议之约定事项及其他有关事宜的完整协议，除本协议规定的之外，未赋予本协议各方其他权利。
        </p>
        <p><strong>&nbsp;&nbsp;&nbsp;&nbsp;15.5标题。</strong>本协议中的标题仅为方便而设，不具法律或契约效果。
        </p>
        <p><strong>&nbsp;&nbsp;&nbsp;&nbsp;15.6 联系信息。</strong>如在使用西网科技服务过程中有任何疑问及需求请发送电子邮件至会员服务中心（kefu@zhenai.com）与我们联系。
        </p>

        <p>
            <br>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;特 别 声 明</strong><br>
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;鉴于：我国《合同法》第39条规定：采用格式条款订立合同的，提供格式条款的一方应当遵循公平原则确定当事人之间的权利和义务，并采取合理的方式提请对方注意免除或者限制其责任的条款，按照对方的要求，对该条款予以说明。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;西网科技在此依法做出特别声明如下：
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;西网科技采取合理的方式提请您注意的义务将通过如下方式实现：在本协议中西网科技以明确的足以引起您注意的加重字体、斜体、下划线、颜色标记等合理方式提醒会员注意相关条款（需要强调的是，还包括会员应特别注意任何未明确标记的含有“不承担”、“免责”“不得”等形式用语的条款），该等条款的确认将导致您在特定情况下的被动、不便、损失，请您在确认同意本协议之前再次阅读上述条款。双方确认上述条款非属于《合同法》第40条规定的“免除其责任、加重对方责任、排除对方主要权利的”的条款，西网科技尊重会员的权利尤其是诉讼的权利，但作为在线网络信息服务提供方，西网科技在尊重会员诉讼权利的同时建议诉讼管辖地法院为西网科技公司所在地法院，而会员选择同意合同并使用服务即视为双方对此约定达成了一致意见。
        </p>
        <p>
            &nbsp;&nbsp;&nbsp;&nbsp;鉴于西网科技已依法明确了上述条款、履行了格式条款制订方的义务，您进行下一步，将被视为且应当被视为您已经完全注意并同意了本协议所有条款尤其是提醒会员注意的条款的合法性及有效性，会员不应当以西网科技未对格式条款以合理方式提醒会员注意，或未根据会员要求尽到说明义务为理由而声称或要求法院或其它任何第三方确认相关条款非法或无效。
        </p>
        <p>
            <br>
        </p>
        <p>
            <strong>&nbsp;&nbsp;&nbsp;&nbsp;我已阅读并充分理解了以上协议中各条款，特别是涉及免除或者限制西网科技责任的免责条款，对会员的权利限制的条款、约定争议解决方式、司法管辖、法律适用的条款，并且同意以上协议的全部内容。</strong>
        </p>
        <p>
            <br>
        </p>
        <p>
            <br>
        </p>
    </div>



</div>





<%@ include file="/common/h5/js.jsp" %>

<script language="JavaScript">

    $("#backBtn").click(function(){
        window.history.back();
    });

</script>



</body>


</html>
