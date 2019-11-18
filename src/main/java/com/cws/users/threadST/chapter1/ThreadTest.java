package com.cws.users.threadST.chapter1;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/1 13:59
 */
public class ThreadTest {
    public static void main(String[] args) {
       /* readFromDataBase();
        writeFromDataBase();*/

        Thread t1=new Thread("read"){
            @Override
            public void run() {
                readFromDataBase();
            }
        };
        Thread t2=new Thread("write"){
            @Override
            public void run() {
                writeFromDataBase();
            }
        };
        t1.start();
        t2.start();
    }

    public static void readFromDataBase(){

        try {
            System.out.println("strat------");
            Thread.sleep(1000*3L);
            System.out.println("run------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end---------");
    }
    public static void writeFromDataBase(){

        try {
            System.out.println("strat write------");
            Thread.sleep(1000*3L);
            System.out.println("run  write------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end write---------");
    }

}
