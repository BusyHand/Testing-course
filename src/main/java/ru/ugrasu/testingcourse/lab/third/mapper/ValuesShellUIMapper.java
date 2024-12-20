package ru.ugrasu.testingcourse.lab.third.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ValuesShellUIMapper {

    public String toShellUi(List<Long> values) {
        return "{ " + values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + " }";
    }
}
