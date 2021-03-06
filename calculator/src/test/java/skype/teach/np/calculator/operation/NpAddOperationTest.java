package skype.teach.np.calculator.operation;

import org.junit.Test;
import skype.teach.np.calculator.exception.NpCalculationOperationException;
import skype.teach.np.calculator.exception.NpInvalidSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author NPrilepa
 */
public class NpAddOperationTest extends NpOperationExpressionItemTest {
    @Override
    protected NpOperationExpressionItem createInstance() {
        return new NpAddOperation();
    }

    @Test(expected = NpInvalidSizeOfOperandsCalculatorException.class)
    public void doCalculate_sizeOfOperandsInvalid() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();

        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(createInstanceOperand(5));
        /*
        if (npOperationExpressionItem.getOperandsNumber() != 1) {*/
        // Each operation contains at least one operand
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
        //}
    }

    @Test(expected = NpInvalidSizeOfOperandsCalculatorException.class)
    public void doCalculate_sizeOfOperandsInvalidMore() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();

        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(createInstanceOperand(5));
        listOfOperandExpressionItem.add(createInstanceOperand(3));
        listOfOperandExpressionItem.add(createInstanceOperand(4));
        /*
        if (npOperationExpressionItem.getOperandsNumber() != 1) {*/
        // Each operation contains at least one operand
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
        //}
    }

    @Test(expected = NpNullPointerOperatorCalculatorException.class)
    public void doCalculate_oneOperandEmpty() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException,NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List<NpOperandExpressionItem> listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(null);
        listOfOperandExpressionItem.add(createInstanceOperand(5));
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
    }

    public void assertEqualsCalculate(String method_name, double operand1, double operand2, double assertResult, int assertPriority, String assertName) throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List<NpOperandExpressionItem> listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(createInstanceOperand(operand1));
        listOfOperandExpressionItem.add(createInstanceOperand(operand2));
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
        assertEquals("value of result of calculate " + method_name, assertResult, npOperandExceptionItem.getValue(), 0.000001);
        assertEquals("priority of operation " + method_name, assertPriority, npOperationExpressionItem.getPriority());
        assertEquals("name of operation " + method_name, assertName, npOperationExpressionItem.getName());

    }

    @Test
    public void doCalculate_simpleOperands() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("simpleOperands", 4, 5, 9, 0,"+");
    }

    @Test
    public void doCalculate_zeroOperand() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("zeroOperand", 0, 5, 5, 0,"+");
    }

    @Test
    public void doCalculate_zeroOperands() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("zeroOperands", 0, 0, 0, 0,"+");
    }

    @Test
    public void doCalculate_floatOperands() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("floatOperands", 1.3, 5.4, 6.7, 0,"+");
    }

    @Test
    public void doCalculate_negativeOperands() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("negativeOperands", -4, -4, -8, 0,"+");
    }

    @Test
    public void doCalculate_negativeOneOperands() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("negativeOneOperands", -4, 4, 0, 0,"+");
    }

}
