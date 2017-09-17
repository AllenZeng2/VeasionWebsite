<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8" />
<title>Veasion Website</title>
<style type="text/css">
body {
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}
.musicTitleClass{

}
#canvas, body div {width: 100%;}
img {width: 350px;}
.white {color: white;}
.black {color: black;}
.headDiv {float: left;width: 100%;}
#h1 {
	font-size: 2em;
	-webkit-margin-before: 0.67em;
	-webkit-margin-after: 0.67em;
	font-weight: bold;
}
.font {font-size: 16px;}
.headDiv div {
	float: left;
	z-index: 200;
	width: 100%;
	font-family: 微软雅黑;
}
a:link,a:visited,a:hover{color:#330099;}
#bgChange {
	width: 50px;
	height: 25px;
	line-height:25px;
	text-align: center;
	margin-left: auto;
	letter-spacing: 8px;
	padding-left: 12px;
	border-radius: 5px;
	/* border: 1px solid #666; */
	box-shadow: 0 1px 2px #B8DCF1 inset, 0 -1px 0 #316F96 inset;
	text-shadow: 1px 1px 0.5px #22629B;
	cursor: pointer;
}
/* 自适应设备 */
@media ( max-width :900px ) {
	img {width: 350px;}
	#h1 {
		font-size: 2em;
		-webkit-margin-before: 0.67em;
		-webkit-margin-after: 0.67em;
		font-weight: bold;
	}
	.font {font-size: 16px;}
	#bgChange {
		width: 50px;
		height: 25px;
		line-height:25px;
	}
}
@media ( max-width :600px ) {
	img {width: 280px;}
	#h1 {
		font-size: 1.6em;
		-webkit-margin-before: 0.83em;
		-webkit-margin-after: 0.83em;
		font-weight: bold;
	}
	.font {font-size: 14px;}
	#bgChange {
		width: 45px;
		height: 24px;
		line-height:24px;
	}
}
@media ( max-width :400px ) {
	img {width: 220px;}
	#h1 {
		font-size: 1.3em;
		-webkit-margin-before: 0.9em;
		-webkit-margin-after: 0.9em;
		font-weight: bold;
	}
	.font {font-size: 11px;}
	#bgChange {
		width: 40px;
		height: 20px;
		line-height:20px;
	}
}
</style>
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/veasion/MouseClick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/veasion/bgStyle1.js"></script>
<!--  白天，蒲花英 -->
<script type="text/JavaScript">
	var time=3200;
	var index=0;
	var urlList;
	$(function(){
		urlList=eval('${veasionUrls}');
		changeImage();
		var top=$("#h1").position().top;
		if(isNaN(top))
			top=45;
		else if(top>80)
			top=45;
		else
			top+=8;
		$("#canvas").css('top', top);
		
		var h=new Date().getHours();
		if(h>=6 && h<=18){
			baitian();
		}else{
			wanshang();
		}
	});
	
	function changeImage(){
		$("#ws").attr("src",urlList[index++]);
		if(index > urlList.length-1){
			index=0;
		}
		setTimeout("changeImage()", time);
	}
	
	function baitian(){
		$("body").css("background-color","pink");
		$("#huaMazz").show();
		$("#canvas").hide();
		$("#bgChange").text("晚上");
		$("#bgChange").attr("title","晚上");
		$(".white").each(function(i){
			$(this).attr("class","black");
		});
	}
	
	function wanshang(){
		$("body").css("background-color","black");
		$("#canvas").show();
		$("#huaMazz").hide();
		$("#bgChange").text("白天");
		$("#bgChange").attr("title","白天");
		$(".black").each(function(i){
			$(this).attr("class","white");
		});
	}
	
	function bgChange(){
		var bg=$("#bgChange").text();
		if(bg=='晚上'){
			wanshang();
		}else{
			baitian();
		}
	}
	
	// 0暂停，1播放，其他则切换
	function playPause(status){
		var audio=document.getElementById("bgsound");
		var musicTitle=document.getElementById("musicTitle");
		if(status==0 && !audio.paused){
			audio.pause();
			musicTitle.innerHTML="继续播放";
		}else if(status==1 && audio.paused){
			audio.play();
			musicTitle.innerHTML="暂停音乐";
		}else if(status!=0 && status!=1){
			if(audio.paused){
				// 继续播放
				audio.play();
				// 重新播放
				// audio.currentTime=0;
				musicTitle.innerHTML="暂停音乐";
			}else{
				// 暂停
				audio.pause();
				musicTitle.innerHTML="继续播放";
			}
		}
	}
	
	// 当前窗体关闭前暂停音乐
	$(function(){
		var icon_id="${param.icon_id}";
		if(icon_id != "" && window.top.window != null){
			var obj=window.top.window.getOpenObj(icon_id);
			var obj=window.top.$("#"+icon_id+" div[class='l-dialog-winbtn l-dialog-close']");
			obj.click(function(){
				playPause(0);
			});
		}else{
			$("body").onunload(function(){
				playPause(0);
			});
		}
	});
</script>
</head>
<body>
	<!-- 切换音乐 -->
	<span onclick="playPause(-1);" id="musicTitle" class="musicTitleClass black" style="font-size: 12px;margin-top: -5px;float: right;border: 1px solid #22629B;cursor: pointer;">暂停音乐</span>
	<div>
		<!-- 背景音乐 -->
		<audio id="bgsound" controls autoplay="autoplay" hidden="true">
			<c:forEach items="${bgsounds }" var="music">
				<source src="${music.url }" />
			</c:forEach>
		</audio>

		<!-- 白天，蒲花英 -->
		<div class="snow-container" id="huaMazz" style="position: fixed; top: 0; left: 0; width: 100%; height: 100%; pointer-events: none; z-index: 100;"></div><br>
		
		<div class="headDiv">
			
			<!-- 黑白切换 -->
			<div class="black" style="width: 50%; text-align: left;">
				&nbsp;&nbsp;
				<div id="bgChange" onclick="bgChange();" title="晚上" class="font">晚上</div>
			</div>

			<!-- 导航 -->
			<div style="width: 50%; text-align: right;">
				<a href="http://59.110.241.52/solo" title="Veasion的博客" class="font">
					我的博客 </a> &nbsp;&nbsp; <a href="https://github.com/veasion"
					title="My Github." class="font"> Github </a> &nbsp;&nbsp;
			</div>
		</div>

		<div style="text-align: center;">
			<br />
			<div id="h1" class="black">Welcome To My First Dedicated Website！</div>
			<div class="font">
				<a href="https://github.com/veasion" title="My Github."
					style="text-decoration: none" target="_blank"> ===Github=== </a> <br />
			</div>
			<br />

			<!-- 图片 -->
			<img id="ws" src="${pageContext.request.contextPath}/resources/images/loading.gif" ondragstart="return false;" alt="Veasion" title="Veasion"/>
		</div>

		<!-- 晚上，烟花 -->
		<canvas id="canvas" style="position: absolute; z-index: 100; display: none;"></canvas>
	</div>
</body>

<!-- 晚上，烟花 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/veasion/bgStyle2.js"></script>

</html>

<!--Veasion -->