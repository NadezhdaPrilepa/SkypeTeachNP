package skype.teach.np.calculator.operation;

import skype.teach.np.calculator.exception.NpCalculationOperationException;
import skype.teach.np.calculator.exception.NpInvalidSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**
 * @author NPrilepa
 */
public class NpSquareRootOperation extends NpAbstractOperationSingleOperand {
    @Override
    public double calculateSingleOperands(NpOperandExpressionItem operand) {
        return Math.sqrt(operand.getValue());
    }

    public NpSquareRootOperation() {
        super("^", 1);
    }

    @Override
    protected boolean isValidOperands(List<NpOperandExpressionItem> operands) throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException,NpCalculationOperationException {
        super.isValidOperands(operands);
        NpOperandExpressionItem operand = operands.get(0);
        if (operand.getValue() < 0) {
            throw new NpCalculationOperationException();  //Line-2
        }
        return true;
    }
}
