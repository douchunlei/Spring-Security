package com.imooc.security.core.validate.code;

public interface SmsCodeSender {

    void send(String mobile, String code);


}
