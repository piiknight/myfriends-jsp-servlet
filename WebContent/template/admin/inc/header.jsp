<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="<%=request.getContextPath() %>/template/admin/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="<%=request.getContextPath() %>/template/admin/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Pii Knight</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">

    <!-- Bootstrap core CSS     -->
    <link href="<%=request.getContextPath() %>/template/admin/css/bootstrap.min.css" rel="stylesheet" />
    
    <link href="<%=request.getContextPath() %>/template/admin/css/style.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="<%=request.getContextPath() %>/template/admin/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="<%=request.getContextPath() %>/template/admin/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="<%=request.getContextPath() %>/template/admin/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="<%=request.getContextPath() %>/template/admin/css/themify-icons.css" rel="stylesheet">
    <script type="text/javascript" src="<%=request.getContextPath() %>/template/admin/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/template/admin/js/jquery.validate.min.js"></script>
	

</head>
<body>
<div class="wrapper">
	<header class="header">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="<%=request.getContextPath() %>/admin/index">ADMIN</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="ti-panel"></i>
								<p>Stats</p>
							</a>
						</li>
						<li class="dropdown">
							  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
									<i class="ti-bell"></i>
									<p class="notification">5</p>
									<p>Notifications</p>
									<b class="caret"></b>
							  </a>
							  <ul class="dropdown-menu">
								<li><a href="#">Notification 1</a></li>
								<li><a href="#">Notification 2</a></li>
								<li><a href="#">Notification 3</a></li>
								<li><a href="#">Notification 4</a></li>
								<li><a href="#">Another notification</a></li>
							  </ul>
						</li>
						<li>
							<a href="#">
								<i class="ti-settings"></i>
								<p>Settings</p>
							</a>
						</li>
					</ul>
	
				</div>
			</div>
		</nav>
	</header>