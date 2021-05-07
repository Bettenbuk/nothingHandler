package hu.bebe.nothingHandler;

import org.junit.Assert;
import org.junit.Test;

import static hu.bebe.nothingHandler.NothingHandler.ifNotNull;
import static hu.bebe.nothingHandler.NothingHandler.ifNull;

public class NothingHandlerObjectTest {

    private static final Object NULL_RESULT = null;
    private static final Object RESULT = "RESULT";
    private static final Object OTHER_RESULT = "OTHER_RESULT";

    @Test
    public void ifNotNullTest() {
        ifNull(RESULT).thenThrow();
        ifNull(RESULT).thenThrow(new RuntimeException());
        Assert.assertEquals(OTHER_RESULT, ifNotNull(NULL_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow(RuntimeException::new));
    }

    @Test(expected = NullPointerException.class)
    public void ifNullThrowException1Test() {
        ifNull(NULL_RESULT).thenThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNullThrowException2Test() {
        ifNull(NULL_RESULT).thenThrow(new RuntimeException());
    }

    @Test(expected = NullPointerException.class)
    public void ifNotNullThrowException1Test() {
        ifNotNull(NULL_RESULT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotNullThrowException2Test() {
        ifNotNull(NULL_RESULT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotNullThrowException3Test() {
        ifNotNull(NULL_RESULT).orElseThrow(RuntimeException::new);
    }
}