package com.cws.users.designPattern.factoryPattern;

import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/5 11:15
 */
public class test {
    public static void main(String[] args) {

        String a=null;
        int b;
        if (a==null){
            System.out.println(a);

        }       /* BookFactory bookFactory = new BookFactory();
        Book book = bookFactory.getBook("englishbook");
        Book book1 = bookFactory.getBook("mathbook");
        Book book2 = bookFactory.getBook("chinesebook");
        book.bookClass();
        book1.bookClass();
        book2.bookClass();*/
/*    *//*    A a=new A();
        A b=new A();
        a.setA(1);
        b.setB("ghj");
        b.setC(BigDecimal.valueOf(67));
b.setD(3L);
        BeanUtils.copyProperties(a,b, *//*CopyUtils.getNullPropertyNames(a));
        System.out.print(b.b+b.c+b.d);*/

    }
}
