<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
	<!-- start: Meta -->
	<%@include file="/common/h5/meta.jsp"%>
	<!-- end: Mobile Specific -->
	<title>管理后台</title>
	<%@include file="/common/h5/css-link.jsp"%>
	<!-- start: CSS -->
	

</head>

<body>
<section class="aui-content-padded">
	<div class="aui-card-list">
		<div class="aui-card-list-header">
			卡片布局头部区域
		</div>
		<div class="aui-card-list-content-padded">
			内容区域，卡片列表布局样式可以实现APP中常见的各类样式
		</div>
		<div class="aui-card-list-footer">
			底部区域
		</div>
	</div>
</section>
<section class="aui-content">
	<div class="aui-card-list">
		<div class="aui-card-list-header">
			卡片布局头部区域
		</div>
		<div class="aui-card-list-content">
			<img src="${ctx}/aui/image/l2.png" />
		</div>
		<div class="aui-card-list-footer">
			2016年7月12日
		</div>
	</div>
	<div class="aui-card-list">
		<div class="aui-card-list-header">
			卡片布局头部区域
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
		<div class="aui-card-list-footer">
			<div><i class="aui-iconfont aui-icon-star"></i></div>
			<div><i class="aui-iconfont aui-icon-laud"></i></div>
			<div><i class="aui-iconfont aui-icon-note"></i></div>
		</div>
	</div>
	<div class="aui-card-list">
		<div class="aui-card-list-header aui-card-list-user aui-border-b">
			<div class="aui-card-list-user-avatar">
				<img src="${ctx}/aui/image/demo4.png" class="aui-img-round" />
			</div>
			<div class="aui-card-list-user-name">
				<div>AUI</div>
				<small>1天前</small>
			</div>
			<div class="aui-card-list-user-info">北京朝阳</div>
		</div>
		<div class="aui-card-list-content-padded">
			<img src="${ctx}/aui/image/l2.png" />
		</div>
		<div class="aui-card-list-footer aui-border-t">
			<div><i class="aui-iconfont aui-icon-note"></i> 666</div>
			<div><i class="aui-iconfont aui-icon-laud"></i> 888</div>
			<div><i class="aui-iconfont aui-icon-star"></i> 888</div>
		</div>
	</div>
	<div class="aui-card-list">
		<div class="aui-card-list-header">
			<div><i class="aui-iconfont aui-icon-my aui-text-danger"></i><span class="aui-text-danger"> 最近联系人</span></div>
			<i class="aui-iconfont aui-icon-more"></i>
		</div>
		<div class="aui-card-list-content">
			<ul class="aui-list aui-media-list">
				<li class="aui-list-item aui-list-item-middle">
					<div class="aui-media-list-item-inner">
						<div class="aui-list-item-media" style="width: 3rem;">
							<img src="${ctx}/aui/image/demo5.png" class="aui-img-round" >
						</div>
						<div class="aui-list-item-inner aui-list-item-arrow">
							<div class="aui-list-item-text">
								<div class="aui-list-item-title aui-font-size-14">AUI</div>
								<div class="aui-list-item-right">08:00</div>
							</div>
							<div class="aui-list-item-text">
								www.auicss.com
							</div>
						</div>
					</div>
				</li>
				<li class="aui-list-item aui-list-item-middle">
					<div class="aui-media-list-item-inner">
						<div class="aui-list-item-media" style="width: 3rem;">
							<img src="${ctx}/aui/image/liulangnan.png" class="aui-img-round">
						</div>
						<div class="aui-list-item-inner aui-list-item-arrow">
							流浪男
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="aui-card-list-footer aui-text-center">
			查看更多
		</div>
	</div>
</section>

<%@ include file="/common/h5/js.jsp" %>

</body>


</html>
