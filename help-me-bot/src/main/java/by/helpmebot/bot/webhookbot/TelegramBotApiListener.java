package by.helpmebot.bot.webhookbot;

import by.helpmebot.config.webhookbot.BotConfig;
import by.helpmebot.service.iface.BotService;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Getter
@Setter
public class TelegramBotApiListener extends SpringWebhookBot {


    private BotService botService;
    private BotConfig botConfig;


    public TelegramBotApiListener(SetWebhook setWebhook, BotService botService, BotConfig botConfig) {
        super(setWebhook);
        this.botService = botService;
        this.botConfig = botConfig;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        try {
            return botService.getAnswer(update);
        } catch (Exception e) {
            return SendMessage.builder()
                    .text("Oooops")
                    .chatId(update.getMessage().getChatId().toString())
                    .build();
        }
    }


    public boolean needToResponse(Update update) {
        //Request processing can be released when update request has message or callback query only.
        if (!update.hasMessage() && !update.hasCallbackQuery()) {
            return false;
        }
        //If update request has message then it must have text too.
        if (update.hasMessage() && !update.getMessage().hasText()) {
            return false;
        }
        return true;
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotUserName();
    }

    @Override
    public String getBotPath() {
        return botConfig.getBotUserName();
    }

}
