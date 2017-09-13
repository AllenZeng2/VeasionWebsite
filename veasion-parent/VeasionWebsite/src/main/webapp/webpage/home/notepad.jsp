<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body{width: 100%;height: 100%;}
.notepadEdit{
	min-height:480px;width:100%;border:0px solid black;
	font-family: 华文楷体;
	background-image: url('${pageContext.request.contextPath}/resources/images/notepadBgimg.png');
}
</style>
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<title>记事本</title>
<script type="text/javascript">
	
	var v="Veasion=";
	var code;
	function txtChange(e, obj){
		var k=e.keyCode;
		var c=e.charCode;
		var value=obj.value;
		if(value.length>=v.length && v==value.substring(0, v.length)){
			if(k==13){
				validation(code);
				code="";
				obj.value="";
				return false;
			}else{
				if(!!code){
					code+=","+c;
				}else{
					code=c;
				}
				obj.value=value+"*";
				return false;
			}
		}else{
			return true;
		}
	}
	
	function delCode(){
		if(!!code){
			var lastIndex=code.lastIndexOf(",");
			if(lastIndex==-1) code="";
			else code=code.substring(0, lastIndex);
		}
	}
	
	function validation(value){
		$.ajax({
			url:"${pageContext.request.contextPath}/desktop/adminValidation",
			data:{"value":value},
			type:"post",
			success:function(data){
				console.log(data);
				if(data){
					var icon_id='${param.icon_id}';
					var obj=window.top.window.getOpenObj(icon_id);
					var win=window.top.window.f_open("admin", "${pageContext.request.contextPath}/webpage/admin/index.jsp", "后台管理", "${pageContext.request.contextPath}/resources/images/icon_tool.png", 1100, 550, true);
					win.show();
					obj.close();
				}
			},
			error:function(e){
				alert('发送错误！');
			}
		});
	}
</script>
</head>
<body>
<textarea class="notepadEdit" onkeypress="return txtChange(event, this);" onkeydown="if(event.keyCode==8)delCode();"></textarea>
</body>
</html>