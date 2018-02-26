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
				 <div class="content-grid">
					 <div class="content-grid-head">
					 <%
					 	Friend friend = (Friend) request.getAttribute("friend");
					 	request.setAttribute("id", friend.getCategory().getFl_id());
					 	ArrayList<Friend> anotherFriends = (ArrayList<Friend>) request.getAttribute("anotherFriends");
					 %>
						 <h3><%=friend.getCategory().getFl_name() %></h3>
						 <h4>Đăng ngày: <%=StringUtil.formatTimestamp(friend.getDate_create()) %> - Lượt xem: <%=friend.getCount_number() %></h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
						 <h3><%=friend.getFname() %></h3>
						 <div class="detail_text">
							 <span><%=friend.getPreview() %></span>
							 <img class="single-pic" src="<%=request.getContextPath() %>/files/<%=friend.getPicture()%>" alt="">
							 <p><%=friend.getDetail() %></p>
						 </div>
						 <div class="comments">
							<h3>Bạn thân khác của tôi</h3>
							 
							<div id="items-involve">
							 
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="my_pagination pagination">
							<a href="javascript:;" title="">PAGE</a>
							<%
								int sumPage = (int) request.getAttribute("sumPage");
							%>
						 	<a id="backlistpage" href="javascript:;">&laquo;</a>
						 	<a id="previouspageinvovle" href="javascript:;">&lsaquo;</a>
						 	<form class="form_involve">
							<%
								for (int k = 1; k <= sumPage; k++) {
							%>
								<a id="idpage<%=k %>" onclick="involveFunction(<%=k %>, <%=friend.getFid() %>);" href="javascript:;"><%=k %></a>	
							<%
								}
							%>
							</form>
						 	<a id="nextpageinvovle" href="javascript:;">&rsaquo;</a>
							<a id="nextlistpage" href="javascript:;">&raquo;</a>
							</div>
					  </div>
					 
				 </div>			 			 
			 </div>
			 
			 <%@include file="/template/public/inc/menu-bar.jsp" %>
		 </div>
	 </div>
</div>

<%@include file="/template/public/inc/footer.jsp" %>