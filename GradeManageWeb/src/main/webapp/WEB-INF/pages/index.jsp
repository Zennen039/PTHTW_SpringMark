<%-- 
    Document   : index
    Created on : Sep 3, 2024, 5:34:41 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center text-success m-1">SUBJECT CATEGORIES</h1>

    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th class="text-center">Id</th>
                <th class="text-center">Name</th>
                <th class="text-center">Description</th>
                <th class="text-center">Lecturer</th>
                <th></th>
            </tr>
        </thead>

        <c:forEach items="${subjects}" var="sj">
            <tbody class="text-center">
                <tr>
                    <td></td>
                    <td class="text-center">${sj.id}</td>
                    <td class="text-center">${sj.name}</td>
                    <td class="text-center">${sj.description}</td>
                    <td class="text-center">${sj.lecturerName}</td>
                    <td></td>
                    <td>
                        <a href="<c:url value="/subjectdetails" />" class="btn btn-info btn-outline-light rounded-pill">
                            See details
                        </a>

                        <c:url value="/subjects/${sj.id}" var="e" />
                        <a href="${e}" class="btn btn-success btn-outline-light rounded-pill">
                            &orarr;
                        </a>

                        <c:url value="/api/subjects/${sj.id}" var="eD" />
                        <button onclick="deleteSubject('${eD}', ${sj.id})" class="btn btn-danger btn-outline-light rounded-pill">
                            &times;
                        </button>
                    </td>
                </tr>
            </tbody>
        </c:forEach>
    </table>

    <a class="btn btn-info m-1 btn-outline-light rounded-pill" href="<c:url value="/subjects" />">Add subject</a>

    <a class="btn btn-info m-1 btn-outline-light rounded-pill" href="<c:url value="/users" />">Add lecturer</a>
</section>
