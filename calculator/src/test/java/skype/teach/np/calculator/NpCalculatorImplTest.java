package skype.teach.np.calculator;

/**
 * @author NPrilepa
 */
public class NpCalculatorImplTest extends NpCalculatorTest {
    @Override
    protected NpCalculator createInstance() {
        return new NpCalculatorImpl();
    }
}
