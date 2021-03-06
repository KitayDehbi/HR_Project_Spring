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
            <a href="${pageContext.request.contextPath}/admin/remuneration/add" class="btn btn-primary">
                Ajouter Remuneration</a>
            <br/>
        </div>
        <table id="example"  class="table table-striped table-bordered">
            <tr>
                <th>date </th>
                <th>Type </th>
                <th>Montant</th>
                <th>Employee</th>




            </tr>
            <c:forEach items="${liste}" var="item">
                <tr>
                    <td>${item.date_remuneration}</td>
                    <td>${item.type}</td>
                    <td>${item.montant}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/employees/${item.employee.cin}">${item.employee.nom}</a></td>
                </tr>
            </c:forEach>
        </table>
    </header>

</div>

</body>
</html>