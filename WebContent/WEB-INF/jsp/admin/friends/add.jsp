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
                                <h3 class="title-w3-agile">Thêm mới bạn bè</h3>
                            </div>
                            <%
                            	String err = request.getParameter("err");
                            	if ("1".equals(err)){
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Username đã tồn tại, hãy nhập username khác.</div>");
                            	}
                            	String name = request.getParameter("username");
                            	String preview = request.getParameter("fullname");
                            	String detail = request.getParameter("detail");
                            	if (name == null){
                            		name = "";
                            	}
                            	if (preview == null){
                            		preview = "";
                            	}
                            	if (detail == null){
                            		detail = "";
                            	}
                            %>
                            <div class="frame-content">
                            	<form id="form-add" class="my-form" method="post">
	                            	<label>Name: </label>
	                            	<input type="text" name="name" value="<%=name %>" class="my-input"/>
	                            	<label>Picture: </label>
	                            	<input type="file" name="picture" value="" class="btn btn-primary">
	                            	<br />
	                            	<label>Preview: </label>
	                            	<input type="text" name="preview" value="<%=preview %>" class="my-input"/>
	                            	<label>Detail: </label>
	                            	<input type="text" name="detail" value="<%=detail %>" class="my-input"/>
	                            	<input type="submit" name="them" value="Thêm" class="btn btn-primary">
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
												fullname:{
													required: true,
												},
											},
											messages:{
												username:{
													required: "Username không được để trống",
												},
												password:{
													required: "Password không được để trống",
												},
												fullname:{
													required: "Fullname không được để trống",
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
