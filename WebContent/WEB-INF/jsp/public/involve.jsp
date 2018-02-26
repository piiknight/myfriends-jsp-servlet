<%@page import="model.bean.Friend"%>
<%@page import="util.StringLibrary"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Friend> listInvolve = (ArrayList<Friend>) request.getAttribute("listInvolve");
%>
<%
	for (Friend friendInv : listInvolve) {
%>
<div class="comment-grid">
	 <img src="<%=request.getContextPath() %>/files/<%=friendInv.getPicture()%>" alt="">
	 <div class="comment-info">
	 <h4><a href="<%=request.getContextPath() %>/<%=StringLibrary.createSlug(friendInv.getCategory().getFl_name()) %>/<%=StringLibrary.createSlug(friendInv.getFname()) %>-<%=friendInv.getFid() %>.html"><%=friendInv.getFname() %></a></h4>
	 <p><%=friendInv.getPreview() %></p>
	 </div>
	 <div class="clearfix"></div>
</div>
<%
	}
%>