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
                                <h3 class="title-w3-agile">Sửa danh sách bạn bè</h3>
                            </div>
                            <%
	                        	//String err = request.getParameter("err");
	                        	//if ("1".equals(err)){
	                        		//out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Danh mục bạn bè đã tồn tại.</div>");
                        		//}
	                        	
	                        	Category category = (Category) request.getAttribute("category");
	                        	
	                        	String name = request.getParameter("name");
	                        	if (name == null){
	                        	 	name = category.getFl_name();
	                        	}
                            %>
                            <div class="frame-content">
                            	<form id="form-add" class="my-form" method="post">
	                            	<label>Danh mục bạn bè: </label>
	                            	<input type="text" name="name" value="<%=name %>" class="my-input"/>
	                            	<br />
	                            	<input type="submit" name="sua" value="Sửa" class="btn btn-primary">
	                            	<input type="reset" name="reset" value="Nhập lại" class="btn btn-primary">
	                            </form>
	                            
	                            <script type="text/javascript">
									$(document).ready(function (){
										$("#form-add").validate({
											rules:{
												name:{
													required: true,
												},
											},
											messages:{
												name:{
													required: "Hãy nhập Tên danh mục",
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
