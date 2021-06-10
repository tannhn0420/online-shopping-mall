<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Font awesome -->
<link href="${css}/font-awesome.min.css" rel="stylesheet">

<link href="${css}/prettyPhoto.css" rel="stylesheet">

<link href="${css}/price-range.css" rel="stylesheet">
<link href="${css}/animate.css" rel="stylesheet">
<link href="${css}/main.css" rel="stylesheet">
<link href="${css}/responsive.css" rel="stylesheet">

<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${images}/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${images}/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${images}/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="${images}/ico/apple-touch-icon-57-precomposed.png">

<!-- Bootstrap Readable theme CSS -->
 <!-- <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">  -->


<!-- Bootstrap DataTableCSS theme CSS -->
 <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">  





<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
	body{
	background-color: #FFDEE9;
background-image: linear-gradient(118deg, #FFDEE9 0%, #d3e0e0 50%, #ffffff 100%);

	}
</style>

</head>

<body>
	<div class="se-pre-con"></div>
	<div class="wrapper" >
	
	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>


	<!-- Page Content -->
	<div class="content">
	
		<!-- Loading the home content -->
		<c:if test="${userClickHome == true }">
			<%@include file="home.jsp"%>
		</c:if>
		<!-- Loading only when user click contact content -->
		<c:if test="${userClickContact == true }">
			<%@include file="contact.jsp"%>
		</c:if>
		<!-- Loading only when user click about content -->
		<c:if test="${userClickAbout == true }">
			<%@include file="about.jsp"%>
		</c:if>
		<!-- Loading only when user click about content -->
		<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true  }">
			<%@include file="listProducts.jsp"%>
		</c:if>
		<!-- Loading only when user click show product -->
		<c:if test="${userClickShowProduct == true}">
			<%@include file="singleProduct.jsp"%>
		</c:if>
		<!-- Loading only when user click manage product -->
		<c:if test="${userClickManageProducts == true}">
			<%@include file="manageProduct.jsp"%>
		</c:if>
		
		<!-- Loading only when user click show cart -->
		<c:if test="${userClickShowCart == true}">
			<%@include file="cart.jsp"%>
		</c:if>
	</div>
	


	<!-- Footer comes here -->
	<%@include file="./shared/footer.jsp"%>

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>
	
	<!-- jQuery validator -->
	<script src="${js}/jquery.validate.js"></script>
	

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
	
	<!-- ScrollUp JavaScript -->
	<script src="${js}/jquery.scrollUp.min.js"></script>
	
	<!-- PriceRange JavaScript -->
	<script src="${js}/price-range.js"></script>
	
	<!-- Pretty Photo JavaScript -->
	<script src="${js}/jquery.prettyPhoto.js"></script>
	
	<!-- DataTables Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>

	<!-- DataTables Bootstrap Script  -->
	<script src="${js}/dataTables.bootstrap.js"></script>
	
	<!-- Bootbox -->
 	<script src="${js}/bootbox.min.js" rel="stylesheet"></script>
	
	<!-- Self coded javascript -->
	<script src="${js}/myapp.js"></script>
	
	<script src="${js}/main.js"></script>
	
	
	
	</div>
</body>

</html>
