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

<title>app开发者主页! |</title>

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
        <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js"></script>
        <style type="text/css">
        .ul1{
        list-style: none;
        }
        #btn1{
            float: left;
            margin-right: 50px;
            position: relative;
            
        }
        .ul1{
            position: absolute;
           
            display: none;
            width:120px;
            height:140px;
            background-color:#26b99a;
            z-index:10;
            font-size:16px;
           
        }
        .ul1 li{
       
        }
        </style>
</head>
<body>
	
			<div class="row">
				<div class="col-md-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>
								APP信息管理维护 <small>${user.devName}用户，你可以通过此页面来维护和修改您的app信息</small>
							</h2><div class="clearfix"></div>
						</div>
						<div class="x_content">
							<br />
							<form class="form-horizontal form-label-left input_mask"
								action="javascript:;" id="form11">
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<c:if test="${appInfo.softwareName!='' }">
										<input type="text" class="form-control" id="inputSuccess1"
											placeholder="根据所输入的字符查询" name="softwareName" value="${appInfo.softwareName}"  />
										</c:if>
										<c:if test="${appInfo.softwareName=='' }">
										<input type="text" class="form-control" id="inputSuccess1"
											placeholder="根据所输入的字符查询" name="softwareName"   />
										</c:if>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appStatus"  class="form-control" name="status">
											<c:if test="${statusList != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${statusList }" var="statu">
													<c:if test="${statu.id==appInfo.status}">
													<option  value="${statu.id}" selected="selected">${statu.valueName}</option>
													</c:if>
													<c:if test="${statu.id!=appInfo.status}">
													<option  value="${statu.id}" >${statu.valueName}</option>
													</c:if>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appFlatform"  class="form-control" name="flatformId">
											<c:if test="${flatFormList != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${flatFormList }" var="flat">
													<c:if test="${flat.id==appInfo.flatformId}">
													<option  value="${flat.id}" selected="selected">${flat.valueName}</option>
													</c:if>
													<c:if test="${flat.id!=appInfo.flatformId}">
													<option  value="${flat.id}" >${flat.valueName}</option>
													</c:if>
												</c:forEach>
												
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appCategoryName1"  class="form-control" name="categoryLevel1" onchange="add1(this.value);">
											<c:if test="${categoryLevel1List != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${categoryLevel1List }" var="cate">
													<c:if test="${cate.id==appInfo.categoryLevel1}">
													<option  value="${cate.id}" selected="selected">${cate.categoryName}</option>
													</c:if>
													<c:if test="${cate.id!=appInfo.categoryLevel1}">
													<option  value="${cate.id}">${cate.categoryName}</option>
													</c:if>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appCategoryName2"  class="form-control" name="categoryLevel2" onchange="add2(this.value);">
											<c:if test="${categoryLevel2List != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${categoryLevel2List }" var="cate">
												<c:if test="${cate.id==appInfo.categoryLevel2}">
													<option  value="${cate.id}" selected="selected">${cate.categoryName}</option>
													</c:if>
													<c:if test="${cate.id!=appInfo.categoryLevel2}">
													<option  value="${cate.id}">${cate.categoryName}</option>
													</c:if>
													
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
										<select id="appCategoryName3"  class="form-control" name="categoryLevel3">
											<c:if test="${categoryLevel3List != null}">
												<option value="">--请选择--</option>
												<c:forEach items="${categoryLevel3List }" var="cate">
												<c:if test="${cate.id==appInfo.categoryLevel3}">
													<option  value="${cate.id}" selected="selected">${cate.categoryName}</option>
													</c:if>
													<c:if test="${cate.id!=appInfo.categoryLevel3}">
													<option  value="${cate.id}">${cate.categoryName}</option>
													</c:if>
												</c:forEach>
											</c:if>
										</select>
									</div>
								</div>
								<div class="ln_solid"></div>
								<div class="form-group">
									<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
									<input type="submit" class="btn btn-success" value="查询"/>
										
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="x_panel">
							<div class="x_content">

								<a href="javascript:add();"  class="btn btn-success">新增APP基础信息</a>

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

									<tbody id="tbody1">
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
												<td class=" "><div  id="btn1"><button >操作 <span class="fa fa-chevron-down"></span></button>
                                   								 <ul  class="ul1">
	                                      						  	<li><a href="javascript:;" style="color:#fff;">下架</a>
	                                      							 </li>
	                                        						<li><a href="javascript:;"  style="color:#fff;">新增版本</a>
	                                       							 </li>
							                                        <li><a href="javascript:;"  style="color:#fff;">修改版本</a>
							                                        </li>
							                                        <li><a href="javascript:update(${app.id });" id="delete" style="color:#fff;">修改</a>
							                                        </li>
							                                        <li><a href="javascript:show(${app.id });"  style="color:#fff;">查看</a>
							                                        </li>
							                                        <li><a href="javascript:deleted(${app.id });"  style="color:#fff;">删除</a>
							                                        </li>
                                    							</ul></div>
                                    </td>
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
						开发者! a Bootstrap 3 template by <a>Kimlabs</a>. | <span
							class="lead"> <i class="fa fa-paw"></i> 开发者!
						</span>
					</p>
				</div>
				<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->

		<script type="text/javascript">
		$("#form11").submit(function(){
			var data =$(this).serialize();
			$.ajax({
				url:"<%=request.getContextPath() %>/sys/devuser/appInfo",
				data:data,
				type:"GET",
				dataType:"html",
				processData:false,
				contentType:false,
				success:function(data){
						$("#main1").html(data);
				}
				});
			
		}); 
		$("#tbody1").on('mouseover','#btn1',function(){
			$(this).children('ul').show();
		});
		$("#tbody1").on('mouseout','#btn1',function(){
			$(this).children('ul').hide();
		});
		
		
		/* 修改 */
		 function update(id){
			 $("#main1").load("<%=request.getContextPath() %>/sys/devuser/updateApp"+id); 
		 }
	     /*删除  */   	
	      function deleted(id){
			 $.ajax({
					url:"<%=request.getContextPath() %>/sys/devuser/deletedApp",
					data:{"id":id},
					type:"POST",
					dataType:"text",
					success:function(data){
						console.log(data)
						if(data=="1"){
							
							alert("APP信息删除成功");
							$("#main1").load("<%=request.getContextPath() %>/sys/devuser/appInfo");
						}else{
							
							alert("APP信息删除失败");
						}
						
					}
					
				});
		 }   	
	      
		 
		 function add(){
			 $("#main1").load("<%=request.getContextPath() %>/sys/devuser/add");
		 }
		 
	
		function add1(val){
			  
			   $.ajax({
				   type:'POST',
				   dataType:'text',//不写这个会提示下载或者改为json也是
				   url:'${pageContext.request.contextPath}/sys/devuser/ajaxFindSecondType',
				   data:{
				   val : val
				   }, 


				   success:function(data){

				   var secondCategoryObj = document.getElementById("appCategoryName2");
				   var secondCategoryObj2 = document.getElementById("appCategoryName3");
				   secondCategoryObj2.innerHTML="";
				     secondCategoryObj.innerHTML = "<option value='0'>--请选择--</option>";
				  	 //解析json为数组
				        var data = eval("("+data+")");     
				        var dataList = data.tasks;
				        if (dataList!= null) { //如果没有这一步，js会报length null之类的
				        for(var i=0;i<dataList.length;i++)//遍历
				        {
				       	 var AppCategory = dataList[i]; 
				   		var id = AppCategory.id;
				   			var categoryName = AppCategory.name;
				             //进行添加到标签里
				            secondCategoryObj.innerHTML += "<option value='"+id+"'>"+categoryName+"</option>";
				            
				        }
				        }

				   }
				   });  
				   }
				 
		function add2(val){
			  
			   $.ajax({
				   type:'POST',
				   dataType:'text',//不写这个会提示下载或者改为json也是
				   url:'${pageContext.request.contextPath}/sys/devuser/ajaxFindSecondType',
				   data:{
				   val : val
				   }, 


				   success:function(data){

				   var secondCategoryObj = document.getElementById("appCategoryName3");
				     secondCategoryObj.innerHTML = "<option value='0'>--请选择--</option>";
				  	 //解析json为数组
				        var data = eval("("+data+")");     
				        var dataList = data.tasks;
				        if (dataList!= null) { //如果没有这一步，js会报length null之类的
				        for(var i=0;i<dataList.length;i++)//遍历
				        {
				       	 var AppCategory = dataList[i]; 
				   		var id = AppCategory.id;
				   			var categoryName = AppCategory.name;
				             //进行添加到标签里
				            secondCategoryObj.innerHTML += "<option value='"+id+"'>"+categoryName+"</option>";
				            
				        }
				        }

				   }
				   });  
				   }
				 
			   
			  

		
		</script>
		
</body>
</html>