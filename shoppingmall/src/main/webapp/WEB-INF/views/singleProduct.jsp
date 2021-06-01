<div class="container">
	
	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>
	
	
	<div class="row">
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-responsive"/>
			</div>
		</div>
		
		<!-- Display the product description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name}</h3>
			<hr/>
			
			<p>${product.description }</p>
			<hr/>
			
			<h4>Price: <strong> &#129321; ${product.unitPrice}$</strong></h4>
			<hr/>
			
			
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h5>Qty. Available: <span style=" color:red">Out of stock!</span></h5>
				</c:when>
				<c:otherwise>
					<h5>Qty. Available: ${product.quantity}</h5>
				</c:otherwise>
			</c:choose>
			
			
			
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<a href="javascript:void(0)" class="btn btn-success disabled">
						<span class="glyphicon glyphicon-shopping-cart"><strike> Add to Cart</strike></span>
					</a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
						<span class="glyphicon glyphicon-shopping-cart"> Add to Cart</span>
					</a>
				</c:otherwise>
			</c:choose>
			
			
			
			
			<a href="${contextRoot}/show/all/products" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove"> Back</span>
			</a>
		</div>
	</div>
	
</div>