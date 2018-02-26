<%@page import="constant.Define"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="copywrite">
	 <div class="container">
	 <p>Copyrights &copy; 2016 <a href="http://vinaenter.edu.vn">VinaEnter Edu</a>. All rights reserved</p>
</div>
</div>
<!-- 
<script type="text/javascript">
		$(document).ready(function() {
		$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
-->

<a href="javascript:;" class="back-to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<script>            
	$(document).ready(function() {
		var offset = 220;
		var duration = 500;
		$(window).scroll(function() {
			if ($(this).scrollTop() > offset) {
				$('.back-to-top').fadeIn(duration);
			} else {
				$('.back-to-top').fadeOut(duration);
			}
		});
		
		$('.back-to-top').click(function(event) {
			event.preventDefault();
			$('html, body').animate({scrollTop: 0}, duration);
			return false;
		})
	});
</script>
<script type="text/javascript">
	var count = 0;
	var sumGroup = 0;
	var sum = 0;
	var countGroup = <%=Define.GROUP_PAGE_PUBLIC %>;
	
	var id_friend = 0;
	var countInvolve = 1;
	$(document).ready(function(){
		$("#Cat<%=request.getAttribute("id") %>").addClass("active");
		
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
    	
    	<%
    	int id_friend = 0;
		if (request.getParameter("fid") != null){
			id_friend = Integer.parseInt(request.getParameter("fid"));
		}
    	%>
    	var id_friend = <%=id_friend %>;
    	if (id_friend != 0) {
    		involveFunction(1, id_friend);
    	}
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
    
    function involveFunction(x, y){
    	var str = "#idpage" + x;
    	$('.form_involve a').attr('class', '');
    	$(str).attr('class', 'active');
    	countInvolve = x;
    	id_friend = y;
		$.ajax({
			url: '<%=request.getContextPath() %>/detail',
			type: 'POST', 
			cache: false,
			data: {
				idpage : x,
				id : y,
			},
			success: function(data){
				$('#items-involve').html(data);
			},
			error: function (){
				// Xử lý nếu có lỗi
				alert('loi');
			}
		});
		if (countInvolve == 1){
    		$("#previouspageinvovle").css("display", "none");
    	} else {
    		$("#previouspageinvovle").css("display", "");
    	}
    	if (countInvolve == sum){
    		$("#nextpageinvovle").css("display", "none");
    	} else {
    		$("#nextpageinvovle").css("display", "");
    	}
    	var groupPageInvolve =  (x - 1) / countGroup + 1;
    	count = parseInt(groupPageInvolve);
    	myFunction(count);
    }
    
    $("#previouspageinvovle").click( function(){
    	countInvolve--;
    	involveFunction(countInvolve, id_friend);
    });
    $("#nextpageinvovle").click( function(){
    	countInvolve++;
    	involveFunction(countInvolve, id_friend);
    });
    
    $("#nextlistpage").click( function(){
    	count++;
    	myFunction(count);
    });
    $("#backlistpage").click( function(){
    	count--;
    	myFunction(count);
    });
</script>
</body>
</html>