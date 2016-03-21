<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String url = request.getParameter("url");
	String new_url = "";
	if(url.indexOf("?")<0){
		new_url = url+"?pageNum=";
	}else{
		new_url = url+"&pageNum=";
	}
	request.setAttribute("new_url",new_url);
 %>
 <div class="col-sm-6">
 <div class="dataTables_paginate paging_bootstrap">
 <ul class="pagination">
	 <c:choose>
	 	<c:when test="${pagination.pageNum==1}">
			<li class="prev disabled"><a href="#">��ҳ</a></li> 	 	
	 	</c:when>
	 	<c:otherwise>
			 <li><a href="${new_url}${pagination.first}">��ҳ</a></li>
			 <li><a href="${new_url}${pagination.previous}">��һҳ</a></li>
	 	</c:otherwise>
	 </c:choose>
	 <c:forEach var="i" begin="${pagination.startNav}" end="${pagination.endNav}">
	 	<c:choose>
	 		<c:when test="${pagination.pageNum==i}">
				<li class="prev disabled"><a href="#">${i}</a></li>
	 		</c:when>
	 		<c:otherwise>
				 <li><a href="${new_url}${i}">${i}</a></li>
	 		</c:otherwise>
	 	</c:choose>
	 </c:forEach>
	 <c:choose>
	 	<c:when test="${pagination.pageNum==pagination.last}">
			<li class="prev disabled"><a href="#">ĩҳ</a></li>
	 	</c:when>
	 	<c:otherwise>
			 <li><a href="${new_url}${pagination.next}">��һҳ</a></li>
			 <li><a href="${new_url}${pagination.last}">ĩҳ</a></li>
	 	</c:otherwise>
	 </c:choose>
</ul>
</div>
</div>