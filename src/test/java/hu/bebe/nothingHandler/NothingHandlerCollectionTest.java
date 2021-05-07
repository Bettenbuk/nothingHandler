package hu.bebe.nothingHandler;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static hu.bebe.nothingHandler.NothingHandler.*;

public class NothingHandlerCollectionTest {

    private static final Set<String> NULL_RESULT = null;
    private static final Set<String> EMPTY_RESULT = new HashSet<>();
    private static final Set<String> RESULT = Set.of("RESULT");
    private static final Set<String> OTHER_RESULT = Set.of("OTHER_RESULT");

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

    @Test
    public void ifNotEmptyTest() {
        ifEmpty(RESULT).thenThrow();
        ifEmpty(RESULT).thenThrow(new RuntimeException());
        Assert.assertEquals(OTHER_RESULT, ifNotEmpty(NULL_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(OTHER_RESULT, ifNotEmpty(EMPTY_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow(RuntimeException::new));
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
    public void ifEmptyThrowException1Test() {
        ifEmpty(NULL_RESULT).thenThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifEmptyThrowException2Test() {
        ifEmpty(NULL_RESULT).thenThrow(new RuntimeException());
    }

    @Test(expected = NullPointerException.class)
    public void ifEmptyThrowException3Test() {
        ifEmpty(EMPTY_RESULT).thenThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifEmptyThrowException4Test() {
        ifEmpty(EMPTY_RESULT).thenThrow(new RuntimeException());
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

    @Test(expected = NullPointerException.class)
    public void ifNotEmptyThrowException1Test() {
        ifNotEmpty(NULL_RESULT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException2Test() {
        ifNotEmpty(NULL_RESULT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException3Test() {
        ifNotEmpty(NULL_RESULT).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotEmptyThrowException4Test() {
        ifNotEmpty(EMPTY_RESULT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException5Test() {
        ifNotEmpty(EMPTY_RESULT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotEmptyThrowException6Test() {
        ifNotEmpty(EMPTY_RESULT).orElseThrow(RuntimeException::new);
    }

}