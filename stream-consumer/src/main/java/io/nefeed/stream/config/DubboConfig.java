package io.nefeed.stream.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Dubbo 配置类
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-04-06 22:59
 */
@Configuration
@PropertySource("classpath:dubbo/dubbo.properties")
@ImportResource({ "classpath:dubbo/*.xml" })
public class DubboConfig {
}
