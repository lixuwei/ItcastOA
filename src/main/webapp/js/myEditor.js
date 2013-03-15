/**
 * 创建一个可以替换TextArea的文本编辑器
 * @type 
 */
var editor={
	createEditor:function(name){
		var oFCKeditor = new FCKeditor(name);
		oFCKeditor.BasePath = Marry.util.build.basePath()+'/fckeditor/';
		oFCKeditor.ToolbarSet = 'simple';
		oFCKeditor.ReplaceTextarea();
	}
};
$(function(){
	var name = $("textarea").attr("name");
	editor.createEditor(name);
});