package com.cws.users.message;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/10/21 20:06
 */
public class MessageDto {
    public static  int appid = 1400273976; // SDK AppID 以1400开头
    // 短信应用 SDK AppKey
    public static  String appkey = "014aaf9a5c22c341fea02fd35ba1475d";
    // 需要发送短信的手机号码
    public String[] phoneNumbers ;
    // 短信模板 ID，需要在短信应用中申请
    public static  int templateId = 449582; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
    // 签名
    public static   String smsSign = "陈文硕经验积累"; // NOTE: 签名参数使用的是`签名内容`，而不是

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
