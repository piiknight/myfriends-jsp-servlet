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
                                <h3 class="title-w3-agile">Admin >> Danh mục bạn bè</h3>
                            </div>
                            
                            <div class="add-item">
                            	<a href="<%=request.getContextPath() %>/admin/cats/add" class="btn btn-info" role="button">
                            		<span>Thêm danh sách bạn bè</span>
                            		<i class="ti-plus"></i>
                            	</a>
                            </div>
                            <div class="clearfix"></div>
                            
                            <%
                            	String msg = request.getParameter("msg");
                            	String err = request.getParameter("err");
                            	String error = request.getParameter("error");
                            	if ("1".equals(msg)){
                            		out.print("<div class='alert alert-success'><strong>Thành công!</strong> 1 danh mục bạn bè đã được thêm.</div>");
                            	} else if ("2".equals(msg)){
                            		out.print("<div class='alert alert-success'><strong>Thành công!</strong> 1 danh mục bạn bè đã được sửa.</div>");
                            	} else if ("3".equals(msg)){
                            		out.print("<div class='alert alert-success'><strong>Thành công!</strong> 1 danh mục bạn bè đã được xóa.</div>");
                            	}
                            	if ("1".equals(err)){
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Thêm danh mục không được thực hiện.</div>");
                            	} else if ("2".equals(err)){
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Id không hợp lệ.</div>");
                            	} else if ("3".equals(err)){
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Sửa danh mục không được thực hiện.</div>");
                            	} else if ("4".equals(err)){
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Xóa danh mục không được thực hiện.</div>");
                            	}
                            	if ("1".equals(error)){
                            		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Không tìm thấy trang.</div>");
                            	}
                            	
                            %>
                            
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                        <th>ID</th>
                                    	<th>Tên danh mục</th>
                                    	<th>Chức năng</th>
                                    </thead>
                                    <tbody>
                                    
                                    	<%
                                    		ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
                                    		if (categories.size() > 0){
                                    			for(Category category:categories){
                                    	%>
                                        <tr>
                                        	<td><%=category.getFl_id() %></td>
                                        	<td><a href="<%=request.getContextPath() %>/admin/cats/edit?id=<%=category.getFl_id() %>" title=""><%=category.getFl_name() %></a></td>
                                        	<td>
												<a href="<%=request.getContextPath() %>/admin/cats/edit?id=<%=category.getFl_id() %>">
							                        <i class="ti-pencil"></i>
							                        <span>Sửa</span>
							                    </a>
							                    <a onclick="return confirm('Bạn có chắc muốn xóa ?')" href="<%=request.getContextPath() %>/admin/cats/del?id=<%=category.getFl_id() %>">
							                        <i class="ti-trash"></i>
							                        <span>Xóa</span>
							                    </a>
											</td>
                                        </tr>
                                        <%
                                    			}}
                                        %>
                                    </tbody>
                                </table>
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
							 		<a href="<%=request.getContextPath() %>/admin/cats?page=<%=currentPage - 1 %>">&lsaquo;</a>
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
										<a id="idpage<%=i %>" <%=active %> href="<%=request.getContextPath() %>/admin/cats?page=<%=i %>"><%=i %></a>
									<%
										}
									%>
									<%
							 			if (currentPage != sumPage) {
							 		%>
							 		<a href="<%=request.getContextPath() %>/admin/cats?page=<%=currentPage + 1 %>">&rsaquo;</a>
							 		<%
							 			}
							 		%>
									<a id="nextlistpage" href="javascript:;">&raquo;</a>
								</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="clearfix">...</div>
<%@include file="/template/admin/inc/footer.jsp" %>
