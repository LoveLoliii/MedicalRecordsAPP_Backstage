<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page  import="com.lua.javautil.Pagination" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
		<link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/jquery.gritter.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/select2.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-editable.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${ctx}/assets/css/ace-skins.min.css" />
		<link href="${ctx}/assets/js/toastr-master/toastr.css" rel="stylesheet" type="text/css" />
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="${ctx}/assets/js/ace-extra.min.js"></script>
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							病历APP后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${ctx}/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
									${session.doctorBaseInfo.getDoctorInfo_name()}
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/doctorInfo">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="icon-off"></i>
										注销
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li>
							<a href="index">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 控制台 </span>
							</a>
						</li>
						<s:if test="#session.doctorBaseInfo.state == 1">
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 医生信息管理 </span>
									<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a href="${ctx}/dep/ment/doctorAllInfo">
										<i class="icon-double-angle-right"></i>
										医生基本信息管理
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/doctorVisit">
										<i class="icon-double-angle-right"></i>
										坐诊时间表管理
									</a>
								</li>
							</ul>

								

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 患者信息管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="${ctx}/dep/ment/registered">
										<i class="icon-double-angle-right"></i>
										预约信息管理
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/patientInfo">
										<i class="icon-double-angle-right"></i>
										患者基本信息管理
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/medical">
										<i class="icon-double-angle-right"></i>
										患者病历信息管理
									</a>
								</li>


								<li>
									<a href="${ctx}/dep/ment/consultation">
										<i class="icon-double-angle-right"></i>
										医患咨询管理
									</a>
								</li>
							</ul>
						</li>
						</s:if>
						<s:if test="#session.doctorBaseInfo.state == 2">
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 医生信息管理 </span>
									<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li>
									<a href="${ctx}/dep/ment/doctorAllInfo">
										<i class="icon-double-angle-right"></i>
										医生基本信息管理
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/doctorVisit">
										<i class="icon-double-angle-right"></i>
										坐诊时间表管理
									</a>
								</li>
							</ul>

								

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text"> 患者信息管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="${ctx}/dep/ment/registered">
										<i class="icon-double-angle-right"></i>
										预约信息管理
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/patientInfo">
										<i class="icon-double-angle-right"></i>
										患者基本信息管理
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/medical">
										<i class="icon-double-angle-right"></i>
										患者病历信息管理
									</a>
								</li>


								<li>
									<a href="${ctx}/dep/ment/consultation">
										<i class="icon-double-angle-right"></i>
										医患咨询管理
									</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 医院科室管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="${ctx}/dep/ment/maindepartment">
										<i class="icon-double-angle-right"></i>
										科室基本信息管理
									</a>
								</li>

								<li>
									<a href="#" class="dropdown-toggle">
										<i class="icon-double-angle-right"></i>
										配置科室信息
										<b class="arrow icon-angle-down"></b>
									</a>
									<ul class="submenu">
										<li>
											<a href="${ctx}/dep/ment/maindepartment!deploymaindepartment">
												<i class="icon-leaf"></i>
												科室与科室信息配置
											</a>
										</li>
										<li>
											<a href="${ctx}/dep/ment/departmentanddoctor">
												<i class="icon-leaf"></i>
												科室与医生信息配置
											</a>
										</li>
									</ul>
								</li>
							</ul>
						</li>

						<li  class="active open">
							<a href="#" class="dropdown-toggle">
								<i class="icon-edit"></i>
								<span class="menu-text"> 医院信息管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="${ctx}/dep/ment/hospitalbaseinfo">
										<i class="icon-double-angle-right"></i>
										医院基本信息管理
									</a>
								</li>

								<li  class="active">
									<a href="#" class="dropdown-toggle">
										<i class="icon-double-angle-right"></i>
										挂号费、药品费管理
										<b class="arrow icon-angle-down"></b>
									</a>
									<ul class="submenu">
										<li>
											<a href="${ctx}/dep/ment/registrationfee">
												<i class="icon-leaf"></i>
												挂号费基本信息管理
											</a>
										</li>
										<li>
											<a href="${ctx}/dep/ment/drug">
												<i class="icon-leaf"></i>
												药品及设备基本信息管理
											</a>
										</li>
									</ul>
								</li>
								<li>
									<a href="${ctx}/dep/ment/druguse">
										<i class="icon-double-angle-right"></i>
										药品及设备使用信息管理
									</a>
								</li>

								<li>
									<a href="${ctx}/dep/ment/pay">
										<i class="icon-double-angle-right"></i>
										支付基本信息管理
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="${ctx}/dep/ment/evaluation">
								<i class="icon-list-alt"></i>
								<span class="menu-text"> 患者评价中心 </span>
							</a>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 统计中心 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="${ctx}/dep/ment/highchart">
										<i class="icon-double-angle-right"></i>
										就诊信息统计
									</a>
								</li>
								<li>
									<a href="${ctx}/dep/ment/hospitalCostShow">
										<i class="icon-double-angle-right"></i>
										医疗费用统计
									</a>
								</li>
							</ul>
						</li>
						</s:if>
						<s:if test="#session.doctorBaseInfo.state == 0">
						<li>
							<a href="gallery.html">
								<i class="icon-picture"></i>
								<span class="menu-text"> 超级管理员信息管理</span>
							</a>
						</li>
						</s:if>
							</ul>
						</li>
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">More Pages</a>
							</li>
							<li class="active">User Profile</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>
									<hr>
											<div >
											<form action="drug">
												<span class="col-xs-3">
												查询条件：<select  id="form-field-select-1" name="id" >
																				<option value="0">--请选择--</option>
																				<option value="1">编号</option>
																				<option value="2">药品（设备）名称</option>
																				<option value="3">剂量</option>
																				<option value="4">价格</option>
																				<option value="5">生产日期</option>
																				<option value="6">保质期</option>
																				<option value="7">制药厂</option>
																				<option value="8">药品类型</option>
												 	</select>
											 	</span>
											 	<span class="col-xs-3">
											 		<input type="text" class="form-control search-query" placeholder="请输入" name="search_id" value="${search_id }"/>
												</span>
												<span class="col-xs-3">
													<button type="submit" class="btn btn-purple btn-sm">查找
														<i class="icon-search icon-on-right bigger-110"></i>
													</button>
												</span>
											</form>
											</div>
											
									<div class="col-xs-12">
										<div class="table-responsive">
											<hr>
											<!-- <button class="btn btn-sm btn-primary" ><i class="icon-pencil align-top bigger-125"></i>增加科室</button><hr> -->
											<button class="btn btn-xs" style="color:#428bca!important;">
															<i class="icon-pencil align-top bigger-125"></i>
															<s:url id="url" action="drug" method="insertDrugBefore">
															</s:url> <s:a href="%{url}" style="color:black;">增加药品（设备）</s:a>
											</button><hr>
											<table id="sample-table-1" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th style="text-align:center;">编号</th>
														<th style="text-align:center;">药品（设备）名称</th>	
														<th style="text-align:center;">剂量（克）</th>	
														<th style="text-align:center;">价格（元）</th>
														<th style="text-align:center;">生产日期</th>	
														<th style="text-align:center;">保质期（天）</th>	
														<th style="text-align:center;">制药厂</th>
														<th style="text-align:center;">药品类型</th>	
														<th>操作</th>
												</thead>
												<tbody>
												<s:iterator value="pagination.list">
													<tr>
														<td id="dialog" style="text-align:center;">${drug_ID }</td>
														<td style="text-align:center;">${drug_name }</td>
														<td style="text-align:center;">${drug_num }</td>
														<td style="text-align:center;">${drug_price }</td>
														<td style="text-align:center;">${drug_time }</td>
														<td style="text-align:center;">${drug_period }</td>
														<td style="text-align:center;">${drug_produce_factory }</td>
														<td style="text-align:center;">${drug_style }</td>
														<td>
														<button class="btn btn-warning btn-xs">
															<i class="icon-wrench  bigger-110 icon-only"></i>
															<s:url id="url" action="drug" method="modifyDrugBefore">
																<s:param name="drug.drug_ID" value="drug_ID" />
															</s:url> <s:a href="%{url}">修改</s:a></button>
														</td>
													</tr>
												</s:iterator>
												</tbody>
											</table>
										</div><!-- /.table-responsive -->
									</div><!-- /span -->
									<jsp:include page="pagination_util.jsp">
										<jsp:param value="drug" name="url"/>
									</jsp:include>
								</div>
								<input type="hidden" id="i" value="${i}">
								<input type="hidden" id="i1" value="${i1}">
								<input type="hidden" id="i2" value="${i2}">

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${ctx}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
		$(function () {
			toastr.options = {
					  "closeButton": false,
					  "debug": false,
					  "positionClass": "toast-top-right",
					  "onclick": null,
					  "showDuration": "300",
					  "hideDuration": "1000",
					  "timeOut": "5000",
					  "extendedTimeOut": "1000",
					  "showEasing": "swing",
					  "hideEasing": "linear",
					  "showMethod": "fadeIn",
					  "hideMethod": "fadeOut"
					}
			
			var id = $("#dialog").html();
			var i = $("#i").val();
			var i1 = $("#i1").val();
			var i2 = $("#i2").val();
			if(id==null){
				toastr.error('抱歉，没有查到相关信息！');
			}
			if(i==1){
				toastr.success('修改药品（设备）成功！');
			}
			if(i1==1 && i2==1){
				toastr.success('增加药品（设备）成功！');
			}
		});
		</script>
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${ctx}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${ctx}/assets/js/toastr-master/toastr.js"></script>
		<script src="${ctx}/assets/js/toastr-master/glimpse.js"></script>
		<script src="${ctx}/assets/js/toastr-master/glimpse.toastr.js"></script>
		<script src="${ctx}/assets/js/bootstrap.min.js"></script>
		<script src="${ctx}/assets/js/typeahead-bs2.min.js"></script>
		<script src="${ctx}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${ctx}/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${ctx}/assets/js/jquery.gritter.min.js"></script>
		<script src="${ctx}/assets/js/bootbox.min.js"></script>
		<script src="${ctx}/assets/js/jquery.slimscroll.min.js"></script>
		<script src="${ctx}/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="${ctx}/assets/js/jquery.hotkeys.min.js"></script>
		<script src="${ctx}/assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="${ctx}/assets/js/select2.min.js"></script>
		<script src="${ctx}/assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="${ctx}/assets/js/fuelux/fuelux.spinner.min.js"></script>
		<script src="${ctx}/assets/js/x-editable/bootstrap-editable.min.js"></script>
		<script src="${ctx}/assets/js/x-editable/ace-editable.min.js"></script>
		<script src="${ctx}/assets/js/jquery.maskedinput.min.js"></script>
		<script src="${ctx}/assets/js/ace-elements.min.js"></script>
		<script src="${ctx}/assets/js/ace.min.js"></script>
		<script type = "text/javascript" >
			var  id = ${id};
			var  ss = document.getElementById('form-field-select-1');
			ss[id].selected = true;//选中
		</script>
</body>
</html>