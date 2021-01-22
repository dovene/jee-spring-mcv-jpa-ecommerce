<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../common/header.jsp" />
<body>
<div class="container">
	<br />
	 <a class="btn btn-dark btn-lg" href="articles/create" role="button">Add an article</a>
	 <br />
	 <br />
		<table class="table table-sarticleed table-hover">
		 <thead class="thead-dark">
          <tr><th scope="col">Id</th>
              <th scope="col">Designation</th>
              <th scope="col">Quantite</th>
              <th scope="col">PU</th>
              <th scope="col" colspan="2">Actions</th>
          </tr>
          </thead>
          <tbody>
           <c:forEach var="article" items="${articles}">
           <tr>
           <td>${article.id}</td>
           <td>${article.designation}</td>
           <td>${article.quantity}</td>
           <td>${article.price}</td>
           <td><a href="articles/edit/${article.id}" class="btn btn-info">Edit</a>
           <a href="articles/delete?id=${article.id}" class="btn btn-danger" onclick="if (!(confirm('Are you sure ?'))) return false">Delete</a>

           </td>
           </tr>
           </c:forEach>
           </tbody>
           </table>
</div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>