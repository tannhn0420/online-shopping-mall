<!-- DataTable Bootstrap Script -->
<script src="${js}/angular.js"></script>

<!-- DataTable Bootstrap Script -->
<script src="${js}/productsController.js"></script>
<div class="container" ng-app="ShoppingApp"
	ng-controller="ProductController as pCtrl">

	<div class="row" ng-init="pCtrl.fetchProducts()">



		<div class="col-sm-12">

			<div id="slider-carousel" class="carousel slide" data-ride="carousel">

				<div class="col-sm-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						</ol>
						<div class="carousel-inner">

							<div class="item active">
								<img class="slide-image" src="${images}/banner1.jpg" alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/banner2.jpg" alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/banner3.jpg" alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${images}/banner4.jpg" alt="">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>

			</div>
		</div>

	</div>

	<div class="row" style="margin-top: 20px; margin-left: 2px;">

		<div class="col-sm-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<div class="col-sm-9 padding-right">
			<div class="features_items">
				<!--Our Most Viewed Products-->
				<h2 class="title text-center">FEATURES ITEMS</h2>
				<div class="col-sm-6" ng-repeat="product in pCtrl.mvProducts">
					<div class="product-image-wrapper">
						<div class="single-products">
							<div class="productinfo text-center">
								<img ng-src="${images}/{{product.code}}.jpg"
									alt="{{product.name}}" height="254px" />
								<h2>{{product.unitPrice}}$</h2>
								<p>{{product.name}}</p>
								<a ng-href="${contextRoot}/cart/add/{{product.id}}/product"
									class="btn btn-default add-to-cart"><i
									class="glyphicon glyphicon-eye-open"></i>View</a>
								<security:authorize access="hasAuthority('USER')">
									<a ng-href="${contextRoot}/cart/add/{{product.id}}/product"
										class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>

								</security:authorize>
								<security:authorize access="hasAuthority('ADMIN')">
									<a ng-href="${contextRoot}/manage/${product.id}/product"
										class="btn btn-warning add-to-cart"><i
										class="glyphicon glyphicon-pencil"></i>Edit</a>
								</security:authorize>
							</div>
							<div class="product-overlay">
								<div class="overlay-content">
									<h2>{{product.unitPrice}}$</h2>
									<p>{{product.name}}</p>
									<a ng-href="${contextRoot}/show/{{product.id}}/product"
										class="btn btn-default add-to-cart"><i
										class="glyphicon glyphicon-eye-open"></i>View</a>
									<security:authorize access="hasAuthority('USER')">
										<a ng-href="${contextRoot}/cart/add/{{product.id}}/product"
											class="btn btn-default add-to-cart"><i
											class="fa fa-shopping-cart"></i>Add to cart</a>

									</security:authorize>
									<security:authorize access="hasAuthority('ADMIN')">
										<a ng-href="${contextRoot}/manage/${product.id}/product"
											class="btn btn-warning add-to-cart"><i
											class="glyphicon glyphicon-pencil"></i>Edit</a>
									</security:authorize>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-sm-4 col-lg-4 col-md-4">
					<h4>Checkout more products!</h4>
					<hr />
					<a class="btn btn-primary" href="${contextRoot}/show/all/products">More
						Products</a>
				</div>

			</div>
		</div>

		<!-- Category tabs -->

		<div class="col-sm-12">
			<ul class="nav nav-tabs">
				<c:forEach items="${categories}" var="category">
					<li class="list-item"><a
						href="#show/category/${category.id}/products" data-toggle="tab">${category.name}</a></li>

				</c:forEach>
			</ul>
		</div>
		<div class="tab-content">
			<div class="tab-pane fade active in" id="1">

				<div class="col-sm-3">
					<div class="product-image-wrapper">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="images/home/gallery4.jpg" alt="" />
								<h2>$56</h2>
								<p>Easy Polo Black Edition</p>
								<a href="#" class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Add to cart</a>
							</div>

						</div>
					</div>
				</div>
			</div>

			<div class="tab-pane fade" id="2">
				<div class="col-sm-3">
					<div class="product-image-wrapper">
						<div class="single-products">
							<div class="productinfo text-center">
								<img src="images/home/gallery4.jpg" alt="" />
								<h2>$56</h2>
								<p>Easy Polo Black Edition</p>
								<a href="#" class="btn btn-default add-to-cart"><i
									class="fa fa-shopping-cart"></i>Add to cart</a>
							</div>

						</div>
					</div>
				</div>


				<div class="tab-pane fade" id="3">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery3.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-shopping-cart"></i>Add to cart</a>
								</div>

							</div>
						</div>
					</div>



				</div>
			</div>


			<div class="col-sm-4 col-lg-4 col-md-4">
				<h4>Checkout more products!</h4>
				<hr />
				<a class="btn btn-primary" href="${contextRoot}/show/all/products">More
					Products</a>
			</div>




		</div>
		<!-- /.container -->