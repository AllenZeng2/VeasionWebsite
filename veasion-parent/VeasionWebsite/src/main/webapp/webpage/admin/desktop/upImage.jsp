<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<link href="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/skins/Aqua/css/ligerui-dialog.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<style type="text/css">
.image_2{width: 420px;}
.image_3{width: 36px;height: 36px;}
</style>
<script type="text/javascript">
	
	var type="${param.type}";
	
	function check(){
		var img = $("#img").val();
    	var pattern = /\.*.(jpg|png|gif|JPG|PNG|GIF)$/;
    	if(img=="" || !pattern.test(img)){
    		$.ligerDialog.alert("图片不能为空或格式错误！（只能上传jpg/png/gif格式）");
    		return false;
    	}
    	$("#loading").show();
    	return true;
	}
	
	function imgChange(obj){
		var file=obj.files[0];
		var img = new Image();
		var url=URL.createObjectURL(file);
		img.src=url;
		img.onload = function(){
			var width=img.width,height=img.height;
			//1900 1200
			if(type==2 && (width<1900||height<1200)){
				$("#message").text("背景图片("+width+"*"+height+")不是最合适的！建议1920*1200");
			}else if(type==3 && (width<36||height<36)){
				$("#message").text("图标("+width+"*"+height+")不是最合适的！建议36*36");
			}else{
				$("#message").text("");
			}
		}
		$("#imgurl").prop("src", url);
		$("#imgurl").prop("class", "image_"+type);
		var path=$("#img").val();
		var index1=path.lastIndexOf("\\");
		if(index1==-1){
			index1=path.lastIndexOf("/");
		}
		var index2=path.lastIndexOf(".");
		if(index2==-1 || index2<index1){
			index2=path.length;
		}
		path=path.substring(index1+1, index2);
		$("#name").val(path);
	}
</script>
</head>
<body>
<br/><br/>
	<c:if test="${param.type=='2'}">
		上传背景：
	</c:if>
	<c:if test="${param.type=='3'}">
		上传图标：
	</c:if>
	<br/>
	 <div id="div" style="border:2px solid pink;display: inline-block;margin-top: 5px;margin-bottom: 5px;padding: 2px;">
    	<img alt="预览" src="" id="imgurl"/>
    </div>
    <br/>
    <span style="color:red;" id="message"></span>
	<br/>
	<img alt="正在上传..." src="${pageContext.request.contextPath}/resources/images/loading.gif" style="display: none;" id="loading"/>
	<br/>
	<c:if test="${param.type!=null}">
		<form action="${pageContext.request.contextPath}/admin/desktop/upFile/upImageFile?type=${param.type }" method="post" enctype="multipart/form-data" onsubmit="return check();">
	        <input id="img" name="file" type="file" onchange="imgChange(this);"/><br/>
	                        文件命名：
	        <input id="name" name="name" type="text" value="" title="默认文件名"/><br/>
	        <input type="submit" value="开始上传" />
	    </form>
    </c:if>
    <br/>
</body>
</html>