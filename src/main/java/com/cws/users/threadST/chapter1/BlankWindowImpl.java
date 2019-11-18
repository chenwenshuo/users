package com.cws.users.threadST.chapter1;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/1 17:24
 */
public class BlankWindowImpl implements Runnable {

    private  static int max = 50;
    private  static  int index=1;


    @Override
    public void run() {
        while (index<=max){
            System.out.println("号窗口:第"+index++);
            try {
                Thread.sleep(300*10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
