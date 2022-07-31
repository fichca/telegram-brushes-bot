package by.liatkouski.service.service;

import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.service.model.ButtonMessageEntity;
import by.liatkouski.service.repository.ButtonMessageRepository;
import by.liatkouski.service.service.iface.ButtonMessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ButtonMessageServiceImpl implements ButtonMessageService {
    private ButtonMessageRepository repository;


    @Override
    public ButtonMessageEntity getButton(String text) {
        List<ButtonMessageEntity> buttonMessageEntityList = repository.findByText(text.trim());
        if (!buttonMessageEntityList.isEmpty()) {
            return buttonMessageEntityList.get(0);
        } else {
            return repository.findByScreen(Screen.BLANK);
        }
    }

    @Override
    public List<ButtonMessageEntity> getButtonsByScreen(Screen screen) {
        return repository.findAllByScreen(screen);
    }
}
