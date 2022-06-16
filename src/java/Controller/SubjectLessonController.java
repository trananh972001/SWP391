/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SubjectDAO;
import Dao.SubjectLessonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Lesson;
import model.Subject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SubjectLessonController", urlPatterns = {"/SubjectLesson"})
public class SubjectLessonController extends HttpServlet {

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
        try {

            SubjectLessonDAO subjectLessonDAO = new SubjectLessonDAO();
            SubjectDAO SubjectDao = new SubjectDAO();
            List<Subject> listSubject= SubjectDao.getAllSubject();
            request.setAttribute("listSubject", listSubject);
               //String subID = request.getParameter("id");
                if (request.getParameter("id") != null) {
                int subID = Integer.parseInt(request.getParameter("id"));
                List<Lesson> getLessonBySubID = subjectLessonDAO.getLessonBySubID(subID);
                System.out.println(new SubjectLessonDAO().getLessonBySubID(1).size());
                request.setAttribute("listLesson", getLessonBySubID);
                int subjectID = Integer.parseInt(request.getParameter("subjectID"));
                request.setAttribute("select", subjectID);
                request.getRequestDispatcher("SubjectLesson.jsp").forward(request, response);
                
            }

            List<Lesson> listLesson = subjectLessonDAO.getLessonBySubID(1);
            //System.out.println(new SubjectLessonDAO().getLessonBySubID(1).size());
            request.setAttribute("select", "subjectid");
            request.setAttribute("listLesson", listLesson);           
            request.getRequestDispatcher("SubjectLesson.jsp").forward(request, response);
        } catch (Exception e) {
        }
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
