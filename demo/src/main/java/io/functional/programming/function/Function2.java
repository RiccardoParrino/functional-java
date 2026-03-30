package io.functional.programming.function;

import io.functional.programming.optional.Option;

@FunctionalInterface
public interface Function2<T1, T2, R> {
    R apply(T1 t1, T2 t2);

    default Function1<T2,R> apply(T1 t1) {
        return curried()
                .apply(t1);
    }

    default Function1<T1, Function1<T2,R>> curried() {
        return t1 -> {
            return t2 -> {
                return this.apply(t1, t2);
            };
        };
    }

    static <T1,T2,R> Function2<T1,T2,Option<R>> lift(Function2<T1,T2,R> fun) {
        return (t1, t2) -> Option.of(fun.apply(t1,t2));
    }

}