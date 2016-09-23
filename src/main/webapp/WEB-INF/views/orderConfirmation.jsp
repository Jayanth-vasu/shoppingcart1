<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Details</title>
</head>

<body>
	<div class="content">
		<fieldset>
			<legend>Confirm Details</legend>
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			
			<form:form modelAttribute="shippingAddress">
				
				<form:label path="">User name:</form:label>${pageContext.request.userPrincipal.name}
					<br />
				<br />
				
				<form:label path="street_name">Street name:</form:label>${shippingAddress.street_name}
					<br />
				<br />
				<form:label path="city">City:</form:label>${shippingAddress.city}
					<br />
				<br />
				<form:label path="state">State :</form:label>${shippingAddress.state}
					<br />
					<br />
				<form:label path="post_code">Postal code :</form:label>${shippingAddress.post_code}
					<br />
					<br />
				<form:label path="country">Country:</form:label>${shippingAddress.country}
					<br />
				<br />
				
				<c:forEach items="${cartItem}" var="item">
				
				<form:label path="country">product name:</form:label>${item.productName}
					<br />
				<br />
				
				<form:label path="country">product price:</form:label>${item.productPrice}
					<br />
				<br />
				
				
				<form:label path="country">quantity:</form:label>${item.quantity}
					<br />
				<br />
				
				
				<form:label path="country">product brand:</form:label>${item.productbrand}
					<br />
				<br />
				
				</c:forEach>
								
				
				
				
				
				
				<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
				<input name="_eventId_edit" type="submit" value="Edit" />
				<input name="_eventId_submit" type="submit" value="Confirm Details" />
				<br />
			</form:form>
		</fieldset>
	</div>
</body>

</html>