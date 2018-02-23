<%@page import="constant.Define"%>
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

		<script type="text/javascript">
	        var count = 0;
			var sumGroup = 0;
			var sum = 0;
			var countGroup = <%=Define.GROUP_PAGE_ADMIN %>;
	        $(document).ready(function(){
	        	var path = window.location.pathname;
	        	var split = path.split("/");
	        	var active = split[3];
	        	active = "#" + active;
	    		$(active).addClass("active");
	    		
	    		<%
		    	int page_id = 0;
	    		if (request.getAttribute("currentPage") != null){
	    			page_id = (Integer)request.getAttribute("currentPage");
	    		}
		    	%>
		    	var page_id = <%=page_id %>; 
		    	<%	
	    		int sum = 0;
	    		if (request.getAttribute("sumPage") != null){
	    			sum = (Integer)request.getAttribute("sumPage");
	    		}
		    	%>
		    	sum = <%=sum %>;
		    	sumGroup = parseInt((sum - 1) / countGroup) + 1;
		    	var groupPage =  (page_id - 1) / countGroup + 1;
		    	count = parseInt(groupPage);
		    	myFunction(count);
	    	});
	        function myFunction(x){
		    	var start = countGroup * (x - 1) + 1;
		    	var end = x * countGroup;
		    	for (var i = 1; i <= sum; i++){
		    		var str = "#idpage" + i;
		    		if (i >= start && i <= end){
		    			$(str).css("display", "");
		    		} else {
		    			$(str).css("display", "none");
		    		}
		    	}
		    	if (count == 1){
		    		$("#backlistpage").css("display", "none");
		    	} else {
		    		$("#backlistpage").css("display", "");
		    	}
		    	if (count == sumGroup){
		    		$("#nextlistpage").css("display", "none");
		    	} else {
		    		$("#nextlistpage").css("display", "");
		    	}
		    }
		    $("#nextlistpage").click( function(){
		    	count++;
		    	myFunction(count);
		    });
		    $("#backlistpage").click( function(){
		    	count--;
		    	myFunction(count);
		    });
        </script>
</html>