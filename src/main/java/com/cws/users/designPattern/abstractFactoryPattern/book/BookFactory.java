package com.cws.users.designPattern.abstractFactoryPattern.book;

import com.cws.users.designPattern.abstractFactoryPattern.AbstractFactory;
import com.cws.users.designPattern.abstractFactoryPattern.color.Color;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/8 16:04
 */
public class BookFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Book getBook(String book) {
        if (book==null){
            return null;

        }
        if (book.equalsIgnoreCase("EnglishBook")){
            return  new EnglishBook();
        }
        if (book.equalsIgnoreCase("ChineseBook")){
            return  new ChineseBook();
        }
        if (book.equalsIgnoreCase("MathBook")){
            return  new MathBook();
        }
        return  null;
    }

}
