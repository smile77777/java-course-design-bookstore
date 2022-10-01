<%@ page import="com.bookstore.Dao.bookDao" %>
<%@ page import="com.bookstore.Dao.DaoImp.bookDaoImp" %>
<%@ page import="com.bookstore.entity.book" %>
<%@ page import="java.util.List" %>
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
<h2>图书修改</h2>
<br>
<%
    bookDao bookDao=new bookDaoImp();
    List<book> list=bookDao.getBookbyId(request.getParameter("bookid"));
%>
<div id="add_form">
    <form method="post" action="/rootServlet?bookid=<%=request.getParameter("bookid")%>">
        <input type="hidden" name="op" value="changebook"/>
        <dl class="add_row">
            <dt>书名:</dt>
            <dd><input type="text" name="book_name" class="add_input" value="<%=list.get(0).getBookname()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>作者:</dt>
            <dd><input type="text" name="book_anthor" class="add_input" value="<%=list.get(0).getBookanthor()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>出版社:</dt>
            <dd><input type="text" name="book_press" class="add_input" value="<%=list.get(0).getBookpress()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>出版时间:</dt>
            <dd><input type="text" name="book_time" class="add_input" value="<%=list.get(0).getBooktime()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>定价:</dt>
            <dd><input type="text" name="book_price" class="add_input" value="<%=list.get(0).getBookprice()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>当当价:</dt>
            <dd><input type="text" name="book_priced" class="add_input" value="<%=list.get(0).getBookpriced()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>图片地址:</dt>
            <dd><input type="file" name="book_image" value="<%=list.get(0).getBookimage()%>"></dd>
        </dl>
        <dl class="add_row">
            <dt>简介:</dt>
            <dd><input type="text" name="book_type" class="add_input" value="<%=list.get(0).getBooktype()%>"></dd>
        </dl>

        <div class="addBtn"><input id="addBtn" type="submit" value="修改" style="background: #5bc0de " /></div>

    </form>
</div>
</body>
</html>

