<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/app.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <div class="container">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h2>
        </c:if>

        <h2>Product List</h2>
        <h4 class="text-center"><a href="${contextPath}/add-product">Add a product</a></h4>

        <br/>

        <div id="btnContainer">
            <button class="btn" onclick="listView()"><i class="fa fa-bars"></i> List</button>
            <button class="btn active" onclick="gridView()"><i class="fa fa-th-large"></i> Grid</button>
            <form method="GET" action="${contextPath}/search-product">
                <div id="cover">
                    <div class="tb">
                        <div class="td"><input type="text" id="searchData" name="searchData" placeholder="Search"></div>
                        <div class="td" id="s-cover">
                            <button onclick="submit">
                                <div id="s-circle"></div>
                                <span></span>
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <br>
        <form id="detailForm" method="GET" action="${contextPath}/detail-product">
            <c:if test="${not empty lists}">
                <c:forEach var="item" items="${lists}" varStatus="loopCounter">
                    <c:if test="${loopCounter.count %3 != 0}">
                        <div class="row">
                    </c:if>
                    <div class="wrapper column">
                        <div class="product-img">
                            <img src="${item.image}" alt="Red dot" />
                        </div>
                        <div class="product-info">
                            <div class="product-text">
                                <h1 class="wrapText">${item.name}</h1>
                                <h2>by TuTran and friends</h2>
                                <p>${item.description}</p>
                            </div>
                            <div class="product-price-btn">
                                <p><span>${item.price}</span>$</p>
                                <button type="button" onclick="moveToDetail(${item.id})">buy now</button>
                            </div>
                        </div>
                    </div>

                    <c:if test="${loopCounter.count %3 == 0}">
                        </div>
                    </c:if>
                </c:forEach>
            </c:if>
        </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script>
        // Get the elements with class="column"
        var elements = document.getElementsByClassName("column");

        // Declare a loop variable
        var i;

        // List View
        function listView() {
            for (i = 0; i < elements.length; i++) {
                // elements[i].style.width = "100%";
            }
        }

        // Grid View
        function gridView() {
            for (i = 0; i < elements.length; i++) {
                elements[i].style.width = "327px";
            }
        }

        /* Optional: Add active class to the current button (highlight it) */
        var container = document.getElementById("btnContainer");
        var btns = container.getElementsByClassName("btn");
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", function() {
                var current = document.getElementsByClassName("active");
                current[0].className = current[0].className.replace(" active", "");
                this.className += " active";
            });
        }

        // Detail product
        function moveToDetail(id) {
            $('#detailForm').append('<input type="hidden" name="productId" value="' + id + '" />');
            $("#detailForm").submit();
        }
    </script>
</body>
</html>
