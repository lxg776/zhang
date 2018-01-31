<%@ page language="java" pageEncoding="UTF-8" %>

<div id="sidebar-left" class="span2">
	<div class="nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li><a href="${ctx}/manage/member/list"><i class="icon-folder-open"></i><span class="hidden-tablet">会员管理</span></a></li>
			<li><a href="${ctx}/manage/activity/list"><i class="icon-tasks"></i><span class="hidden-tablet">活动管理</span></a></li>
			<li><a href="${ctx}/manage/memberType/list"><i class="icon-tasks"></i><span class="hidden-tablet">会员类型管理</span></a></li>
			<li><a href="${ctx}/manage/contact/list"><i class="icon-tasks"></i><span class="hidden-tablet">红娘帮忙联系列表</span></a></li>
			<li>
				<a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet">支付管理</span></a>
				<ul>
					<li><a class="submenu" href="submenu.html"><i class="icon-file-alt"></i><span class="hidden-tablet">商户管理</span></a></li>
					<li><a class="submenu" href="${ctx}/manage/payVendor/list"><i class="icon-file-alt"></i><span class="hidden-tablet">第三方支付管理</span></a></li>
					<li><a class="submenu" href="submenu3.html"><i class="icon-file-alt"></i><span class="hidden-tablet"> Sub Menu3</span></a></li>
				</ul>
			</li>


		</ul>
	</div>
</div>

