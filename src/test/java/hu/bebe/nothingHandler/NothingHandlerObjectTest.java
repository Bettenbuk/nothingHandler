package hu.bebe.nothingHandler;

import org.junit.Assert;
import org.junit.Test;

import static hu.bebe.nothingHandler.NothingHandler.ifNotNull;
import static hu.bebe.nothingHandler.NothingHandler.ifNull;

public class NothingHandlerObjectTest {

    private static final Object NULL_INPUT = null;
    private static final Object INPUT = "INPUT";
    private static final Object RESULT_INPUT = INPUT;
    private static final Object RESULT_ELSE = "OTHER_RESULT";
    private static final Integer OTHER_RESULT = 1;
    private static final Integer OTHER_RESULT_ELSE = 2;

    @Test
    public void ifNotNullTest() {
        ifNull(INPUT).thenThrow();
        ifNull(INPUT).thenThrow(new RuntimeException());
        Assert.assertEquals(RESULT_ELSE, ifNotNull(NULL_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT_INPUT, ifNotNull(INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT_INPUT, ifNotNull(INPUT).orElseThrow());
        Assert.assertEquals(RESULT_INPUT, ifNotNull(INPUT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT_INPUT, ifNotNull(INPUT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotNullThenTest() {
        Assert.assertEquals(OTHER_RESULT, ifNotNull(INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT_ELSE, ifNotNull(NULL_INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
    }

    @Test(expected = NullPointerException.class)
    public void ifNullThrowException1Test() {
        ifNull(NULL_INPUT).thenThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNullThrowException2Test() {
        ifNull(NULL_INPUT).thenThrow(new RuntimeException());
    }

    @Test(expected = NullPointerException.class)
    public void ifNotNullThrowException1Test() {
        ifNotNull(NULL_INPUT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotNullThrowException2Test() {
        ifNotNull(NULL_INPUT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotNullThrowException3Test() {
        ifNotNull(NULL_INPUT).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotNullThenThrowException1Test() {
        ifNotNull(NULL_INPUT).then(this::getValue).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotNullThenThrowException2Test() {
        ifNotNull(NULL_INPUT).then(this::getValue).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotNullThenThrowException3Test() {
        ifNotNull(NULL_INPUT).then(this::getValue).orElseThrow(RuntimeException::new);
    }

    private Integer getValue(Object o) {
        return OTHER_RESULT;
    }
}