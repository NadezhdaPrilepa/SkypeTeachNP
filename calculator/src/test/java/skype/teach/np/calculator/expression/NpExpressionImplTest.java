package skype.teach.np.calculator.expression;
import org.junit.Ignore;
import org.junit.Test;
import skype.teach.np.calculator.exception.NpInvalidExpressionCalculatorException;
import skype.teach.np.calculator.expression.operation.NpOperationExpressionItem;

import static org.junit.Assert.*;
/**
 * @author NPrilepa
 */
public class NpExpressionImplTest extends NpExpressionTest{
    @Override
    protected NpExpression createInstance() {
        return new NpExpressionImpl();
    }
}
