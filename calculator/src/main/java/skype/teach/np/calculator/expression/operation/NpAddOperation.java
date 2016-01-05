package skype.teach.np.calculator.expression.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**
 * Add arithmetic operation. Required number of operands =2.
 * Operands must be defined and not empty. Name (Name is a symbol designation
 * of operation in exception) of Add operation is '+'.
 * Priority(operation with the highest priority is performed first) =0
 * @author NPrilepa
 */
public class NpAddOperation extends NpAbstractOperationTwoOperands implements NpOperationExpressionItem {
    public NpAddOperation() {
        super("+",0);
    }

    @Override
    protected double calculateTwoOperands(NpOperandExpressionItem operand1,NpOperandExpressionItem operand2) {
        return operand1.getValue() + operand2.getValue();
    }

}
