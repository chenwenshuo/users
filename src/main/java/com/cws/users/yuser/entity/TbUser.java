package com.cws.users.yuser.entity;

//import com.baomidou.ant.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.catalina.User;
import org.apache.shiro.codec.Hex;


/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-10-18
 */

public class TbUser {

    private static final long serialVersionUID=1L;
    @TableId(type = IdType.AUTO)
    private  Integer id;
    private String name;

    private String passsword;

    private String mail;

    private String phoneNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Hex进行 16 进制字符串编码 / 解码操作
    public String SetPassWd(String password) {

        String hexEncoded = Hex.encodeToString(password.getBytes());


        return  hexEncoded;
    }
    //解密
    public  String getPassWd(String password){
        String str2 = new String(Hex.decode(password.getBytes()));
        return str2;
    }

}
