package skype.teach.np.calculator.expression.operation;

import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**
 * Multi arithmetic operation. Required number of operands =2.
 * Operands must be defined and not empty.
 * Name (name is a symbol designation of operation in exception) of Multi operation is '*'.
 * Priority(operation with the highest priority is performed first) =1
 * @author NPrilepa
 */
public class NpMultiOperation extends NpAbstractOperationTwoOperands implements  NpOperationExpressionItem{

    public NpMultiOperation() {
        super("*",1);
    }

    @Override
    protected double calculateTwoOperands(NpOperandExpressionItem operand1,NpOperandExpressionItem operand2) {
        return operand1.getValue() * operand2.getValue();
    }

}
