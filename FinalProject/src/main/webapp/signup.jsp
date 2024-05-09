<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up Page</title>
        <link href="assets/stylesheets/base.css" rel="stylesheet" type="text/css"/>
        <link href="assets/stylesheets/assign.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="assign">
            <div class="container">
                <div class="login-form form">
                    <p class="form-title">Sign up to continue</p>
                    <form action="signup" method="POST">
                        <div class="input-block form-block">
                            <label for="email" class="form-lbl">Email</label>
                            <input type="email" id="email" name="email" class="form-txt" required=""/>
                        </div>
                        <div class="input-block form-block">
                            <label for="password" class="form-lbl">Password</label>
                            <input type="password" id="password" name="password" class="form-txt" required=""/>
                        </div>
                        <div class="input-block form-block">
                            <label for="repassword" class="form-lbl">Confirm password</label>
                            <input type="password" id="repassword" name="repassword" class="form-txt" required=""/>
                        </div>
                        <div class="select-block form-block">
                            <label for="roleId" class="form-lbl">You are</label>
                            <select id="roleId" name="roleId" class="form-slc" required>
                                <option value="2">Customer</option>
                                <option value="1">Seller</option>
                            </select>
                        </div>
                        <p class="form-err">${SIGNUP_ERROR}</p>
                        <div class="form-block">
                            <input type="submit" class="form-btn" value="Sign up"/>
                        </div>
                    </form>
                    <a href="login.jsp" class="txt-link">Go to Log in</a>
                </div>
            </div>
        </section>
        <script src="assets/scripts/signup.js" type="text/javascript"></script>
    </body>
</html>
