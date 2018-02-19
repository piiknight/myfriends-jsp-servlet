<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidebar" data-background-color="white" data-active-color="danger">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="<%=request.getContextPath() %>/admin/index" class="simple-text">
                    Pii Knight
                </a>
            </div>

            <ul class="nav">
				<li id="index">
                    <a href="<%=request.getContextPath() %>/admin/index">
                        <i class="ti-home"></i>
                        <p>Home</p>
                    </a>
                </li>
                <li id="cats">
                    <a href="<%=request.getContextPath() %>/admin/cats">
                        <i class="ti-menu"></i>
                        <p>Friend List</p>
                    </a>
                </li>
                <li id="friends">
                    <a href="<%=request.getContextPath() %>/admin/friends">
                        <i class="ti-face-smile"></i>
                        <p>Friends</p>
                    </a>
                </li>
                <li id="users">
                    <a href="<%=request.getContextPath() %>/admin/users">
                        <i class="ti-user"></i>
                        <p>Users</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>