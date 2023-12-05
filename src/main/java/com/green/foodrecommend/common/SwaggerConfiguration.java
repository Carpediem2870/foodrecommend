package com.green.foodrecommend.common;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean // 스웨거 문서 위쪽의 내용들을 수정하기위해 설정
    public OpenAPI openAPI(){

        return new OpenAPI().components(new Components())
                .info(new Info()
                        .title("Food Receipe Share Ver.1")
                        .description("음식 레시피 쉐어 v1")
                        .version("1.0.0")
                );
    }
}
