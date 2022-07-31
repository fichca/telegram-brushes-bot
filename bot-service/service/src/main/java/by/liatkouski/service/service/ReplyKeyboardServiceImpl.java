package by.liatkouski.service.service;

import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.service.model.ButtonMessageEntity;
import by.liatkouski.service.service.iface.ButtonMessageService;
import by.liatkouski.service.service.iface.ReplyKeyboardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ReplyKeyboardServiceImpl implements ReplyKeyboardService {
    private ButtonMessageService buttonMessageService;


    @Override
    public ReplyKeyboardMarkup getKeyboard(Screen screen) {
        List<ButtonMessageEntity> buttons = buttonMessageService.getButtonsByScreen(screen);
        Collections.sort(buttons);
        int previousLine = 1;
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        for (ButtonMessageEntity button : buttons) {
            if (button.getLine() != previousLine) {
                keyboard.add(row);
                row = new KeyboardRow();
                previousLine = button.getLine();
            }
            row.add(new KeyboardButton(button.getId().getText()));
        }
        keyboard.add(row);
        return new ReplyKeyboardMarkup(keyboard);
    }
}
