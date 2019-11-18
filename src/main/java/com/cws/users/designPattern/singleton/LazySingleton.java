package com.cws.users.designPattern.singleton;

import sun.security.jca.GetInstance;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/18 15:16
 * 1、懒汉式，线程不安全
 *
 * 是否 Lazy 初始化：是
 *
 * 是否多线程安全：否
 *
 *
 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 */
public class LazySingleton {

    private static LazySingleton instance;
    private LazySingleton(){};
    private static LazySingleton getInstance(){
        if(instance==null){
            instance=new LazySingleton();
        }
        return instance;
    }

}
