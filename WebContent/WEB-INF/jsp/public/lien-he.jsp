<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/public/inc/header.jsp" %>
<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			  <%
                 	String msg = request.getParameter("msg");
                 	if ("1".equals(msg)){
                 		out.print("<div class='alert alert-danger'><strong>Thất bại!</strong> Gởi đi thất bại.</div>");
                 	} else if ("2".equals(msg)){
                 		out.print("<div class='alert alert-success'><strong>Thành công!</strong> Gởi đi hoàn tất.</div>");
                 	}
                 	String name = request.getParameter("name");
                 	if (request.getParameter("name") == null) {
                 		name = "";
                 	}
                 	String email = request.getParameter("email");
                 	if (request.getParameter("email") == null) {
                 		email = "";
                 	}
                 	String phone = request.getParameter("phone");
                 	if (request.getParameter("phone") == null) {
                 		phone = "";
                 	}
                 	String message = request.getParameter("message");
                 	if (request.getParameter("message") == null) {
                 		message = "";
                 	}
                 %>
			  <form id="form" action="" method="post">
				  <div class="col-md-6 contact-left">
						<input type="text" name="name" value="<%=name %>" placeholder="Name" >
						<input type="text" name="email" value="<%=email %>" placeholder="E-mail" >
						<input type="text" name="phone" value="<%=phone %>" placeholder="Phone" >
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea name="message" placeholder="Message"><%=message %></textarea>
						 <input type="submit" value="SEND">
				 </div>
				 <div class="clearfix"></div>
			 </form>
		 </div>
	 </div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#home").removeClass("active");
		$("#contact").addClass("active");
	});
	
	$(document).ready(function (){
		$("#form").validate({
			rules:{
				name:{
					required: true,
				},
				email:{
					required: true,
					email: true,
				},
				phone:{
					required: true,
					number: true,
					minlength: 9,
					maxlength: 13,
				},
			},
			messages:{
				name:{
					required: "Hãy nhập thông tin Name",
				},
				email:{
					required: "Hãy nhập thông tin Email",
					email: "Định dạng email không đúng",
				},
				phone:{
					required: "Hãy nhập thông tin Phone",
					number: "Chỉ được nhập số",
					minlength: "Số lượng trong khoảng tư 9 - 13 kí tự",
					maxlength: "Số lượng trong khoảng tư 9 - 13 kí tự",
				},
			}
			
		});			
	});
</script>
<%@include file="/template/public/inc/footer.jsp" %>