/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controller;
import Logica.Employee;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alanl
 */
@WebServlet(name = "SvLoginPage", urlPatterns = {"/SvLoginPage"})
public class SvLoginPage extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

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
        
        Controller control = new Controller();
        control.adminUserCount();   
        //control.adminUser();
         //ontrol.automaticTestData();
            
        String jspUser = request.getParameter("jspUser");
        String jspPassword = request.getParameter("jspPassword");
        boolean validateUser = control.validateUser(jspUser, jspPassword);
        HttpSession mySession = request.getSession(true);
        if (validateUser){
            
            mySession.setAttribute(("jspUser"), jspUser);
            
            // esto no va acá, modificar en lo posible
            List<Employee> employeeList = control.getEmployeeList();
            
            mySession.setAttribute("employeeList", employeeList);
            
            response.sendRedirect("HomePage.jsp");
        } else {
            String alert = "Verifique sus credenciales";
            mySession.setAttribute("alert", alert);
            response.sendRedirect("login.jsp");
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
