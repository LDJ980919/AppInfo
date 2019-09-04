<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gentellela Alela! |</title>

<!-- Bootstrap core CSS -->

<link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/static/fonts/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/static/css/animate.min.css"
	rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="<%=request.getContextPath()%>/static/css/custom.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/static/css/icheck/flat/green.css"
	rel="stylesheet">
<!-- editor -->
<link
	href="<%=request.getContextPath()%>/static/http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/static/css/editor/external/google-code-prettify/prettify.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/static/css/editor/index.css"
	rel="stylesheet">
<!-- select2 -->
<link
	href="<%=request.getContextPath()%>/static/css/select/select2.min.css"
	rel="stylesheet">
<!-- switchery -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/css/switchery/switchery.min.css" />

<script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>

<!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>APP基础信息</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-expanded="false"><i
								class="fa fa-wrench"></i></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Settings 1</a></li>
								<li><a href="#">Settings 2</a></li>
							</ul></li>
						<li><a class="close-link"><i class="fa fa-close"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
					<br />
					<form id="demo-form2" data-parsley-validate
						class="form-horizontal form-label-left">

						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="first-name">软件名称 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.softwareName}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">APK名称 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.APKName}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">支持ROM <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.supportROM}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">界面语言 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.interfaceLanguage}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">软件大小 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.softwareSize}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">下载次数 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.downloads}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">所属平台 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.appFlatform}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">所属分类 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.appCategoryName1}->${appInfo.appCategoryName2}->${appInfo.appCategoryName3}"
									readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">APP状态 <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input type="text" required="required"
									class="form-control col-md-7 col-xs-12"
									value="${appInfo.appStatus}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">应用简介 <span class="required">*</span>
							</label>
							<textarea class="col-md-6 col-sm-6 col-xs-12" readonly="readonly"> 
             				 ${appInfo.appInfo}</textarea>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12"
								for="last-name">LOGO图片 <span class="required">*</span>
							</label>
							<div>
								<c:if test="${appInfo.logoPicPath!=null}">
									<img alt="图片"
										src="<%=request.getContextPath() %>/static/uploadfiles/${appInfo.logoPicPath }"
										style="width: 150px; height: 200px;" id="image1">
								</c:if>
								<c:if test="${appInfo.logoPicPath==null}">
									<span>暂无图片</span>
								</c:if>
							</div>
						</div>
					</form>
				</div>
			</div>

			<div class="x_panel">
				<div class="x_title">
					<h2>历史版本列表</h2>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">

					<table class="table table-bordered">
						<thead>
							<tr>
								<th>软件名称</th>
								<th>版本号</th>
								<th>版本大小(单位:Mb)</th>
								<th>发布状态</th>
								<th>APK文件下载</th>
								<th>最新更新时间</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${appList }" var="app">
								<tr>
									<td>${app.softwareName }</td>
									<td>${app.versionNo }</td>
									<td>${app.versionSize }</td>
									<td>${app.status }</td>
									<td>${app.downloadLink }</td>
									<td>${app.modifyDate }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
  <button  class="btn btn-success"><a href="<%=request.getContextPath() %>/sys/devuser/index">返回</a></button>
</body>
</html>