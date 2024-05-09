<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${ESTATE.name}</title>
        <link href="assets/stylesheets/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/stylesheets/header.css" rel="stylesheet" type="text/css"/>
        <link href="assets/stylesheets/detail.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:import url="assets/components/header.jsp">
        </c:import>
        <section id="detail">
            <div class="container">
                <div class="card">
                    <div class="card-top">
                        <div class="card-img img">
                            <img src="assets/images/${ESTATE.images}" alt=""/>
                        </div>
                    </div>
                    <div class="card-center">
                        <p class="card-name">${ESTATE.name}</p>
                        <p class="card-description">${ESTATE.description}</p>
                    </div>
                    <div class="card-bottom">
                        <p class="card-sell">Sell price: $${ESTATE.sellPrice}</p>
                        <p class="card-rent">Rent price: $${ESTATE.rentPrice}</p>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
