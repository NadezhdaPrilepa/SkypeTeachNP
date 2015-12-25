package skype.teach.np.calculator.expression.operation;

import skype.teach.np.calculator.exception.NpInCorrectOperandException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.exception.NpSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.expression.NpExpressionItem;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;

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
public interface NpOperationExpressionItem extends NpExpressionItem {
    /**
     * Get symbol designation of operation in exception
     *
     * @return name of operation
     */
    String getName();

    /**
     * Get priority of operation that affect the order of its execution in expression
     *
     * @return
     */
    int getPriority();

    /**
     * Get result of operation under operand.
     *
     * @param operands List of input operands. Size of the list must be equal
     *                 to {@link NpOperationExpressionItem#getOperandsNumber()}
     * @return NpOperandExpressionItem result of operation
     * @throws NpNullPointerOperatorCalculatorException If operand not defined or null</nb>
     * @throws NpSizeOfOperandsCalculatorException      If Size of the list operands not equal {@link NpOperationExpressionItem#getOperandsNumber()}</nb>
     *
     */
    NpOperandExpressionItem doCalculate(List<NpOperandExpressionItem> operands) throws NpNullPointerOperatorCalculatorException, NpSizeOfOperandsCalculatorException;

    /**
     * Get number of operands for operation
     *
     * @return number of operands
     */
    int getOperandsNumber();
}
