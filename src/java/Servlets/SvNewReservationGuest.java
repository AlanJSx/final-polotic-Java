/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controller;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SvNewReservationGuest", urlPatterns = {"/SvNewReservationGuest"})
public class SvNewReservationGuest extends HttpServlet {

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
        processRequest(request, response);
        
        HttpSession mySession = request.getSession();
        
        Controller control = new Controller();
        
              
        String dni = request.getParameter("dni");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String adress = request.getParameter("adress");
        String career = request.getParameter("career");
        String birthDate = request.getParameter("birthDate");
        String checkIn = (String) request.getSession().getAttribute("checkIn");
        String checkOut = (String) request.getSession().getAttribute("checkOut");
        int numberPeople = (int) request.getSession().getAttribute("numberPeople");
        //int numberNights = 2;  // calcular cantidad de noches
        
        String selectedRoom = (String) request.getSession().getAttribute("selectedRoom");
        
        String userEmployee = (String) request.getSession().getAttribute("jspUser");
       
        try {
            control.newReservation(dni, name, lastName, adress, career, birthDate, checkIn, checkOut, numberPeople,  selectedRoom, userEmployee);
        } catch (ParseException ex) {
            Logger.getLogger(SvNewReservationGuest.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("reservationComplete.jsp");


        
        
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
