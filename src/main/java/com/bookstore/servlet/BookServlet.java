package com.bookstore.servlet;

import com.bookstore.Dao.DaoImp.bookDaoImp;
import com.bookstore.Dao.bookDao;
import com.bookstore.entity.book;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import sun.plugin.dom.core.Element;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/bookservlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String op=request.getParameter("op");
        switch (op){
            case "add":add(request,response);
            break;
            case  "remove":
                try {
                    remove(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "rem":
                try {
                    remove2(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }

    }
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        bookDao bookDao=new bookDaoImp();
        String bookid=request.getParameter("bookno");

        Map<String,List<book>> map = (Map<String,List<book>>)request.getSession().getAttribute("bookmap");
        if(map==null)
        {
            map = new HashMap<String, List<book>>();
            try {
                map.put(bookid, bookDao.getBookbyId("1"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            try {
                map.put(bookid,bookDao.getBookbyId(bookid));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.getSession().setAttribute("bookmap", map);
        response.sendRedirect("product.jsp");
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bookid=request.getParameter("bookno");
        Map<String,List<book>> map = (Map<String,List<book>>)request.getSession().getAttribute("bookmap");
        map.remove(bookid);
        request.getSession().setAttribute("bookmap", map);
        response.sendRedirect("shopping.jsp");
    }
    public void remove2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("bookmap");
        response.sendRedirect("shopping.jsp");
    }
}
