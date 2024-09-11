<%-- 
    Document   : subjects
    Created on : Sep 3, 2024, 5:35:31 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">Subject Management</h1>

<c:url value="/subjects" var="action"/>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="subject">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="mb-3">
        <label for="name" class="form-label">Subject name: </label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name" />
    </div>

    <div class="mb-3">
        <label for="des" class="form-label">Subject description: </label>
        <form:input path="description" type="text" class="form-control" id="des" placeholder="Enter description" name="description" />
    </div>

    <div class="mb-3">
        <label for="browser" class="form-label">Lecturer: </label>
        <form:select class="form-select" path="lecturerId" >
            <c:forEach items="${subjects}" var="s">
                <c:choose>
                    <c:when test="${s.id == subject.lecturerId.id}">
                        <option value="${s.id}" selected>${s.lecturerName}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">${s.lecturerName}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </div>

    <div class="mb-3">
        <label for="browser" class="form-label">Category: </label>
        <form:select class="form-select" path="cateId" >
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id == subject.cateId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </div>

    <div class="mb-3">
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">
            <c:choose>
                <c:when test="${subject.id != null}">
                    <option value="${c.id}" selected>Update</option>
                </c:when>
                <c:otherwise>
                    Add
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
