package hu.bebe.nothingHandler;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static hu.bebe.nothingHandler.NothingHandler.*;

public class NothingHandlerCollectionTest {

    private static final Set<String> NULL_INPUT = null;
    private static final Set<String> EMPTY_INPUT = new HashSet<>();
    private static final Set<String> INPUT = Set.of("RESULT");
    private static final Set<String> RESULT = INPUT;
    private static final Set<String> RESULT_ELSE = Set.of("OTHER_RESULT");
    private static final Integer OTHER_RESULT = 1;
    private static final Integer OTHER_RESULT_ELSE = 2;

    @Test
    public void ifNotNullTest() {
        ifNull(RESULT).thenThrow();
        ifNull(RESULT).thenThrow(new RuntimeException());
        Assert.assertEquals(RESULT_ELSE, ifNotNull(NULL_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotEmptyTest() {
        ifEmpty(RESULT).thenThrow();
        ifEmpty(RESULT).thenThrow(new RuntimeException());
        Assert.assertEquals(RESULT_ELSE, ifNotEmpty(NULL_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT_ELSE, ifNotEmpty(EMPTY_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotNullOrEmptyOrBlankThenTest() {
        Assert.assertEquals(OTHER_RESULT, ifNotNull(INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT_ELSE, ifNotNull(NULL_INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT, ifNotEmpty(INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT_ELSE, ifNotEmpty(NULL_INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
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
    public void ifEmptyThrowException1Test() {
        ifEmpty(NULL_INPUT).thenThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifEmptyThrowException2Test() {
        ifEmpty(NULL_INPUT).thenThrow(new RuntimeException());
    }

    @Test(expected = NullPointerException.class)
    public void ifEmptyThrowException3Test() {
        ifEmpty(EMPTY_INPUT).thenThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifEmptyThrowException4Test() {
        ifEmpty(EMPTY_INPUT).thenThrow(new RuntimeException());
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
    public void ifNotEmptyThrowException1Test() {
        ifNotEmpty(NULL_INPUT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException2Test() {
        ifNotEmpty(NULL_INPUT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException3Test() {
        ifNotEmpty(NULL_INPUT).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotEmptyThrowException4Test() {
        ifNotEmpty(EMPTY_INPUT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException5Test() {
        ifNotEmpty(EMPTY_INPUT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException6Test() {
        ifNotEmpty(EMPTY_INPUT).orElseThrow(RuntimeException::new);
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

    @Test(expected = NullPointerException.class)
    public void ifNotEmptyThenThrowException1Test() {
        ifNotEmpty(NULL_INPUT).then(this::getValue).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThenThrowException2Test() {
        ifNotEmpty(NULL_INPUT).then(this::getValue).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThenThrowException3Test() {
        ifNotEmpty(NULL_INPUT).then(this::getValue).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotEmptyThenThrowException4Test() {
        ifNotEmpty(EMPTY_INPUT).then(this::getValue).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThenThrowException5Test() {
        ifNotEmpty(EMPTY_INPUT).then(this::getValue).then(this::getValue).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThenThrowException6Test() {
        ifNotEmpty(EMPTY_INPUT).then(this::getValue).orElseThrow(RuntimeException::new);
    }

    private Integer getValue(Object o) {
        return OTHER_RESULT;
    }
}