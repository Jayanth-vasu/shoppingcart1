<%@include file="/WEB-INF/views/header.jsp"%>

<script>
	var app = angular.module('myCart', []);
	app.controller('cartController', function($scope, $http) {
		$http({
			method : 'GET',
			url : 'http://localhost:8089/jvsmartwatches/mycartlist'
		}).success(function(data, status, headers, config) {
			$scope.myCart = data;
		});
	

	$scope.getTotal = function(){
	    var totalPrice = 0;
	    for(var i = 0; i < $scope.myCart.length; i++){
	    	 totalPrice += $scope.myCart[i].productPrice;
	    }
	    return totalPrice;
	}
	
	});
	
	function goBack() {
		window.history.back();
	}
</script>
<style>
#addtocart {
	background-color: tomato; /* Green */
	border: none;
	color: white;
	padding: 18px 8px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	width: 98%;
}

#wrap {
	background-color: black;
	width: 10px;
	border: 25px solid black;
	padding: 25px;
	margin: 25px;
}

.panel {
	 background-color:#555;
	color: white; 
	
	   /*  border: 5px solid black; */
	   
	   
}
</style>
<script >
function goBack() {
	window.history.back();
}

</script>
<div class="container">
<div class="row">
		<div class="col-xs-8">
			<a href="<c:url value='/index' />"><button type="button" class="btn btn-primary" >Continue shopping</button></a>
		</div>
		
		<div class="col-xs-4" align="right">
			<a href="<c:url value='/clearall' />"><button type="button" class="btn btn-primary" >Clear all</button></a>
		</div>
</div>
</div>
<h1>
	<center>My Cart</center>
</h1>
<div class="container" data-ng-app="myCart"
	data-ng-controller="cartController">
	<div class="row">

		<div class="col-xs-9">
			<table class="table">
				<thead>
					<tr>
						<th>Product</th>
						<th>Quantity</th>
						<th class="text-center">Price</th>

						<th> </th>
					</tr>
				</thead>

				<tbody>

					<tr data-ng-repeat="cart in myCart">

						<td class="col-xs-12">
							<div class="row">
								<div class="col-xs-5">
									<a class="pull-left" href="#"> <img
										src="<c:url value="/resources/img/{{cart.imagename}}"/>"">
									</a>
								</div>

								<div class="col-xs-5">
									<h4>{{cart.productName}}</h4>
									<h5>by {{cart.productbrand}}</h5>
								</div>
							</div>

						</td>
						<td class="col-xs-1" style="text-align: center"><input
							type="number" class="form-control text-center" value="1">
						</td>
						<td class="col-sm-1" style="text-align: center"><strong>{{cart.productPrice}}</strong></td>

						<td class="col-sm-1" style="text-align: center"><a
							href="<c:url value='/removecartproduct/{{cart.cart_id}}' />">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button>
						</a></td>

					</tr>


					<!-- <tr>
						<td> </td>
						<td> </td> -->

					<%-- <td><h3>Total</h3></td>

						<td class="text-right"><h3>
								<strong>{{getTotal()}}</strong>
							</h3></td>




					</tr>
					<tr>

						<td> </td>
						<td> </td>
						<td><a href="<c:url value='/clearall' />">
								<button type="button" class="btn btn-warning">
									<span class="glyphicon glyphicon-shopping-cart"></span> Clear
									all
								</button>
						</a></td>
						<td><a href="index">
								<button type="button" class="btn btn-primary">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Continue Shopping
								</button>
						</a></td>
						<td><a href="<c:url value='/checkout' />">
								<button type="button" class="btn btn-success">
									Checkout <span class="glyphicon glyphicon-play"></span>
								</button>
						</a></td>
					</tr> --%>

				</tbody>

			</table>


		</div>

		<div class="col-xs-3">

			<div class="panel">

				<h3 style="text-align: center">Order Summary</h3>
				<hr>

				<div class="panel-body">
					<div class="row">
					<div class="col-xs-6">
						<h5>ORDER:</h5>
					</div>
					<div class="col-xs-6"><h5>Rs.{{getTotal()}}</h5></div>
					</div>
					
					<div class="row">
					<div class="col-xs-6">
						<h5>SHIPPING:</h5>
					</div>
					<div class="col-xs-6"><h5>FREE</h5></div>
					<hr>
					</div>
					
					<div class="row">
					<div class="col-xs-6">
						<h5>TAX:</h5>
					</div>
					<div class="col-xs-6"><h5>NIL</h5></div>
					
					</div>
					
					<div class="row">
					<hr>
					<div class="col-xs-6">
					
						<h5>TOTAL:</h5>
					</div>
					<div class="col-xs-6"><h5>Rs.{{getTotal()}}</h5></div>
					</div>
					<a href="<c:url value='/checkout' />"><button id="addtocart">CHECKOUT</button></a>
				</div>

			</div>
		</div>
	</div>
</div>



</body>
</html>