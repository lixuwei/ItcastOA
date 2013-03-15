$().ready(function(){
	var btn = $("input[name='btn']");
	btn.unbind("click");
	btn.bind("click",function(){
		$.post("../charts/demo_reponseJSON.do",null,function(data){
			alert(data.name);
		});
	});
});