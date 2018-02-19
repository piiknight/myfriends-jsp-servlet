<%@page import="util.StringUtil"%>
<%@page import="model.bean.Friend"%>
<%@page import="model.dao.FriendDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/public/inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">				 
				 <h1 class="title">Những người bạn</h1>
				 <%
				 	ArrayList<Friend> friends = (ArrayList<Friend>) request.getAttribute("friends");
				 	for(Friend friend:friends){
				 %>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							 <h3><a href="<%=request.getContextPath() %>/detail?fid=<%=friend.getFid() %>"><%=friend.getFname() %></a></h3>
							 <h4>Đăng ngày: <%=StringUtil.formatTimestamp(friend.getDate_create()) %> - Lượt xem: <%=friend.getCount_number() %></h4>
							 <p><%=friend.getPreview() %></p>
							 <img src="<%=request.getContextPath() %>/images/<%=friend.getPicture() %>" alt=""/>
							 <a class="bttn" href="<%=request.getContextPath() %>/detail?fid=<%=friend.getFid() %>">Chi tiết bạn tôi</a>
					 </div>
				 </div>
				<%
				 	}
				%>
			 </div>
			 
			 <%@include file="/template/public/inc/menu-bar.jsp" %>
		 </div>
	 </div>
</div>

<%@include file="/template/public/inc/footer.jsp" %>