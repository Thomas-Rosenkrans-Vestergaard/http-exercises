package com.tvestergaard.htmlexercises;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/e6/headers")
public class Headers extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter writer = resp.getWriter();

        writer.print("<html>");
        writer.print("<body>");
        writer.print("<table>");
        writer.print("<tr><th>Header</th><th>Value</th></tr>");
        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            writer.print("<tr>");
            writer.print("<td>");
            writer.print(header);
            writer.print("</td>");
            writer.print("<td>");
            writer.print(req.getHeader(header));
            writer.print("</td>");
            writer.print("</tr>");
        }
        writer.print("</table>");
        writer.print("</body>");
        writer.print("</html>");

        writer.flush();
    }
}
