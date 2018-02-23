<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/admin/inc/header.jsp" %>
	
<%@include file="/template/admin/inc/left-bar.jsp" %>

    <div class="main-panel">

        <div class="content">
            <div class="container-fluid">
            	<div class="header">
                    <h3 class="title-w3-agile">WELCOME To My Home</h3>
                </div>
                <div class="row">
                    <div class="card-add">
                        <a href="<%=request.getContextPath() %>/admin/cats/add" class="dashboard-module">
                        	<img src="<%=request.getContextPath() %>/template/admin/img/addFriendsList.png" alt="" />
							<p>Thêm Danh mục</p>
						</a>
                    </div>
                    <div class="card-add">
                        <a href="<%=request.getContextPath() %>/admin/friends/add" class="dashboard-module">
                        	<img src="<%=request.getContextPath() %>/template/admin/img/addFriends.png" alt="" />
							<p>Thêm Bạn bè</p>
						</a>
                    </div>
                    <div class="introduce">
                    	<div class="introduce-title">
                    		<p>Quản lý hệ thống</p>
                    	</div>
                    	<div class="introduce-content">
                    		<p><strong>Project:</strong> Myfriends</p>
                    		<p><strong>Người thực hiện:</strong> Trịnh Mai Thanh Điền</p>
                    		<p><strong>Email:</strong> tmtdien266@gmail.com</p>
                    		<p><strong>Phone:</strong> 0126.266.7176</p>
                    	</div>
                    </div>
                        <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="clearfix">...</div>
<%@include file="/template/admin/inc/footer.jsp" %>
