package com.bookstore.servlet;

import com.bookstore.Dao.userDao;
import com.bookstore.entity.User;
import com.bookstore.service.serviceImp.userServiceImp;
import com.bookstore.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userservlet")
public class UserServlet extends HttpServlet {

    userService userService=new userServiceImp();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String op=request.getParameter("op");
        switch (op){
            case "login":
                System.out.println(1111);
                login(request,response);
                break;
            case"register":
                register(request,response);
                break;
            case"logout":
                logout(request,response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        doPost(request,response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println("正在调用login方法");
        String name=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        try{
            User user=userService.login(name,pwd);
            if(user==null){
                request.setAttribute("ERROR","用户名或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                System.out.println("跳转失败");
            }else {
                request.getSession().setAttribute("USERS",user);
                response.sendRedirect("index.jsp");
                System.out.println("登录成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected  void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        User user=new User();
        user.setUsername(request.getParameter("nickName"));
        user.setUseremail(request.getParameter("email"));
        user.setUserpwd(request.getParameter("pwd"));
        user.setUsersex(request.getParameter("sex"));
        user.setUsersite(request.getParameter("province")+request.getParameter("city"));
        try {
            userService.save(user);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.toString());
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getSession().removeAttribute("USERS");
        response.sendRedirect("index.jsp");

    }
}
