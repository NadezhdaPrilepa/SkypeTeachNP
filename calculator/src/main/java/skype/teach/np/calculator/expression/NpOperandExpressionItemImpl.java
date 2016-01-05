package skype.teach.np.calculator.expression;

/**
 * @author NPrilepa
 */
public class NpOperandExpressionItemImpl implements NpOperandExpressionItem {
    private double value;

    public NpOperandExpressionItemImpl(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
