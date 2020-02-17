package com.fanhanfei.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhangjunshuai
 * @date 2020/2/17
 * @description
 **/
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Bean
    public Docket apiDocket() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        Contact contact = new Contact("API Support", "http://gotozhangsanlisi.com/", "wuqingming@zhangsanlisi.com");

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Keep Polaris Http API")
                .description("API文档管理, 该文档系统自动生成并保持最新,内网接口host: polaris.http.svc.ali.keep")
                .termsOfServiceUrl("http://api.gotozhangsanlisi.com")
                .contact(contact)
                .license("Apache License Version 2.0")
                .licenseUrl("http://www.gotozhangsanlisi.com")
                .version("/v1.0")
                .build();

        docket.apiInfo(apiInfo);

        return docket;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
