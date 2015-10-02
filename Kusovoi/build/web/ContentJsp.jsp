
<%@page import="MyPackage.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MyPackage.PhoneBaseItem"%>
<%@page import="java.util.List"%>
<%@page import="MyPackage.PhoneDAO"%>
<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<style>
   <%@include file='style.css' %>
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Phone list</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
        <div class="col-md-3">
         <form class="form-admin" action="Sucess" method="post">
               <INPUT TYPE=hidden NAME=item VALUE=searchByNumber>
        
            <label for="phoneNumberForSort">Поиск телефона по немеру:</label>
            <input type="text" class="form-control" name="phoneNumberForSort" size="20" required = "true" style="margin-bottom: 10px"/>
                <button class="btn btn btn-primary btn-block" type="submit">Поиск</button>
             </form>
        
        <form class="form-admin" action="Sucess" method="post">
               <INPUT TYPE=hidden NAME=item VALUE=searchByDescription>
            <label for="phoneDescriptionForSort">Поиск телефона по описанию:</label>
            <input type="text" class="form-control" name="phoneDescriptionForSort" size="30" required = "true" style="margin-bottom: 10px"/>            
                <button class="btn btn btn-primary btn-block" type="submit">Поиск</button>
             </form>
        <form class="form-admin" action="Sucess" method="post">
               <INPUT TYPE=hidden NAME=item VALUE=orderByDescription>
            <label >Сортировка по описанию:</label>
                <button class="btn btn btn-primary btn-block" type="submit">Упорядочит по компании</button>
            </form>
            
        <form class="form-admin" action="Register.jsp">
            <INPUT TYPE=hidden NAME=item VALUE=toRegister>
            <button class="btn btn btn-primary btn-block" type="submit">К регистрации</button>
        </form>
        <form class="form-admin" action="UserPanel.jsp">
            <INPUT TYPE=hidden NAME=item VALUE=toUserPanel>
            <button class="btn btn btn-primary btn-block" type="submit">К кабинету пользователя</button>
        </form>
          
        </div>
  
        <div class="col-md-8 pdrs ">
            <table id="table228" class="table-content table-striped table">
    <tr>
                <th id="th1">ID</th>
                <th id="th1">Телефон</th>
                <th id="th1">Моб.Номер</th>
                <th id="th1">Описание</th>
            </tr>
    <%
                PhoneDAO phoneDAO = new PhoneDAO();
                List <PhoneBaseItem> allItems =  null; 
                //allItems.clear();
                //allItems = phoneDAO.getAllEnttities();
                allItems = (ArrayList<PhoneBaseItem>)request.getAttribute("items");
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
        <div>
            

            </div>
        </div>
                </div>
                <div style="text-align: center">
                По всем вопросам пишите на : admin@gmail.com
                </div>
</div>
            
    </body>
    
</html>
