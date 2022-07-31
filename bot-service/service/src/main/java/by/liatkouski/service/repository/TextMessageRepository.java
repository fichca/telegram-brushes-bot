package by.liatkouski.service.repository;

import by.liatkouski.service.model.TextMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextMessageRepository extends JpaRepository<TextMessageEntity, String> {
}
