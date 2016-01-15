package skype.teach.np.calculator.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

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
}
