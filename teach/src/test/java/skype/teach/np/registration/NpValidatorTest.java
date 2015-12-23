package skype.teach.np.registration;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpValidatorTest {
    private INpValidatorUser npv = new NpValidatorUser();

    @Test
    public void isValid_login_incorrect() {
        assertFalse("login must be incorrect: isValid(\"NP\", \"q1w2e3r4t5\")", npv.isValid("NP", "q1w2e3r4t5"));
        assertFalse("login must be incorrect: isValid(null, \"q1w2e3r4t5\")", npv.isValid(null, "q1w2e3r4t5"));
        assertFalse("login must be incorrect: isValid(\"\", \"q1w2e3r4t5\")", npv.isValid("", "q1w2e3r4t5"));
        assertFalse("login must be incorrect: isValid(\" \", \"q1w2e3r4t5\")", npv.isValid(" ", "q1w2e3r4t5"));
        assertFalse("login must be incorrect: isValid(\"@NPrilepa\", \"q1w2e3r4t5\")", npv.isValid("@NPrilepa", "q1w2e3r4t5"));
        assertFalse("login must be incorrect: isValid(\"%NPrilepa\", \"q1w2e3r4t5\")", npv.isValid("%NPrilepa", "q1w2e3r4t5"));
    }

    @Test
    public void isValid_pass_incorrect() {
        assertFalse("Pass must be incorrect: isValid(\"NPrilepa\", null)", npv.isValid("NPrilepa", null));
        assertFalse("Pass must be incorrect: isValid(\"NPrilepa\", \"\")", npv.isValid("NPrilepa", ""));
        assertFalse("Pass must be incorrect: isValid(\"NPrilepa\", \" \")", npv.isValid("NPrilepa", " "));

    }

    @Test
    public void isValid_login_and_pass_incorrect() {
        String[] incorrectLogin ={null,"NP",""," ","@NPrilepa","%NPrilepa"};
        String[] incorrectPass = {null,""," ","q1w2"};
        String exceptionStr;
        for (int i=0;i<incorrectLogin.length-1;i++)
        {
            for (int j=0;j<incorrectPass.length-1;j++)
            {
                exceptionStr="Pass and Login must be incorrect: login='"+incorrectLogin[i]+"' pass='"+incorrectPass[j]+"'";
                assertFalse(exceptionStr, npv.isValid(incorrectLogin[i], incorrectPass[j]));
            }
        }
    }

    @Test
    public void isValid_login_and_pass_correct() {
        assertTrue("login must be correct", npv.isValid("NPrilepa", "q1w2e3r4t5"));
    }

}
