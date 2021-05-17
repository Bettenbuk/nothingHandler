package hu.bebe.nothingHandler;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Supplier;

final class NothingHandlerDataNegativeSide<T> extends NothingHandlerData<T> {

    NothingHandlerDataNegativeSide(T subject, boolean isOk) {
        super(subject, isOk);
    }

    public T orElseThrow() {
        if (isOk) return subject;
        throw new NullPointerException();
    }

    public T orElseThrow(@NotNull RuntimeException e) {
        if (isOk) return subject;
        throw e;
    }

    public T orElseThrow(@NotNull Supplier<RuntimeException> exceptionSupplier) {
        if (isOk) return subject;
        throw exceptionSupplier.get();
    }

    public T orElse(@NotNull T otherSubject) {
        if (isOk) return subject;
        return otherSubject;
    }

    public <R> NothingHandlerDataNegativeSide<R> then(Function<T, R> function) {
        if (isOk) return new NothingHandlerDataNegativeSide<>(function.apply(subject), true);
        return new NothingHandlerDataNegativeSide<>(null, false);
    }
}
