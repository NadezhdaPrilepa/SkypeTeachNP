package skype.teach.np.calculator.operator;

import skype.teach.np.calculator.INpNumber;

/**class operation Addition (+)
 * @author NPrilepa
 */
public class NpAddition extends NpOperator implements INpOperator {

    public NpAddition(int priority) {
        this.priority = priority;
    }

    public double getResult(INpNumber number) {
        return 0;
    }
}
