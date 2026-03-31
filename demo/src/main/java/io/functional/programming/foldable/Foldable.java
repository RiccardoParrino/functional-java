package io.functional.programming.foldable;

import io.functional.programming.function.Function2;

import java.util.List;
import java.util.function.BinaryOperator;

public class Foldable {

    public static<T> T foldr(BinaryOperator<T> callback, T initialValue, List<T> values) {
        return values
                .stream()
                .reduce(initialValue, callback);
    }

    public static<T> T foldl(BinaryOperator<T> callback, T initialValue, List<T> values) {
        return values
                .reversed()
                .stream()
                .reduce(initialValue, callback);
    }
}
