/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controller;
import Logica.Guest;
import Logica.Room;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alanl
 */
@WebServlet(name = "SvCheckGuest", urlPatterns = {"/SvCheckGuest"})
public class SvCheckGuest extends HttpServlet {

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
        
        String dni = request.getParameter("dni");
        String selectRoom = (String) request.getSession().getAttribute("selectedRoom");
        int selectRoomId = Integer.parseInt(selectRoom.replace(" ","")); 
        
        Room selectedRoom = control.getRoom(selectRoomId);
        request.getSession().setAttribute("selectedRoomName", selectedRoom.getRoomName());
        if (control.findGuestDni(dni)){
            Guest guestFound = control.getGuest(dni);
            //boolean guestExist = true;
            //request.getSession().setAttribute("guestExist", guestExist);
            request.getSession().setAttribute("guestName", guestFound.getName());
            request.getSession().setAttribute("guestLastname", guestFound.getLastName());
            request.getSession().setAttribute("guestAdress", guestFound.getAdress());
            request.getSession().setAttribute("guestCareer", guestFound.getCareer());
            request.getSession().setAttribute("guestBirth", control.convertDatetoString(guestFound.getBirthDate()));
            
            request.getSession().setAttribute("dniGuest", dni);
            
            
            response.sendRedirect("reservationGuestFound.jsp");
        } else {
            request.getSession().setAttribute("dniGuest", dni);
            response.sendRedirect("reservationNewGuest.jsp");
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
