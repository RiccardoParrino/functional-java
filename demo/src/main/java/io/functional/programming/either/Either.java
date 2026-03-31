package io.functional.programming.either;

import io.functional.programming.function.Function1;

import java.util.Optional;

public class Either<L,R> {

    private L left;
    private R right;

    private Either(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public Either() {
    }

    public static <L,R> Either<L,R> of(L left, R right) {
        return new Either<>(left, right);
    }

    public static <L,R> Either<L,R> left(L left) {
        return new Either<>(left, null);
    }

    public static <L,R> Either<L,R> right(R right) {
        return new Either<>(null, right);
    }

    public <S> Either<L,S> fmap(Function1<R,S> function) {
        if (this.right != null)
            return new Either<>(this.left, function.apply(this.right));
        else
            return new Either<>(this.left, null);
    }

    public <S> Either<L,S> mapRight(Function1<R,S> function) {
        if (this.right != null)
            return new Either<>(this.left, function.apply(this.right));
        else
            return new Either<>(this.left, null);
    }

    public <M> Either<M,R> mapLeft(Function1<L,M> function) {
        if(this.left != null)
            return new Either<>(function.apply(this.left), this.right);
        else
            return new Either<>(null, this.right);
    }

    public <M,S> Either<M,S> mapBoth(Function1<L,M> mapLeft, Function1<R,S> mapRight) {
        return new Either<>(
                Optional.ofNullable(this.left)
                                .map(mapLeft::apply)
                                        .orElse(null),
                Optional.ofNullable(this.right)
                                .map(mapRight::apply)
                                        .orElse(null));
    }

    public Optional<L> leftToOptional() {
        return Optional.ofNullable(this.left);
    }

    public Optional<R> rightToOptional() {
        return Optional.ofNullable(this.right);
    }

    public L left() {
        return this.left;
    }

    public R right() {
        return this.right;
    }

}
