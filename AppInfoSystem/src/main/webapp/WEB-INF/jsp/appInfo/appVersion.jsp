<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->

    <link href="<%=request.getContextPath() %>/static/css/bootstrap.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath() %>/static/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="<%=request.getContextPath() %>/static/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/icheck/flat/green.css" rel="stylesheet">


    <script src="<%=request.getContextPath() %>/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js"></script>
</head>
<body>
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

                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>新增版本信息</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <form id="demo-form2" class="form-horizontal form-label-left" action="javascript:;" method="post" enctype="multipart/form-data">
											<input type="hidden" name="appId" value="${appId }"/>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">版本号 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input placeholder="请输入版本号" type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12" name="versionNo">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">版本大小 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input placeholder="请输入版本大小,单位为Mb" type="text" id="last-name" name="versionSize" required="required" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">发布状态 <span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <span class="required">预发布</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">版本简介<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input placeholder="请输入本版本的相关信息,本信息做为该版本的详细信息进行版本介绍" id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="versionInfo">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">APK文件<span class="required">*</span></label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="middle-name" class="form-control col-md-7 col-xs-12" type="file" name="attachs">
                                            </div>
                                        </div>
                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                <button type="submit" class="btn btn-primary">保存</button>
                                                   <button  class="btn btn-success"> <a href="<%=request.getContextPath() %>/sys/devuser/index">返回</a></button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
          <script type="text/javascript">
          	$("form").submit(function(){
          		var data = $(this).serialize();
          		var data = new FormData(document.getElementById("demo-form2"));
          		$.ajax({
          			url:"<%=request.getContextPath() %>/sys/appVersion/addAppVersionSave",
          			data:data,
          			type:"post",
          			dataType:"text",
          			processData:false,
    				contentType:false,
          			success:function(data){
          				
          				if(data == "1"){
          					alert("添加成功!");
          					$("#main1").load("<%=request.getContextPath() %>/sys/devuser/appInfo");
          				}else{
          					alert("添加失败");
          				}
          			}
          		});
          	});
          </script>
</body>
</html>