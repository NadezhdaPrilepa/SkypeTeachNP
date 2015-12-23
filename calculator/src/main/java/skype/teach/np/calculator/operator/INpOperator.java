package skype.teach.np.calculator.operator;

import skype.teach.np.calculator.INpNumber;

/**class - member of expression-operator
 * @author NPrilepa
 */
public interface INpOperator {
    /**
     * Get result of operation
     * @param number - Object with operand
     * @return double result of operation
     */
   double getResult(INpNumber number);

    /**
     * Check operand. For Division operand2 must be <>0
     * @return true if operands correct.
     */
    boolean isValid();

    /**
     * Get priority of operation. Operator of Addition and Substruction has priority=1,
     * Multiplication and Division>1
     * @return int priority of operator
     */
     int getPriority();
}
