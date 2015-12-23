package skype.teach.np.calculator;

/**
 * @author NPrilepa
 */
public interface INpCalculator {

    /**
     * Get final result of input String Expression, contains simple math operators,
     * double number and parenthesis.
     * @return If expression contains division on 0
     * return exception, else return result of expression
     */
    double calculate();
}
