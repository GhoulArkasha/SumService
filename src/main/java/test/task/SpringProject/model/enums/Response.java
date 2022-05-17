package test.task.SpringProject.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Response {

    OK(0L, "ОК"),
    RECORD_ALREADY_EXISTS(1L, "Такая запись уже существует!"),
    RECORD_NOT_FOUND(2L, "Записи с таким именем не существует!"),
    SESSION_CREATION(3L, "Не удалось создать сессию"),
    SESSION_CLOSE(4L, "Не удалось закрыть сессию."),
    DATA_IS_NULL(5L, "Данные не были переданы.");


    private final long code;
    private final String description;

}
