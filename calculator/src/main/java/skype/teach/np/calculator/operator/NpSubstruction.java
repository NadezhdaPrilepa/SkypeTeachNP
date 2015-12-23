package skype.teach.np.calculator.operator;

import skype.teach.np.calculator.INpNumber;

/**class operation Substruction (-)
 * @author NPrilepa
 */
public class NpSubstruction extends NpOperator implements INpOperator {

    public NpSubstruction(int priority) {
        this.priority = priority;
    }

    public double getResult(INpNumber number) {
        return 0;
    }

    public int getPriority() {
        return 0;
    }
}
