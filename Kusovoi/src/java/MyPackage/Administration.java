/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Лапа
 */
public class Administration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PhoneDAO phoneDAO = new PhoneDAO();
        List <PhoneBaseItem> allItems = null; 
        allItems = new ArrayList<PhoneBaseItem>();
        allItems = phoneDAO.getAllEnttities();
        request.setAttribute("items", allItems);
        
        UserDAO userDAO = new UserDAO();
        List <User> allUsers = new ArrayList<User>();
        allUsers = userDAO.getAllEnttities();
        request.setAttribute("items1", allUsers);
        response.sendRedirect("admin.jsp");
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String mobNumber = request.getParameter("mobNumber");
        String description = request.getParameter("description");
        String phoneNumber = request.getParameter("phoneNumber");
        String id = request.getParameter("id");
        
        String newUserName = request.getParameter("newUserName");
        String newUserPassword = request.getParameter("newUserPassword");
        String UserIdToDelite = request.getParameter("userIdToDelite");
        
        String editId = request.getParameter("editID");
        String editUserName = request.getParameter("editUserName");
        String editUserPassword = request.getParameter("editUserPassword");
        
        String editPhoneId = request.getParameter("editPhoneID");
        String editPhoneDescription = request.getParameter("editPhoneDescription");
        String editPhoneNumber = request.getParameter("editPhoneNumber");
        
        
        
        switch(request.getParameter("item"))
        {
            case "addForm" :{
        
        HttpSession session = request.getSession(true);
        try {
            PhoneDAO phoneDAO = new PhoneDAO();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            phoneDAO.addPhoneDetails(description, phoneNumber,mobNumber);
        } catch (Exception e) {
 
            e.printStackTrace();
        
                }
        break;
            }
            case "deleteForm":
            {
            HttpSession session = request.getSession(true);
        try {
            PhoneDAO phoneDAO = new PhoneDAO();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            phoneDAO.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
 
            e.printStackTrace();
        
                }
        break;
            }
            case "addUser":{
            
        HttpSession session = request.getSession(true);
        try {
            UserDAO userDAO = new UserDAO();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            userDAO.addUserDetails(newUserName, newUserPassword);
        } catch (Exception e) {
 
            e.printStackTrace();
        
                }
                break;
            }
            case "deleteUser":{
                HttpSession session = request.getSession(true);
        try {
            UserDAO userDAO = new UserDAO();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            userDAO.deleteById(Integer.parseInt(UserIdToDelite));
        } catch (Exception e) {
 
            e.printStackTrace();
        
                }
            break;
            }
            case"editUser":
            {
                HttpSession session = request.getSession(true);
        try {
            UserDAO userDAO = new UserDAO();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            userDAO.editUserDetails(editUserName, editUserPassword, Integer.parseInt(editId));
        } catch (Exception e) {
 
            e.printStackTrace();
        
                }
            break;
            }
            case "editPhone":
            {
                   HttpSession session = request.getSession(true);
        try {
            PhoneDAO phoneDAO = new PhoneDAO();
            //userDAO.addUserDetails(userName, password, email, phone, city);
            phoneDAO.editPhoneDetails(editPhoneDescription, editPhoneNumber, Integer.parseInt(editPhoneId));
        } catch (Exception e) {
 
            e.printStackTrace();
        
                }
            break;
            }
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
