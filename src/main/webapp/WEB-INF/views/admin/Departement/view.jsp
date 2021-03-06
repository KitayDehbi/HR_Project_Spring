<%--
  Created by IntelliJ IDEA.
  User: binizmohamed
  Date: 4/6/20
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Blog</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">

    <jsp:directive.include file="../../layout/header.jsp" />

    <div class="col-lg-12">
        <h3>Departement : ${departement.name}</h3>
        <h4>Employes  </h4>
        <table class="table table-bordered">
            <tr>
                <th>Nom complet</th>
                <th>Cin</th>
                <th>Tel</th>
                <th>email</th>
                <th>grade</th>
                <th>salaire</th>
                <th>Ch Affaire</th>


            </tr>
            <c:forEach items="${liste}" var="item">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/employees/${item.cin}">${item.nom}</a></td>
                    <td>${item.cin}</td>
                    <td>${item.tel}</td>
                    <td>${item.email}</td>
                    <td>${item.grade}</td>
                    <td>${item.salaire}</td>
                    <td>${item.chiffre_affaire}</td>

                </tr>

            </c:forEach>

        </table>

    </div>
</div>

</body>
</html>