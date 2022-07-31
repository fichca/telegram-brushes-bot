package by.liatkouski.service.config;

import by.liatkouski.service.interceptor.TokenInterceptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.InputStream;
import java.util.Properties;

import static ch.qos.logback.core.util.CloseUtil.closeQuietly;

@Configuration
@EnableSwagger2
@Slf4j
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private TokenInterceptor tokenInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor).addPathPatterns("/test/**");
//    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("by.liatkouski.service.controller")) // Пакет сканирования Swagger
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Properties props = new Properties();
        try {
            InputStream input = WebConfig.class.getClassLoader().getResourceAsStream("project.properties");
            props.load(input);
            closeQuietly(input);
        } catch (Exception e) {
            log.warn("Cannot read project properties file", e);
        }

        return new ApiInfoBuilder()
                .title("Bot")
                .description(props.getProperty("description", "Service API"))
                .version(props.getProperty("version", "unknown"))
                .license("Liatkouski")
                .build();
    }
}