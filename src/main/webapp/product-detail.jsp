<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="${contextPath}/resources/css/product-detail.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div id="container">

        <!-- Start	Product details -->
        <div class="product-details">
            <!-- 	Product Name -->
            <h1 class="wrapText">${product.name}</h1>
            <!-- 		<span class="hint new">New</span> -->
            <!-- 		<span class="hint free-shipping">Free Shipping</span> -->
            <!-- 		the Product rating -->
            <span class="hint-star star">
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star" aria-hidden="true"></i>
            <i class="fa fa-star-half-o" aria-hidden="true"></i>
            <i class="fa fa-star-o" aria-hidden="true"></i>
        </span>
            <!-- The most important information about the product -->
            <p class="information">${product.description}</p>
            <!-- Control -->
            <div class="control">
                <!-- Start Button buying -->
                <button class="btn">
                    <!-- 		the Price -->
                    <span class="price">${product.price} $</span>
                    <!-- 		shopping cart icon-->
                    <span class="shopping-cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>
                    <!-- 		Buy Now / ADD to Cart-->
                    <span class="buy">Buy Now</span>
                </button>
                <!-- End Button buying -->
            </div>
        </div>
        <!-- 	End	Product details   -->

        <!-- 	Start product image & Information -->
        <div class="product-image">
            <img src="${product.image}" alt="Red dot" />
            <!-- 	product Information-->
            <div class="info">
                <h2>The Description</h2>
                <ul>
                    <li><strong>Sun Needs: </strong>Full Sun</li>
                    <li><strong>Soil Needs: </strong>Damp</li>
                    <li><strong>Zones: </strong>9 - 11</li>
                    <li><strong>Height: </strong>2 - 3 feet</li>
                    <li><strong>Blooms in: </strong>Mid‑Summer - Mid‑Fall</li>
                    <li><strong>Features: </strong>Tolerates heat</li>
                </ul>
            </div>
        </div>
        <!--  End product image  -->
    </div>
</body>
</html>
