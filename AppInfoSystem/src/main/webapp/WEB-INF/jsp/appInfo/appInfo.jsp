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
	<div class="right_col" role="main">
		<div class="">
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>
								APP信息管理维护 <small>某某某用户，你可以通过此页面来维护和修改您的app信息</small>
							</h2>
							<ul class="nav navbar-right panel_toolbox">
								<li><a class="collapse-link"><i
										class="fa fa-chevron-up"></i></a></li>
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
							<form class="form-horizontal form-label-left input_mask"
								action="javascript:;">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" class="form-control" id="inputSuccess1"
											placeholder="根据所输入的字符查询">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appStatus"  class="form-control">
											<c:if test="${statusList != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${statusList }" var="statu">
													<option <c:if test="${statu.id == appStatus}">selected="selected"</c:if> value="${statu.id}">${statu.valueName}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appFlatform"  class="form-control">
											<c:if test="${flatFormList != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${flatFormList }" var="flat">
													<option <c:if test="${flat.id == appFlatform }">selected="selected"</c:if> value="${flat.id}">${flat.valueName}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appCategoryName1"  class="form-control">
											<c:if test="${categoryLevel1List != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${categoryLevel1List }" var="cate">
													<option <c:if test="${cate.id == appCategoryName1 }">selected="selected"</c:if> value="${cate.id}">${cate.categoryName}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appCategoryName2"  class="form-control">
											<c:if test="${categoryLevel2List != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${categoryLevel2List }" var="cate">
													<option <c:if test="${cate.id == appCategoryName2 }">selected="selected"</c:if> value="${cate.id}">${cate.categoryName}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appCategoryName3"  class="form-control">
											<c:if test="${categoryLevel3List != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${categoryLevel3List }" var="cate">
													<option <c:if test="${cate.id == appCategoryName3 }">selected="selected"</c:if> value="${cate.id}">${cate.categoryName}</option>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="ln_solid"></div>
								<div class="form-group">
									<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
										<button type="submit" class="btn btn-success">查询</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_content">

								<button type="submit" class="btn btn-success">新增APP基础信息</button>

								<table
									class="table table-striped responsive-utilities jambo_table bulk_action">
									<thead>
										<tr class="headings">
											<th class="column-title">软件名称</th>
											<th class="column-title">APK名称</th>
											<th class="column-title">软件大小(单位:M)</th>
											<th class="column-title">所属平台</th>
											<th class="column-title">所属分类(一级分类、二级分类、三级分类)</th>
											<th class="column-title">状态</th>
											<th class="column-title">下载次数</th>
											<th class="column-title">最新版本号</th>
											<th class="column-title no-link last"><span class="nobr">操作</span>
											</th>
											<th class="bulk-actions" colspan="7"><a class="antoo"
												style="color: #fff; font-weight: 500;">Bulk Actions ( <span
													class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
											</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${appList}" var="app">
											<tr class="even pointer">
												<td class=" ">${app.softwareName}</td>
												<td class=" ">${app.APKName}</td>
												<td class=" ">${app.softwareSize}</td>
												<td class=" ">${app.appFlatform}</td>
												<td class=" ">${app.appCategoryName1}->${app.appCategoryName2}->${app.appCategoryName3}</td>
												<td class=" ">${app.appStatus}</td>
												<td class=" ">${app.downloads}</td>
												<td class=" ">${app.versionId}</td>
												<td class=" "><button type="submit"
														class="btn btn-success">点击操作</button></td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- footer content -->
			<footer>
			<div class="">
				<p class="pull-right">
					Gentelella Alela! a Bootstrap 3 template by <a>Kimlabs</a>. | <span
						class="lead"> <i class="fa fa-paw"></i> Gentelella Alela!
					</span>
				</p>
			</div>
			<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->

		</div>
		<script type="text/javascript">
			$("form").submit(function(){
				var softwareName=$("#inputSuccess1").val();
				var appStatus=$("#appStatus").val();
				var appFlatform=$("#appFlatform").val();
				var appCategoryName1=$("#appCategoryName1").val();
				var appCategoryName2=$("#appCategoryName2").val();
				var appCategoryName3=$("#appCategoryName3").val();
				$("body").load("<%=request.getContextPath()%>/appInfo",
					"softwareName=" + softwareName,"appStatus=" + appStatus,
					"appFlatform=" + appFlatform,"appCategoryName1=" + appCategoryName1,
					"appCategoryName2=" + appCategoryName2,"appCategoryName3=" + appCategoryName3);
			});
		</script>
</body>
</html>