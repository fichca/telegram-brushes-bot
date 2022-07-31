package by.liatkouski.service.repository;

import by.liatkouski.service.model.CommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<CommandEntity, String> {
}
