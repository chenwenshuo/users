package com.cws.users.designPattern.ProxyPattern;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/30 11:32
 */
public class Test {

    public static void main(String[] args) {
        Book book=new proxyBook("new book");
        book.getNewBook();


    }
}

