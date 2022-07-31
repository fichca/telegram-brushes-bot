package by.liatkouski.service.model;

import by.liatkouski.api.api.scope.dto.Screen;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ButtonMessageId implements Serializable {
    @Column
    private String text;
    @Enumerated(EnumType.STRING)
    @Column
    private Screen screen;
}


