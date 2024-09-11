<%-- 
    Document   : header
    Created on : Sep 3, 2024, 5:36:13 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">GMW</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
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

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class="btn btn-secondary btn-outline-light rounded-pill" href="<c:url value="/login" />">Sign in</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link text-warning" href="<c:url value="/" />">Hi! ${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-secondary btn-outline-light rounded-pill" href="<c:url value="/logout" />">Sign out</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>

            <form action="<c:url value="/" />" method="GET" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Tìm kiếm môn học">
                <button class="btn btn-info btn-outline-light rounded-pill" type="submit" title="Tìm kiếm">Tìm</button>
            </form>
        </div>
    </div>
</nav>
