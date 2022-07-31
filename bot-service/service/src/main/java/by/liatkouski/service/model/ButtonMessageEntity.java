package by.liatkouski.service.model;

import by.liatkouski.api.api.scope.dto.Screen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(schema = "bot", name = "button_messages")
public class ButtonMessageEntity implements Comparable<ButtonMessageEntity> {

    @EmbeddedId
    private ButtonMessageId id;
    @Enumerated(EnumType.STRING)
    @Column(name = "screen_rout")
    private Screen screenRout;
    @Column
    private int position;
    @Column
    private int line;
    @ManyToOne
    @JoinColumn(name = "text_message_id", nullable = false)
    private TextMessageEntity textMessage;

    @Override
    public String toString() {
        return "ButtonMessageEntity{" +
                "id=" + id +
                ", screenRout=" + screenRout +
                ", position=" + position +
                ", line=" + line +
                '}';
    }

    @Override
    public int compareTo(ButtonMessageEntity o) {
        return Integer.compare(getPosition(), o.getPosition());
    }
}

