package com.apollo.swaggerlearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @author wangxin
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(ApiInfo apiInfo, Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo)
                .enable(flag)
                .groupName("hello")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apollo.swaggerlearn"))
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfo("Swagger测试接口",
                "Swagger测试接口文档说明",
                "1.0",
                "urn:tos",
                new Contact("wangxin", "", "154397432@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
