package by.liatkouski.service.mapper;

import by.liatkouski.api.api.scope.dto.response.CommandResponse;
import by.liatkouski.service.model.CommandEntity;
import org.mapstruct.factory.Mappers;

public interface CommandMapper {
    CommandMapper INSTANCE = Mappers.getMapper(CommandMapper.class);

    CommandResponse toCommandResponse(CommandEntity command);
}
