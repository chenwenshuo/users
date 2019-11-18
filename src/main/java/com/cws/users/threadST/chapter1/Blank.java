package com.cws.users.threadST.chapter1;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/11/1 14:56
 */
public class Blank {
    public static void main(String[] args) {
      /*  BlankWindows blankWindow1= new BlankWindows("一号");
        BlankWindows blankWindow2= new BlankWindows("二号");
        BlankWindows blankWindow3= new BlankWindows("三号");
        blankWindow1.start();
        blankWindow2.start();
        blankWindow3.start();
        */
      final BlankWindowImpl blank=new BlankWindowImpl();
      Thread t1=new Thread(blank,"1");
      Thread t2=new Thread(blank,"2");
      Thread t3=new Thread(blank,"3");
      t1.start();
      t2.start();
      t3.start();

}


}
