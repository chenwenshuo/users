package com.cws.users.designPattern.factoryPattern;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/5 10:52
 * 工厂模式:复杂对象都可以使用
 * 意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 *
 * 主要解决：主要解决接口选择的问题。
 *
 * 何时使用：我们明确地计划不同条件下创建不同实例时。
 *
 * 如何解决：让其子类实现工厂接口，返回的也是一个抽象的产品。
 *
 * 关键代码：创建过程在其子类执行。
 *
 * 创建接口,实现接口,不同表现,创建工厂,使用工厂,根据传参不同表现
 *
 * 创建一个Book接口和实现他的实体类,定义一个BookFactory,定义生成对象的规则.通过传入不同的参数获取不同的对象
 */
public interface Book {
    void bookClass();
}
