package com.example.demo;

import com.example.demo.pojo.AuthorSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication {
	@Autowired
	private AuthorSetting as;

	@RequestMapping("/hello")
	public String hello() {
		String ret = "authorName is " + as.getName() + " and authorAge is " + as.getAge();
		return ret;
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		System.out.println("CPU个数:" + Runtime.getRuntime().availableProcessors());
		/**
		 * @Author caoyajuan
		 * @Description //代码关闭banner
		 * @Date  2021/2/8 14:31
		 * @Param  [args]
		 * @return  void

		SpringApplication sa = new SpringApplication(DemoApplication.class);
		sa.setBannerMode(Banner.Mode.OFF);
		sa.run(args);*/
	}

}
