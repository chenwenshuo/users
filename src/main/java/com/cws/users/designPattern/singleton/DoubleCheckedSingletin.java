package com.cws.users.designPattern.singleton;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/18 20:26
 */
public class DoubleCheckedSingletin {
    private static DoubleCheckedSingletin instance;

    public DoubleCheckedSingletin(){}
    private static DoubleCheckedSingletin getInstance(){
        if (instance==null){
            synchronized (DoubleCheckedSingletin.class){
            if (instance==null)
            {
            instance=new DoubleCheckedSingletin();}
            }
        }
        return instance;
    }

}
