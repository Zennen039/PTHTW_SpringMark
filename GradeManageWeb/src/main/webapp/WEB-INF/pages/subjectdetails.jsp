<%-- 
    Document   : subjectdetails
    Created on : Sep 5, 2024, 9:57:13 AM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-success">Student details</h1>

<div class="row container">
    <div class="row">
        <div>
            <a class="btn btn-primary my-2 text-decoration-none" href="<c:url value='/users'/>">Add student</a>
        </div>

        <div class="row">
            <form action="<c:url value="/subjectdetails" />" method="GET" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Tìm kiếm sinh viên">
                <button class="btn btn-primary" type="submit" title="Tìm kiếm">Tìm</button>
            </form>
        </div> 
    </div>

    <table class="table table-hover ">
        <thead>
            <tr>
                <th>Student information</th>
                <th>Midterm score</th>
                <th>Final score</th>

            </tr>
        </thead>

        <tbody>
            <c:forEach items="${user}" var="u">
                <c:if test="${u.userRole == 'ROLE_STUDENT'}">
                    <tr>
                        <td>
                            <div class="card" style="width:400px">
                                <img class="card-img-top" src="${u.avatar}" alt="${u.firstName}">
                                <div class="card-body">
                                    <h4 class="card-title">Student name: ${u.firstName}</h4>
                                    <p>Id: ${u.id}</p>
                                    <p>Role: ${u.userRole}</p>
                                    <p>Email: ${u.email}</p>

                                    <a href="<c:url value="/userdetails/${u.id}"/>" class="btn btn-primary btn-outline-light rounded-pill">
                                        User details
                                    </a>

                                    <c:url value="/api/users/${u.id}" var="url"/>
                                    <button onclick="deleteUser('${url}',${u.id})" class="btn btn-danger btn-outline-light rounded-pill">
                                        &times;
                                    </button>

                                </div>
                            </div>
                        </td>

                        <td>
                            <c:forEach items="${scores}" var="sc">
                                ${sc.midterm}
                            </c:forEach>
                        </td>

                        <td>
                            <c:forEach items="${scores}" var="sc">
                                ${sc.final1}
                            </c:forEach>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</div>
