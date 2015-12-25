package skype.teach.np.calculator.expression.operation;
import org.junit.Test;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.exception.NpSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;


import java.util.ArrayList;
import java.util.List;

/**
 * @author NPrilepa
 */
public abstract class NpOperationExpressionItemTest {
    @Test(expected = NpSizeOfOperandsCalculatorException.class)
    public void doCalculate_sizeOfOperandsInValid() throws NpNullPointerOperatorCalculatorException, NpSizeOfOperandsCalculatorException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();

        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add("5");
        if (npOperationExpressionItem.getOperandsNumber() != 1) {
            NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
        }
    }

    @Test(expected = NpNullPointerOperatorCalculatorException.class)
    public void doCalculate_null() throws NpNullPointerOperatorCalculatorException, NpSizeOfOperandsCalculatorException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(null);

    }

    @Test(expected = NpNullPointerOperatorCalculatorException.class)
    public void doCalculate_empty() throws NpNullPointerOperatorCalculatorException, NpSizeOfOperandsCalculatorException {

        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add("");
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
    }

    @Test(expected = NpNullPointerOperatorCalculatorException.class)
    public void doCalculate_oneOperandEmpty() throws NpNullPointerOperatorCalculatorException, NpSizeOfOperandsCalculatorException {

        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add("");
        listOfOperandExpressionItem.add("5");
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
    }

    @Test(expected = NpNullPointerOperatorCalculatorException.class)
    public void doCalculate_space() throws NpNullPointerOperatorCalculatorException, NpSizeOfOperandsCalculatorException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(" ");
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
    }

    @Test(expected = NpNullPointerOperatorCalculatorException.class)
    public void doCalculate_oneOperandSpace() throws NpNullPointerOperatorCalculatorException, NpSizeOfOperandsCalculatorException {
        NpOperationExpressionItem npOperationExpressionItem = createInstance();
        List listOfOperandExpressionItem = new ArrayList();
        listOfOperandExpressionItem.add(" ");
        listOfOperandExpressionItem.add("5");
        NpOperandExpressionItem npOperandExceptionItem = npOperationExpressionItem.doCalculate(listOfOperandExpressionItem);
    }

    protected abstract NpOperationExpressionItem createInstance();
}
