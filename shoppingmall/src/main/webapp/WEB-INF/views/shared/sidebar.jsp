<div class="left-sidebar">
	<h2>Category</h2>
	<div class="panel-group category-products" id="accordian">
		<div class="panel panel-default">
			<c:forEach items="${categories}" var="category">
				<a href="${contextRoot}/show/category/${category.id}/products"
					id="a_${category.name}" class="list-group-item">${category.name}</a>
			</c:forEach>
		</div>
	</div>

	<div class="brands_products">
		<!--brands_products-->
		<h2>Brands</h2>
		<div class="brands-name">
			<ul class="nav nav-pills nav-stacked">
				
					<li><a href="#">
						 <span class="pull-right">(10)</span>Apple
					</a></li>
					<li><a href="#">
						 <span class="pull-right">(2)</span>Sony
					</a></li>
					<li><a href="#">
						 <span class="pull-right">(4)</span>Sam Sung
					</a></li>
					<li><a href="#">
						 <span class="pull-right">(30)</span>Oppo
					</a></li>
					<li><a href="#">
						 <span class="pull-right">(10)</span>Television
					</a></li>
					<li><a href="#">
						 <span class="pull-right">(2)</span>MP3 Player
					</a></li>
					<li><a href="#">
						 <span class="pull-right">(4)</span>Air Conditioner
					</a></li>
					<li><a href="#">
						 <span class="pull-right">(30)</span>Tablet
					</a></li>
				
			</ul>
		</div>
	</div>
	<!--/brands_products-->
	
	

</div>