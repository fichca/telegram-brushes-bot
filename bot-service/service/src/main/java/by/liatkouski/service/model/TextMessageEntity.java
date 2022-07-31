package by.liatkouski.service.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(schema = "bot", name = "text_messages")
public class TextMessageEntity {

    public TextMessageEntity(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "text")
    private String text;
    @OneToMany(mappedBy = "textMessage")
    private Set<ButtonMessageEntity> buttonMessages;
    @OneToMany(mappedBy = "textMessage")
    private Set<CommandEntity> commands;

    @Override
    public String toString() {
        return "TextMessageEntity{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
