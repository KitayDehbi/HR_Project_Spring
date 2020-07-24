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
    <jsp:directive.include file="../layout/employeeHeader.jsp" />
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
                <th>Tel</th>
                <th>email</th>
                <th>grade</th>
            </tr>
            <c:forEach items="${liste}" var="item">
                <tr>
                    <td>${item.nom}</td>
                    <td>${item.tel}</td>
                    <td>${item.email}</td>
                    <td>${item.grade}</td>
                </tr>
            </c:forEach>

        </table>
        <h4>Rémunerations </h4>
        <table class="table table-bordered">
            <tr>
                <th>Date</th>
                <th>Type</th>
                <th>Montant</th>
            </tr>
            <c:forEach items="${remuneration}" var="remu">
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