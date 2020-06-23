package com.xg.demo.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author Muhammad Azis
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "mconfig",name = "swagger-ui-open",havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        // 参数配置
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("Authorization").description("user token")
                .modelRef(new ModelRef("string")).parameterType("header") // header表示参数放在请求头
                .required(false); //header中的Authorization参数非必填，传空也可以
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true) // 动态决定是否启动swagger
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))//这个代码说明的我们扫描的哪些接口，我这行意思是扫描带@Api注解的接口类
                //也可以这样，说明扫描哪个包下的类
                // .apis(RequestHandlerSelectors.basePackage("com.xxx.xxx.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);// 参数配置
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("xxx接口文档")
                .description("xxx相关接口的文档")
                .termsOfServiceUrl("http://www.xxx.com")
                .version("1.0")
                .build();
    }





}
