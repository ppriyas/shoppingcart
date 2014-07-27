<!doctype html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Shopping Cart</title>
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<div class="container">
    <h1>Shopping Cart</h1>
    <form:form id="entry_form" method="post" action="/addorupdate" commandName="cartitem" role="form">
        <div class="form-group">
            <form:label path="productName">Product Name:</form:label>
            <form:input id="productName" path="productName" class="form-control" placeholder="Product Name"/>
        </div>
        <div class="form-group">
            <form:label path="price">Price:</form:label>
            <form:input id="price" path="price" class="form-control" placeholder="Price"/>
        </div>
        <div class="form-group">
            <form:label path="quantity">Quantity:</form:label>
            <form:input id="quantity" path="quantity" class="form-control" placeholder="Quantity"/>
        </div>
        <form:hidden id="id" path="id"/>
        <button type="submit" class="btn btn-default">Save Item</button>
    </form:form>

    <c:if test="${!empty cartitems}">
        <h3>Cart Items</h3>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>&nbsp;</th>
                <th>&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cartitems}" var="cartitem">
                <tr>
                    <td>${cartitem.productName}</td>
                    <td>${cartitem.price}</td>
                    <td>${cartitem.quantity}</td>
                    <td>
                        <form:form action="delete/${cartitem.id}" method="post"><input type="submit"
                                                                                   value="Delete"/>
                        </form:form>
                    </td>
                    <td>
                        <form:form action="load/${cartitem.id}" method="get"><input type="submit"
                                                                          value="Update"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>