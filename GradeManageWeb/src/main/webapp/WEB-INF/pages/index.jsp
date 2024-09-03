<%-- 
    Document   : index
    Created on : Sep 1, 2024, 10:49:09 PM
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
                    <td></td>
                    <td></td>
                    <td>
                        <c:url value="/subjects/${sj.id}" var="e" />
                        <a href="${e}" class="btn btn-success">&orarr;</a>

                        <c:url value="/api/subjects/${sj.id}" var="eD" />
                        <button onclick="deleteSubject('${eD}', ${sj.id})" class="btn btn-danger">&times;</button>
                    </td>
                </tr>
            </tbody>
        </c:forEach>
    </table>

    <a class="btn btn-info m-1" href="<c:url value="/subjects" />">Add subject</a>
</section>