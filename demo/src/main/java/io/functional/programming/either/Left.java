package io.functional.programming.either;

public class Left<L,R> extends Either<L,R> {

    private L left;

    public Either<L,R> of(L left) {
        return Either.of(left, null);
    }
}
