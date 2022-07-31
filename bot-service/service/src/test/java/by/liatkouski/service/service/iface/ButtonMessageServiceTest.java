package by.liatkouski.service.service.iface;

import by.liatkouski.api.api.scope.dto.Screen;
import by.liatkouski.service.model.ButtonMessageEntity;
import by.liatkouski.service.model.ButtonMessageId;
import by.liatkouski.service.model.TextMessageEntity;
import by.liatkouski.service.repository.ButtonMessageRepository;
import by.liatkouski.service.service.ButtonMessageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class ButtonMessageServiceTest {


    @Mock
    private ButtonMessageRepository repository;
    private ButtonMessageService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ButtonMessageServiceImpl(repository);
    }

    @Test
    void canGetButtonIfExisting() {
        TextMessageEntity textMessage = new TextMessageEntity(5, "Акварель Текст BRUSHES screen");
        String textButtonExisting = "Акварель";
        ButtonMessageEntity buttonMessageEntity = new ButtonMessageEntity(new ButtonMessageId(textButtonExisting, Screen.BRUSHES), Screen.BRUSHES, 1, 1, textMessage);
        List<ButtonMessageEntity> buttonMessageEntities = List.of(
                buttonMessageEntity
        );
        given(repository.findByText(any()))
                .willReturn(buttonMessageEntities);
        given(repository.findByScreen(Screen.BRUSHES))
                .willReturn(buttonMessageEntity);

        ButtonMessageEntity buttonExisting = service.getButton(textButtonExisting);
        Assertions.assertEquals(buttonExisting, buttonMessageEntity);
    }

    @Test
    void canGetButtonIfNotExisting() {
        TextMessageEntity textMessage = new TextMessageEntity(5, "Акварель Текст BRUSHES screen");
        String textButton = "Акварель";
        ButtonMessageEntity buttonMessageEntity = new ButtonMessageEntity(new ButtonMessageId(textButton, Screen.BRUSHES), Screen.BRUSHES, 1, 1, textMessage);
        given(repository.findByText(any()))
                .willReturn(List.of());
        given(repository.findByScreen(Screen.BRUSHES))
                .willReturn(buttonMessageEntity);

        ButtonMessageEntity buttonNotExisting = service.getButton(textButton);
        Assertions.assertNotEquals(buttonMessageEntity, buttonNotExisting);
    }

    @Test
    void getButtonsByScreen() {
    }
}