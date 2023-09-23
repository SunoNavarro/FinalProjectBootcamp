<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
</head>
<body style="background-color: #f0f1f2">
	<div class="container-fluid"
		style="position: relative; min-height: 70vh">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4 mt-4">
				<div class="card mt-4">
					<div class="card-body px-5 mt-4">
						<div class="container text-center mt-3 mb-4">

							<h5 style="color: green;" class="text-center">
								<i class="fa fa-check-square fa-5x"></i>
							</h5>
							
                <c:set var="totalbalance" value="${0}" />
				<c:forEach items="${list}" var="transactionlist">

						<c:set var="totalbalance" value="${transactionlist.totalbalance}" />
						</c:forEach>
							<h3>Hola, ${sessionScope.user.userName} Su saldo actual es </h3>
							<h2>Euros:  ${totalbalance}</h2>
							<h2>Gracias</h2>
							<a href="<c:url value = "/welcome" />" class="btn btn-primary mt-3">Home</a>
							<a href="<c:url value = "/transactionlist" />" class="btn btn-success mt-3">Ver lista transacciones</a>


						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>