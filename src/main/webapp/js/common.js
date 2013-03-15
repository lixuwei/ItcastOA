var MyConfirm = {
		showConfirm:function(){
			return window.confirm("您是否确定删除?");
		},
		initEvent:function(){
			$("a").each(function(){
				if($(this).text()=="删除"){
					$(this).unbind("click");
					$(this).bind("click",function(){
						return MyConfirm.showConfirm();
					});
				}
			});
		}
};
$().ready(function(){
	MyConfirm.initEvent();
});