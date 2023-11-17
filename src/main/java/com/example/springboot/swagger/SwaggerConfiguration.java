package com.example.springboot.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类.
 */

@Configuration
@EnableSwagger2
@ConditionalOnProperty(value = {"swagger.enable"}, matchIfMissing = true)
public class SwaggerConfiguration {
    @Value("${swagger.basePackage}")
    private String basePackage;       // controller接口所在的包

    @Value("${swagger.title}")
    private String title;           // 当前文档的标题

    @Value("${swagger.description}")
    private String description;         // 当前文档的详细描述

    @Value("${swagger.version}")
    private String version;         // 当前文档的版本

    @Value("${swagger.contact.name}")
    private String contactName;         // 作者

    @Value("${swagger.contact.url}")
    private String contactUrl;         // swagger地址

    @Value("${swagger.contact.email}")
    private String contactEmail;         // 邮箱

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(contactName, contactUrl, contactEmail);
        return new ApiInfoBuilder()
                .title(title)
                .contact(contact)
                .description(description)
                .version(version)
                .build();
    }
}
