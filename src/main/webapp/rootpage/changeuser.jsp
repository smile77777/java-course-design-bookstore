<%@ page import="com.bookstore.Dao.bookDao" %>
<%@ page import="com.bookstore.Dao.DaoImp.bookDaoImp" %>
<%@ page import="com.bookstore.entity.book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bookstore.Dao.userDao" %>
<%@ page import="com.bookstore.Dao.DaoImp.userDaoImp" %>
<%@ page import="com.bookstore.entity.User" %>
<%@ page import="com.bookstore.service.userService" %>
<%@ page import="com.bookstore.service.serviceImp.userServiceImp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .add_row{
            clear:both;
        }
        .add_row dt{
            float:left;
            width:200px;
            height:40px;
            text-align:right;
            font-size:16px;
        }
        .add_row dd{
            float:left;
            margin-right:5px;
            display:inline;
        }
        .add_input{
            width:400px;
            height:40px;
            border:solid 1px #999;
            margin:0px 0px 8px 0px;
        }
        .add_submit{
            float: right;
            width: 40px;
        }
        .addBtn{
            height:50px;
            margin:10px 10px 20px 240px;
            clear:both;
        }
    </style>
</head>
<body>
<h2>用户修改</h2>
<br>
<%
    userService userService=new userServiceImp();
    User user=userService.findById(request.getParameter("userid"));
%>
<div id="add_form">
    <form method="post" action="/rootServlet?userid=<%=request.getParameter("userid")%>" accept-charset="utf-8"/> >
        <input type="hidden" name="op" value="changeuser"/>
        <dl class="add_row">
            <dt>用户名:</dt>
            <dd><input type="text" name="uname" class="add_input" value="<%=user.getUsername()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>邮箱:</dt>
            <dd><input type="text" name="uemail" class="add_input" value="<%=user.getUseremail()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>电话:</dt>
            <dd><input type="text" name="unumber" class="add_input" value="<%=user.getUsernumber()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>性别:</dt>
            <dd><input type="text" name="usex" class="add_input" value="<%=user.getUsersex()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>住址:</dt>
            <dd><input type="text" name="usite" class="add_input" value="<%=user.getUsersite()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>权限:</dt>
            <dd><input type="text" name="utype" class="add_input" value="<%=user.getType()%>"></dd>
        </dl>

        <div class="addBtn"><input id="addBtn" type="submit" value="修改" style="background: #5bc0de " /></div>

    </form>
</div>
</body>
</html>


