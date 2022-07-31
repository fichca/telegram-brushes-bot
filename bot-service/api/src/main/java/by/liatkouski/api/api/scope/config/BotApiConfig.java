package by.liatkouski.api.api.scope.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("by.liatkouski.api.api.scope.feignclient")
@ComponentScan({"by.liatkouski.api.api.scope"})
public class BotApiConfig {
}