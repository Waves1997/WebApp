package com.example.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.example")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("swagger2文档").description("更多精彩博客请关注：https://blog.csdn.net/qq_42495847?spm=1000.2115.3001.5343").termsOfServiceUrl("https://blog.csdn.net/qq_42495847?spm=1000.2115.3001.5343").contact(new Contact("cheng", "https://blog.csdn.net/qq_42495847?spm=1000.2115.3001.5343", "1003816735@qq.com")).version("1.0").build();
    }
}
