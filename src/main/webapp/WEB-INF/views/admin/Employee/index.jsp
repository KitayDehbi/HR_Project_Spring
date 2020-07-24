<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gestion HR </title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="https://code.jquery.com/jquery-3.5.1.js" />"></script>
    <script src="<c:url value="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js" />"></script>
    <script src="<c:url value="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js" />"></script>
    <style>
        #btn{
            margin-bottom: 2%;
        }
    </style>
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
        } );
    </script>
</head>
<body>
<div class="container" id="global">
    <jsp:directive.include file="../../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Tous les employees</h1>
        <div class="col-lg-12" id="btn">
            <a href="${pageContext.request.contextPath}/admin/employees/add" class="btn btn-primary">
                Ajouter Employee</a>
            <br/>
        </div>
        <table id="example"  class="table table-striped table-bordered">
            <tr>
                <th>Nom complet</th>
                <th>Cin</th>
                <th>Tel</th>
                <th>email</th>
                <th>grade</th>
                <%--<th>salaire</th>
                <th>Ch Affaire</th>--%>
                <th>Actions</th>


            </tr>
            <c:forEach items="${liste}" var="item">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/employees/${item.cin}">${item.nom}</a></td>
                    <td>${item.cin}</td>
                    <td>${item.tel}</td>
                    <td>${item.email}</td>
                    <td>${item.grade}</td>
                    <%--<td>${item.salaire}</td>
                    <td>${item.chiffre_affaire}</td>--%>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/employees/delete/${item.cin}" class="btn btn-danger"
                           onclick="if (!(confirm('Vous Voulez supprimer Lemployer?'))) return false">Supprimer</a>
                        <a href="${pageContext.request.contextPath}/admin/employees/add/${item.cin}" class="btn btn-warning">Modifier</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </header>

</div>

</body>
</html>