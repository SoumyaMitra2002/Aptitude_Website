package com.tech.blog.servlets;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");

            String check = request.getParameter("check");
            if (check == null) {
                out.println("box not check");
            } else {
                String name = request.getParameter("user_name");
                String email = request.getParameter("user_email");
                String password = request.getParameter("user_password");
                String gender = request.getParameter("gender");
                String about = request.getParameter("about");

                if (email == null || password == null || name == null || gender == null) {
                    response.sendRedirect("error_page.jsp");
                } else {
                    User user = new User(name, email, password, gender, about);

                    UserDao dao = new UserDao(ConnectionProvider.getConnection());
                    if (dao.saveUser(user)) {
                        out.println("<h1>Done</h1>");
                        HttpSession s = request.getSession();

                        Message m = new Message("Registered Successfully", "success", "alert-success");
                        s.setAttribute("msg", m);
                        response.sendRedirect("login_page.jsp");

                    } else {
                        out.println("Error");
                        response.sendRedirect("error_page.jsp");
                    }
                }

                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RegisterServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
//
//            String check = request.getParameter("check");
//            if (check == null) {
//                out.println("box not check");
//            } else {
//                String name = request.getParameter("user_name");
//                String email = request.getParameter("user_email");
//                String password = request.getParameter("user_password");
//                String gender = request.getParameter("gender");
//                String about = request.getParameter("about");
//
//                User user = new User(name, email, password, gender, about);
//
//                UserDao dao = new UserDao(ConnectionProvider.getConnection());
//                if (dao.saveUser(user)) {
//                    out.println("Done");
//                } else {
//                    out.println("Error");
//                }
//
//                out.println("</body>");
//                out.println("</html>");
//            }
//        }
//    }
//
//}
