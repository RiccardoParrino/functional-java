package io.functional.programming.function;

import io.functional.programming.optional.Option;

@FunctionalInterface
public interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);

    default Function1<T2, Function1<T3,R>> apply(T1 t1) {
        return curried()
                .apply(t1);
    }

    default  Function1<T3, R> apply(T1 t1, T2 t2) {
        return this.apply(t1).apply(t2);
    }

    default Function1<T1, Function1<T2, Function1<T3,R>>> curried() {
        return t1 -> {
            return t2 -> {
                return t3 -> {
                    return this.apply(t1,t2,t3);
                };
            };
        };
    }

    static <T1,T2,T3,R> Function3<T1,T2,T3, Option<R>> lift (Function3<T1,T2,T3,R> fun) {
        return (t1, t2, t3) -> Option.of(fun.apply(t1,t2,t3));
    }
}
