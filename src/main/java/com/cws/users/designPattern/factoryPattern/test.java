package com.cws.users.designPattern.factoryPattern;

import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/5 11:15
 */
public class test {
    public static void main(String[] args) {
     /* BookFactory bookFactory = new BookFactory();
        Book book = bookFactory.getBook("englishbook");
        Book book1 = bookFactory.getBook("mathbook");
        Book book2 = bookFactory.getBook("chinesebook");
        book.bookClass();
        book1.bookClass();
        book2.bookClass();*/
       /* A a=new A();
        A b=new A();
        A c=new A();
        a.setA(1);
        if (a.getLl()==null) {
            System.out.println(89);
        }
        else {
        System.out.println(a.getLl());}*/

       /* List<String> list=new ArrayList<>();
        List<String> list1=null;
        //list.add("fghj");
      list.removeAll(list1);*/
        double c=3.154;
        DecimalFormat myformat=new java.text.DecimalFormat("0.00");
        String str = myformat.format(c);
        System.out.println(str);


    }

}
