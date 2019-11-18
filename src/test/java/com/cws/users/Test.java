package com.cws.users;

import java.math.BigDecimal;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/4 13:55
 */
public class Test {

    public static void main(String[] args) {
        double a=4;
        double b=3.6;
        double c=a-b;
        System.out.println(c);


        BigDecimal b1 = new BigDecimal(Double.toString(4.0));
        BigDecimal b2 = new BigDecimal(Double.toString(3.6));
        System.out.println(b1.subtract(b2));
        }

}
