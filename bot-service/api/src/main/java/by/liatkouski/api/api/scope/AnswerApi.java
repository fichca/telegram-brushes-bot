package by.liatkouski.api.api.scope;

import by.liatkouski.api.api.scope.dto.ButtonMessageResponse;
import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.api.api.scope.dto.response.CommandResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface AnswerApi {

    @GetMapping("/scope/bot/answer/command")
    @ApiOperation(value = "Get command by message")
    ResponseEntity<CommandResponse> command(@RequestParam String command);

    @GetMapping("/scope/bot/answer/buttons/reply")
    @ApiOperation(value = "Get screen callback query")
    ResponseEntity<ReplyKeyboardMarkup> replyKeyboard(@RequestParam Screen screen);

    @GetMapping("/scope/bot/answer/buttons/inline")
    @ApiOperation(value = "Get screen buttons")
    ResponseEntity<ButtonMessageResponse> buttonMessage(@RequestParam String text);

}
