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
@Table(schema = "bot", name = "commands")
public class CommandEntity {
    @Id
    @Column
    private String text;
    @Enumerated(EnumType.STRING)
    @Column(name = "screen_rout")
    private Screen screenRout;
    @ManyToOne
    @JoinColumn(name = "text_message_id", nullable = false)
    private TextMessageEntity textMessage;

    @Override
    public String toString() {
        return "CommandEntity{" +
                "text='" + text + '\'' +
                ", screenRout=" + screenRout +
                '}';
    }
}
