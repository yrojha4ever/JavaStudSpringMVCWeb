<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring MVC Web: JavaStud</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/simple-sidebar.css" rel="stylesheet">
</head>
<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Spring MVC Demo
                    </a>
                </li>
                <li>
                    <a href="#">Student Form</a>
                </li>
                <li>
                    <a href="#">File Upload Example</a>
                </li>
                <li>
                    <a href="#">Rest API Example</a>
                </li>
                <li>
                    <a href="#">Angular App</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                	<a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></a>
                	<hr/>
                    <div class="col-lg-12">
                    	
                        <h1> Sample Demo for Sidebar Menu</h1>
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <script src="${pageContext.request.contextPath }/resources/js/jquery.js""></script>
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
	    $("#menu-toggle").click(function(e) {
	        e.preventDefault();
	        $("#wrapper").toggleClass("toggled");
	    });
    </script>

</body>

</html>
