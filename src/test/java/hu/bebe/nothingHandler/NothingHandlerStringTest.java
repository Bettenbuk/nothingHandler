package hu.bebe.nothingHandler;

import org.junit.Assert;
import org.junit.Test;

import static hu.bebe.nothingHandler.NothingHandler.*;

public class NothingHandlerStringTest {

    private static final String NULL_RESULT = null;
    private static final String EMPTY_RESULT = "";
    private static final String BLANK_RESULT = " ";
    private static final String RESULT = "RESULT";
    private static final String OTHER_RESULT = "OTHER_RESULT";

    @Test
    public void ifNotNullTest() {
        Assert.assertEquals(OTHER_RESULT, ifNotNull(NULL_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotNull(RESULT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotEmptyTest() {
        Assert.assertEquals(OTHER_RESULT, ifNotEmpty(NULL_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(OTHER_RESULT, ifNotEmpty(EMPTY_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotEmpty(RESULT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotBlankTest() {
        Assert.assertEquals(OTHER_RESULT, ifNotBlank(NULL_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(OTHER_RESULT, ifNotBlank(EMPTY_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(OTHER_RESULT, ifNotBlank(BLANK_RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotBlank(RESULT).orElse(OTHER_RESULT));
        Assert.assertEquals(RESULT, ifNotBlank(RESULT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotBlank(RESULT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotBlank(RESULT).orElseThrow(RuntimeException::new));
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

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThrowException1Test() {
        ifNotBlank(NULL_RESULT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException2Test() {
        ifNotBlank(NULL_RESULT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException3Test() {
        ifNotBlank(NULL_RESULT).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThrowException4Test() {
        ifNotBlank(EMPTY_RESULT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException5Test() {
        ifNotBlank(EMPTY_RESULT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException6Test() {
        ifNotBlank(EMPTY_RESULT).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThrowException7Test() {
        ifNotBlank(BLANK_RESULT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException8Test() {
        ifNotBlank(BLANK_RESULT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException9Test() {
        ifNotBlank(BLANK_RESULT).orElseThrow(RuntimeException::new);
    }

}