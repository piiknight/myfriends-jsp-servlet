<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>

	<title>TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER</title>
	<link href="<%=request.getContextPath() %>/template/public/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="<%=request.getContextPath() %>/template/public/css/style.css" rel='stylesheet' type='text/css' />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="vinaneter, php, java, android, ios, laravel, codeigniter" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!----webfonts---->
		<link href='http://fonts.googleapis.com/css?family=Oswald:100,400,300,700' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,300italic,400italic,600italic' rel='stylesheet' type='text/css'>
		<!----//webfonts---->
		  <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<!--end slider -->
		<!--script-->
<script type="text/javascript" src="<%=request.getContextPath() %>/template/public/js/move-top.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/template/public/js/easing.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/template/public/js/jquery.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/template/public/js/jquery.validate.min.js" ></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>
<!---->

</head>
<body>
<!---strat-banner---->
<div class="banner">				
	 <div class="header">  
		  <div class="container">
			  <div class="logo">
					<a href="<%=request.getContextPath() %>/nhung-nguoi-ban.html"> <img src="<%=request.getContextPath() %>/template/public/images/logo.png" title="soup" /></a>
			 </div>
			 <!---start-top-nav---->
			 <div class="top-menu">
				  <span class="menu"> </span> 
				   <ul>
						<li class="active"><a href="<%=request.getContextPath() %>/nhung-nguoi-ban.html">Trang chủ</a></li>						
						<div class="clearfix"> </div>
				 </ul>
			 </div>
			 <div class="clearfix"></div>
					<script>
					$("span.menu").click(function(){
					$(".top-menu ul").slideToggle("slow" , function(){
					});
					});
					</script>
				<!---//End-top-nav---->					
		 </div>
	 </div>
	 <div class="container">
		 <div class="banner-head">
			 <h1>NHỮNG NGƯỜI BẠN THÂN CỦA TÔI</h1>
		 </div>
		 <div class="banner-links">
			 <ul>
				 <li id="home" class="active"><a href="<%=request.getContextPath() %>/nhung-nguoi-ban.html">Những người bạn</a></li>
				 <li id="contact"><a href="<%=request.getContextPath() %>/lien-he.html">Liên hệ</a></li>
				 <div class="clearfix"></div>
			 </ul>
		 </div>
	 </div>
</div>
<!---//End-banner---->