package com.cws.users.threadST.chapter1;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/1 15:06
 */
public class BlankWindows extends Thread {

    private static int max = 50;
    private static int index = 1;



    @Override
    public void run() {

        while (index <= max) {
            System.out.println("当前号码: " + index);
            index++;
        }

    }
}
