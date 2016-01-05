package skype.teach.np.calculator.expression.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**
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
