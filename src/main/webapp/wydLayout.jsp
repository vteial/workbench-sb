<%@ page language="java"%>
<%
	String contextPath     = request.getContextPath();
	String applicationName = (String)request.getAttribute("applicationName");
	String viewTitle       = (String)request.getAttribute("viewTitle");
	String viewName        = (String)request.getAttribute("viewName");
%>
<!doctype html>
<html lang="en">

<head>
	<title><%=applicationName%> - <%=viewTitle%></title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
	<link href="assets/css/myworkbench.css" rel="stylesheet"/>

	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
</head>

<body>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<ul class="nav">
				<li class="">
					<a class="brand" href="index">
						<strong><%=applicationName%></strong>
					</a>
				</li>
				<li class="divider-vertical"></li>
				<li class="<%=viewName.equals("wydIndex") ? "active" : ""%>">
					<a href="index"><i class="icon-home icon-white"></i></a>
				</li>
				<li>
					<a href="html5sqlConsole.html">HTML5 SQL Console</a>
				</li>
				<li>
					<a href="treeTable.html">Tree Table</a>
				</li>
			</ul>
			<ul class="nav pull-right">
				<li class="<%=viewName.equals("wydAbout") ? "active" : ""%>">
					<a href="about.html">About</a>
				</li>
			</ul>
		</div>
	</div>
</div>

<%
	pageContext.include(viewName + ".jsp");
%>

<div class="container">
   <p align="center">
   		Built using 
	   <a href="http://twitter.github.io/bootstrap/">Twitter Bootstrap</a>,
	   <a href="http://www.jquery.com/">JQuery</a> and 
	   <a href="http://www.springsource.org/spring-framework/">Spring Framework</a> 
   </p>
</div>

</body>
</html>