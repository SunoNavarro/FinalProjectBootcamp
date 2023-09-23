<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #f0f1f2">


	<div class="container" style="position: relative; min-height: 65vh">
		<div class="container mt-5 pt-5 align-items-cente">
			<div class="card bg-light">
				<div class="cardbody mx-auto">
					<p class="h4 mb-4 text-center mt-2">Ingresar</p>

					<sf:form method="post"
						action="${pageContext.request.contextPath}/depositemoney"
						modelAttribute="form">
						<br style="clear: both">
						<%
							String uri = (String) request.getAttribute("uri");
						%>
						<b class="text-center"><%@ include file="businessMessage.jsp"%></b>

						<div class="card" style="background-color: background;">
							<div class="card-body">
							<s:bind path="transaction">
                                   <label for="inputEmail4" class="form-label">Ingrese cantidad</label>
									<sf:input path="${status.expression}" type="text"
										placeholder="Enter Amount" class="form-control" />
										<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>

								</s:bind>

							</div>
						</div>


						<div class="container mt-4 text-center mb-2">
							<input type="submit" class="btn btn-primary" name="operation"
								value="Proceder">
						</div>

					</sf:form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>