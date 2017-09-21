<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FAILURE</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<link href="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/skins/Aqua/css/ligerui-dialog.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
	function bodyload(){
		var message="${message}";
		if(message != ""){
			$.ligerDialog.alert(message);
		}
		window.setTimeout(function(){
			history.back();
			var tabid="${tabid}";
			if(tabid!="")
				window.parent.window.f_delTab(tabid);
		}, 2000);
	}
</script>
<body onload="bodyload();">
	<br />
	<h1 style="color: red;text-align: center;">操作失败！</h1>
</body>
</html>