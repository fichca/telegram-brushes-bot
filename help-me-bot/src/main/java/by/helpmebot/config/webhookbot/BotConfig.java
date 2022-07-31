package by.helpmebot.config.webhookbot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfig {
    @Value("${telegram.webhookPath}")
    private String webhookPath;
    @Value("${telegram.botUserName}")
    private String botUserName;
    @Value("${telegram.token}")
    private String token;
}
