<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Veasion Website</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<link href="${pageContext.request.contextPath}/resources/css/mobile-style.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/veasion/MouseClick.js"></script>
<script type="application/x-javascript">
	addEventListener("load", function() { 
		setTimeout(hideURLbar, 0); 
	}, false);
	function hideURLbar(){ 
		window.scrollTo(0, 1);
	}
	function menuClick(event){
		 $("ul.nav1").slideToggle(200, function(){ });
		 event.stopPropagation();
	}
	function hideMenu(){
		$("ul.nav1").hide();
	}
	// 点赞
	function upvote(){
		$.ajax({
			url : "${pageContext.request.contextPath}/home/desktop/upvote",
			type : "post",
			success : function(data) {
				if(data){
					var obj=$("#upvoteCount");
					var count=parseInt(obj.text())+1;
					obj.text("+1");
					setTimeout(function(){
						obj.text(count);
					}, 200);
				}
			}
		});
	}
	// 鼠标右键菜单
	document.oncontextmenu = function(){
		// 显示右键菜单
		// 禁用右键
	    event.returnValue = false;
	}
</script>
</head>
<body>
<div class="banner">
	<div class="banner-text" onclick="hideMenu();" ontouchend="this.onclick();">
		<div class="menu">
			<span class="menu-icon" onclick="menuClick(event);" ontouchend="this.onclick(event);" title="菜单栏">
			<a href="javascript:void(0);"><img src="${pageContext.request.contextPath}/resources/images/mobile/menu-icon.png" alt=""/></a></span>	
			<ul class="nav1">
				<li><a href="/solo" ontouchend="location.href=this.href;">我的博客</a></li>
				<li><a href="https://github.com/veasion" ontouchend="location.href=this.href;">Github</a></li>
				<li><a href="${pageContext.request.contextPath}/home/desktop/index" ontouchend="location.href=this.href;">Home</a></li>
				<li><a href="${pageContext.request.contextPath}" ontouchend="location.href=this.href;">Website</a></li>
				<li><a href="mailto:luozhuowei.kong@qq.com" ontouchend="location.href=this.href;">联系我</a></li>
			</ul>
		</div>
		<div class="title">
			<div class="title-left">
				<img class="head-img" src="${pageContext.request.contextPath}/resources/images/veasion.png" alt=""/>
			</div>
			<div class="title-right">
				<h2>My Website</h2>
				<h6>${autograph }</h6>
			</div>
			<div class="clear"> </div>
		</div>
	</div>
</div>
<div class="clear"></div>
<div class="banner-bottom" onclick="hideMenu();" ontouchend="this.onclick();">
	<div class="banner-bottom-left">
		<h3>${accessCount }</h3>
		<p>Access number</p>
	</div>
	<div class="banner-bottom-right" title="点一个赞！" onclick="upvote();" ontouchend="this.onclick();">
		<h3 id="upvoteCount">${upvoteCount }</h3>
		<p>Upvote number</p>
	</div>
	<div class="clear"></div>
</div>
<div class="work-text" onclick="hideMenu();" ontouchend="this.onclick();">
	<h3>MODULE</h3>
	<section class="ac-container">
		<div>
			<c:forEach items="${desktop.desktopCloumns }" var="c">
				<div class="icon-div">
					<img src="${c.icon }" />
					<span onclick="location.href='${c.url }';" ontouchend="this.onclick();" title="${c.title }">${c.title }</span>
				</div>
			</c:forEach>
		</div>
		
		<%-- <div>
			<input id="ac-1" name="accordion-1" type="checkbox" />
			<label for="ac-1" class="grid1"><i></i>Finish landing page concept</label>
			<article class="ac-small">
				<p>Lorem Ipsum is simply dummy text of the printing and industry.</p>
			</article>
		</div>
		<div>
			<input id="ac-2" name="accordion-1" type="checkbox" />
			<label for="ac-2" class="grid2"><i></i>Design app illustrations</label>
			<article class="ac-small">
				<p>Lorem Ipsum is simply dummy text of the printing and industry.</p>
			</article>
		</div>
		<div>
			<input id="ac-3" name="accordion-1" type="checkbox" />
			<label for="ac-3" class="grid3"><i></i>Javascript training</label>
			<article class="ac-small">
				<p>Lorem Ipsum is simply dummy text of the printing and industry.</p>
			</article>
		</div>
		<div>
			<input id="ac-4" name="accordion-1" type="checkbox" />
			<label for="ac-4" class="grid4"><i></i>Surprise Party for Meet</label>
			<article class="ac-small">
				<p>Lorem Ipsum is simply dummy text of the printing and industry.</p>
			</article>
		</div> --%>
	</section>
</div>
</body>
</html>