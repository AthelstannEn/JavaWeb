<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>




   <div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/goodTypes">Category</a></li>
					<li class="active"><a href="/admin/goodModels<custom:allParams/>">Products</a></li>
					<li><a href="/admin/goodCountries">Country </a></li>
					<li><a href="/admin/gpuTypes">Grammature</a></li>
					<li><a href="/admin/memoryTypes">Manufacturer </a></li>
					<li><a href="/admin/proccTypes">Size</a></li>
					<li><a href="/admin/ramTypes">Age category</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>


<div class="row">
	<div class="col-md-3 col-xs-12">
	
		<form:form class="form-inline" action="/admin/screan" method="GET" modelAttribute="filter">
			<custom:hiddenInputs excludeParams="search"/>
			<div class="form-group">
				<form:input path="search" class="form-control" placeholder="Search"/>
			</div>
			<button class="btn btn-primary" type="submit">go</button>
		</form:form>
	
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/screan" method="POST" modelAttribute="screan">
				<custom:hiddenInputs excludeParams="type"/>								
				
				<div class="form-group">
						<label style="color:red;text-align:left;" for="name" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="type"/></label>
					</div>
				
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Screan size</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="type" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-primary">Create/Update</button>
      						<a class="btn btn-primary" href="/admin/screan/cancel">Cancel</a>      						
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-xs-8"><h3>Model Name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Update</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${page.content}" var="screan">
				<div class="row">
					<div class="col-md-8 col-xs-8">${screan.type}in Decimetry </div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/screan/update/${screan.id}<custom:allParams/>">update</a></div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-danger" href="/admin/screan/delete/${screan.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
	
		<div class="row">
					<div class="col-md-6 col-xs-6 text-center">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle" type="button"
								data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Size asc" paramValue="type" />
								<custom:sort innerHtml="size desc" paramValue="type,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-xs-6 text-center">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
		</div>
	
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
	
</div>

<script>
	$('label').each(function(){
		if(!$(this).html()) $(this).parent().hide();
	});
	
</script>