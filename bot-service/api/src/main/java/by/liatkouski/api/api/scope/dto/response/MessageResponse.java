package by.liatkouski.api.api.scope.dto.response;

import by.liatkouski.api.api.scope.dto.Screen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class MessageResponse {
    private String text;
    @NonNull
    private Screen screen;
}
