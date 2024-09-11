<%-- 
    Document   : users
    Created on : Sep 4, 2024, 10:33:24 PM
    Author     : nguye
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<h1 class="text-center text-info">User Management</h1>

<c:url value="/users" var="action"/>

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>

    <div class="mb-3">
        <label for="firstName">First Name: </label>
        <form:input class="form-control" id="firstName" placeholder="Your first name" path="firstName" />
    </div>

    <div class="mb-3">
        <label for="lastName">Last Name: </label>
        <form:input class="form-control" id="lastName" placeholder="Your last name" path="lastName" />
    </div>

    <div class="mb-3">
        <label for="email">Email: </label>
        <form:input class="form-control" id="email" placeholder="Your email" path="email" />
    </div>

    <div class="mb-3">
        <label for="phone">Phone number: </label>
        <form:input class="form-control" id="phone" placeholder="Your mobile phone" path="phone" />
    </div>

    <div class="mb-3">
        <label for="username">Username: </label>
        <form:input class="form-control" id="username" placeholder="Your username" path="username" />
    </div>

    <div class="mb-3">
        <label for="password">Password: </label>
        <form:input type="password" class="form-control" id="pass" placeholder="Your password" path="password" />
    </div>

    <div class="mb-3">
        <label for="password">Confirm </label>
        <form:input type="password" class="form-control" id="pass" placeholder="Confirm password" path="password" />
    </div>

    <div class="mb-3">
        <label for="avatar">Avatar: </label>
        <form:input class="form-control" id="avatar" type="file" path="file" />
        <form:errors path="file" cssClass="error" />
    </div>

    <div class="mb-3">
        <button type="submit" class="btn btn-success btn-outline-light rounded-pill">
            Add
        </button>
    </div>
</form:form>