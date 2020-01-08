package com.cws.users.designPattern.ProxyPattern.image;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/30 16:02
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}