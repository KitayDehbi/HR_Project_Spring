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
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class="container">
    <jsp:directive.include file="../../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Ajouter un Employee</h1>
        <form:errors path="employee" cssClass="alert-danger" />
        <form:form method="post" action="${pageContext.request.contextPath}/admin/save" modelAttribute="employee" >
            <form:input path="id" type="hidden" />
            <div class="form-group">
                <label class="form-check-label">
                    Departement
                </label>

                <form:select path="departement"  class="form-control" id="select">
                    <c:forEach items="${departements}"   var="dep">
                        <option value="${dep.id}"> ${dep.name}  </option>
                    </c:forEach>
                </form:select>
                <form:errors path="departement" cssClass="alert-danger" />
            </div>


            <div class="form-group">
                <label for="cin">cin </label>
                <form:input path="cin" cssClass="form-control"  placeholder="Cin" />
                <form:errors path="cin" cssClass="alert-danger" />

            </div>
            <div class="form-group">
                <label for="nom">Nom Complet</label>
                <form:input path="nom" cssClass="form-control"  placeholder="Nom Complet" />
                <form:errors path="nom" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="tel">Tel</label>
                <form:input path="tel" cssClass="form-control"  placeholder="Tel" />
                <form:errors path="tel" cssClass="alert-danger" />

            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" cssClass="form-control"  placeholder="Email" />
                <form:errors path="email" cssClass="alert-danger" />

            </div>

            <div class="form-group">
                <label for="grade">Grade</label>
                <form:input path="grade" cssClass="form-control"  placeholder="Grade" />
                <form:errors path="grade" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="salaire">Salaire</label>
                <form:input path="salaire" cssClass="form-control"  placeholder="Salaire" />
                <form:errors path="salaire" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="chiffre_affaire">Chiffre d'affaire</label>
                <form:input path="chiffre_affaire" cssClass="form-control"  placeholder="Chiffre d'affaire"/>
                <form:errors path="chiffre_affaire" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label class="form-check-label">
                    Manager
                </label>

                <form:select path="manager"  class="form-control" id="select">
                    <option value=""> selectionner un manager  </option>
                    <c:forEach items="${employees}"   var="dep">
                        <option value="${dep.id}"> ${dep.nom}  </option>
                    </c:forEach>
                </form:select>
                <form:errors path="manager" cssClass="alert-danger" />
            </div>
            <%--<c:forEach items="${employees}"   var="emp">
                <c:choose>
                    <c:when test="${emp.used}">
                        <form:checkbox path="sous_jacents" value="${emp.id}" label="${ emp.nom }" checked="checked" />
                        <br/>
                    </c:when>
                    <c:otherwise>
                        <form:checkbox path="sous_jacents" value="${emp.id}" label="${ emp.nom }"/>
                        <br/>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            <form:errors path="sous_jacents" cssClass="alert-danger" />--%>
            <%--<div class="form-check">
                <label class="form-check-label">
                    Tags
                </label>
                <br/>


                <c:forEach items="${tags}"   var="tag">
                    <c:choose>
                        <c:when test="${tag.used}">
                            <form:checkbox path="tagList" value="${tag.id}" label="${ tag.title }" checked="checked" />
                            <br/>
                        </c:when>
                        <c:otherwise>
                            <form:checkbox path="tagList" value="${tag.id}" label="${ tag.title }"  />
                            <br/>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                <form:errors path="tagList" cssClass="alert-danger" />
            </div>
            --%>





            <input type = "submit" value = "Submit" class="btn btn-primary"/>
        </form:form>
    </header>
</div>
</body>
</html>
