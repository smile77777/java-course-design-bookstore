package com.bookstore.servlet;

import com.bookstore.Dao.DaoImp.bookDaoImp;
import com.bookstore.Dao.DaoImp.userDaoImp;
import com.bookstore.Dao.bookDao;
import com.bookstore.Dao.userDao;
import com.bookstore.entity.User;
import com.bookstore.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/rootServlet")
public class rootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op=request.getParameter("op");
        request.setCharacterEncoding("utf-8");

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        switch (op){
            case "addbook":
                try {
                    addbook(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "changebook":
                try {
                    changebook(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case"delbook":
                try {
                    delbook(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "changeuser":
                try {
                    changeuser(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    public void addbook(HttpServletRequest request, HttpServletResponse response) throws Exception {
        book book=new book();
        bookDao bookDao=new bookDaoImp();
        book.setBookname(request.getParameter("book_name"));
        book.setBookanthor(request.getParameter("book_anthor"));
        book.setBookpress(request.getParameter("book_press"));
        book.setBooktime(request.getParameter("book_time"));
        book.setBookprice(request.getParameter("book_price"));
        book.setBookpriced(request.getParameter("book_priced"));
        book.setBookimage("images/"+request.getParameter("book_image"));
        book.setBooktype(request.getParameter("book_type"));
        bookDao.addbook(book);
        response.sendRedirect("rootpage/addbook.jsp");
    }
    public void delbook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        bookDao bookDao=new bookDaoImp();
        bookDao.delete(request.getParameter("bookid"));
        response.sendRedirect("rootpage/bookmanage.jsp");
    }
    public void changebook(HttpServletRequest request, HttpServletResponse response) throws Exception{
        bookDao bookDao=new bookDaoImp();
        book book=new book();
        book.setBookname(request.getParameter("book_name"));
        book.setBookanthor(request.getParameter("book_anthor"));
        book.setBookpress(request.getParameter("book_press"));
        book.setBooktime(request.getParameter("book_time"));
        book.setBookprice(request.getParameter("book_price"));
        book.setBookpriced(request.getParameter("book_priced"));
        book.setBookimage("images/"+request.getParameter("book_image"));
        book.setBooktype(request.getParameter("book_type"));
        bookDao.update(book,request.getParameter("bookid"));
        response.sendRedirect("rootpage/bookmanage.jsp");
    }
    public void changeuser(HttpServletRequest request, HttpServletResponse response) throws Exception{
        userDao userDao=new userDaoImp();
        User user=new User();
        user.setUsername(request.getParameter("uname"));
        user.setUseremail(request.getParameter("uemail"));
        user.setUsernumber(request.getParameter("unumber"));
        user.setUsersex(request.getParameter("usex"));
        user.setUsersite(request.getParameter("usite"));
        user.setType(request.getParameter("utype"));
        userDao.update(user,request.getParameter("userid"));
        response.sendRedirect("rootpage/usermanage.jsp");
    }
}
