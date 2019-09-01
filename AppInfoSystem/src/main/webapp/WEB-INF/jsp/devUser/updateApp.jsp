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
 <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js"></script>

   
</head>
<body>
    <div class="container body">


        <div class="main_container">

            <!-- top navigation -->
            <div class="top_nav">
            </div>
            <!-- /top navigation -->

            <!-- page content -->
          
                <div class="">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>新增APP基础信息</h2>
                                    
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="javascript:;" enctype="multipart/form-data" method="post" id="addForm">
											<input type="hidden" name="id" value="${appInfo.id }"/>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">软件名称 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text"   id="first-name" required="required" class="form-control col-md-7 col-xs-12" name="softwareName" value="${appInfo.softwareName }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">APK名称 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" id="last-name"   name="APKName" required="required" class="form-control col-md-7 col-xs-12"  value="${appInfo.APKName }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">支持ROM</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="middle-name"   class="form-control col-md-7 col-xs-12" type="text" name="supportROM" value="${appInfo.supportROM }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">界面语言</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="middle-name"   class="form-control col-md-7 col-xs-12" type="text" name="interfaceLanguage" value="${appInfo.interfaceLanguage }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">软件大小 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="middle-name"   class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" name="softwareSize" value="${appInfo.softwareSize }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">下载次数<span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="middle-name"  class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" name="downloads" value="${appInfo.downloads }">
                                            </div>
                                        </div>
                                        <div></div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                            	<select id="middle-name" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" name="flatformId">
                                            		<option>--请选择--</option>
                                            		<c:forEach items="${status}" var="sta">
	                                            		<c:if test="${sta.id==appInfo.flatformId}">
	                                            		<option value="${sta.id}" selected="selected">${sta.valueName}</option>
	                                            		</c:if>
	                                            		<c:if test="${sta.id!=appInfo.flatformId}">
	                                            		<option value="${sta.id}" >${sta.valueName}</option>
	                                            		</c:if>
                                            		</c:forEach>
                                            	</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                            <select id="middle-name" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" name="categoryLevel1" onchange="add1(this.value);">
                                            		<option>--请选择--</option>
                                            		<c:forEach items="${list1}" var="list">
                                            			<c:if test="${list.id==appInfo.categoryLevel1}">
	                                            		<option value="${list.id}"  selected="selected">${list.categoryName}</option>
	                                            		</c:if>
	                                            		<c:if test="${list.id!=appInfo.categoryLevel1}">
	                                            		<option value="${list.id}" >${list.categoryName}</option>
	                                            		</c:if>
														
													</c:forEach>
                                            	</select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                             <select id="middle-name1" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" name="categoryLevel2" onchange="add2(this.value);">
                                            	<option>--请选择--</option>
                                            		<c:forEach items="${categoryList}" var="list">
                                            			<c:if test="${list.id==appInfo.categoryLevel2}">
	                                            		<option value="${list.id}"  selected="selected">${list.categoryName}</option>
	                                            		</c:if>
	                                            		<c:if test="${list.id!=appInfo.categoryLevel1}">
	                                            		<option value="${list.id}" >${list.categoryName}</option>
	                                            		</c:if>
														
													</c:forEach>	
                                            	</select>
                                               
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                            <select id="middle-name2" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" name="categoryLevel3">
                                            		<option>--请选择--</option>
                                            		<c:forEach items="${categoryList}" var="list">
                                            			<c:if test="${list.id==appInfo.categoryLevel3}">
	                                            		<option value="${list.id}"  selected="selected">${list.categoryName}</option>
	                                            		</c:if>
	                                            		<c:if test="${list.id!=appInfo.categoryLevel1}">
	                                            		<option value="${list.id}" >${list.categoryName}</option>
	                                            		</c:if>
														
													</c:forEach>
                                            	</select>
                                              
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="hidden" name="status" value="1"/>
                                                <span>待审核</span>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">应用简介 <span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input id="middle-name" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" name="appInfo" value="${appInfo.appInfo }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12">LOGO图片<span class="required">*</span>
                                            </label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                            	<c:if test="${appInfo.logoPicPath!=null }">
                                                <img alt="图片" src="<%=request.getContextPath() %>/static/uploadfiles/${appInfo.logoPicPath }" style="width:150px;height:200px;" id="image1">
                                              </c:if>
                                              <c:if test="${appInfo.logoPicPath==null }">
                                                <span class="date-picker form-control col-md-7 col-xs-12" >暂无图片</span>
                                              </c:if>
                                                 <input id="middle-name" class="date-picker form-control col-md-7 col-xs-12"  type="file" name="attachs" id="file1" value="${appInfo.logoPicPath }" /> 
                                            </div>
                                        </div>
                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                            <input  type="submit" class="btn btn-primary" value="保存">
                                              
                                                <button  class="btn btn-success"><a href="<%=request.getContextPath() %>/sys/devuser/appInfo">返回</a></button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <script type="text/javascript">
                        $(document).ready(function () {
                            $('#birthday').daterangepicker({
                                singleDatePicker: true,
                                calender_style: "picker_4"
                            }, function (start, end, label) {
                                console.log(start.toISOString(), end.toISOString(), label);
                            });
                           
                            
                            
                        });
                    </script>
                <!-- /page content -->

                <!-- footer content -->
                <footer>
                    <div class="">
                        <p class="pull-right">开发者管理 <a>Kimlabs</a>. |
                            <span class="lead"> <i class="fa fa-paw"></i> 开发者!</span>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->

            </div>

        
    </div>

        <div id="custom_notifications" class="custom-notifications dsp_none">
            <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
            </ul>
            <div class="clearfix"></div>
            <div id="notif-group" class="tabbed_notifications"></div>
        </div>

        <script src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>

        <!-- chart js -->
        <script src="<%=request.getContextPath() %>/static/js/chartjs/chart.min.js"></script>
        <!-- bootstrap progress js -->
        <script src="<%=request.getContextPath() %>/static/js/progressbar/bootstrap-progressbar.min.js"></script>
        <script src="<%=request.getContextPath() %>/static/js/nicescroll/jquery.nicescroll.min.js"></script>
        <!-- icheck -->
        <script src="<%=request.getContextPath() %>/static/js/icheck/icheck.min.js"></script>
        <!-- tags -->
        <script src="<%=request.getContextPath() %>/static/js/tags/jquery.tagsinput.min.js"></script>
        <!-- switchery -->
        <script src="<%=request.getContextPath() %>/static/js/switchery/switchery.min.js"></script>
        <!-- daterangepicker -->
        <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/moment.min2.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/datepicker/daterangepicker.js"></script>
        <!-- richtext editor -->
        <script src="<%=request.getContextPath() %>/static/js/editor/bootstrap-wysiwyg.js"></script>
        <script src="<%=request.getContextPath() %>/static/js/editor/external/jquery.hotkeys.js"></script>
        <script src="<%=request.getContextPath() %>/static/js/editor/external/google-code-prettify/prettify.js"></script>
        <!-- select2 -->
        <script src="<%=request.getContextPath() %>/static/js/select/select2.full.js"></script>
        <!-- form validation -->
        <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/parsley/parsley.min.js"></script>
        <!-- textarea resize -->
        <script src="<%=request.getContextPath() %>/static/js/textarea/autosize.min.js"></script>
        <script>
            autosize($('.resizable_textarea'));
        </script>
        <!-- Autocomplete -->
        <script type="text/javascript" src="<%=request.getContextPath() %>/static/js/autocomplete/countries.js"></script>
        <script src="<%=request.getContextPath() %>/static/js/autocomplete/jquery.autocomplete.js"></script>
        <script type="text/javascript">
            $(function () {
                'use strict';
                var countriesArray = $.map(countries, function (value, key) {
                    return {
                        value: value,
                        data: key
                    };
                });
                // Initialize autocomplete with custom appendTo:
                $('#autocomplete-custom-append').autocomplete({
                    lookup: countriesArray,
                    appendTo: '#autocomplete-container'
                });
            });
        </script>
        <script src="<%=request.getContextPath() %>/static/js/custom.js"></script>
