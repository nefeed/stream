package io.nefeed.stream.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * classpath路径：locations={"classpath:application-bean1.xml","classpath:application-bean2.xml"}
 * file路径： locations ={"file:d:/test/application-bean1.xml"};
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 14:17
 */
@Configuration
@ImportResource(locations={"classpath:spring-*.xml"})
//@ImportResource(locations={"file:d:/test/application-bean1.xml"})
public class ContextConfig {

}