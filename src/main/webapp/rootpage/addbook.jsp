<%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2022/6/22
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
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
<h2>图书添加</h2>
<br>
<div id="add_form">
    <form method="post" action="/rootServlet">
        <input type="hidden" name="op" value="addbook"/>
        <dl class="add_row">
            <dt>书名:</dt>
            <dd><input type="text" name="book_name" class="add_input"></dd>
        </dl>
        <dl class="add_row">
            <dt>作者:</dt>
            <dd><input type="text" name="book_anthor" class="add_input"></dd>
        </dl>
        <dl class="add_row">
            <dt>出版社:</dt>
            <dd><input type="text" name="book_press" class="add_input"></dd>
        </dl>
        <dl class="add_row">
            <dt>出版时间:</dt>
            <dd><input type="text" name="book_time" class="add_input"></dd>
        </dl>
        <dl class="add_row">
            <dt>定价:</dt>
            <dd><input type="text" name="book_price" class="add_input"></dd>
        </dl>
        <dl class="add_row">
            <dt>当当价:</dt>
            <dd><input type="text" name="book_priced" class="add_input"></dd>
        </dl>
        <dl class="add_row">
            <dt>图片地址:</dt>
            <dd><input type="file" name="book_image" ></dd>
        </dl>
        <dl class="add_row">
            <dt>简介:</dt>
            <dd><input type="text" name="book_type" class="add_input"></dd>
        </dl>

        <div class="addBtn"><input id="addBtn" type="submit" value="添加" style="background: #5bc0de " /></div>

    </form>
</div>
</body>
</html>
