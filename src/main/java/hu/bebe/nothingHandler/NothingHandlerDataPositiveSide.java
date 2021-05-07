package hu.bebe.nothingHandler;

final class NothingHandlerDataPositiveSide<T> extends NothingHandlerData<T> {

    NothingHandlerDataPositiveSide(T subject, boolean isOk) {
        super(subject, isOk);
    }

    public void thenThrow() {
        if (isOk) throw new NullPointerException();
    }

    public void thenThrow(RuntimeException e) {
        if (isOk) throw e;
    }
}
