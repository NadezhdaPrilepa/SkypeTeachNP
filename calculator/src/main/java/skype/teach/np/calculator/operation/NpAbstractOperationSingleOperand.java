package skype.teach.np.calculator.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**Operation arithmetic expression do calculate under operands.
 * Operation required one operand.
 * Operand must be defined and not empty.
 * Operation has name and priority(operation with the highest priority is performed first)
 * Name is a symbol designation of operation in exception
 * Priority is a property operation that affect the order of its execution in expression
 * The same priority can be for several operations
 * @author NPrilepa
 */
public abstract class NpAbstractOperationSingleOperand extends NpAbstractOperation {

    public NpAbstractOperationSingleOperand(String name, int priority) {
        super(1, name, priority);
    }

    @Override
    protected double calculate(List<NpOperandExpressionItem> operands) {
        NpOperandExpressionItem operand = operands.get(0);
        return calculateSingleOperands(operand);
    }

    public abstract double calculateSingleOperands(NpOperandExpressionItem operand);
}
