package com.bookstore.entity;

public class book {

    private String bookid;
    private String bookname;
    private String bookanthor;
    private String bookpress;
    private String booktime;
    private String bookprice;
    private String bookpriced;
    private String bookimage;
    private String booktype;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookanthor() {
        return bookanthor;
    }

    public void setBookanthor(String bookanthor) {
        this.bookanthor = bookanthor;
    }

    public String getBookpress() {
        return bookpress;
    }

    public void setBookpress(String bookpress) {
        this.bookpress = bookpress;
    }

    public String getBooktime() {
        return booktime;
    }

    public void setBooktime(String booktime) {
        this.booktime = booktime;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }

    public String getBookpriced() {
        return bookpriced;
    }

    public void setBookpriced(String bookpriced) {
        this.bookpriced = bookpriced;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookname='" + bookname + '\'' +
                ", bookanthor='" + bookanthor + '\'' +
                ", bookpress='" + bookpress + '\'' +
                ", booktime='" + booktime + '\'' +
                ", bookprice='" + bookprice + '\'' +
                ", bookpriced='" + bookpriced + '\'' +
                ", bookimage='" + bookimage + '\'' +
                ", booktype='" + booktype + '\'' +
                '}';
    }
}
