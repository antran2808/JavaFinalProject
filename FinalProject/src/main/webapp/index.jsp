<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="assets/stylesheets/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/stylesheets/header.css" rel="stylesheet" type="text/css"/>
        <link href="assets/stylesheets/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:import url="assets/components/header.jsp">
        </c:import>
        <section id="home">
            <div class="home-container container">
                <div class="card-holder">
                    <c:forEach var="o" items="${ESTATE_LIST}">
                        <div class="card">
                            <div class="card-top">
                                <div class="card-img img">
                                    <img src="assets/images/${o.images}" alt=""/>
                                </div>
                            </div>
                            <div class="card-center">
                                <p class="card-name">${o.name}</p>
                                <p class="card-description">${o.description}</p>
                            </div>
                            <div class="card-bottom">
                                <p class="card-sell">Sell price: $${o.sellPrice}</p>
                                <p class="card-rent">Rent price: $${o.rentPrice}</p>
                            </div>
                            <a class="card-btn btn" href="estate?id=${o.id}">More detail</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <script src="assets/scripts/home.js" type="text/javascript"></script>
    </body>
</html>
