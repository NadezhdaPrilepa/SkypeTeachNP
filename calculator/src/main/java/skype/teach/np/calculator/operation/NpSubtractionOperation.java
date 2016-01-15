package skype.teach.np.calculator.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

/**
 * Subtraction arithmetic operation. Required number of operands =2.
 * Operands must be defined and not empty.
 * Name (name is a symbol designation of operation in exception) of Subtraction operation is '-'.
 * Priority(operation with the highest priority is performed first) =0
 * @author NPrilepa
 */
public class NpSubtractionOperation extends NpAbstractOperationTwoOperands  {

    public NpSubtractionOperation() {
        super("-",0);
    }

    @Override
    protected double calculateTwoOperands(NpOperandExpressionItem operand1,NpOperandExpressionItem operand2) {
        return operand1.getValue() - operand2.getValue();
    }

}
