package com.sonia;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Hello world!
 *
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServicePropeties
{
    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
