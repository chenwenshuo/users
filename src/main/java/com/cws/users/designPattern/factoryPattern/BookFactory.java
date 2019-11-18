package com.cws.users.designPattern.factoryPattern;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/5 11:01
 * 工厂
 */
public class BookFactory {
    public Book getBook(String bookType){
        if (bookType==null){
            return null;

        }
        if (bookType.equalsIgnoreCase("EnglishBook")){
            return  new EnglishBook();
        }
        if (bookType.equalsIgnoreCase("ChineseBook")){
            return  new ChineseBook();
        }
        if (bookType.equalsIgnoreCase("MathBook")){
            return  new MathBook();
        }
        return  null;
    }
}
