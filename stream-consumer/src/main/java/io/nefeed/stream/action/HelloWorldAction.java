package io.nefeed.stream.action;

import io.nefeed.stream.service.HelloWorldService;

/**
 * Dubbo 服务调用方
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-04-04 17:38
 */
public class HelloWorldAction {
    private HelloWorldService helloWorldService;

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }
}
