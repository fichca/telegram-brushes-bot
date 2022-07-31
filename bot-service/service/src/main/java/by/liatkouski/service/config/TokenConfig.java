package by.liatkouski.service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TokenConfig {
    @Value("${telegram.internal.token}")
    private String token;
}
