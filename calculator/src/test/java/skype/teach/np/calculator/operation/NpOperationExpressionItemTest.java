package skype.teach.np.calculator.operation;

import org.junit.Ignore;
import org.junit.Test;
import skype.teach.np.calculator.exception.NpCalculationOperationException;
import skype.teach.np.calculator.exception.NpInvalidSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;
import skype.teach.np.calculator.expression.NpOperandExpressionItemImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NPrilepa
 */
@Ignore
public abstract class NpOperationExpressionItemTest {
    @Test(expected = NpInvalidSizeOfOperandsCalculatorException.class)
    public void doCalculate_sizeOfOperandsInValid() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException,NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();

        List listOfOperandExpressionItem = new ArrayList();
        /*listOfOperandExpressionItem.add("5");
        if (npOperationExpressionItem.getOperandsNumber() != 1) {*/
        // Each operation contains at least one operand
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
        //}
    }

    @Test(expected = NpNullPointerOperatorCalculatorException.class)
    public void doCalculate_null() throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException,NpCalculationOperationException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(null);

    }


    protected abstract NpOperationExpressionItem createInstance();

    protected NpOperandExpressionItem createInstanceOperand(double value) {
        return new NpOperandExpressionItemImpl(value);
    }

}
