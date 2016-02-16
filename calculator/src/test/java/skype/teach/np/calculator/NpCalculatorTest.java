package skype.teach.np.calculator;

import org.junit.Test;
import skype.teach.np.calculator.exception.NpCalculatorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author NPrilepa
 */
public abstract class NpCalculatorTest {
    @Test(expected = NpCalculatorException.class)
    public void calculate_divisionZero() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5/0");
    }
    @Test(expected = NpCalculatorException.class)
    public void calculate_divisionZeroException() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5/(4-4)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_emptyString() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_space() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate(" ");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_spaceInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("( )");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_emptyInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("()");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_onlyGroupClose() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_onlyGroupOpen() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate(")");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_null() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate(null);
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_doubleOperatorBetweenOperand() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5--6");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_doubleOperatorBetweenOperandInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5--6)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_doubleOperatorBeforeOperand() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("++5");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_doubleOperatorBeforeOperandInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(++5)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_doubleOperatorAfterOperand() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5++");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_doubleOperatorAfterOperandInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5++)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedOperandLast() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5+");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedOperandLastInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5+)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedOperands() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("-5+");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedLastOperandAndGroupOpen() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5+)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedFirstOperandAndGroupOpen() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("-5)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedFirstOperandAndGroupClose() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(-5");
    }
    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedLastOperandAndGroupClose() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5+");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedOperandsInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(-5-6+)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedOperandsAndGroupClose() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(-5-6+");
    }
    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedOperandsAndGroupOpen() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("-5-6+)");
    }


    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedGroupOpen() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5+7))");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedGroupClose() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("((4+7)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedSimpleOperandGroupOpen() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedSimpleOperandGroupClose() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedNotDefinedSymbol() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("@");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedNotDefinedSymbolInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(@)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedNotDefinedOperator() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5@7");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedNotDefinedOperatorExpectedGroupClose() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5@7");
    }
    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedNotDefinedOperatorExpectedGroupOpen() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("5@7)");
    }

    @Test(expected = NpCalculatorException.class)
    public void calculate_expectedNotDefinedOperatorInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        npCalculator.calculate("(5@7)");
    }

    @Test
    public void calculate_simpleOperand() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("5");
        assertTrue("calculate_simpleOperand result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_simpleOperand equals npResult.getValue()", 5, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_simpleOperandNegative() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("-5");
        assertTrue("calculate_simpleOperandNegative result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_simpleOperandNegative equals npResult.getValue()", -5, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_samePriority() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("5+7-5");
        assertTrue("calculate_samePriority result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_samePriority equals npResult.getValue()", 7, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_Zero() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("0-0.0");
        assertTrue("calculate_samePriority result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_samePriority equals npResult.getValue()", 0, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_samePriorityFloat() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("5.1+7.1-5.0");
        assertTrue("calculate_samePriority result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_samePriority equals npResult.getValue()", 7.2, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_samePriorityInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("(5+7-5)");
        assertTrue("calculate_samePriorityInsideGroup result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_samePriorityInsideGroup equals npResult.getValue()", 7, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_samePriorityWithGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("5+(7-5)");
        assertTrue("calculate_samePriorityWithGroup result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_samePriorityWithGroup equals npResult.getValue()", 7, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_samePriorityWithGroupNested() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("(5+(7-5))");
        assertTrue("calculate_samePriorityWithGroupNested result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_samePriorityWithGroupNested equals npResult.getValue()", 7, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_differentPriority() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("5+4*2");
        assertTrue("calculate_differentPriority result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_differentPriority equals npResult.getValue()", 13, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_differentPriorityInsideGroup() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("(5+4*2)");
        assertTrue("calculate_differentPriorityInsideGroup result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_differentPriorityInsideGroup equals npResult.getValue()", 13, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_differentPriorityWithGroupLow() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("(5+4)*2");
        assertTrue("calculate_differentPriorityWithGroupLow result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_differentPriorityWithGroupLow equals npResult.getValue()", 18, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_differentPriorityWithGroupHigh() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("5+(4*2)");
        assertTrue("calculate_differentPriorityWithGroupHigh result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_differentPriorityWithGroupHigh equals npResult.getValue()", 13, npResult.getValue(), 0.000001);
    }

    @Test
    public void calculate_difficultExpression() throws NpCalculatorException {
        NpCalculator npCalculator = createInstance();
        NpResult npResult = npCalculator.calculate("(5+9)*6-18/9*3*(1+4)-12");
        assertTrue("calculate_difficultExpression result of calculate instance of NpResult ",npResult instanceof NpResult);
        assertEquals("value of result calculate_difficultExpression equals npResult.getValue()", 42, npResult.getValue(), 0.000001);
    }

    protected abstract NpCalculator createInstance();
}
