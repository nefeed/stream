package io.nefeed.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动器
 * @author 章华隽
 */
@ServletComponentScan
@SpringBootApplication
public class StreamApplication {
	public static void main(String[] args) {
		SpringApplication.run(StreamApplication.class, args);
	}
}
