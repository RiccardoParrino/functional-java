package io.functional.programming.lazy;

import javax.swing.*;
import java.util.function.Supplier;

public class Lazy<T> {

    private T value;
    private final Supplier<T> supplier;

    private Lazy(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> Lazy<T> of(Supplier<T> supplier) {
        return new Lazy<>(supplier);
    }

    public T get() {
        if (this.value == null) {
            this.value = supplier.get();
        }
        return this.value;
    }

}
