package by.helpmebot.bot.webhookbot.controller;

import by.helpmebot.bot.webhookbot.TelegramBotApiListener;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@AllArgsConstructor
public class WebhookController {

    private final TelegramBotApiListener telegramBotApi;

    @PostMapping("/")
    public ResponseEntity<BotApiMethod<?>> onUpdateReceived(@RequestBody Update update) {
        if (telegramBotApi.needToResponse(update))
            return ResponseEntity.ok(telegramBotApi.onWebhookUpdateReceived(update));
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
