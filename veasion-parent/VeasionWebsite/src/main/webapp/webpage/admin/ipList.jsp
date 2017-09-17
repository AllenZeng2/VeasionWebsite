<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IP管理</title>
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
<link href="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.9.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/core/base.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
<style>
a{text-decoration:none}
</style>
<script type="text/javascript">

	var grid = null;
	
	$(function() {
		loadData(null);
	});
	
	function loadData(parms){
		grid = $("#maingrid4").ligerGrid({
			url:"${pageContext.request.contextPath}/admin/ip/ipSearch",
			columns : [ {
				display : 'id',
				name : 'id',
				width : 35
			}, {
				display : 'ip',
				name : 'ip'
			}, {
				display : '地址',
				name : 'area'
			}, {
				display : '来访时间',
				name : 'date'
			}, {
				display : '当前人数',
				name : 'line',
				width : 60
			}, {
				display : '删除',
				name : 'del'
			} ],
			pageSize : 10,
			width : '100%',
			height : '100%',
			rowAttrRender: function (rowdata, rowid){
				var id=rowdata.id;
				var ip=rowdata.ip;
				var area=rowdata.area;
				var line=rowdata.line;
				var date=rowdata.date;
				rowdata.ip="<span title='"+ip+"'>"+ip+"</span>";
				rowdata.area="<span title='"+area+"'>"+area+"</span>";
				rowdata.date="<span title='"+date+"'>"+date+"</span>";
				rowdata.del="<a href=\"javascript:del('"+id+"','"+ip+"');\" style='color:red;'>删除</a>";
				return null;
			},
			parms : parms
		});
		$("#pageloading").hide();
	}
	
	function del(id, ip){
		if(confirm("确定要删除“"+ip+"”?")){
			$.ajax({
				url:"${pageContext.request.contextPath}/admin/ip/ipDelete?id="+id,
				type:"post",
				success:function(data){
					if(data!=null && data>0){
						$.ligerDialog.alert("删除成功！");
						window.setTimeout(function(){
							loadData(null);
						}, 800);
					}else{
						$.ligerDialog.alert("删除失败！");
					}
				},
				error:function(e){
					$.ligerDialog.alert('发送错误！');
				}
			});
		}
	}
	
	//查询
	function search() {
		loadData({"ip":$("#ip").val(), "area":$("#area").val()});
	}
	
</script>
</head>
<body style="padding: 6px; overflow: hidden;">
	<div id="searchbar">
		ip：<input id="ip" type="text" value=""/>&nbsp;&nbsp;
		来访地址：<input id="area" type="text" value=""/>
		<input id="btnOK" type="button" value="搜索" onclick="search();" />
	</div>
	<div id="maingrid4" style="margin: 0; padding: 0"></div>
	<div style="display: none;"></div>
</body>
</html>