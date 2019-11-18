package com.cws.users.message;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.cws.users.message.MessageDto.smsSign;
import static com.cws.users.message.MessageDto.templateId;

/**
 * @author wenshuo.chen@hand-china.com @data 2019/10/21 20:08
 */
@RestController
public class MessageController {

    @GetMapping("/test")
    public String pushMessage(){
        try {
            String[] params = {"5678","123"};
            SmsSingleSender ssender = new SmsSingleSender(MessageDto.appid,MessageDto.appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", "17864282307",
                    templateId, params, smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
        return "发送成功";
    }
}
