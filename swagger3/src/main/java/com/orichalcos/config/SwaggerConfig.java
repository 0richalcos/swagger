package com.orichalcos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    //注：这里注入了 Environment 对象，目的是获取系统环境
    public Docket docket(Environment environment) {

        //设置要显示 swagger 的环境（dev 或者 test）
        Profiles profiles = Profiles.of("dev", "test");
        //判断当前是否处于该环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.orichalcos.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("文档标题")
                .description("测试的接口文档")
                .version("v1.0")
                .termsOfServiceUrl("baidu.com")
                .contact(new Contact("Orichalcos", "https://github.com/0richalcos", "xox.zhe@foxmail.com"))
                .build();
    }

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("orichalcos");
    }
}