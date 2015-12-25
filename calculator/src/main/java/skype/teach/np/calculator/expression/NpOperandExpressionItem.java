package skype.teach.np.calculator.expression;

/**
 * Operand of arithmetic operation. Data that are processed by the operation
 *
 * @author NPrilepa
 */
public interface NpOperandExpressionItem extends NpExpressionItem {
    /**
     * Get value of operand
     * @return double value of operand
     */
    double getValue();
}
