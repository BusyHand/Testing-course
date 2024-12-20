package ru.ugrasu.testingcourse.lab.third.repository;

import org.springframework.stereotype.Repository;
import ru.ugrasu.testingcourse.lab.third.exception.ArrayNotSortedException;
import ru.ugrasu.testingcourse.lab.third.exception.ValueNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ConsoleArrayRepository {

    private final CopyOnWriteArrayList<Long> values = new CopyOnWriteArrayList<>();

    private boolean isSorted() {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public int search(Long value) {
        if (!isSorted()) {
            throw new ArrayNotSortedException("Массив не отсортирован");
        }
        int position = Collections.binarySearch(values, value);
        if (position < 0) {
            throw new ValueNotFoundException("Значение: " + value + " не найдено");
        }
        return position + 1;
    }

    public void sortValues() {
        Collections.sort(values);
    }

    public List<Long> getAll() {
        return Collections.unmodifiableList(values);
    }

    public void delete(Long value) {
        boolean wasRemoved = values.remove(value);
        if (!wasRemoved) {
            throw new ValueNotFoundException("Значение: " + value + " не найдено");
        }
    }

    public void add(Long value) {
        values.add(value);
    }
}
