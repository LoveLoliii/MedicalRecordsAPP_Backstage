<%@page import="com.lua.model.MinorDepartment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page  import="com.lua.javautil.Pagination" %>
<%@ page  import="com.lua.javautil.PaginationNew" %>
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
		<script src="${ctx}/assets/js/ace-extra.min.js"></script>
		
		<!-- 实现注销弹窗 -->
			<!-- Jquery --> 		<script src="${ctx}/assets/js/jquery-1.11.3.min.js"> </script>
    		<!-- Confirm Modal -->  <script type="text/javascript" src="${ctx}/assets/js/confirm.js"></script>
    
 <script>

$(function() {
        Confirm.init('sm');
 $('#delete1').unbind();
        $('#delete1').bind('click', function(e) {
            e.preventDefault();
            Confirm.show('注销确认', '您确定要退出此账号吗？', {
                '确定': {
                    'primary': true,
                    'callback': function() {
                        Confirm.show('信息', '退出中！');
                        window.setTimeout("window.location='${ctx }/dep/ment/killSession'",2000); 
                    }
                }
            });
        });
 });
</script>
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
									<a href="${ctx}/dep/ment/doctorInfo">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>

								<li class="divider"></li>

								<li ><i class="icon-off" ></i>
										<button id="delete1" class="btn btn-success" type="submit">注销</button>
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
						<li class="active open">
							<a href="#" class="dropdown-toggle">
								<i class="icon-text-width"></i>
								<span class="menu-text"> 医生信息管理 </span>
									<b class="arrow icon-angle-down"></b>
							</a>
							<ul class="submenu">
								<li class="active">
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
						<li class="active open">
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

								<li class="active">
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

							<li  class="active">
								医院科室管理
							</li>
							<li  class="active">
								配置科室信息
							</li>
							<li>
							<a href="/MedicalRecordsAPP_Backstage/dep/ment/departmentanddoctor">科室与医生信息配置</a>
							</li>
							<li>
							<a href="/MedicalRecordsAPP_Backstage/dep/ment/departmentanddoctor!showDoctor.action?minordepartment.minordepartment_ID=${minordepartment.minordepartment_ID }&minordepartment.minordepartment_name=${minordepartment.minordepartment_name }">查看属下医生</a>
							</li>
								
						</ul><!-- .breadcrumb -->

						<%-- <div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div> --%><!-- #nav-search -->
					</div>
									<hr>
											<div >
											
											</div>
											
											
										<div class="col-sm-5">
										<hr>
										<div class="widget-box">
											<table id="sample-table-1" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th style="text-align:center;">次科室编号</th>
														<th style="text-align:center;">次科室名称</th>	
														<th>操作</th>
												</thead>
												<tbody>
													<s:iterator value="pagination.list">
													<tr>
														<td style="text-align:center;">${minordepartment_ID }</td>
														<td style="text-align:center;">${minordepartment_name }</td>
														<td>
														<button class="btn btn-warning btn-xs">
															<i class="icon-wrench  bigger-110 icon-only"></i>
															<s:url id="url" action="departmentanddoctor" method="showDoctor">
																<s:param name="minordepartment.minordepartment_ID" value="minordepartment_ID" />
																<s:param name="minordepartment.minordepartment_name" value="minordepartment_name" />
															</s:url> <s:a href="%{url}">查看属下医生</s:a></button>
														</td>
													</tr>
												</s:iterator>
												</tbody>
											</table>
											<jsp:include page="pagination_util.jsp" >
												<jsp:param value="departmentanddoctor" name="url"/>
											</jsp:include>
										</div>
										
									</div>
									
									<div class="col-sm-7">
									<hr>
									<h4 class="pink">
										<i class="icon-hand-right icon-animated-hand-pointer blue"></i>${minordepartment.minordepartment_name }
									</h4>
									<input type="hidden" id="minordepartment" value="${id}"/>
										<div class="widget-box">
											<table id="sample-table-1" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th style="text-align:center;">医生编号</th>
														<th style="text-align:center;">医生名称</th>	
														<th style="text-align:center;">性别</th>
														<th style="text-align:center;">职位</th>
														<th style="text-align:center;">电话</th>
														<th style="text-align:center;">坐诊类型</th>
														<th style="text-align:center;">操作</th>
													</tr>
												</thead>
												<tbody>
													<s:iterator value="paginationNew.listNew">
													<tr>
														<td style="text-align:center;">${doctorInfo_ID }</td>
														<td style="text-align:center;">${doctorInfo_name }</td>
														<td style="text-align:center;">
															<c:if test="${doctorInfo_sex==1}">
															 男</c:if>
														<c:if test="${doctorInfo_sex==0}">
															 女</c:if>
														</td>
														<td style="text-align:center;">${doctorInfo_position }</td>
														<td style="text-align:center;">${doctorInfo_phone }</td>
														<td style="text-align:center;">
															 <span class="label label-lg label-pink arrowed-right">${doctorInfo_type}</span>
														</td>
														<td style="text-align:center;">
														<button class="btn btn-warning btn-xs">
															<i class="icon-wrench  bigger-110 icon-only"></i>
															<s:url id="url" action="departmentanddoctor" method="modifyDepartmentAndDoctorBefore">
																<s:param name="doctorBaseInfo.doctorInfo_ID" value="doctorInfo_ID" />
															</s:url> <s:a href="%{url}">修改</s:a></button>
														</td>
													</tr>
												</s:iterator>
												</tbody>
											</table>
											<jsp:include page="pagination_util_other.jsp">
												<jsp:param value="departmentanddoctor!showDoctor?minordepartment.minordepartment_ID=${minordepartment.minordepartment_ID}&minordepartment.minordepartment_name=${minordepartment.minordepartment_name}" name="url"/>
											</jsp:include>
										</div>
									</div>
								</div>


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
			/* function delete_doc(){
				alert(e)
				var boo = confirm("确定要删除这条用户信息？");
				if(!boo){
					return false;
				}else{
					return false;
				}
				
			} */
			
			var state = $("#minordepartment").val();
			if(state==0){
				toastr.error('您所选的次科室属下没有医生！');
			}
		});
		</script>
		<script src="${ctx}/assets/js/toastr-master/toastr.js"></script>
		<script src="${ctx}/assets/js/toastr-master/glimpse.js"></script>
		<script src="${ctx}/assets/js/toastr-master/glimpse.toastr.js"></script>
		
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
		
</body>
</html>