<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.col-item {
	border: 1px solid #E1E1E1;
	border-radius: 5px;
	background: #FFF;
}

.col-item .photo img {
	margin: 0 auto;
	width: 100%;
}

.col-item .info {
	padding: 10px;
	border-radius: 0 0 5px 5px;
	margin-top: 1px;
}

.col-item:hover .info {
	background-color: #F5F5DC;
}

.col-item .price {
	/*width: 50%;*/
	float: left;
	margin-top: 5px;
}

.col-item .price h5 {
	line-height: 20px;
	margin: 0;
}

.price-text-color {
	color: #219FD1;
}

.col-item .info .rating {
	color: #777;
}

.col-item .rating {
	/*width: 50%;*/
	float: left;
	font-size: 17px;
	text-align: right;
	line-height: 52px;
	margin-bottom: 10px;
	height: 52px;
}

.col-item .separator {
	border-top: 1px solid #E1E1E1;
}

.clear-left {
	clear: left;
}

.col-item .separator p {
	line-height: 20px;
	margin-bottom: 0;
	margin-top: 10px;
	text-align: center;
}

.col-item .separator p i {
	margin-right: 5px;
}

.col-item .btn-add {
	width: 50%;
	float: left;
}

.col-item .btn-add {
	border-right: 1px solid #E1E1E1;
}

.col-item .btn-details {
	width: 50%;
	float: left;
	padding-left: 10px;
}

.controls {
	margin-top: 20px;
}

[data-slide="prev"] {
	margin-right: 10px;
}
</style>

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>


<div class="container">
	<div class="row">
		<div class="row">
			<div class="col-md-9">
				<h3>Carousel Product Cart Slider</h3>
			</div>
			<div class="col-md-3">
				<!-- Controls -->
				<div class="controls pull-right hidden-xs">
					<a href="<c:url value="viewallproducts"/>"><button
							class="btn btn-primary">View all</button></a> <a
						class="left fa fa-chevron-left btn btn-success"
						href="#carousel-example" data-slide="prev"></a><a
						class="right fa fa-chevron-right btn btn-success"
						href="#carousel-example" data-slide="next"></a>
				</div>
			</div>
		</div>
		<p></p>
		<div id="carousel-example" class="carousel slide hidden-xs"
			data-ride="carousel">
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<div class="row">
					<c:forEach items="${listproduct}" var="pr">
						<div class="col-sm-3" >
							<div class="col-item">
								<div align="center">
									<img src="<c:url value="/resources/img/${pr.image_name}" />"
										class="img-responsive" alt="" />
								</div>
								<div class="info">
									<div class="row">
										<div class="price col-md-6">
											<h5>${pr.product_name}</h5>
											<h5 class="price-text-color">${pr.product_price}</h5>
										</div>
										<!--   <div class="rating hidden-sm col-md-6">
                                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                        </div> -->
									</div>
									<div class="separator clear-left">
										<p class="btn-add">
											<i class="fa fa-shopping-cart"></i><a
												href="http://www.jquery2dotnet.com" class="hidden-sm">Add
												to cart</a>
										</p>
										<p class="btn-details">
											<i class="fa fa-list"></i><a
												href="http://www.jquery2dotnet.com" class="hidden-sm">More
												details</a>
										</p>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
</c:forEach>
					</div>
				</div>

			</div>

		</div>
	</div>

</div>
