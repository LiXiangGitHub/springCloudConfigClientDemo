package com.zhwl.springCloudConfigClientDemo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@RefreshScope
@EnableSwagger2
public class SpringCloudConfigClientDemoApplication {
	@Value("${test}")
	private String name;
	@ApiOperation(value="获取测试信息", notes="测试详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = false, dataType  = "Integer")
	@RequestMapping("/hello")
	public String home(Integer id){
		return "Hello "+name +"ID"+id;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientDemoApplication.class, args);
	}

}
