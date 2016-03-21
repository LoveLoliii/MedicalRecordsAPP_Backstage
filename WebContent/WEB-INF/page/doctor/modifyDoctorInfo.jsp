<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
		<link rel="stylesheet" href="${ctx}/assets/SweetAlert/sweetalert.css" />
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
								<li >
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
								<li >
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

						<li>
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

								<li>
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
								<a href="index">首页</a>
							</li>
							<li  >
								<a href="/MedicalRecordsAPP_Backstage/dep/ment/doctorInfo">个人资料</a>
							</li>
							<li><a href="/MedicalRecordsAPP_Backstage/dep/ment/doctorInfo!modifyDoctorInfo.action?doctorBaseInfo.doctorInfo_ID=${doctorBaseInfo.doctorInfo_ID }">修改个人资料</a>
							</li>
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

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<div class="hr dotted"></div>
								<form action="doctorInfo!updateDoctorInfo" id="form_doc" class="form-horizontal" role="form" enctype="multipart/form-data" method="post">
								<div>
									<div id="user-profile-1" class="user-profile row">
										<div class="col-xs-12 col-sm-3 center">
											<div>
												<span class="profile-picture">
													<img id="avatar" class="editable img-responsive" alt="Alex's Avatar" src="" />
												</span>

												<div class="space-4"></div>

												<div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
													<div class="inline position-relative">
														<a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
															<i class="icon-circle light-green middle"></i>
															&nbsp;
															<span class="white">
															
															<input type="text" name="doctorBaseInfo.doctorInfo_name" value="${doctorBaseInfo.doctorInfo_name}" style="border-style:none;padding:2">
															</span>
														</a>
													</div>
												</div>
											</div>

											<div class="space-6"></div>

											<div class="profile-contact-info">
												<div class="space-6"></div>

											</div>

											<div class="hr hr12 dotted"></div>


											<div class="hr hr16 dotted"></div>
											
											</div>

										<div class="col-xs-12 col-sm-9">
											<div class="center">
											</div>

											<div class="space-12"></div>

											<div class="profile-user-info profile-user-info-striped">
												<div class="profile-info-row">
													<div class="profile-info-name"> 编号 </div>
													<div class="profile-info-value">
														<span class="editable" id="username">
															<input type="hidden" name="doctorBaseInfo.doctorInfo_type" value="${doctorInfo_type }">
															<input type="hidden" name="doctorBaseInfo.ID" value="${doctorBaseInfo.ID}">
															<input type="hidden" name="doctorBaseInfo.state" value="${doctorBaseInfo.state}">
															<input type="text" name="doctorBaseInfo.doctorInfo_ID" value="${doctorBaseInfo.doctorInfo_ID}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> 密码 </div>

													<div class="profile-info-value">
														<span class="editable" id="country">
														<input type="text" name="doctorBaseInfo.doctorInfo_pwd" value="${doctorBaseInfo.doctorInfo_pwd}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> 性别 </div>

													<div class="profile-info-value">
														<span class="editable" id="age">
															<select name="doctorBaseInfo.doctorInfo_sex" class="select">
																<option value="1" <c:if test="${doctorBaseInfo.doctorInfo_sex == 1}">selected="selected"</c:if>>男</option>		
																<option value="0" <c:if test="${doctorBaseInfo.doctorInfo_sex == 0}">selected="selected"</c:if>>女</option>		
															</select>
														</span>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name"> 头像 </div>

													<div class="profile-info-value">
														<div class="form-group">
													<div class="col-sm-9" style="width:352px;">
														<input type="hidden" name="fileFileName" value="${doctorBaseInfo.doctorInfo_photo}">
														<input  type="file" id="id-input-file-2" name="file" />
														<%-- <span class="file-name" data-title="photo1.png"></span></label> --%>
													</div>
												</div>
													</div>
												</div>
												<div class="profile-info-row">
													<div class="profile-info-name"> 出生日期 </div>

													<div class="profile-info-value">
														<span class="editable" id="signup">
														<input type="text" name="doctorBaseInfo.doctorInfo_birthday" value="${doctorBaseInfo.doctorInfo_birthday}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> 家庭住址 </div>

													<div class="profile-info-value">
														<span class="editable" id="login">
														<input type="text" name="doctorBaseInfo.doctorInfo_address" value="${doctorBaseInfo.doctorInfo_address}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name"> 学历 </div>

													<div class="profile-info-value">
														<span class="editable" id="about">
														<input type="text" name="doctorBaseInfo.doctorInfo_record" value="${doctorBaseInfo.doctorInfo_record}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>
													<div class="profile-info-row">
													<div class="profile-info-name"> 职位 </div>

													<div class="profile-info-value">
														<span class="editable" id="about">
														<input type="text" name="doctorBaseInfo.doctorInfo_position" value="${doctorBaseInfo.doctorInfo_position}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>
													<div class="profile-info-row">
													<div class="profile-info-name"> 联系方式 </div>

													<div class="profile-info-value">
														<span class="editable" id="about">
														<input type="text" name="doctorBaseInfo.doctorInfo_phone" value="${doctorBaseInfo.doctorInfo_phone}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>
													<div class="profile-info-row">
													<div class="profile-info-name"> Email </div>

													<div class="profile-info-value">
														<span class="editable" id="about">
														<input type="text" name="doctorBaseInfo.doctorInfo_email" value="${doctorBaseInfo.doctorInfo_email}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>
													<%-- <div class="profile-info-row">
													<div class="profile-info-name"> 坐诊类型 </div>

													<div class="profile-info-value">
														<span class="editable" id="about">
																<select name="doctorBaseInfo.doctorInfo_type" class="select">
																	<option value="1" <c:if test="${doctorBaseInfo.doctorInfo_type == 1}">selected="selected"</c:if>>专家门诊</option>		
																	<option value="0" <c:if test="${doctorBaseInfo.doctorInfo_type == 0}">selected="selected"</c:if>>普通门诊</option>		
																</select>
														</span>
													</div>
												</div> --%>
													<div class="profile-info-row">
													<div class="profile-info-name"> 擅长治疗的疾病 </div>

													<div class="profile-info-value">
														<span class="editable" id="about">
														<input type="text" name="doctorBaseInfo.doctorInfo_disease" value="${doctorBaseInfo.doctorInfo_disease}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
												</div>
													<div class="profile-info-row">
													<div class="profile-info-name"> 办公室地址 </div>

													<div class="profile-info-value">
														<span class="editable" id="about">
														<input type="text" name="doctorBaseInfo.doctorInfo_Oaddress" value="${doctorBaseInfo.doctorInfo_Oaddress}" size="50" style="border-style:none;padding:10">
														</span>
													</div>
													
												</div>
													<div class="profile-info-row">
												<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" id="save_doc">
												<i class="icon-ok bigger-110"></i>
												提交
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="icon-undo bigger-110"></i>
												重置
											</button>
										</div>
									</div>
											</div>
												
											</div>
											
											<div class="space-20"></div>
											
											<div class="space-6"></div>
										
										</div>
									</div>
								</div>
								</form>
											</div>
										</div>
									</div>
								</div>
							<input type="hidden" id="photo" value="${doctorBaseInfo.doctorInfo_photo}">

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
  		$("#save_doc").click(function() {
            swal({
                title: "您确定要修改吗？",
                text: "您确定要修改这条数据？",
                type: "warning",
                showCancelButton: true,
                closeOnConfirm: false,
                confirmButtonText: "是的，我要修改",
                confirmButtonColor: "#ec6c62"
            }, function() {
            	$('#form_doc').submit();
            });
        });

  		</script>
		<script src="${ctx}/assets/SweetAlert/sweetalert.min.js"></script>
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${ctx}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
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
		var photo = $("#photo").val();
		$("#avatar").attr("src","${ctx}\\images\\"+photo);
		</script>
</body>
</html>