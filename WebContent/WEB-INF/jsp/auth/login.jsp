<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/admin/inc/header.jsp" %>
	
<%@include file="/template/admin/inc/left-bar.jsp" %>

    <div class="main-panel">

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h3 class="title-w3-agile">Đăng nhập</h3>
                            </div>
                            <%
	                        	String err = request.getParameter("err");
	                        	if ("1".equals(err)){
	                        		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Không thể đăng nhập, vui lòng thử lại sau.</div>");
                        		}
	                        	String username = request.getParameter("username");
	                        	if (username == null){
	                        		username = "";
	                        	}
                            %>
                            <div class="frame-content">
                            	<form id="form-add" class="my-form" method="post">
	                            	<label>Tài khoản: </label>
	                            	<input type="text" name="username" value="<%=username %>" class="my-input"/>
	                            	<label>Mật khẩu: </label>
	                            	<input type="password" name="password" value="" class="my-input"/>
	                            	<br />
	                            	<input type="submit" name="login" value="Đăng nhập" class="btn btn-primary">
	                            	<input type="reset" name="reset" value="Nhập lại" class="btn btn-primary">
	                            </form>
	                            
	                            <script type="text/javascript">
									$(document).ready(function (){
										$("#form-add").validate({
											rules:{
												username:{
													required: true,
												},
												password:{
													required: true,
												},
											},
											messages:{
												username:{
													required: "Hãy nhập Tài khoản",
												},
												password:{
													required: "Hãy nhập Mật khẩu",
												},
											}
											
										});			
									});
								</script>
								
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="clearfix">...</div>
<%@include file="/template/admin/inc/footer.jsp" %>
