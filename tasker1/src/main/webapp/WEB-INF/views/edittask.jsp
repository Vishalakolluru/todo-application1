<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

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
  <form:form  modelAttribute="Task" method="post" action="update" >
  <p>true is for COMPLETED task,false is for PENDING</p>
  <table>
     
      <tr><td><form:label path="tasktitle">TaskName :</form:label></td>
               <td><form:input path="tasktitle" value="${Task.tasktitle}"/></td>
               </tr>
           <tr><td><form:label path="description">Description :</form:label></td>
               <td><form:input path="description" value="${Task.description}"/></td>
           </tr>
           <tr><td><form:label path="taskstatus">Task Status:</form:label></td>
               <td><select name="Task.id" >
   				 <option value="">---Select---</option>
   				 <c:forEach var="Task" items="${tasks}">
   				 <option value="${Task.id}">${Task.taskstatus}</option>
    		</c:forEach>
    		</select></td></tr>
 		</table>  
 		<input type="submit" value="submit"/>    
  </form:form>  
   

</body>

</html>
