<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login/Registration</title>
    <head>
    
       <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %> 
        <s:url value="/static/login.css" var="mainCss" />
        

	<link href="${mainCss}" rel="stylesheet" />
    </head>
    <body>
        <h1 id="title"> Lover Login Form </h1>
        <p id="description" >Hey Buddy ! Thanks For Login To Share Your Experience  Which May Help Others In Anyways.</p>
     
     <!-- below line for action tag url -->
          <s:url var="loginUser" value="/user/login-user"/>
       
       <!-- model attribute is use bind user class data to this form  -->
         <!--  path to match user class object field to form  field -->
         <!--  ${registerUser}  to send total data to controller   -->
         
          <f:form id="survey-form" modelAttribute="userCommand" action="${loginUser}" method="post">

            <p>Name:</p> 
            <f:input class="details" type="text" path="name" name="user_name" placeholder="Enter Your Name"/><br>
           
            <p>Email</p>
            <f:input class="details" type="text" path="email" name="user_name" placeholder="Enter Your Email"/><br>
            <p>Password</p> 
            <f:input class="details" type="text" path="password" name="user_name" placeholder="Enter Your Name"/><br>
           
            
            <br>

            <button type="submit" id="button" name="button">Login</button>
        </f:form>
    </body>
</html>