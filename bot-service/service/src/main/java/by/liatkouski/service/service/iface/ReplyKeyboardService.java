package by.liatkouski.service.service.iface;

import by.liatkouski.api.api.scope.dto.Screen;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface ReplyKeyboardService {
    ReplyKeyboardMarkup getKeyboard(Screen screen);
}