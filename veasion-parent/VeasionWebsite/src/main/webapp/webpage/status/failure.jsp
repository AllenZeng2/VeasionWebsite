<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FAILURE</title>
</head>
<script type="text/javascript">
	function bodyload(){
		window.setTimeout(function(){
			history.back();
			var tabid="${tabid}";
			if(tabid!="")
				window.parent.window.f_delTab(tabid);
		},2000);
	}
</script>
<body onload="bodyload();">
	<br />
	<h1 style="color: red;text-align: center;">操作失败！</h1>
</body>
</html>