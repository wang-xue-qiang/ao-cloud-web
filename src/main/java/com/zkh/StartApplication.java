package com.zkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
/*@EnableEurekaClient
@EnableHystrix*/
public class StartApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StartApplication.class);
	}
	
	/**
	 * 
	 * @Description:Hystrix默认轮询
	 * @return
	 * @author wangxueqiang
	 * @date 2018年11月16日 上午9:05:40
	 *
	 */
/*	@Bean
	@LoadBalanced 
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
*/
}
