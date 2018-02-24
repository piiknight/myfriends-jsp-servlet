<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>

                        <li>
                            <a href="#">
                                Pii Knight
                            </a>
                        </li>
                        <li>
                            <a href="#">
                               Blog
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Licenses
                            </a>
                        </li>
                    </ul>
                </nav>
				<div class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script><i class="fa fa-heart heart"></i>
                </div>
            </div>
        </footer>
        <script type="text/javascript">
	        $(document).ready(function(){
	        	var path = window.location.pathname;
	        	var split = path.split("/");
	        	var active = split[3];
	        	active = "#" + active;
	    		$(active).addClass("active");
	    	});
        </script>
</div>


</body>

    <!--   Core JS Files   -->

	<script src="<%=request.getContextPath() %>/template/admin/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="<%=request.getContextPath() %>/template/admin/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="<%=request.getContextPath() %>/template/admin/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="<%=request.getContextPath() %>/template/admin/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="<%=request.getContextPath() %>/template/admin/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="<%=request.getContextPath() %>/template/admin/js/demo.js"></script>


</html>