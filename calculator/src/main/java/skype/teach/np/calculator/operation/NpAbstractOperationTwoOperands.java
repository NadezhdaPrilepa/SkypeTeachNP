package skype.teach.np.calculator.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**Operation arithmetic expression do calculate under operands.
 * Operation required two operands.
 * Operands must be defined and not empty.
 * Operation has name and priority(operation with the highest priority is performed first)
 * Name is a symbol designation of operation in exception
 * Priority is a property operation that affect the order of its execution in expression
 * The same priority can be for several operations
 * @author NPrilepa
 */
public abstract class NpAbstractOperationTwoOperands extends NpAbstractOperation {

    public NpAbstractOperationTwoOperands(String name, int priority) {
        super(2, name, priority);
    }


    protected abstract double calculateTwoOperands(NpOperandExpressionItem operand1, NpOperandExpressionItem operand2);

    @Override
    protected double calculate(List<NpOperandExpressionItem> operands) {
        NpOperandExpressionItem operand1 = operands.get(0);
        NpOperandExpressionItem operand2 = operands.get(1);
        return calculateTwoOperands(operand1, operand2);
    }

}
