package com.cws.users.designPattern.ProxyPattern.image;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/30 16:01
 */
public class RealImage  implements  Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(){
        System.out.println("Loading " );
    }
}
