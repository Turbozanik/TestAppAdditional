<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
    <%request.getSession().setAttribute("login", "guest");%>
    <div class="container">
    <div class="col-md-4">
    <form class="form-admin" action="register" method="post">
        <h2 class="form-admin-heading">Регистрация</h2>
         <INPUT TYPE=hidden NAME=item VALUE=registrationForm>
        <label for="userName">Email :</label>
        <input type="text" class="form-control" name="userName" size="30" required = "true" maxlength="15"/>
            <label for="password1">Пароль :</label>
                <input type="password" class="form-control" name="password1" size="30" required = "true" maxlength="15"/>
            <label for="password2">Подтверждение пароля :</label>
                <input type="password" class="form-control" name="password2" size="30" required = "true" maxlength="15"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегстрироваться</button>
    </form>
    <form class="form-admin" action="register" method="post">
        <INPUT TYPE=hidden NAME=item VALUE=content>
        <button class="btn btn-lg btn-warning btn-block" type="submit">Прейти к справочнику</button>
    </form>
        </div>
    
    
    <div class="col-md-4">
    <form class="form-admin" action="register" method="post">
    <h2 class="form-admin-heading">Вход</h2>
        <INPUT TYPE=hidden NAME=item VALUE=signInForm>
        <label for="signName">Email :</label>
                <input type="text" class="form-control" name="signName" size="30" required = "true" maxlength="15"/>
                <label for="signPassword">Пароль :</label>
                <input type="password" class="form-control" name="signPassword" size="30" required = "true" maxlength="15"/>
        <button class="btn btn-lg btn-success btn-block" type="submit">Войти</button>
    </form>
    </div>  
        <div class="col-md-4">
            <img src ="img/ZVONKI.png"
        </div>
    </form>
    </div>
    <div style="text-align: center">
        По всем вопросам пишите на : admin@gmail.com
    </div>
    </div>    
</body>
</html>