<script type="text/javascript">
$('#button1').click(function () {
    $('#image1').toggle(1000);
    $('#file1').toggle(1000);
    
  });

</script>
<script type="text/javascript">
$("#demo-form2").submit(function(){
	var data =$(this).serialize();
	var data=new FormData(document.getElementById("demo-form2"));
	$.ajax({
		url:"<%=request.getContextPath() %>/sys/devuser/appInfoUpdateSave",
		data:data,
		type:"POST",
		dataType:"text",
		processData:false,
		contentType:false,
		success:function(data){
			console.log(typeof data)
			if(data=="1"){
				
				alert("APP信息修改成功");
				$("#main1").load("<%=request.getContextPath() %>/sys/devuser/appInfo");
			}else{
				
				alert("APP信息修改失败");
			}
			
		}
		
	});
	
}); 


function add1(val){
	  
	   $.ajax({
		   type:'POST',
		   dataType:'text',//不写这个会提示下载或者改为json也是
		   url:'${pageContext.request.contextPath}/sys/devuser/ajaxFindSecondType',
		   data:{
		   val : val
		   }, 


		   success:function(data){

		   var secondCategoryObj = document.getElementById("middle-name1");
		   var secondCategoryObj2 = document.getElementById("middle-name2");
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

		   var secondCategoryObj = document.getElementById("middle-name2");
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

        <!-- select2 -->
        <script>
            $(document).ready(function () {
                $(".select2_single").select2({
                    placeholder: "Select a state",
                    allowClear: true
                });
                $(".select2_group").select2({});
                $(".select2_multiple").select2({
                    maximumSelectionLength: 4,
                    placeholder: "With Max Selection limit 4",
                    allowClear: true
                });
            });
        </script>
        <!-- /select2 -->
        <!-- input tags -->
        <script>
            function onAddTag(tag) {
                alert("Added a tag: " + tag);
            }

            function onRemoveTag(tag) {
                alert("Removed a tag: " + tag);
            }

            function onChangeTag(input, tag) {
                alert("Changed a tag: " + tag);
            }

            $(function () {
                $('#tags_1').tagsInput({
                    width: 'auto'
                });
            });
        </script>
        <!-- /input tags -->
        <!-- form validation -->
        <script type="text/javascript">
            $(document).ready(function () {
                $.listen('parsley:field:validate', function () {
                    validateFront();
                });
                $('#demo-form .btn').on('click', function () {
                    $('#demo-form').parsley().validate();
                    validateFront();
                });
                var validateFront = function () {
                    
            };

            $(document).ready(function () {
                $.listen('parsley:field:validate', function () {
                    validateFront();
                });
               
                var validateFront = function () {
                   
                };
            });
            try {
                hljs.initHighlightingOnLoad();
            } catch (err) {}
        </script>
        <!-- /form validation -->
        <!-- editor -->
        <script>
            $(document).ready(function () {
                $('.xcxc').click(function () {
                    $('#descr').val($('#editor').html());
                });
            });

            $(function () {
                function initToolbarBootstrapBindings() {
                    var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                'Times New Roman', 'Verdana'],
                        fontTarget = $('[title=Font]').siblings('.dropdown-menu');
                    $.each(fonts, function (idx, fontName) {
                        fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
                    });
                    $('a[title]').tooltip({
                        container: 'body'
                    });
                    $('.dropdown-menu input').click(function () {
                            return false;
                        })
                        .change(function () {
                            $(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
                        })
                        .keydown('esc', function () {
                            this.value = '';
                            $(this).change();
                        });

                    $('[data-role=magic-overlay]').each(function () {
                        var overlay = $(this),
                            target = $(overlay.data('target'));
                        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
                    });
                    if ("onwebkitspeechchange" in document.createElement("input")) {
                        var editorOffset = $('#editor').offset();
                        $('#voiceBtn').css('position', 'absolute').offset({
                            top: editorOffset.top,
                            left: editorOffset.left + $('#editor').innerWidth() - 35
                        });
                    } else {
                        $('#voiceBtn').hide();
                    }
                };

                function showErrorAlert(reason, detail) {
                    var msg = '';
                    if (reason === 'unsupported-file-type') {
                        msg = "Unsupported format " + detail;
                    } else {
                        console.log("error uploading file", reason, detail);
                    }
                    $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
                };
                initToolbarBootstrapBindings();
                $('#editor').wysiwyg({
                    fileUploadError: showErrorAlert
                });
                window.prettyPrint && prettyPrint();
            })
        </script>
        <!-- /editor -->

</body>
</html>