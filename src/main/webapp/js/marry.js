//创建一个缺省的命名空间
var Marry = {};
//创建一个自命名空间
Marry.util = {};
//创建一个用于操作实际数据,有功能描述的的命名空间
Marry.util.build = {
	/**
	 * 获取项目的根目录的url
	 * @return {}
	 */
	basePath : function(){
		var curWwwPath = window.document.location.href;
		//console.info(curWwwPath);
		var pathName = window.document.location.pathname;
		//console.info(pathName);
		var pos = curWwwPath.indexOf(pathName);
		//console.info(pos);
		var localhostPath = curWwwPath.substring(0,pos);
		//console.info(localhostPath);
		var projectName = pathName.substring(0,pathName.substring(1).indexOf('/')+1);
		//console.info(localhostPath+projectName);
		return localhostPath+projectName;
	}
};
