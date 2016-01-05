package skype.teach.np.calculator.expression.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**
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
