package com.cws.users.designPattern.StrategyPattern;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/4 11:33
 * 加法 实现
 */
public class MathAdd implements Strategy {
    @Override
    public int math(int a, int b) {
        return a+b;
    }
}
