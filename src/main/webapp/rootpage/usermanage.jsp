<%@ page import="com.bookstore.entity.User" %>
<%@ page import="com.bookstore.Dao.userDao" %>
<%@ page import="com.bookstore.Dao.DaoImp.userDaoImp" %>
<%@ page import="java.util.List" %><%--
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
    <title>角色管理</title>
    <script type="text/javascript" src="js/personManageJS.js"></script>
    <link rel="stylesheet" type="text/css" href="css/personManageCSS.css">
</head>
<body bgcolor="#eeeeee">

<br/><h2>角色管理</h2>


<table id="Table" cellpadding="5" cellspacing="0" width="68%" border="0">
    <thead>
    <tr bgcolor="#c0c0c0">
        <td>编号</td>
        <td>姓名</td>
        <td>邮箱</td>
        <td>性别</td>
        <td>住址</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody id="listTable">
    <%User user=new User();
        userDao userDao=new userDaoImp();
        List<User> list=userDao.getUsers();
        for(User li:list){%>
    <tr>
        <td><%=li.getUserid()%></td>
        <td><%=li.getUsername()%></td>
        <td><%=li.getUseremail()%></td>
        <td><%=li.getUsersex()%></td>
        <td><%=li.getUsersite()%></td>
        <td><a href="changeuser.jsp?userid=<%=li.getUserid()%>"><button>修改</button></a></td>
    </tr>
    <%}
    %>
    </tbody>
</table><br/>
</body>
</html>


