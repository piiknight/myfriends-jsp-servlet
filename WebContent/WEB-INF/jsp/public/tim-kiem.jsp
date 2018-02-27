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
                 	String err = request.getParameter("err");
                 	if ("1".equals(err)){
                 		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Không tìm thấy ID.</div>");
                 	} else if ("2".equals(err)){
                 		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Không tìm thấy trang.</div>");
                 	}
                 	String name = request.getParameter("name");
                 	if (request.getParameter("name") == null){
                 		name = "";
                 	}
                 %>			 
				 <h1 class="title">Danh sách tìm kiếm : <span><%=name %></span></h1>
				 <%
				 	ArrayList<Friend> friends = (ArrayList<Friend>) request.getAttribute("friends");
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
			 		<a href="<%=request.getContextPath() %>/danh-sach-tim-kiem.html-<%=name %>/page/<%=currentPage - 1 %>">&lsaquo;</a>
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
						<a id="idpage<%=i %>" <%=active %> href="<%=request.getContextPath() %>/danh-sach-tim-kiem.html?name=<%=name %>&page=<%=i %>"><%=i %></a>
					<%
						}
					%>
					<%
			 			if (currentPage != sumPage) {
			 		%>
			 		<a href="<%=request.getContextPath() %>/danh-sach-tim-kiem.html-<%=name %>/page/<%=currentPage + 1 %>">&rsaquo;</a>
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