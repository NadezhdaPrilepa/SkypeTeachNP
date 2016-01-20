package skype.teach.np.calculator.operation;

import skype.teach.np.calculator.exception.NpCalculationOperationException;
import skype.teach.np.calculator.exception.NpInvalidSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;
import skype.teach.np.calculator.expression.NpOperandExpressionItemImpl;

import java.util.List;

/**
 * Operation arithmetic expression do calculate under operands.
 * Each operation defines its required number of operands.
 * Operands must be defined and not empty.
 * Operation has name and priority(operation with the highest priority is performed first)
 * Name is a symbol designation of operation in exception
 * Priority is a property operation that affect the order of its execution in expression
 * The same priority can be for several operations
 *
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
     * @throws NpNullPointerOperatorCalculatorException   if operands are null
     * @throws NpInvalidSizeOfOperandsCalculatorException if size of list operands not equal @link NpOperationExpressionItem#getOperandsNumber()
     * @throws NpCalculationOperationException            if some operation has error with operands
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

    public final NpOperandExpressionItem doCalculate(List<NpOperandExpressionItem> operands) throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException, NpCalculationOperationException {
        isValidOperands(operands);
        return new NpOperandExpressionItemImpl(calculate(operands));

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
