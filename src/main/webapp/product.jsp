<%@ page import="com.bookstore.entity.book" %>
<%@ page import="com.bookstore.Dao.bookDao" %>
<%@ page import="com.bookstore.service.serviceImp.userServiceImp" %>
<%@ page import="com.bookstore.Dao.DaoImp.bookDaoImp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: smile
  Date: 2022/6/19
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>当当网商品展示页面</title>
    <link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/product.js"></script>
    <link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="css/template.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/header.js"></script>
</head>
<body>
<!--<div id="header"><iframe src="header.jsp" height="155px" width="960px" frameborder="0"></iframe></div>-->
<%bookDao bookDao=new bookDaoImp();%>
<%--分页技术代码--%>
<%
int pageindex=1;
int pagesize=5;
    String pindex=request.getParameter("pindex");
    if(pindex==null)
        pageindex=1;
    else
        pageindex=Integer.parseInt(pindex);
    if(pageindex<1)
        pageindex=1;
%>
<div id=""header><%@include file="header.jsp"%></div>
<!--中间部分开始-->
<div id="main">
    <div class="dd_index_top_adver"><img src="images/dd_index_top_adver.jpg" alt="通栏广告图片" /></div>
    <div class="current_place">您现在的位置：<a href="index.jsp">当当图书</a> &gt;&gt; 小说 &gt;&gt; 财经</div>
    <!--左侧菜单开始-->
    <div id="product_left">
        <div id="product_catList">
            <div class="product_catList_top">浏览同级分类</div>
            <div id="product_catList_class"><!--使用javaScript显示图书分类--></div>
        </div>
        <div class="product_catList_end">
            <img src="images/product_01.gif" alt="shopping"/>
            <img src="images/product_02.gif" alt="shopping"/>
        </div>
    </div>
    <!--右侧内容开始-->
    <div id="product_storyList">
        <div id="product_storyList_top">
            <ul>
                <li>排序方式</li>
                <li><img src="images/dd_arrow_right.gif" alt="arrow"/></li>
                <li>
                    <select id="compositor">
                        <option>按销量 降序</option>
                        <option>按价格 升序</option>
                        <option>按价格 降序</option>
                        <option>按折扣 升序</option>
                        <option>按折扣 降序</option>
                        <option>按出版时间 升序</option>
                        <option>按出版时间 降序</option>
                        <option>按上架时间 升序</option>
                        <option>按上架时间 降序</option>
                    </select>
                </li>
                <li><img src="images/product_icon_01.gif" alt="icon"/></li>
                <li><img src="images/product_icon_02.gif" alt="icon"/></li>
                <li><img src="images/product_icon_03.gif" alt="icon"/></li>
                <li><img src="images/product_icon_04.gif" alt="icon"/></li>
<%--                <li>每页显示的数量</li>--%>
<%--                <li><img src="images/dd_arrow_right.gif" alt="arrow"/></li>--%>
<%--                <li><img src="images/product_icon_20.gif" alt="icon"/></li>--%>
<%--                <li><img src="images/product_icon_40.gif" alt="icon"/></li>--%>
                <li style="float:right; padding-right:10px;"><a href="product.jsp?pindex=<%=(pageindex +1)%>"><img src="images/product_page_down.gif" alt="icon"/></a></li>
                <li style="float:right;">第<%=pageindex%>页</li>
                <li style="float:right;"><a href="product.jsp?pindex=<%=(pageindex -1)%>"><img src="images/product_page_up.gif" alt="icon"/></a></li>
            </ul>
        </div>
        <div id="product_array">
            <a class="click" name="array"  href="javascript:void(0)">列表</a>
            <a name="bigImg" href="javascript:void(0)">大图</a>
        </div>
        <!--图书排列开始-->
        <div id="product_storyList_content" class="product_storyList_content">
<%--            <div id="storyBooksssss"><!--使用javaScript显示图书列表--></div>--%>
            <!--列表开始-->

            <%
                List<book> list= null;
                try {
                    list = bookDao.getBookFenye(pageindex,pagesize);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
<%--    <%System.out.println(list.toString());%>--%>
            <%for(book li:list){%>
            <div class="product_storyList_content_left"><img src=<%=li.getBookimage()%> alt="图书列表"/></div>
            <div class="product_storyList_content_right">
                <ul>
                    <li class="product_storyList_content_dash"><a href="#" class="blue_14"><%=li.getBookname()%></a></li>
                    <li>顾客评分：<img src="images/star_red.gif" alt="star"/><img src="images/star_red.gif" alt="star"/><img src="images/star_red.gif" alt="star"/><img src="images/star_red.gif" alt="star"/><img src="images/star_gray.gif" alt="star"/></li>
                    <li>作　者：<a href="#" class="blue_14"><%=li.getBookanthor()%></a> 著</li>
                    <li>出版社：<a href="#" class="blue_14"><%=li.getBookpress()%></a></li>
                    <li>出版时间：<%=li.getBooktime()%></li>
                    <li><%=li.getBooktype()%></li>
                    <li>
                        <dl class="product_content_dd">
                            <dd><img src="images/product_buy_02.gif" alt="shopping"/></dd>
                            <dd><a href="bookservlet?bookno=<%=li.getBookid()%>&&op=add" ><img src="images/product_buy_01.gif" alt="shopping"/></a></dd>
                            <% double sum=Double.parseDouble(li.getBookprice())-Double.parseDouble(li.getBookpriced());
                                String  str = String.format("%.2f",sum);
                                double sum2 = Double.parseDouble(str);
                            %>
                            <dd>节省：￥<%=sum2%></dd>
<%--                            <dd>折扣：<span>59折</span></dd>--%>
                            <dd class="footer_dull_red"><span>￥<%=li.getBookpriced()%></span></dd>
                            <dd class="product_content_delete"><span>￥<%=li.getBookprice()%></span></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="product_storyList_content_bottom"></div>
            <%}%>
            <div>
                <dl class="product_content_dd">
                    <dd><img src="images/OK.gif" alt="ok"/></dd>
                    <dd>页</dd>
                    <dd><input name="page" type="text" value="1" style="width:20px;"/></dd>
                    <dd>跳转到第</dd>
                    <dd><a href="product.jsp?pindex=<%=(pageindex +1) %>"><img src="images/next.gif" alt="ok"/></a></dd>
                    <dd>
                        <ul id="product_page">
                            <li><a href="product.jsp?pindex=1" class="product_page">1</a></li>
                            <li><a href="product.jsp?pindex=2" class="product_page">2</a></li>
                            <li> <a href="product.jsp?pindex=3" class="product_page">3</a></li>
                            <li> ...</li>
                            <li><a href="#" class="product_page">14</a></li>
                            <li><a href="#" class="product_page">15</a></li>
                            <li><a href="#" class="product_page">16</a></li>
                        </ul>
                    </dd>
                    <dd><a href="product.jsp?pindex=<%=(pageindex -1) %>"><img src="images/product_page_up.gif" alt="ok"/></a></dd>
                </dl>
            </div>
        </div>
    </div>
    <!--右侧内容结束-->
</div>
<!--网站版权部分开始-->
<div id="footer">
    <div class="footer_top"><a href="#" target="_parent" class="footer_dull_red">公司简介</a> | <a href="#" target="_parent" class="footer_dull_red">诚证英才</a> | <a href="#" target="_parent" class="footer_dull_red">网站联盟</a> | <a href="#" target="_parent" class="footer_dull_red">百货招商</a> | <a href="#" target="_parent" class="footer_dull_red">交易条款</a></div>
    <iframe src="footer.html" height="50px" width="900px" frameborder="0"></iframe></div>
</body>
</html>

