package by.liatkouski.service.controller.scope;

import by.liatkouski.api.api.scope.AnswerApi;
import by.liatkouski.api.api.scope.dto.ButtonMessageResponse;
import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.api.api.scope.dto.response.CommandResponse;
import by.liatkouski.service.model.ButtonMessageEntity;
import by.liatkouski.service.model.CommandEntity;
import by.liatkouski.service.service.iface.ButtonMessageService;
import by.liatkouski.service.service.iface.CommandService;
import by.liatkouski.service.service.iface.ReplyKeyboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@RestController
@AllArgsConstructor
public class AnswerController implements AnswerApi {

    private CommandService commandService;
    private ButtonMessageService buttonMessageService;
    private ReplyKeyboardService replyKeyboardService;

    @Override
    public ResponseEntity<CommandResponse> command(String command) {
        CommandEntity commandEntity = commandService.getCommand(command);
        return ResponseEntity.ok(CommandResponse.builder()
                .screenRout(commandEntity.getScreenRout())
                .textMessage(commandEntity.getTextMessage().getText())
                .build());
    }

    @Override
    public ResponseEntity<ReplyKeyboardMarkup> replyKeyboard(Screen screen) {
        return ResponseEntity.ok(replyKeyboardService.getKeyboard(screen));
    }

    @Override
    public ResponseEntity<ButtonMessageResponse> buttonMessage(String text) {
        ButtonMessageEntity buttonMessage = buttonMessageService.getButton(text);
        return ResponseEntity.ok(ButtonMessageResponse.builder()
                .screenRout(buttonMessage.getScreenRout())
                .textMessage(buttonMessage.getTextMessage().getText())
                .build());
    }
}
