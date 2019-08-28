<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/test">
		<input type="text" name="softwareName"/>
		<input type="text" name="appStatus"/>
		<input type="submit" value="测试">
	</form>
	<div>
		<table>
			<thead>
				<tr>
					<th>软件名称</th>
					<th>APK名称</th>
					<th>软件大小</th>
					<th>状态</th>
					<th>平台</th>
					<th>一级</th>
					<th>二级</th>
					<th>三级</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${appList}" var="app">
					<tr>
						<td>${app.softwareName}</td>
						<td>${app.APKName}</td>
						<td>${app.appStatus}</td>
						<td>${app.appFlatform}</td>
						<td>${app.appCategoryName1}</td>
						<td>${app.appCategoryName2}</td>
						<td>${app.appCategoryName3}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>