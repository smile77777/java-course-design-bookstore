package com.bookstore.Dao.DaoImp;

import com.bookstore.Dao.bookDao;
import com.bookstore.Database.database;
import com.bookstore.entity.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class bookDaoImp implements bookDao {
    database db=new database();
    @Override
    public List<book> getBooks() throws Exception {
        List<book> list=new ArrayList<>();
        try
        {
            String sql="select * from book";

            Connection conn=db.getCon();

            PreparedStatement ps=conn.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                book book=new book();
                book.setBookid(rs.getString("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setBookanthor(rs.getString("bookanthor"));
                book.setBookpress(rs.getString("bookpress"));
                book.setBooktime(rs.getString("booktime"));
                book.setBookprice(rs.getString("bookprice"));
                book.setBookpriced(rs.getString("bookpriced"));
                book.setBookimage(rs.getString("bookimage"));
                book.setBooktype(rs.getString("booktype"));
                list.add(book);
            }
            db.closeConnection(rs,ps,conn);
        }catch (Exception ex)
        {
            throw ex;
        }

        return list;
    }

    @Override
    public List<book> getBookbyId(String bookid) throws Exception {
        List<book> list=new ArrayList<>();
        try
        {
            String sql="select * from book where bookid=?";

            Connection conn=db.getCon();

            PreparedStatement ps=conn.prepareStatement(sql);

            ResultSet rs=db.executeQuery(sql,bookid);

            while(rs.next())
            {
                book book=new book();
                book.setBookid(rs.getString("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setBookanthor(rs.getString("bookanthor"));
                book.setBookpress(rs.getString("bookpress"));
                book.setBooktime(rs.getString("booktime"));
                book.setBookprice(rs.getString("bookprice"));
                book.setBookpriced(rs.getString("bookpriced"));
                book.setBookimage(rs.getString("bookimage"));
                book.setBooktype(rs.getString("booktype"));
                list.add(book);
            }
            db.closeConnection(rs,ps,conn);
        }catch (Exception ex)
        {
            throw ex;
        }

        return list;
    }

    @Override
    public int update(book book, String bookId) throws Exception {
        int r=-1;
        try
        {
            String sql="update book set bookname=?,bookanthor=?,bookpress=?,booktime=?,bookprice=?,bookpriced=?,bookimage=?,booktype=? where bookid=?";

            r=db.executeUpdate(sql,book.getBookname(),book.getBookanthor(),book.getBookpress(),book.getBooktime(),book.getBookprice(),book.getBookpriced(),book.getBookimage(),book.getBooktype(),bookId);

        }catch (Exception ex)
        {
            throw ex;
        }

        return r;
    }

    @Override
    public int delete(String bookId) throws Exception {
        int r=-1;
        try
        {
            String sql="delete from  book  where bookid=?";

            r=db.executeUpdate(sql,bookId);

        }catch (Exception ex)
        {
            throw ex;
        }

        return r;
    }

    @Override
    public int addbook(book book) throws Exception {
        int r=-1;
        try {
            String sql = "insert into book (bookname,bookanthor,bookpress,booktime,bookprice,bookpriced,bookimage,booktype) values(?,?,?,?,?,?,?,?)";
            r = db.executeUpdate(sql,book.getBookname(),book.getBookanthor(),book.getBookpress(),book.getBooktime(),book.getBookprice(),book.getBookpriced(),book.getBookimage(),book.getBooktype());
        }catch (Exception e){
            throw e;
        }
        return r;
    }

    @Override
    public List<book> getBookFenye(int pageNo, int pageSize) throws Exception {
        List<book> list=new ArrayList<>();
        try
        {
            String sql="select * from book limit ?,?";

            Connection conn=db.getCon();
            PreparedStatement ps=conn.prepareStatement(sql);


//            PreparedStatement ps=conn.prepareStatement(sql,(pageNo-1)*pageSize,pageSize);

            ResultSet rs=db.executeQuery(sql,(pageNo-1)*pageSize,pageSize);

            while(rs.next())
            {
                book book=new book();
                book.setBookid(rs.getString("bookid"));
                book.setBookname(rs.getString("bookname"));
                book.setBookanthor(rs.getString("bookanthor"));
                book.setBookpress(rs.getString("bookpress"));
                book.setBooktime(rs.getString("booktime"));
                book.setBookprice(rs.getString("bookprice"));
                book.setBookpriced(rs.getString("bookpriced"));
                book.setBookimage(rs.getString("bookimage"));
                book.setBooktype(rs.getString("booktype"));
                list.add(book);
            }
            db.closeConnection(rs,ps,conn);
        }catch (Exception ex)
        {
            throw ex;
        }

        return list;
    }
}
