<%-- 
    Document   : header
    Created on : Sep 1, 2024, 10:49:03 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">GMW</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">Home</a>
                </li>

                <c:forEach items="${categories}" var="c">
                    <c:url value="/" var="myC">
                        <c:param name="subjectId" value="${c.id}" />
                    </c:url>

                    <li class="nav-item">
                        <a class="nav-link" href="${myC}">${c.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>