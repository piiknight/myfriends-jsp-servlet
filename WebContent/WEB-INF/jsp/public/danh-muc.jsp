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
			 	<% 
			 		ArrayList<Friend> friends = (ArrayList<Friend>) request.getAttribute("friends");
			 		Category objCat = (Category) request.getAttribute("objCat");
			 		if (friends.size() > 0){
			 		request.setAttribute("id", objCat.getFl_id());
				 %>				 
				 <h1 class="title"><span>Những người bạn >> </span><%=objCat.getFl_name() %></h1>
				 <%
				 	for(Friend friend:friends){
				 %>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
							 <h3><a href="<%=request.getContextPath() %>/detail?fid=<%=friend.getFid() %>"><%=friend.getFname() %></a></h3>
							 <h4>Đăng ngày: <%=StringUtil.formatTimestamp(friend.getDate_create()) %> - Lượt xem: <%=friend.getCount_number() %></h4>
							 <p><%=friend.getPreview() %></p>
							 <img src="<%=request.getContextPath() %>/files/<%=friend.getPicture() %>" alt=""/>
							 <a class="bttn" href="<%=request.getContextPath() %>/<%=StringLibrary.createSlug(friend.getCategory().getFl_name()) %>/<%=StringLibrary.createSlug(friend.getFname()) %>-<%=friend.getFid() %>.html">Chi tiết bạn tôi</a>
					 </div>
				 </div>
				 
				<%
			 		}} else {
				%>
				<h3>Không có dữ liệu</h3>
				<%
			 		}
				%>
				
			    <div class="my_pagination pagination">
				<span>PAGE</span>
				<%
					int sumPage = (int) request.getAttribute("sumPage");
					int currentPage = (int) request.getAttribute("currentPage");
				%>
			 		<a id="backlistpage" href="javascript:;">&laquo;</a>
			 		<%
			 			if (currentPage != 1) {
			 		%>
			 		<a href="<%=request.getContextPath() %>/<%=StringLibrary.createSlug(objCat.getFl_name()) %>-<%=objCat.getFl_id() %>/page/<%=currentPage - 1 %>">&lsaquo;</a>
			 		<%
			 			}
			 		%>
					<%
						
						String active = "";
						for (int i = 1; i <= sumPage; i++){
							if (i == currentPage) {
								active = "class='active'";
							} else {
								active = "";
							}
					%>
						<a id="idpage<%=i %>" <%=active %> href="<%=request.getContextPath() %>/<%=StringLibrary.createSlug(objCat.getFl_name()) %>-<%=objCat.getFl_id() %>/page/<%=i %>"><%=i %></a>
					<%
						}
					%>
					<%
			 			if (currentPage != sumPage) {
			 		%>
			 		<a href="<%=request.getContextPath() %>/<%=StringLibrary.createSlug(objCat.getFl_name()) %>-<%=objCat.getFl_id() %>/page/<%=currentPage + 1 %>">&rsaquo;</a>
			 		<%
			 			}
			 		%>
					<a id="nextlistpage" href="javascript:;">&raquo;</a>
				</div>
			 </div>
			 
			 <%@include file="/template/public/inc/menu-bar.jsp" %>
		 </div>
	 </div>
</div>

<%@include file="/template/public/inc/footer.jsp" %>