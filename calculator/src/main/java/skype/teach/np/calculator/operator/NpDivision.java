package skype.teach.np.calculator.operator;

import skype.teach.np.calculator.INpNumber;

/**class operation Division (/)
 * @author NPrilepa
 */
public class NpDivision extends NpOperator implements INpOperator {
    public NpDivision(int priority) {

        this.priority = priority;
    }
    public double getResult(INpNumber number) {
        return 0;
    }

    public boolean isValid() {

        return false;
    }

    public int getPriority() {
        return 0;
    }
}