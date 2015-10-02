<%-- 
    Document   : UserPanel
    Created on : Jun 3, 2015, 12:01:58 AM
    Author     : Лапа
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>User panel</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
    </head>
    <body>
        <div class="form-user">
        Личный кабинет пользователя<br>    
        Вы вошли как: ${login}<br>
        Ваш пароль: ${pass}
        <form class="form-admin" action="Sucess">
            <INPUT TYPE=hidden NAME=item VALUE=toContentJsp>
            <button class="btn btn btn-primary btn-block" type="submit">К контенту</button>
        </form>
        <form class="form-admin" action="UserPanel" method="post">
               <INPUT TYPE=hidden NAME=item VALUE=addPhone>
            <label for="phoneDescriptionForSort">Введите номер:</label>
            <input type="text" class="form-control" name="phoneNumber" size="30" required = "true" style="margin-bottom: 10px" maxlength="15"/>
            <label for="phoneDescriptionForSort">Введите моб.номер:</label>
            <input type="text" class="form-control" name="mobNumber" size="30" required = "true" style="margin-bottom: 10px" maxlength="15"/>
            <label for="phoneDescriptionForSort">Введите описание:</label>
            <input type="text" class="form-control" name="description" size="30" required = "true" style="margin-bottom: 10px" maxlength="15"/>
                <button class="btn btn btn-primary btn-block" type="submit">Добавить</button>
             </form>
        </div>
    </body>
</html>
