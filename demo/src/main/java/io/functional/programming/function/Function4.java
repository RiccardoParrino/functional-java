package io.functional.programming.function;

import io.functional.programming.optional.Option;

@FunctionalInterface
public interface Function4<T1, T2, T3, T4, R> {
    R apply(T1 t1, T2 t2, T3 t3, T4 t4);

    default Function1<T2, Function1<T3, Function1<T4,R>>> apply(T1 t1) {
        return this.curried()
                    .apply(t1);
    }

    default Function1<T3, Function1<T4,R>> apply(T1 t1, T2 t2) {
        return this.curried()
                .apply(t1)
                    .apply(t2);
    }

    default Function1<T4,R> apply(T1 t1, T2 t2, T3 t3) {
        return this.curried()
                .apply(t1)
                    .apply(t2)
                        .apply(t3);
    }

    default Function1<T1, Function1<T2, Function1<T3, Function1<T4, R>>>> curried() {
        return t1 -> {
            return t2 -> {
                return t3 -> {
                    return t4 -> {
                        return this.apply(t1,t2,t3,t4);
                    };
                };
            };
        };
    }

    static <T1,T2,T3,T4,R> Function4<T1,T2,T3,T4,Option<R>> lift (Function4<T1,T2,T3,T4,R> fun) {
        return (t1, t2, t3, t4) -> Option.of(fun.apply(t1,t2,t3,t4));
    }
}
