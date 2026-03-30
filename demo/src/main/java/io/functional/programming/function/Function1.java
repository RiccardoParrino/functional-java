package io.functional.programming.function;

@FunctionalInterface
public interface Function1<T1, R> {
    R apply(T1 t1);
}
