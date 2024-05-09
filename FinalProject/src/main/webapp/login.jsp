<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="assets/stylesheets/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/stylesheets/assign.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="assign">
            <div class="container">
                <div class="login-form form">
                    <p class="form-title">Login to continue</p>
                    <form action="login" method="POST">
                        <div class="input-block form-block">
                            <label for="email" class="form-lbl">Email</label>
                            <input type="email" id="email" name="email" class="form-txt" required=""/>
                        </div>
                        <div class="input-block form-block">
                            <label for="password" class="form-lbl">Password</label>
                            <input type="password" id="password" name="password" class="form-txt" required=""/>
                        </div>
                        <p class="form-err">${LOGIN_ERROR}</p>
                        <div class="form-block">
                            <input type="submit" class="form-btn" value="Login"/>
                        </div>
                    </form>
                    <a href="signup.jsp" class="txt-link">Go to Sign up</a>
                </div>
            </div>
        </section>
    </body>
</html>
