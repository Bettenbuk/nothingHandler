package hu.bebe.nothingHandler;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

public final class NothingHandler {

    private NothingHandler() {
    }

    public static <R> NothingHandlerDataPositiveSide<R> ifNull(R subject) {
        return new NothingHandlerDataPositiveSide<>(subject, Objects.isNull(subject));
    }

    public static NothingHandlerDataPositiveSide<String> ifEmpty(String subject) {
        return new NothingHandlerDataPositiveSide<>(subject, StringUtils.isEmpty(subject));
    }

    public static NothingHandlerDataPositiveSide<Collection<?>> ifEmpty(Collection<?> subject) {
        return new NothingHandlerDataPositiveSide<>(subject, Objects.isNull(subject) || subject.isEmpty());
    }

    public static NothingHandlerDataPositiveSide<String> ifBlank(String subject) {
        return new NothingHandlerDataPositiveSide<>(subject, StringUtils.isBlank(subject));
    }

    public static <R> NothingHandlerDataNegativeSide<R> ifNotNull(R subject) {
        return new NothingHandlerDataNegativeSide<>(subject, Objects.nonNull(subject));
    }

    public static NothingHandlerDataNegativeSide<String> ifNotEmpty(String subject) {
        return new NothingHandlerDataNegativeSide<>(subject, StringUtils.isNotEmpty(subject));
    }

    public static NothingHandlerDataNegativeSide<String> ifNotBlank(String subject) {
        return new NothingHandlerDataNegativeSide<>(subject, StringUtils.isNotBlank(subject));
    }

    public static NothingHandlerDataNegativeSide<Collection<?>> ifNotEmpty(Collection<?> subject) {
        return new NothingHandlerDataNegativeSide<>(subject, Objects.nonNull(subject) && !subject.isEmpty());
    }
}
