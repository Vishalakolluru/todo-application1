<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="todo">Mobile Shopping</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="todo">Home</a></li>
	</ul>
  </div>
</nav>
 
   
   <form:form commandName="Task" method="post" action="storetask" >
   <p>true is for COMPLETED task,false is for PENDING</p>
       <table class="table table-bordered" >
           
           <tr><td><form:label path="tasktitle">title :</form:label></td>
               <td><form:input path="tasktitle"/>
               <font color="red"><form:errors path="tasktitle"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="description">Description :</form:label></td>
               <td><form:input path="description"/>
               <font color="red"><form:errors path="description"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="taskstatus">Task Status:</form:label></td>
               <td><select name="Task.id" >
   				 <option value="">---Select---</option>
   				 <c:forEach var="Task" items="${tasks}">
   				 <option value="${Task.id}">${Task.taskstatus}</option>
    		</c:forEach>
    		</select></td></tr>            
       </table>
      <input type="submit" value="submit" class="btn"/>
   </form:form>
</body>
</html> 