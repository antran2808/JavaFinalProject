<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<section id="header">
    <div class="header-container container">
        <div class="header-left">
            <ul class="nav-bar nav">
                <li class="nav-item">
                    <a href="home" class="nav-item-link">Home</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-item-link">Booking</a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-item-link">Edit post</a>
                </li>
            </ul>
        </div>
        <div class="header-right">
            <c:choose>
                <c:when test="${sessionScope.LOGIN_USER != null}">
                    <a href="user?id=${sessionScope.LOGIN_USER.id}" class="login-btn btn">${sessionScope.LOGIN_USER.email}</a>
                    <a href="logout" class="login-btn btn">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="login.jsp" class="login-btn btn">Login</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>