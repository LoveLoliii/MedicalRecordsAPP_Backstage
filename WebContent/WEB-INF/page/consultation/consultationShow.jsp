<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.lua.javautil.Pagination"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet"
	href="${ctx}/assets/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/jquery.gritter.css" />
<link rel="stylesheet" href="${ctx}/assets/css/select2.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-editable.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/ace-skins.min.css" />
<script src="${ctx}/assets/js/ace-extra.min.js"></script>
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> 病历APP后台管理系统
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="${ctx}/assets/avatars/user.jpg" alt="Jason's Photo" /> <span
							class="user-info"> <small>Welcome,</small> Jason
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="icon-cog"></i> 设置
							</a></li>

							<li><a href="${ctx}/dep/ment/doctorInfo"> <i
									class="icon-user"></i> 个人资料
							</a></li>

							<li class="divider"></li>

							<li><a href="#"> <i class="icon-off"></i> 注销
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->
				<ul class="nav nav-list">
					<li  ><a href="index"> <i
							class="icon-dashboard"></i> <span class="menu-text"> 控制台 </span>

					</a></li>
					<s:if test="#session.doctorBaseInfo.state == 1">
						<li><a href="#" class="dropdown-toggle"> <i
								class="icon-text-width"></i> <span class="menu-text">
									医生信息管理 </span> <b class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">
								<li><a href="${ctx}/dep/ment/doctorAllInfo"> <i
										class="icon-double-angle-right"></i> 医生基本信息管理
								</a></li>

								<li><a href="${ctx}/dep/ment/doctorVisit"> <i
										class="icon-double-angle-right"></i> 坐诊时间表管理
								</a></li>
							</ul>
						<li class="active open"><a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i> <span class="menu-text">
									患者信息管理 </span> <b class="arrow icon-angle-down"></b>
						</a>

							<ul class="submenu">
								<li><a href="${ctx}/dep/ment/registered"> <i
										class="icon-double-angle-right"></i> 预约信息管理
								</a></li>

								<li><a href="${ctx}/dep/ment/patientInfo"> <i
										class="icon-double-angle-right"></i> 患者基本信息管理
								</a></li>

								<li><a href="${ctx}/dep/ment/medical"> <i
										class="icon-double-angle-right"></i> 患者病历信息管理
								</a></li>


								<li class="active"><a href="${ctx}/dep/ment/consultation">
										<i class="icon-double-angle-right"></i> 医患咨询管理
								</a></li>
							</ul></li>
					</s:if>
					<s:if test="#session.doctorBaseInfo.state == 2">
						<li><a href="#" class="dropdown-toggle"> <i
								class="icon-text-width"></i> <span class="menu-text">
									医生信息管理 </span> <b class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">
								<li><a href="${ctx}/dep/ment/doctorAllInfo"> <i
										class="icon-double-angle-right"></i> 医生基本信息管理
								</a></li>

								<li><a href="${ctx}/dep/ment/doctorVisit"> <i
										class="icon-double-angle-right"></i> 坐诊时间表管理
								</a></li>
							</ul>
						<li class="active open"><a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i> <span class="menu-text">
									患者信息管理 </span> <b class="arrow icon-angle-down"></b>
						</a>

							<ul class="submenu">
								<li><a href="${ctx}/dep/ment/registered"> <i
										class="icon-double-angle-right"></i> 预约信息管理
								</a></li>

								<li><a href="${ctx}/dep/ment/patientInfo"> <i
										class="icon-double-angle-right"></i> 患者基本信息管理
								</a></li>

								<li><a href="${ctx}/dep/ment/medical"> <i
										class="icon-double-angle-right"></i> 患者病历信息管理
								</a></li>


								<li class="active"><a href="${ctx}/dep/ment/consultation">
										<i class="icon-double-angle-right"></i> 医患咨询管理
								</a></li>
							</ul></li>
						<li><a href="#" class="dropdown-toggle"> <i
								class="icon-list"></i> <span class="menu-text"> 医院科室管理 </span> <b
								class="arrow icon-angle-down"></b>
						</a>

							<ul class="submenu">
								<li><a href="${ctx}/dep/ment/maindepartment"> <i
										class="icon-double-angle-right"></i> 科室基本信息管理
								</a></li>

								<li><a href="#" class="dropdown-toggle"> <i
										class="icon-double-angle-right"></i> 配置科室信息 <b
										class="arrow icon-angle-down"></b>
								</a>
									<ul class="submenu">
										<li><a
											href="${ctx}/dep/ment/maindepartment!deploymaindepartment">
												<i class="icon-leaf"></i> 科室与科室信息配置
										</a></li>
										<li><a href="${ctx}/dep/ment/departmentanddoctor"> <i
												class="icon-leaf"></i> 科室与医生信息配置
										</a></li>
									</ul></li>
							</ul></li>

						<li><a href="#" class="dropdown-toggle"> <i
								class="icon-edit"></i> <span class="menu-text"> 医院信息管理 </span> <b
								class="arrow icon-angle-down"></b>
						</a>

							<ul class="submenu">
								<li><a href="${ctx}/dep/ment/hospitalbaseinfo"> <i
										class="icon-double-angle-right"></i> 医院基本信息管理
								</a></li>

								<li><a href="#" class="dropdown-toggle"> <i
										class="icon-double-angle-right"></i> 挂号费、药品费管理 <b
										class="arrow icon-angle-down"></b>
								</a>
									<ul class="submenu">
										<li><a href="${ctx}/dep/ment/registrationfee"> <i
												class="icon-leaf"></i> 挂号费基本信息管理
										</a></li>
										<li><a href="${ctx}/dep/ment/drug"> <i
												class="icon-leaf"></i> 药品及设备基本信息管理
										</a></li>
									</ul></li>
								<li><a href="${ctx}/dep/ment/druguse"> <i
										class="icon-double-angle-right"></i> 药品及设备使用信息管理
								</a></li>
								<li><a href="${ctx}/dep/ment/pay"> <i
										class="icon-double-angle-right"></i> 支付基本信息管理
								</a></li>
							</ul></li>
						<li><a href="${ctx}/dep/ment/evaluation"> <i
								class="icon-list-alt"></i> <span class="menu-text">
									患者评价中心 </span>
						</a></li>

						<li><a href="#" class="dropdown-toggle"> <i
								class="icon-list"></i> <span class="menu-text"> 统计中心 </span> <b
								class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">
								<li><a href="${ctx}/dep/ment/highchart"> <i
										class="icon-double-angle-right"></i> 就诊信息统计
								</a></li>
								<li><a href="${ctx}/dep/ment/hospitalCostShow"> <i
										class="icon-double-angle-right"></i> 医疗费用统计
								</a></li>
							</ul></li>
					</s:if>
					<s:if test="#session.doctorBaseInfo.state == 0">
						<li><a href="gallery.html"> <i class="icon-picture"></i>
								<span class="menu-text"> 超级管理员信息管理</span>
						</a></li>
					</s:if>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li class="active">控制台</li>
					</ul>
					<!-- .breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>
				<hr>
				<div class="col-sm-5">
					<div class="widget-box">
						<div class="widget-header">
							<h4>患者列表</h4>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse"> <i
									class="icon-chevron-up"></i>
								</a> <a href="#" data-action="close"> <i class="icon-remove"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<div>
									<form action="consultation" id="myform">
										<select class="form-control" id="form-field-select-2"
											multiple="multiple" size="28" name="id">
											<s:iterator value="attentions">
												<option value="${patient_ID}" id="${patient_ID }"
													onclick="submitForm();">${patient_ID }</option>
											</s:iterator>
										</select>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%-- <div class="col-sm-7">
					<div class="widget-box">
						<div class="widget-header">
							<h4><i class="icon-comment blue">会话</i></h4>
						</div>
						<div class="widget-body">
							<div class="widget-main no-padding">
									<dl id="dt-list-1">
										<s:iterator value="list">
											<dt>${ consultation_sendID }&nbsp;&nbsp;&nbsp;${consultation_time }</dt>
											<dd>
												<span class="label label-info arrowed-in-right arrowed">
													${ consultation_msg } </span>
											</dd>
										</s:iterator>
									</dl>
											<div class="dialogs" >
												<s:iterator value="list">
													<div class="itemdiv dialogdiv">
														<div class="body">
															<div class="time">
																<i class="icon-time"></i>
																<span class="green">${consultation_time }</span>
															</div>
															<div class="name">
																<a href="#">${ consultation_sendID }</a>
															</div>
															<div class="text">
																${ consultation_msg }
															</div>
															<div class="tools">
																	<a href="#" class="btn btn-minier btn-info">
																		<i class="icon-only icon-share-alt"></i>
																	</a>
																</div>
														</div>
													</div>
												</s:iterator>
											</div>
									<hr>
									<form action="consultation!insert" method="post">
										<input type="hidden" name="id" id="def" value="${id }">
										<input type="text" size="75" style="height: 34px;" name="consultation.consultation_msg"/>
										<button class="btn btn-info btn-sm dropdown-toggle" onclick="getValue()">发送</button>
									</form>
							</div>
						</div>
					</div>
				</div> --%>
				<div class="col-sm-7">
					<div class="widget-box ">
						<div class="widget-header">
							<h4 class="lighter smaller">
								<i class="icon-comment blue"></i> 会话
							</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main no-padding">
								<div class="dialogs" style="overflow: scroll; height: 300px;">
									<s:iterator value="list">
										<div class="itemdiv dialogdiv">
											<div class="user">
												<img alt="Alexa's Avatar"
													src="${ctx }/assets/avatars/avatar2.png" />
											</div>

											<div class="body">
												<div class="time">
													<i class="icon-time"></i> <span class="green">${consultation_time }</span>
												</div>

												<div class="name">
													<a href="#">${ consultation_sendID }</a>
												</div>
												<div class="text">${ consultation_msg }</div>

												<div class="tools"></div>
											</div>
										</div>
									</s:iterator>

								</div>

								<form action="consultation!insert" method="post">
									<input type="hidden" name="id" id="def" value="${id }">
									<div class="form-actions">
										<div class="input-group">
											<input placeholder="Type your message here ..." type="text"
												class="form-control" name="consultation.consultation_msg" />
											<span class="input-group-btn">
												<button class="btn btn-sm btn-info no-radius" type="submit">
													<i class="icon-share-alt"></i> 发送
												</button>
											</span>
										</div>
									</div>
								</form>
							</div>
							<!-- /widget-main -->
						</div>
						<!-- /widget-body -->
					</div>
					<!-- /widget-box -->
				</div>
				<!-- /span -->

			</div>
			<!-- /.main-container-inner -->
		</div>
		<!-- /.main-container -->

		<!-- basic scripts -->

		<input type="hidden" id="abc" value="${id }">
		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery
					|| document
							.write("<script src='${ctx}/assets/js/jquery-2.0.3.min.js'>"
									+ "<"+"script>");
		</script>


		<script type="text/javascript">
			if ("ontouchend" in document)
				document
						.write("<script src='${ctx}/assets/js/jquery.mobile.custom.min.js'>"
								+ "<"+"script>");
		</script>
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
		<script type="text/javascript">
			var id = $("#abc").val();
			var ss = document.getElementById(id);
			ss.selected = true;//选中
		</script>
		<script type="text/javascript">
			function submitForm() {
				//获取form表单对象
				var form = document.getElementById("myform");

				form.submit();//form表单提交
			}
		</script>
</body>
</html>