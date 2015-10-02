<%@page import="MyPackage.User"%>
<%@page import="MyPackage.UserDAO"%>
<%@page import="MyPackage.PhoneBaseItem"%>
<%@page import="java.util.List"%>
<%@page import="MyPackage.PhoneDAO"%>
<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<style>
   <%@include file='style.css' %>
</style>

<%if(session.getAttribute("login").equals("admin")){%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Админка</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/bootstrap.js"></script>
    </head>
    <body>
    <div class="container">
        <div clas="row">
    <div class="col-md-12">
	<h1 class="text-center">Админка</h1>    	
    </div>
    <div class="col-md-6">
        
        
        <form class="form-admin" action="Administration" method="post">
        <h2 class="form-admin-heading">Добавление телефона:</h2>
             <INPUT TYPE=hidden NAME=item VALUE=addForm>
        <label for="description">Введите описание :</label>
                <input type="text" class="form-control" name="description" size="30" required = "true"/>
            <label for="phoneNumber">Введите номер :</label>
                <input type="text" class="form-control" name="phoneNumber" size="30" required = "true"/>
       <label for="phoneNumber">Введите моб.номер :</label>
                <input type="text" class="form-control" name="mobNumber" size="30" required = "true"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form>
        
        
        <form class="form-admin" action="Administration" method="post">
            <h2 class="form-admin-heading">удаление телефона по id:</h2>
             <INPUT TYPE=hidden NAME=item VALUE=deleteForm>
        <label for="id">Id для удаления :</label>
               <input type="text" class="form-control" name="id" size="30" required = "true"/>
            
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form>
        
        <form class="form-admin" action="Administration" method="post">
              <h2 class="form-admin-heading">Добавление пользователя:</h2>
             <INPUT TYPE=hidden NAME=item VALUE=addUser>
        <label for="newUserName">Введите email :</label>
                <input type="text" class="form-control" name="newUserName" size="30" required = "true"/>
            <label for="newUserPassword">Введите пароль:</label>
                <input type="text" class="form-control" name="newUserPassword" size="30" required = "true"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form>
        
        <form class="form-admin" action="Administration" method="post">
              <h2 class="form-admin-heading">Удаление пользователя по id:</h2>
             <INPUT TYPE=hidden NAME=item VALUE=deleteUser>
        <label for="userIdToDelite">Id для удаления :</label>
                <input type="text" class="form-control" name="userIdToDelite" size="30" required = "true"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form>
        
        <form class="form-admin" action="Administration" method="post">
              <h2 class="form-admin-heading">Редактирование пользователей:</h2>
             <INPUT TYPE=hidden NAME=item VALUE=editUser>
        <label for="editID">введиите id :</label>
        <input type="text" class="form-control" name="editID" size="30" required = "true"/>
            <label for="editUserName">Введите имя :</label>
                <input type="text" class="form-control" name="editUserName" size="30" required = "true"/>
            <label for="editUserPassword">Ведите пароль:</label>
                <input type="text" class="form-control" name="editUserPassword" size="30" required = "true"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form> 
          
        <form class="form-admin" action="Administration" method="post">
              <h2 class="form-admin-heading">Изменение данных телефона:</h2>
             <INPUT TYPE=hidden NAME=item VALUE=editPhone>
             <label for="editPhoneID">Введите id :</label>
                <input type="text" class="form-control" name="editPhoneID" size="30" required = "true"/>
            <label for="editPhoneDescription">Введите описание :</label>
                <input type="text" class="form-control" name="editPhoneDescription" size="30" required = "true"/>
            <label for="editPhoneNumber">Введите номер :</label>
                <input type="text" class="form-control" name="editPhoneNumber" size="30" required = "true"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form>   
             </div>
             <div class="col-md-6">
        <div >
         
          <table id="table228" class="table-content">
              <tr>
                <th id="th1">ID</th>
                <th id="th1">Number</th>
                <th id="th1">Mob.Number</th>  
                <th id="th1">Description</th>
            </tr>
    <%
                PhoneDAO phoneDAO = new PhoneDAO();
                List <PhoneBaseItem> allItems = null; 
                //allItems.clear();
                allItems = phoneDAO.getAllEnttities();
                for(PhoneBaseItem item : allItems)
                {%>
                <tr>
                    <td><%=item.getId()%></td>
                    <td><%=item.getPhoneNumber()%></td>
                    <td><%=item.getMobNumber()%></td>
                    <td><%=item.getDescription()%></td>
                </tr>
                <%    
                }
                %>
    </table>    
          <br>
          </div>
        <div>
          
            
            <table id="table228" class="table-content">
                <tr>
                <th id="th1">ID</th>
                <th id="th1">NickName</th>
                <th id="th1">Password</th>
            </tr>
    <%
                UserDAO userDAO = new UserDAO();
                List <User> allItems1 = null; 
                //allItems.clear();
                allItems1 = userDAO.getAllEnttities();
                for(User item : allItems1)
                {%>
                <tr>
                    <td><%=item.getId()%></td>
                    <td><%=item.getUserName()%></td>
                    <td><%=item.getPassword1()%></td>
                </tr>
                <%    
                }
                %>
    </table>
            </div>
            </div>
</div>
          </div>
    </body>
</html>
<%}%>
<%if(!session.getAttribute("login").equals("admin")){%>
<html>
    <body>
    <h1>Вы не админ сударь!</h1>
    </body>
</html>
<%}%>