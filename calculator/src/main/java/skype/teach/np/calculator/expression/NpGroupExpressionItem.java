package skype.teach.np.calculator.expression;

/**
 * Group can change order of calculations.
 * Group must be pair in expression(every <code>start</code>
 * group has the corresponding <code>end</code> operation)
 *
 *
 *
 * @author NPrilepa
 */
public interface NpGroupExpressionItem extends NpExpressionItem {
    /**
     *
     * @return is group operation open in arithmetic expression
     */
    boolean isOpen();

    /**
     *
     * @return is group operation close in arithmetic expression
     */
    boolean isClose();
}
