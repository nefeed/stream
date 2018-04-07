package io.nefeed.stream.service;

import com.alibaba.dubbo.config.annotation.Service;
import io.nefeed.stream.annotation.AnalysisActuator;

import java.util.Optional;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 09:09
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloWorldServiceImpl implements HelloWorldService {

    @AnalysisActuator(note = "获取聊天信息方法")
    @Override
    public String getHelloMessage(String name) {
        return "Hello " + Optional.ofNullable(name).orElse("World!");
    }

}
