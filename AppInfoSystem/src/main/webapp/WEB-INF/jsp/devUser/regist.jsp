<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>app开发者注册系统 </title>

    <!-- Bootstrap core CSS -->

    <link href="<%=request.getContextPath() %>/static/css/bootstrap.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath() %>/static/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="<%=request.getContextPath() %>/static/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/static/css/icheck/flat/green.css" rel="stylesheet">


    <script src="<%=request.getContextPath() %>/static/js/jquery.min.js"></script>

    <!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>
<body style="background:#F9F9F9;">
<div class="">
        <a class="hiddenanchor" id="toregister"></a>
        <a class="hiddenanchor" id="tologin"></a>

        <div id="wrapper">
            <div id="login" class="animate form">
                <section class="login_content">
                    <form action="<%=request.getContextPath() %>/devRegistSave" method="post">
                        <h1>注册</h1>
                        <div>
                            <input type="text" class="form-control" name="devCode" placeholder="LoginName" required="" />
                        </div>
                        <div>
                            <input type="text" class="form-control" name="devName" placeholder="Username" required="" />
                        </div>
                        <div>
                            <input type="password" class="form-control" name="devPassword" placeholder="Password" required="" />
                        </div>
                        <div>
                            <input type="text" class="form-control" name="devEmail" placeholder="Email" required="" />
                        </div>
                        <div>
                            <input type="text" class="form-control" name="devInfo" placeholder="infomation" required="" />
                        </div>
                        
                        
                        <div>
                         <input class="btn btn-default submit" type="submit" value="注册">
                        </div>
                        <div class="clearfix"></div>
                        <div class="separator">

                            <p class="change_link">已经有账号?
                                <a href="<%=request.getContextPath() %>/devuser" class="to_register"> 登陆 </a>
                            </p>
                            <div class="clearfix"></div>
                            <br />
                            <div>
                                <h1><i class="fa fa-paw" style="font-size: 26px;"></i> 开发者注册!</h1>

                                <p>©2015 All Rights Reserved. Gentelella Alela! is a Bootstrap 3 template. Privacy and Terms</p>
                            </div>
                        </div>
                    </form>
                    <!-- form -->
                </section>
                <!-- content -->
            </div>
        </div>
    </div>
</body>
</html>