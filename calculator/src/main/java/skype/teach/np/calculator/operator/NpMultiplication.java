package skype.teach.np.calculator.operator;

import skype.teach.np.calculator.INpNumber;

/**class operation Multiplication (*)
 * @author NPrilepa
 */
public class NpMultiplication extends NpOperator implements INpOperator {

    public NpMultiplication(int priority) {
        this.priority = priority;
    }

    public double getResult(INpNumber number) {
        return 0;
    }

    public int getPriority()
    {
        return 0;
    }
}