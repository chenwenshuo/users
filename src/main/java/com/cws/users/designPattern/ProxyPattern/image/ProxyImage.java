package com.cws.users.designPattern.ProxyPattern.image;

/**
 * @author wenshuo.chen@hand-china.com 2019/11/30 16:02
 */
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
