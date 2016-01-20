package skype.teach.np.calculator;

/**
 * @author NPrilepa
 */
public class NpResultImpl implements NpResult {
    private double value;

    public NpResultImpl(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
