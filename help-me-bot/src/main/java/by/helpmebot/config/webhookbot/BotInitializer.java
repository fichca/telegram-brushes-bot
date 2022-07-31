package by.helpmebot.config.webhookbot;

import by.helpmebot.bot.webhookbot.TelegramBotApiListener;
import by.helpmebot.service.iface.BotService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@AllArgsConstructor
public class BotInitializer {

    private final BotConfig botConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(botConfig.getWebhookPath()).build();
    }


    @Bean
    public TelegramBotApiListener springWebhookBot(SetWebhook setWebhook, BotService botService, BotConfig botConfig) {
        return new TelegramBotApiListener(setWebhook, botService, botConfig);
    }
}
