<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<jsp:include page="../common/header.jsp" />
<body>
<div class="container">
<div class="row justify-content-md-center">
   <h2>update article information</h2>
 </div>
      <form:form action="#" modelAttribute="article" method="post">

        <div class="form-group col-md-6">
          <label for="designation">Designation</label>
           <form:input type="text" path="designation" placeholder="input designation" id="designation" cssClass="form-control"/>
          </div>

          <div class="form-group col-md-6">
          <label for="type">Quantite</label>
           <form:input type="number" path="quantity" placeholder="input quantity" id="quantity" cssClass="form-control"/>
          </div>

         <div class="form-group col-md-6">
          <label for="price">Prix</label>
           <form:input type="number" path="price" placeholder="input price" id="price" cssClass="form-control"/>
          </div>


       	  <div class="form-group col-md-6">
          <button type="submit" class="btn btn-primary">Submit</button>
          </div>
      </form:form>
     </div>
 <jsp:include page="../common/footer.jsp" />
  <script>
    $(function () {
    $("#datepicker").datepicker();
    });
  </script>
     </body>
</html>
