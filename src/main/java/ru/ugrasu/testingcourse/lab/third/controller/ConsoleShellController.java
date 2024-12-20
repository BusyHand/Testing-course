package ru.ugrasu.testingcourse.lab.third.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ugrasu.testingcourse.lab.third.exception.ArrayNotSortedException;
import ru.ugrasu.testingcourse.lab.third.exception.ValueNotFoundException;
import ru.ugrasu.testingcourse.lab.third.mapper.ValuesShellUIMapper;
import ru.ugrasu.testingcourse.lab.third.repository.ConsoleArrayRepository;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ConsoleShellController {

    private final ConsoleArrayRepository consoleRepository;
    private final ValuesShellUIMapper valuesShellUIMapper;

    @ShellMethod(key = "add", value = "Добавить значение")
    public String add(@ShellOption("Значение") Long value) {
        consoleRepository.add(value);
        return "Значение: " + value + " было добавлено";
    }

    @ShellMethod(key = "delete", value = "Удалить значение")
    public String delete(@ShellOption("Значение") Long value) {
        try {
            consoleRepository.delete(value);
            return "Значение: " + value + " было удаленно";
        } catch (ValueNotFoundException e) {
            return "Произошла ошибка: " + e.getMessage();
        }
    }

    @ShellMethod(key = "show", value = "Показать все значения")
    public String show() {
        List<Long> values = consoleRepository.getAll();
        return valuesShellUIMapper.toShellUi(values);
    }

    @ShellMethod(key = "sort", value = "Отсортировать все значения")
    public String sort() {
        consoleRepository.sortValues();
        return "Массив был успешно отсортирован";
    }

    @ShellMethod(key = "search", value = "Бинарный поиск конкретного значения")
    public String search(@ShellOption("Значение") Long value) {
        try {
            int position = consoleRepository.search(value);
            return "Значение: " + value + " было найдено на позиции: " + position;
        } catch (ValueNotFoundException | ArrayNotSortedException e) {
            return "Произошла ошибка: " + e.getMessage();
        }
    }

}
