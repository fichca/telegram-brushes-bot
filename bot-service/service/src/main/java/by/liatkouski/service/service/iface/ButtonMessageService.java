package by.liatkouski.service.service.iface;

import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.service.model.ButtonMessageEntity;

import java.util.List;

public interface ButtonMessageService {
    ButtonMessageEntity getButton(String text);

    List<ButtonMessageEntity> getButtonsByScreen(Screen screen);
}
