package by.liatkouski.api.api.scope.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ButtonMessageResponse {
    private String textMessage;
    private Screen screenRout;
}
