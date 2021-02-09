<%@ page language="java" contentType="text/html;	charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="com.uniovi.sdi.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html	PUBLIC "-//W3C//DTD	HTML	4.01	Transitional//EN"	
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>JSP</title>
<meta charset="utf-8" />


<meta name="viewport" content="width=device-width,	initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


	

	<!-- Contenido	-->
	<div class="container" id="contenedor-principal">
		<!-- Contenido -->
		<div class="container" id="contenedor-principal">
			<h2>Agregar comentario al blog</h2>
			<form class="form-horizontal" method="post"
				action="agregarComentario.jsp">
				<div class="form-group">
					<label class="control-label	col-sm-2" for="nombre">Usuario:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="usuario"
							required="true" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label	col-sm-2" for="nombre">Comentario:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="comentario"
							required="true" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2	col-sm-10">
						<button type="submit" class="btn	btn-primary">Agregar</button>
					</div>
				</div>
			</form>
		</div>
	</div>


	<%
		if (request.getParameter("usuario") != null && request.getParameter("comentario") != null) {
			String user = (String) request.getParameter("usuario");
			String coment = (String) request.getParameter("comentario");
		
			Comentario comentar = new Comentario(user, coment);
			new ComentariosService().setNuevoComentario(comentar);
			request.getRequestDispatcher("vista-comentarios.jsp").forward(request, response);
		}
	%>
</body>
</html>