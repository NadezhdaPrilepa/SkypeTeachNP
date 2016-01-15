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
public class NpSquareRootOperationTest extends NpOperationExpressionItemTest {
    @Override
    protected NpOperationExpressionItem createInstance() {
        return new NpSquareRootOperation();
    }
    @Test(expected = NpInvalidSizeOfOperandsCalculatorException.class)
    public void doCalculate_sizeOfOperandsInvalid() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();

        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(createInstanceOperand(5));
        listOfOperandExpressionItem.add(createInstanceOperand(6));
        /*
        if (npOperationExpressionItem.getOperandsNumber() != 1) {*/
        // Each operation contains at least one operand
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
        //}
    }
    @Test(expected = NpCalculationOperationException.class)
    public void doCalculate_negativeOperand() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException,NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(createInstanceOperand(-16));
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
    }

    public void assertEqualsCalculate(String method_name, double operand, double assertResult, int assertPriority, String assertName) throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List<NpOperandExpressionItem> listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(createInstanceOperand(operand));
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
        assertEquals("value of result of calculate " + method_name, assertResult, npOperandExceptionItem.getValue(), 0.000001);
        assertEquals("priority of operation " + method_name, assertPriority, npOperationExpressionItem.getPriority());
        assertEquals("name of operation " + method_name, assertName, npOperationExpressionItem.getName());

    }
    @Test
    public void doCalculate_simpleOperands() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("simpleOperands", 4, 2, 1, "^");
    }

    @Test
    public void doCalculate_zeroOperands() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        assertEqualsCalculate("simpleOperands", 0, 0, 1, "^");
    }


}
