/**
 * 为保存添加一个验证的事件
 */
var user = {
	submit:function(){
		$("form:first").submit();
	},
	initEvent:function(){
		$("input[type='image']").unbind("click");
		$("input[type='image']").bind("click",function(){
			if($("select[name='did']").val() == "0"){
				alert("请选择部门");
				return false;
			}else{
				user.submit();
			}
		});
	}
};
 
$().ready(function(){
	user.initEvent();
});