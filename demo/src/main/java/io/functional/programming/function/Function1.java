package io.functional.programming.function;

import io.functional.programming.optional.Option;

@FunctionalInterface
public interface Function1<T1, R> {
    R apply(T1 t1);

    static <T1,R> Function1<T1, Option<R>> lift(Function1<T1,R> fun) {
        return t1 -> Option.of(fun.apply(t1));
    }
}
