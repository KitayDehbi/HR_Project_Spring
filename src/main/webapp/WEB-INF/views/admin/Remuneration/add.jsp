<%--
  Created by IntelliJ IDEA.
  User: binizmohamed
  Date: 4/6/20
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Ajouter employee</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class="container">
    <jsp:directive.include file="../../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Ajouter une Remuneration</h1>
        <form:errors path="employee" cssClass="alert-danger" />
        <form:form method="post" action="${pageContext.request.contextPath}/admin/remuneration/save" modelAttribute="remuneration" >
            <form:input path="id" type="hidden" />
            <div class="form-group">
                <label class="form-check-label">
                    Employee
                </label>

                <form:select path="employee"  class="form-control" id="select">
                    <c:forEach items="${employees}"   var="emp">
                        <option value="${emp.id}"> ${emp.nom}  </option>
                    </c:forEach>
                </form:select>
                <form:errors path="employee" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label class="form-check-label">
                    Type
                </label>

                <form:select path="type"  class="form-control" id="select2">
                        <option value="fixe"> Fixe  </option>
                        <option value="variable"> variable  </option>

                </form:select>
                <form:errors path="type" cssClass="alert-danger" />
            </div>


           <input type = "submit" value = "Submit" class="btn btn-primary"/>
        </form:form>
    </header>
</div>
</body>
</html>
