package com.example.maktabhomeworks3;

import com.example.maktabhomeworks3.hw18.entity.Book;
import com.example.maktabhomeworks3.hw18.manager.BooKManager;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookServlet", value = "/book-servlet")
public class BookServlet extends HttpServlet {

    BooKManager booKManager = new BooKManager();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String publisher = request.getParameter("publisher");
        double price = Double.parseDouble(request.getParameter("price"));
        Book newBook = new Book(title, writer, price, publisher);
        booKManager.saveOrUpdate(newBook);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Saved Successfully" + "</h1>");
        out.println("</body></html>");
    }

}