package io.functional.programming.either;

public class Right<L,R> extends Either<L,R> {

    private R right;

    public Either<L,R> of(R right) {
        return Either.of(null, right);
    }

}
