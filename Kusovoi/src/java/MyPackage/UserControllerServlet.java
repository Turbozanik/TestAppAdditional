package MyPackage;


 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 


public class UserControllerServlet extends HttpServlet {
     
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        
        Boolean isUsed = false;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password1");
        String passwordProof = request.getParameter("password2");

        String signName = request.getParameter("signName");
        String signPassword = request.getParameter("signPassword");
        
        switch(request.getParameter("item"))
        {
            case "registrationForm":{
           HttpSession session = request.getSession(true);
        try {
            UserDAO userDAO = new UserDAO();
            List <User> allItems = new ArrayList<User>();
            allItems = userDAO.getAllEnttities();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            for(User user : allItems)
            {
                if(user.getUserName().equals(userName))
                {
                    isUsed = true;
                }
            }
            if(isUsed == true || !password.equals(passwordProof))
            {
                   session.setAttribute("login", userName);
                   session.setAttribute("pass", password);
                   response.sendRedirect("ErrorRegister.jsp");
            }else{
            session.setAttribute("login",userName );
            session.setAttribute("pass", password);
            userDAO.addUserDetails(userName, password);
            response.sendRedirect("Sucess");
            }
        } catch (Exception e) {
 
            e.printStackTrace();
        }
            break;
        }
            case "signInForm":{
            /* TODO output your page here. You may use following sample code. */
                HttpSession session = request.getSession(true);
                if(signName.equals("admin") && signPassword.equals("admin"))
                {
                    request.getSession().setAttribute("login", "admin");
                    response.sendRedirect("Administration");
                }else {
                    UserDAO userDAO = new UserDAO();
                    List <User> allItems = new ArrayList<User>();
                    allItems = userDAO.getAllEnttities();
                    for(User user : allItems )
                    {
                        if(signName.equals(user.getUserName())&& signPassword.equals(user.getPassword1()))
                                {
                                    request.getSession().setAttribute("login", signName);
                                    session.setAttribute("pass", signPassword);
                                    response.sendRedirect("Sucess");
                                    break;
                                }
                        else{
                        request.getSession().setAttribute("login", "guest");
                        response.sendRedirect("Error.jsp");
                        break;
                        }
                    }
                }
            break;
            }
            case "content":
            {
                request.getSession().setAttribute("login", "guest");
                HttpSession session = request.getSession(true);
                PhoneDAO phone = new PhoneDAO();
                List <PhoneBaseItem> allItems = new ArrayList<PhoneBaseItem>();
                allItems = phone.getAllEnttities();
                response.sendRedirect("Sucess");
                break;
            }
        }
}
}
    

