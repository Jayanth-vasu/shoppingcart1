<%@include file="/WEB-INF/views/header.jsp"%>
<h1><center>My Cart</center></h1>
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

<div class="container"data-ng-app="myCart"
	data-ng-controller="cartController">
    <div class="row">
    
        <div class="col-sm-12 col-md-10 col-md-offset-1">
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
                        <div >
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="<c:url value="/resources/img/{{cart.imagename}}"/>" style="width: 72px; height: 72px;"> </a>
                         <div></div>
                            <div >
                                <h4 ><a href="#">{{cart.productName}}</a></h4>
                                <h5 > by <a href="#">{{cart.productbrand}}</a></h5>
                              
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                       	<input type="number" class="form-control text-center" value="1"> 
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>{{cart.productPrice}}</strong></td>
                       
                        <td class="col-sm-1 col-md-1">
                       <a href="<c:url value='/removecartproduct/{{cart.cart_id}}' />"> <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></a></td>
                    </tr>
              
                   
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        
                        <td><h3>Total</h3></td>
                        
                        <td class="text-right"><h3><strong>{{getTotal()}}</strong></h3></td>
                      
                        
                        
                        
                    </tr>
                    <tr>
                        
                        <td>   </td>
                        <td>   </td>
                        <td>
                        
                        <a href="<c:url value='/clearall' />"> <button type="button" class="btn btn-warning">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Clear all
                        </button></a></td>
                        <td>
                       <a href="index"> <button type="button" class="btn btn-primary">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></a></td>
                        <td><a href="<c:url value='/checkout' />">
                        <button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></a></td>
                    </tr>
                 
                </tbody>
               
            </table>
        
        
        </div>
        
    </div>
    </div>
</body>
</html>