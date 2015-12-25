package skype.teach.np.calculator.expression;

import skype.teach.np.calculator.exception.NpInvalidExpressionCalculatorException;

import java.util.List;

/**
 * Arithmetic expression it is ordered
 * collection of elements. Element of NpExpression - NpExpressionItem.
 * NpExpressionItems can be operators, operands and grouping operators
 *
 * @author NPrilepa
 */
public interface NpExpression {
    /**
     * Get ordered collection of elements arithmetic expression
     * Collection may contains operators, operands and grouping operators
     *
     * @return List of NpExpressionItem object
     */
    List<NpExpressionItem> getExpressionItems();

    /**
     * Parse String arithmetic expression to NpExpression. Incoming arithmetic expression must be define
     * (not null and not empty), else method return exception <br/>
     * Valid expression:<br/>
     * expression := operand | {expression} operation {expression} | group.start {expression} group.end
     *
     * @param inputExpressionStr String arithmetic expression
     * @return NpExpression object matched to <code>inputExpressionStr</code>
     * @throws NpInvalidExpressionCalculatorException if expression is invalid
     */
    NpExpression parseExpressionString(String inputExpressionStr) throws NpInvalidExpressionCalculatorException;


}


