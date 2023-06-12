package com.codewithraj.blog.blogappapis.config;

import io.swagger.annotations.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER="Authorization";

    private ApiKey apiKey()
    {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private List<SecurityContext> securityContexts()
    {
        return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
        //return SecurityContext.builder().securityReferences(null).build();
    }

    private List<SecurityReference> sf()
    {
        AuthorizationScope scope=new AuthorizationScope("global","accessEverything");
        return Arrays.asList(new SecurityReference("JWT",new AuthorizationScope[]{scope}));
    }

    @Bean
    public Docket api(){



        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo())
                .securityContexts(securityContexts())
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo getInfo(){

        return new ApiInfo("Blogging Application : Backend Course",
                "This Project is Developed By Raj","1.0","Terms of Service",
                new Contact("Raj","https://SoftechStudy.com","raj.secpnd344@gmail.com"),
                "License of APIS","API license URL", Collections.emptyList());

    };


}
