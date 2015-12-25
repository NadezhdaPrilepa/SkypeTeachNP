package skype.teach.np.calculator;

import skype.teach.np.calculator.exception.NpCalculatorException;

/**
 * Calculate incoming arithmetic expression.
 * Arithmetic expression contains unlimited number of operators, operands and grouping operators.
 * Operators can dynamically connect. Grouping operators can be nested. The order of
 * operations corresponds grouping and their priorities(Operators of equal priority
 * are performed one after the other. Grouping can change order of calculations)
 *
 * @author NPrilepa
 */
public interface NpCalculator {

    /**
     * Calculate of given arithmetic expression. Incoming arithmetic expression must be define
     * (not null and not empty), else method return exception
     * @return If some operation  issued error return NpCalculatorException, else return result of expression NpResult
     */
    NpResult calculate(String inputException)  throws NpCalculatorException;
}
