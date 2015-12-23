package skype.teach.np.calculator.operator;

import skype.teach.np.calculator.INpNumber;

/**
 * @author NPrilepa
 */
public abstract class NpOperator implements INpOperator {
    protected int priority;

    public int getPriority() {
        return priority;
    }

    public abstract double getResult(INpNumber number);

    public  boolean isValid(){
        return true;
    }

}
