<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../common/header.jsp" />
<body>
<div class="container">
	<br />
	 <a class="btn btn-dark btn-lg" href="articles/create" role="button">Valide le panier</a>
	 <br />
	 <br />
		<table class="table table-sarticleed table-hover">
		 <thead class="thead-dark">
          <tr>
              <th scope="col">Designation</th>
              <th scope="col">Quantite</th>
              <th scope="col" colspan="2">Actions</th>
          </tr>
          </thead>
          <tbody>
           <c:forEach var="cart" items="${cart}">
           <tr>
           <td>${cart.designationArticle}</td>
           <td>${cart.quantity}</td>
            <td><a href="cart/delete?id=${cart.idCart}" class="btn btn-danger" onclick="if (!(confirm('Are you sure ?'))) return false">Delete</a>
            </td>
           </td>
           </tr>
           </c:forEach>
           </tbody>
           </table>
</div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>