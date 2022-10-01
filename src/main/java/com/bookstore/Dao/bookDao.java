package com.bookstore.Dao;

import com.bookstore.entity.User;
import com.bookstore.entity.book;

import java.util.List;

public interface bookDao {
    List<book> getBooks() throws  Exception;
    List<book> getBookbyId(String bookid) throws  Exception;
    public int update(book book, String bookId) throws Exception;

    public int delete(String bookId) throws Exception;
    public int addbook(book book) throws  Exception;
    List<book> getBookFenye(int pageNo, int pageSize) throws Exception;
}
