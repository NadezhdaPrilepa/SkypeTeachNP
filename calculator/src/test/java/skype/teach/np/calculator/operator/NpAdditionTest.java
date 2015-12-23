package skype.teach.np.calculator.operator;

import org.junit.Test;
import skype.teach.np.calculator.INpNumber;
import skype.teach.np.calculator.NpNumber;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpAdditionTest {

    INpOperator ad = new NpAddition(1);

    @Test
    public void getResult() {
        INpNumber num = new NpNumber(12, 13);
        assertSame("12+13", 25, ad.getResult(num));
    }
}
