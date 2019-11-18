package com.cws.users.designPattern.StrategyPattern;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/4 11:36
 * 新建class 将接口注入 ,并构造方法,新建方法调用接口方法,
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public int executeStrategy(int a,int b){
      return   strategy.math(a,b);
    }
}
