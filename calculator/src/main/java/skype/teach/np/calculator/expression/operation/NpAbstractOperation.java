package skype.teach.np.calculator.expression.operation;

import skype.teach.np.calculator.exception.NpCalculationOperationException;
import skype.teach.np.calculator.exception.NpInvalidSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;
import skype.teach.np.calculator.expression.NpOperandExpressionItemImpl;

import java.util.List;

/**
 * @author NPrilepa
 */
public abstract class NpAbstractOperation implements NpOperationExpressionItem {

    private final int numberOfOperands;

    private final String name;

    private final int priority;

    public NpAbstractOperation(int numberOfOperands, String name, int priority) {

        this.numberOfOperands = numberOfOperands;

        this.name = name;

        this.priority = priority;
    }

    /**
     * Check operands - any operands can not be null and number
     * of operands must be equal {@link NpOperationExpressionItem#getOperandsNumber()}</nb>
     *
     * @param operands of operation
     * @return true if operands are correct
     */
    protected boolean isValidOperands(List<NpOperandExpressionItem> operands) throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {

        if (operands == null) {
            throw new NpNullPointerOperatorCalculatorException();  //Line-2

        }
        if (operands.size() != getOperandsNumber()) {
            throw new NpInvalidSizeOfOperandsCalculatorException();  //Line-2

        }
        for (int i = 0; i < operands.size(); i++) {
            if (operands.get(i) == null) {
                throw new NpNullPointerOperatorCalculatorException();  //Line-2

            }
        }


        return true;
    }

    protected abstract double calculate(List<NpOperandExpressionItem> operands);

    public final NpOperandExpressionItem doCalculate(List<NpOperandExpressionItem> operands) throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException,NpCalculationOperationException {
        if (isValidOperands(operands)) {
            return new NpOperandExpressionItemImpl(calculate(operands));
        }
        return null;
    }

    public final int getOperandsNumber() {

        return numberOfOperands;
    }

    public final String getName() {
        return name;
    }

    public final int getPriority() {
        return priority;
    }
}
