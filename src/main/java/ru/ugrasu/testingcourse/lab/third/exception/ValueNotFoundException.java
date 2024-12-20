package ru.ugrasu.testingcourse.lab.third.exception;

public class ValueNotFoundException extends RuntimeException {
    public ValueNotFoundException(String message) {
        super(message);
    }
}
