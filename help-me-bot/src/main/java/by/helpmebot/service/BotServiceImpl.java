package by.helpmebot.service;

import by.helpmebot.bot.model.MessageType;
import by.helpmebot.service.iface.BotService;
import by.liatkouski.api.api.scope.dto.ButtonMessageResponse;
import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.api.api.scope.dto.response.CommandResponse;
import by.liatkouski.api.api.scope.feignclient.BotApiClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BotServiceImpl implements BotService {
    private final BotApiClient botApiClient;

    private static final String COMMAND_SYMBOL = "/";

    @Override
    public BotApiMethod<?> getAnswer(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        switch (getMessageType(update)) {
            case COMMAND:
                return getSendMessageByCommand(update.getMessage().getText(), chatId);
            case TEXT_BUTTON:
                return getSendMessageByText(update.getMessage().getText(), chatId);
            case CALLBACK_BUTTON:
                return getSendMessageByButton(update.getCallbackQuery(), chatId);
            default:
                throw new NoSuchElementException();
        }
    }

    private SendMessage getSendMessageByCommand(String command, String chatId) {
        CommandResponse commandResponse = botApiClient.command(command).getBody();
        return getSendMessage(commandResponse.getScreenRout(), chatId, commandResponse.getTextMessage());
    }

    private SendMessage getSendMessageByButton(CallbackQuery callbackQuery, String chatId) {
        return SendMessage.builder()
                .text("")
                .chatId(chatId)
                .build();
    }

    private SendMessage getSendMessageByText(String text, String chatId) {
        ButtonMessageResponse buttonMessageResponse = botApiClient.buttonMessage(text).getBody();
        return getSendMessage(buttonMessageResponse.getScreenRout(), chatId, buttonMessageResponse.getTextMessage());
    }

    private SendMessage getSendMessage(Screen screen, String chatId, String textMessage) {
        ReplyKeyboardMarkup keyboardMarkup =
                botApiClient.replyKeyboard(screen).getBody();
        return SendMessage.builder()
                .text(textMessage)
                .replyMarkup(keyboardMarkup)
                .chatId(chatId)
                .build();
    }

    private MessageType getMessageType(Update update) {
        if (update.hasCallbackQuery()) {
            return MessageType.CALLBACK_BUTTON;
        } else {
            if (update.hasMessage() && StringUtils.startsWithIgnoreCase(update.getMessage().getText(), COMMAND_SYMBOL))
                return MessageType.COMMAND;
            else
                return MessageType.TEXT_BUTTON;
        }
    }
}
