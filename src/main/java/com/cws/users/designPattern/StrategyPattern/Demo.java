package com.cws.users.designPattern.StrategyPattern;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/4 11:38
 */
public class Demo {
    public static void main(String[] args) {
        Context context=new Context(new MathAdd());
        System.out.println(context.executeStrategy(1,1));

        Context context1=new Context(new MathMultiply());
        System.out.println(context1.executeStrategy(4,7));

        Context context2=new Context(new MathSubstract());
        System.out.println(context2.executeStrategy(9,6));
    }
}
