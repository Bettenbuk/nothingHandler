package hu.bebe.nothingHandler;

abstract class NothingHandlerData<T> {

    protected final T subject;
    protected final boolean isOk;

    protected NothingHandlerData(T subject, boolean isOk) {
        this.subject = subject;
        this.isOk = isOk;
    }

}
