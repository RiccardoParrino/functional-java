package io.functional.programming.optional;

public class Option<T> {

    private final T value;

    private Option(T value) {
        this.value = value;
    }

    public static <T> Option<T> of(T value) {
        return new Option<>(value);
    }

}
