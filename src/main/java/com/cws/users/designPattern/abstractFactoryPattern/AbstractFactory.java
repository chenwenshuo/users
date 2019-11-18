package com.cws.users.designPattern.abstractFactoryPattern;

import com.cws.users.designPattern.abstractFactoryPattern.book.Book;
import com.cws.users.designPattern.abstractFactoryPattern.color.Color;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/8 15:53
 * 新建接口
 * 接口不同实现
 * 新建抽象工厂
 * 继承抽象类重写方法
 * 使用抽象类新建需要的工厂对象
 * 调用工厂对象方法
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Book getBook(String book);

}
