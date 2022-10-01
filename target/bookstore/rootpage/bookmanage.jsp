<%@ page import="com.bookstore.entity.User" %>
<%@ page import="com.bookstore.Dao.userDao" %>
<%@ page import="com.bookstore.Dao.DaoImp.userDaoImp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bookstore.Dao.bookDao" %>
<%@ page import="com.bookstore.Dao.DaoImp.bookDaoImp" %>
<%@ page import="com.bookstore.entity.book" %><%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2022/6/21
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>图书管理</title>
    <style>
        td{
            height: 50px;
        }
    </style>
</head>
<body bgcolor="#eeeeee">

<h2>图书管理</h2>


<table id="Table" cellpadding="5" cellspacing="0"  border="1" width="85%" >
    <thead>
    <tr bgcolor="#c0c0c0">
        <td>编号</td>
        <td>书名</td>
        <td>作者</td>
        <td>出版社</td>
        <td>发布时间</td>
        <td>原价</td>
        <td>折扣价</td>
        <td>图片</td>
        <td>简介</td>
        <td>操作</td>

    </tr>
    </thead>
    <tbody id="listTable">
    <%
        bookDao bookDao=new bookDaoImp();
        List<book> list=bookDao.getBooks();
        for(book li:list){%>
    <tr>
        <td><%=li.getBookid()%></td>
        <td><%=li.getBookname()%></td>
        <td><%=li.getBookanthor()%></td>
        <td><%=li.getBookpress()%></td>
        <td><%=li.getBooktime()%></td>
        <td><%=li.getBookprice()%></td>
        <td><%=li.getBookpriced()%></td>
        <td><%=li.getBookimage()%></td>
        <td><%=li.getBooktype()%></td>
        <td>
            <a href="changebook.jsp?bookid=<%=li.getBookid()%>"><button>修改</button></a>
            <a href="/rootServlet?op=delbook&bookid=<%=li.getBookid()%>"><button>删除</button></a>
        </td>
    </tr>
    <%}
    %>
    </tbody>
</table><br/>
</body>
</html>


