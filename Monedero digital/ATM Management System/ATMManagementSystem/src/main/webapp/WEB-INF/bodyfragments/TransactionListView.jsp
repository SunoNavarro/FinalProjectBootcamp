<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<c:url var="delete" value="/transaction/Delete" />
	
	<div class="container mt-2"
		style="position: relative; min-height: 72vh">

<h2 align="center">Ultimos movimientos</h2>
		<sf:form method="post"
			action="${pageContext.request.contextPath}/transactionlist"
			modelAttribute="form">
			
				<c:if test="${sessionScope.user.roleid == 1}">
			<table width="100%">
				<tr>
					<td align="center"><s:bind path="transactiontype">
							<sf:input path="${status.expression}" type="text" name="name"
								placeholder="Search By Transaction Type" value="" />
						</s:bind> &emsp;&emsp; <input type="submit" name="operation" value="Search">&nbsp;&nbsp;&nbsp;<input
						type="submit" name="operation" value="Reset"></td>
				</tr>
			</table>
			</c:if>
			<br>
<b class="text-center"><%@ include file="businessMessage.jsp"%></b>
			<table class="table table-striped table table-dark">
				<tr>

                    <th scope="col">Numero de cuenta</th>
					<th scope="col">Nombre usuario</th>
					<th scope="col">Transaccion</th>
					<th scope="col">Tipo Transaccion</th>
					<th scope="col">Total Balance</th>
					<th scope="col">Dia y hora</th>
					<th scope="col">Action</th>
				</tr>

                <c:set var="totalbalance" value="${0}" />
				<c:forEach items="${list}" var="transactionlist">

					<tr>
                        <td>${transactionlist.accountnumber}</td>
						<td>${transactionlist.username}</td>
						<td>Euros:  ${transactionlist.transaction}</td>
						<td>${transactionlist.transactiontype}</td>
						<td>Euros: ${transactionlist.totalbalance}</td>
						<td><fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${transactionlist.date}" /></td>  
						<c:choose>
							<c:when test="${sessionScope.user.roleid == 1}">
								<td>
&nbsp;&nbsp;&nbsp;
									<a class="btn btn-danger" href="${delete}?id=${transactionlist.id}"><i
										class='	far fa-trash-alt' style='font-size: 15px;'></i></a></td>
								
							</c:when>
							<c:otherwise>
							<td>---------</td>

							</c:otherwise>
						</c:choose>

					</tr>
				</c:forEach>
				</tbody>
			</table>


		</sf:form>


	</div>
</body>
</html>