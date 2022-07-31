package by.helpmebot.config;

import by.liatkouski.api.api.scope.config.BotApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "by.helpmebot")
@Import({BotApiConfig.class})
public class HelpMeBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelpMeBotApplication.class, args);
    }
}
