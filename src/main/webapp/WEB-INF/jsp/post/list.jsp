<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript">
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">岗位名称</td>
				<!-- <td width="150px">上级部门名称</td> -->
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
		<s:iterator value="#posts" id="post">
	        <tbody id="TableData" class="dataContainer">
				<tr class="TableDetail1 template">
					<td><s:property value="#post.pname"/>&nbsp;</td>
					<%-- <td><s:property value="#department.dname"/>&nbsp;</td> --%>
					<td><s:property value="#post.description" escape="false"/>&nbsp;</td>
					<td>
						<s:a action="post_deletePost.do?pid=%{pid}">删除</s:a>&nbsp;&nbsp;&nbsp;
						<s:a action="post_showUpdateUI.do?pid=%{pid}">修改</s:a>
					</td>
				</tr>
	        </tbody>
        </s:iterator>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="post_showAddUI.do">
            <img src="${pageContext.request.contextPath}/style/images/createNew.png" />
            </s:a>
        </div>
    </div>
</div>

</body>
</html>
