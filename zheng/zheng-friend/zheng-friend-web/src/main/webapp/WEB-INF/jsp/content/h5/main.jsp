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
			width: 4rem;
			height: 4rem;
			position: absolute;
			left: 50%;
			top: 50%;
			margin-left: -2rem;
			margin-top: -2rem;
			background-color: #e0e0e0;
			border-radius: 50%;
			line-height: 4rem;
			text-align: center;
			color: #212121;
			font-size: 1.2rem;
		}
	</style>

</head>

<body>
<body>
<div id="demo">1</div>
<footer class="aui-bar aui-bar-tab" id="footer">
	<div class="aui-bar-tab-item aui-active" tapmode>
		<i class="aui-iconfont aui-icon-home"></i>
		<div class="aui-bar-tab-label">首页</div>
	</div>
	<div class="aui-bar-tab-item" tapmode>
		<i class="aui-iconfont aui-icon-star"></i>
		<div class="aui-bar-tab-label">活动</div>
	</div>
	<div class="aui-bar-tab-item" tapmode>
		<div class="aui-badge">99</div>
		<i class="aui-iconfont aui-icon-comment"></i>
		<div class="aui-bar-tab-label">消息</div>
	</div>
	<div class="aui-bar-tab-item" tapmode>
		<div class="aui-dot"></div>
		<i class="aui-iconfont aui-icon-my"></i>
		<div class="aui-bar-tab-label">我的</div>
	</div>
</footer>
</body>

<%@ include file="/common/h5/js.jsp" %>

<script type="text/javascript" src="${ctx}/aui/script/aui-tab.js" ></script>
<script type="text/javascript">
    apiready = function(){
        api.parseTapmode();
    }
    var tab = new auiTab({
        element:document.getElementById("footer")
    },function(ret){
        console.log(ret);
        if(ret){
            document.getElementById("demo").textContent = ret.index;
        }
    });
</script>

</body>


</html>
