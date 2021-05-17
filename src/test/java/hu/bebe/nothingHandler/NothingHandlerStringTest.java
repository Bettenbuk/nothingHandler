package hu.bebe.nothingHandler;

import org.junit.Assert;
import org.junit.Test;

import static hu.bebe.nothingHandler.NothingHandler.*;

public class NothingHandlerStringTest {

    private static final String NULL_INPUT = null;
    private static final String EMPTY_INPUT = "";
    private static final String BLANK_INPUT = " ";
    private static final String INPUT = "INPUT";
    private static final String RESULT = INPUT;
    private static final String RESULT_ELSE = "OTHER_RESULT";
    private static final Integer OTHER_RESULT = 1;
    private static final Integer OTHER_RESULT_ELSE = 2;

    @Test
    public void ifNotNullTest() {
        Assert.assertEquals(RESULT_ELSE, ifNotNull(NULL_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotNull(INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotNull(INPUT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotNull(INPUT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotNull(INPUT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotEmptyTest() {
        Assert.assertEquals(RESULT_ELSE, ifNotEmpty(NULL_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT_ELSE, ifNotEmpty(EMPTY_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotEmpty(INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotEmpty(INPUT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotEmpty(INPUT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotEmpty(INPUT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotBlankTest() {
        Assert.assertEquals(RESULT_ELSE, ifNotBlank(NULL_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT_ELSE, ifNotBlank(EMPTY_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT_ELSE, ifNotBlank(BLANK_INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotBlank(INPUT).orElse(RESULT_ELSE));
        Assert.assertEquals(RESULT, ifNotBlank(INPUT).orElseThrow());
        Assert.assertEquals(RESULT, ifNotBlank(INPUT).orElseThrow(new RuntimeException()));
        Assert.assertEquals(RESULT, ifNotBlank(INPUT).orElseThrow(RuntimeException::new));
    }

    @Test
    public void ifNotNullOrEmptyOrBlankThenTest() {
        Assert.assertEquals(OTHER_RESULT, ifNotNull(INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT_ELSE, ifNotNull(NULL_INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT, ifNotEmpty(INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT_ELSE, ifNotEmpty(NULL_INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT, ifNotBlank(INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
        Assert.assertEquals(OTHER_RESULT_ELSE, ifNotBlank(NULL_INPUT).then(this::getValue).orElse(OTHER_RESULT_ELSE));
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
    public void ifNotBlankThrowException1Test() {
        ifNotBlank(NULL_INPUT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException2Test() {
        ifNotBlank(NULL_INPUT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException3Test() {
        ifNotBlank(NULL_INPUT).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThrowException4Test() {
        ifNotBlank(EMPTY_INPUT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException5Test() {
        ifNotBlank(EMPTY_INPUT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException6Test() {
        ifNotBlank(EMPTY_INPUT).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThrowException7Test() {
        ifNotBlank(BLANK_INPUT).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException8Test() {
        ifNotBlank(BLANK_INPUT).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThrowException9Test() {
        ifNotBlank(BLANK_INPUT).orElseThrow(RuntimeException::new);
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

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThenThrowException1Test() {
        ifNotBlank(NULL_INPUT).then(this::getValue).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThenThrowException2Test() {
        ifNotBlank(NULL_INPUT).then(this::getValue).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThenThrowException3Test() {
        ifNotBlank(NULL_INPUT).then(this::getValue).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThenThrowException4Test() {
        ifNotBlank(EMPTY_INPUT).then(this::getValue).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThenThrowException5Test() {
        ifNotBlank(EMPTY_INPUT).then(this::getValue).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThenThrowException6Test() {
        ifNotBlank(EMPTY_INPUT).then(this::getValue).orElseThrow(RuntimeException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ifNotBlankThenThrowException7Test() {
        ifNotBlank(BLANK_INPUT).then(this::getValue).orElseThrow();
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThenThrowException8Test() {
        ifNotBlank(BLANK_INPUT).then(this::getValue).orElseThrow(new RuntimeException());
    }

    @Test(expected = RuntimeException.class)
    public void ifNotBlankThenThrowException9Test() {
        ifNotBlank(BLANK_INPUT).then(this::getValue).orElseThrow(RuntimeException::new);
    }

    private Integer getValue(Object o) {
        return OTHER_RESULT;
    }
}