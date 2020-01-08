package com.cws.users.designPattern.ProxyPattern;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/30 11:28
 */
public class proxyBook implements  Book {
    private String bookName;
    private RealBook realBook;

    public proxyBook(String bookName){
        this.bookName=bookName;
    }

    @Override
    public void getNewBook() {
        if (realBook==null){
            RealBook realBook=new RealBook(bookName);
        }
        realBook.getNewBook();

    }
}
