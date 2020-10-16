package com.springbootdemo.client.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.mail.internet.InternetAddress;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendEmail")
    private String sendSimpleEmail(){

        System.out.println("from:"+from);
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);   //发件人
            message.setTo("R13260656629@163.com");   //收件人
            message.setSubject("一封简单的邮件aaa");    //标题
            message.setText("你好你好你好"+
                    "ncjsdnc\n"+
                    "smpdcv\n"+
                    "sdkpmv csdk");
            mailSender.send(message);
            return "发送成功";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
