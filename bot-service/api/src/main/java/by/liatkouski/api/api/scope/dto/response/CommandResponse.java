package by.liatkouski.api.api.scope.dto.response;

import by.liatkouski.api.api.scope.dto.Screen;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommandResponse {
    private String textMessage;
    @NonNull
    private Screen screenRout;
}
