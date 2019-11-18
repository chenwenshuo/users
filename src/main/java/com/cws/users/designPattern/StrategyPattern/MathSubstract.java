package com.cws.users.designPattern.StrategyPattern;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/4 11:34
 * 减法实现
 */
public class MathSubstract implements Strategy {
    @Override
    public int math(int a, int b) {
        return a-b;
    }
}
