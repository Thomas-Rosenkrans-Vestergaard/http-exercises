package com.tvestergaard.htmlexercises;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/e8/cookies")
public class CookieDemo extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String name = request.getParameter("name");
        if (name != null) {
            Cookie cookie = new Cookie("username", name);
            cookie.setMaxAge(60 * 60 * 24 * 365);
            response.addCookie(cookie);
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("username")) {
                    name = cookie.getValue();
                }
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
/* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieDemo</title>");
            out.println("</head>");
            out.println("<body>");
            if (name != null) {
                out.println("<p> Welcome " + name + " !</p>");
            } else {
                out.println("<h2>Please enter your name, and submit</h2>");
                out.println("<form action='cookies'>");
                out.println("<input type='input' name='name'>");
                out.println("<input type='submit'></form>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}
