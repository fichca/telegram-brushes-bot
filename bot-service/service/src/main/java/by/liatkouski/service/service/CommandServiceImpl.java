package by.liatkouski.service.service;

import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.service.model.CommandEntity;
import by.liatkouski.service.repository.CommandRepository;
import by.liatkouski.service.service.iface.CommandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommandServiceImpl implements CommandService {
    private CommandRepository repository;

    @Override
    public CommandEntity getCommand(String command) {
        Optional<CommandEntity> commandEntity = repository.findById(command.trim());
        return commandEntity.orElseGet(() -> repository.getById(Screen.BLANK.toString()));
    }
}
