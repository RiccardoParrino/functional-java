package io.functional.programming.reader;

import io.functional.programming.function.Function1;

public class Reader<C,A> {

    private final C config;
    private final Function1<C,A> run;

    private Reader(C config, Function1<C,A> run ) {
        this.config = config;
        this.run = run;
    }

    public static <C,A> Reader<C,A> of(C config, Function1<C,A> run) {
        return new Reader<>(config,run);
    }

    public A get() {
        return this.run.apply(this.config);
    }

}
