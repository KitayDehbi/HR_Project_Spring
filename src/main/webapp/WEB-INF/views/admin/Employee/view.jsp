<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gestion HR</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">

    <jsp:directive.include file="../../layout/header.jsp" />

    <div class="col-lg-12">
        <h3>Departement : ${employee.departement.name}</h3>
        <h3>Manager  : ${employee.manager.nom}</h3>
        <h4>Nom : ${employee.nom}</h4>
        <h4>Cin : ${employee.cin}</h4>
        <h4>grade : ${employee.grade}</h4>
        <h4>salaire : ${employee.salaire}</h4>
        <h4>Sous-jascent  </h4>
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
        <div class="col-lg-12" >
            <a href="${pageContext.request.contextPath}/admin/remuneration/add" class="btn btn-primary" style="margin-bottom: 10px">
                Ajouter Remuneration</a>
            <br/>
        </div>
        <h4>Rémunerations </h4>
        <table class="table table-bordered">
            <tr>
                <th>Date</th>
                <th>Type</th>
                <th>Montant</th>
            </tr>
            <c:forEach items="${remunerations}" var="remu">
                <tr>

                    <td>${remu.date_remuneration}</td>
                    <td>${remu.type}</td>
                    <td>${remu.montant}</td>

                </tr>

            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>