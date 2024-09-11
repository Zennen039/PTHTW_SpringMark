<%-- 
    Document   : userdetails
    Created on : Sep 5, 2024, 9:57:24 AM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">User Details</h1>

<c:forEach var="detail" items="${userdetails}">
    <div class="mb-3">
        <h2>${detail.studentName}</h2>

        <p><strong>MSSV:</strong> ${detail.studentId}</p>

        <ul>
            <li>
                <strong>Điểm giữa kỳ:</strong> ${midtermScore}<br>
                <strong>Điểm cuối kỳ:</strong> ${finalScore}
            </li>
        </ul>
        <hr>
    </div>
</c:forEach>
