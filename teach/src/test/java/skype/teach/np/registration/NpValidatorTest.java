package skype.teach.np.registration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpValidatorTest {
    private INpValidatorUser npv = new NpValidatorUser();

    @Test
    public void isValid_login_incorrect() {
        assertFalse("login must be incorrect", npv.isValid("NP", "q1w2e3r4t5"));
        assertFalse("login must be incorrect", npv.isValid(null, "q1w2e3r4t5"));
        assertFalse("login must be incorrect", npv.isValid("", "q1w2e3r4t5"));
        assertFalse("login must be incorrect", npv.isValid(" ", "q1w2e3r4t5"));
        assertFalse("login must be incorrect", npv.isValid("@NPrilepa", "q1w2e3r4t5"));
        assertFalse("login must be incorrect", npv.isValid("%NPrilepa", "q1w2e3r4t5"));
    }

    @Test
    public void isValid_pass_incorrect() {
        assertFalse("Pass must be incorrect", npv.isValid("NPrilepa", "q1w2"));
        assertFalse("Pass must be incorrect", npv.isValid("NPrilepa", null));
        assertFalse("Pass must be incorrect", npv.isValid("NPrilepa", ""));
        assertFalse("Pass must be incorrect", npv.isValid("NPrilepa", " "));

    }

    @Test
    public void isValid_login_and_pass_incorrect() {
        assertFalse("Pass and Login must be incorrect", npv.isValid(null, null));
        assertFalse("Pass and Login must be incorrect", npv.isValid("NP", null));
        assertFalse("Pass and Login must be incorrect", npv.isValid("", null));
        assertFalse("Pass and Login must be incorrect", npv.isValid(" ", null));
        assertFalse("Pass and Login must be incorrect", npv.isValid("@NPrilepa", null));
        assertFalse("Pass and Login must be incorrect", npv.isValid("%NPrilepa", null));
        assertFalse("Pass and Login must be incorrect", npv.isValid("", ""));
        assertFalse("Pass and Login must be incorrect", npv.isValid("NP", ""));
        assertFalse("Pass and Login must be incorrect", npv.isValid(null, ""));
        assertFalse("Pass and Login must be incorrect", npv.isValid(" ", ""));
        assertFalse("Pass and Login must be incorrect", npv.isValid("@NPrilepa", ""));
        assertFalse("Pass and Login must be incorrect", npv.isValid("%NPrilepa", ""));
        assertFalse("Pass and Login must be incorrect", npv.isValid(" ", " "));
        assertFalse("Pass and Login must be incorrect", npv.isValid("NP", " "));
        assertFalse("Pass and Login must be incorrect", npv.isValid(null, " "));
        assertFalse("Pass and Login must be incorrect", npv.isValid("", " "));
        assertFalse("Pass and Login must be incorrect", npv.isValid("@NPrilepa", " "));
        assertFalse("Pass and Login must be incorrect", npv.isValid("%NPrilepa", " "));
        assertFalse("Pass and Login must be incorrect", npv.isValid("NP", "q1w2"));
        assertFalse("Pass and Login must be incorrect", npv.isValid("@NPrilepa", "q1w2"));
        assertFalse("Pass and Login must be incorrect", npv.isValid("%NPrilepa", "q1w2"));
        assertFalse("Pass and Login must be incorrect", npv.isValid(" ", "q1w2"));
        assertFalse("Pass and Login must be incorrect", npv.isValid(null, "q1w2"));
        assertFalse("Pass and Login must be incorrect", npv.isValid("", "q1w2"));
        assertFalse("Pass and Login must be incorrect", npv.isValid("@NPrilepa", "q1w2"));
        assertFalse("Pass and Login must be incorrect", npv.isValid("%NPrilepa", "q1w2"));
    }

    @Test
    public void isValid_login_and_pass_correct() {
        assertTrue("login must be correct", npv.isValid("NPrilepa", "q1w2e3r4t5"));
    }

}
