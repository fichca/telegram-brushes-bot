package by.liatkouski.service.repository;

import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.service.model.ButtonMessageEntity;
import by.liatkouski.service.model.ButtonMessageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ButtonMessageRepository extends JpaRepository<ButtonMessageEntity, ButtonMessageId> {

    @Query(value = "select b from ButtonMessageEntity b where b.id.text = :text")
    List<ButtonMessageEntity> findByText(String text);

    @Query(value = "select b from ButtonMessageEntity b where b.id.screen = :screen")
    List<ButtonMessageEntity> findAllByScreen(Screen screen);

    @Query(value = "select b from ButtonMessageEntity b where b.id.screen = :screen")
    ButtonMessageEntity findByScreen(Screen screen);
}
