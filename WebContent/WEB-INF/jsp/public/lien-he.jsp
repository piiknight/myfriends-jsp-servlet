<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/public/inc/header.jsp" %>
<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			 <%
			 	if (request.getParameter("success") != null){
			 	if (Integer.parseInt(request.getParameter("success")) == 1){
			 %>
			 <p>Bạn đã nhập thành công!</p>
			 <%
			 	} else {
			 %>
			 <p>Nhập vào thất bại!</p>
			 <%
			 	}}
			 %>
			  <form id="form" action="<%=request.getContextPath() %>/contact" method="post">
				  <div class="col-md-6 contact-left">
						<input type="text" name="name" placeholder="Name" >
						<input type="text" name="email" placeholder="E-mail" >
						<input type="text" name="phone" placeholder="Phone" >
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea name="message" placeholder="Message"></textarea>
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