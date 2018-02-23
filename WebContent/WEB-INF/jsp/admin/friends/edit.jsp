<%@page import="model.bean.Friend"%>
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
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Sửa bạn bè bị lỗi</div>");
                            	} else if ("2".equals(err)){
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Hãy nhập file ảnh!</div>");
                            	}
                            	Friend friend = (Friend) request.getAttribute("friend");
                            %>
                            <div class="frame-content">
                            	<form id="form-add" class="my-form" action="" method="post" enctype="multipart/form-data">
	                            	<label>Name: </label>
	                            	<input type="text" name="name" value="<%=friend.getFname() %>" class="my-input" />
	                            	<label>Danh mục tin</label>
	                            	<%
	                            		ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
	                            	%>
									<select name="category" class="input-short">
										<% 
											for (Category category : categories) {
										%>
										<option value="<%=category.getFl_id() %>" <%if (category.getFl_id() == friend.getCategory().getFl_id()) out.print("selected"); %>><%=category.getFl_name() %></option>
										<%
											}
										%>
									</select>
									
	                            	<label>Picture: </label>
	                            	<input type="file" name="picture" value="" class="btn btn-primary">
	                            	<br />
	                            	<label>Preview: </label>
	                            	<textarea name="preview" rows="7" cols="90" class="my-input"><%=friend.getPreview() %></textarea>
	                            	<label>Detail: </label>
	                            	<textarea  name="detail" rows="7" cols="90" class="my-input" id="editor"><%=friend.getDetail() %></textarea>
	                            	<br />
	                            	<input type="submit" name="them" value="Thêm" class="btn btn-primary">
	                            	<input type="reset" name="reset" value="Nhập lại" class="btn btn-primary">
	                            </form>
	                            
	                            <script type="text/javascript">
		                            var editor = CKEDITOR.replace('editor');
		            				CKFinder.setupCKEditor(editor, '<%=request.getContextPath() %>/template/admin/js/ckfinder');
									$(document).ready(function (){
										$("#form-add").validate({
											rules:{
												name:{
													required: true,
												},
												preview:{
													required: true,
												},
												detail:{
													required: true,
												},
											},
											messages:{
												name:{
													required: "Username không được để trống",
												},
												preview:{
													required: "Preview không được để trống",
												},
												detail:{
													required: "Detail không được để trống",
												},
											},
											ignore: []
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
