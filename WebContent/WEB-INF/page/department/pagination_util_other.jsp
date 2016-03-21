<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String url = request.getParameter("url");
	String new_url = "";
	if(url.indexOf("?")<0){
		new_url = url+"?pageNumNew=";
	}else{
		new_url = url+"&pageNumNew=";
	}
	request.setAttribute("new_url",new_url);
 %>
 <div class="row">
 <div class="col-sm-6">
 <div class="dataTables_paginate paging_bootstrap">
 <ul class="pagination" style="float:right;">
	 <c:choose>
	 	<c:when test="${paginationNew.pageNumNew==1}">
			<li class="prev disabled"><a href="#"><i class="icon-double-angle-left"></i></a></li> 	 	
	 	</c:when>
	 	<c:otherwise>
			 <li><a href="${new_url}${paginationNew.previousNew}"><i class="icon-double-angle-left"></i></a></li>
	 	</c:otherwise>
	 </c:choose>
	 <c:forEach var="i" begin="${paginationNew.startNavNew}" end="${paginationNew.endNavNew}">
	 	<c:choose>
	 		<c:when test="${paginationNew.pageNumNew==i}">
				<li class="active"><a href="#">${i}</a></li>
	 		</c:when>
	 		<c:otherwise>
				 <li><a href="${new_url}${i}">${i}</a></li>
	 		</c:otherwise>
	 	</c:choose>
	 </c:forEach>
	 <c:choose>
	 	<c:when test="${paginationNew.pageNumNew==paginationNew.lastNew}">
	 		<li class="prev disabled"><a href="#"><i class="icon-double-angle-right"></i></a></li> 
	 	</c:when>
	 	<c:otherwise>
			 <li class="next"><a href="${new_url}${paginationNew.nextNew}"><i class="icon-double-angle-right"></i></a></li>
	 	</c:otherwise>
	 </c:choose>
</ul>
</div>
</div>
</div>