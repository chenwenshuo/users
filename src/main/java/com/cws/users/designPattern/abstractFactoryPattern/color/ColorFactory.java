package com.cws.users.designPattern.abstractFactoryPattern.color;


import com.cws.users.designPattern.abstractFactoryPattern.AbstractFactory;
import com.cws.users.designPattern.abstractFactoryPattern.book.Book;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/8 15:46
 */
public class ColorFactory  extends AbstractFactory {
    @Override
    public Color getColor(String colorType){
        if (colorType.equalsIgnoreCase(null)) {
            return null;
        }
        if (colorType.equalsIgnoreCase("blue")){
            return new Blue();
        }
        if (colorType.equalsIgnoreCase("red")){
            return new Red();
        }
        if (colorType.equalsIgnoreCase("green")){
            return new Green();
        }
return null;
    }

    @Override
    public Book getBook(String book) {
        return null;
    }


}
