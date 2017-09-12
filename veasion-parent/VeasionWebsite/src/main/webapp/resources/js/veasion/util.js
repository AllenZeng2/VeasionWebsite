﻿
//只能输入 onkeydown="return inputInt(event);"
function inputInt(event){
	var code=event.keyCode;
	if((code>=48 && code<=57) || (code>=96 && code<=105) || code==8){
		return true;
	}else{
		return false;
	}
}

//names的value是否有null或""
function hasNull(names,ale){
	for (var i = 0,l=names.length; i < l; i++) {
		var v=document.getElementsByName(names[i])[0].value;
		if(v==null||v.trim()==""){
			if(ale){
				alert("“"+names[i]+"”不能为空！");
			}
			return true;
		}
	}
	return false;
}

//自动填充
function fillForm(map){
	for(var key in map){  
	   var obj=document.getElementsByName(key);
	   if(obj!=null){
		   obj[0].value=map[key];
	   }
	}
}

// 获取当前时间yyyy-MM-dd HH:mm:ss
function getFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
