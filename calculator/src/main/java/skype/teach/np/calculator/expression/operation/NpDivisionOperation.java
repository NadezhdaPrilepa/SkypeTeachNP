package skype.teach.np.calculator.expression.operation;

import skype.teach.np.calculator.exception.NpCalculationOperationException;
import skype.teach.np.calculator.exception.NpInvalidSizeOfOperandsCalculatorException;
import skype.teach.np.calculator.exception.NpNullPointerOperatorCalculatorException;
import skype.teach.np.calculator.expression.NpOperandExpressionItem;

import java.util.List;

/**
 * Division arithmetic operation. Required number of operands =2.
 * Operands must be defined and not empty. Second operand must be non zero.
 * Name (name is a symbol designation of operation in exception) of Division operation is '/'.
 * Priority(operation with the highest priority is performed first) =1
 * @author NPrilepa
 */

public class NpDivisionOperation extends NpAbstractOperationTwoOperands implements NpOperationExpressionItem {
    public NpDivisionOperation() {
        super("/",1);
    }

    @Override
    protected boolean isValidOperands(List<NpOperandExpressionItem> operands) throws NpNullPointerOperatorCalculatorException, NpInvalidSizeOfOperandsCalculatorException,NpCalculationOperationException {
        if (super.isValidOperands(operands)) {

            NpOperandExpressionItem operand = operands.get(1);
            if (operand.getValue() == 0) {
                throw new NpCalculationOperationException();  //Line-2
            }
            return true;
        }
        return false;
    }

    @Override
    protected double calculateTwoOperands(NpOperandExpressionItem operand1,NpOperandExpressionItem operand2) {
        return operand1.getValue() / operand2.getValue();
    }



}
