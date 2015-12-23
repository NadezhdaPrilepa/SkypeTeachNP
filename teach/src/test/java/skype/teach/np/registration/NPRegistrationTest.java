package skype.teach.np.registration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NPRegistrationTest {
    private INpRegistration npr = new NpRegistration();


    @Test
    public void registerUser_login_incorrect() {
        assertNull("login must be incorrect: registerUser(\"NP\", \"q1w2e3r4t5\")", npr.registerUser("NP", "q1w2e3r4t5"));
        assertNull("login must be incorrect: registerUser(null, \"q1w2e3r4t5\")", npr.registerUser(null, "q1w2e3r4t5"));
        assertNull("login must be incorrect: registerUser(\"\", \"q1w2e3r4t5\")", npr.registerUser("", "q1w2e3r4t5"));
        assertNull("login must be incorrect: registerUser(\" \", \"q1w2e3r4t5\")", npr.registerUser(" ", "q1w2e3r4t5"));
        assertNull("login must be incorrect: registerUser(\"@NPrilepa\", \"q1w2e3r4t5\")", npr.registerUser("@NPrilepa", "q1w2e3r4t5"));
        assertNull("login must be incorrect: registerUser(\"%NPrilepa\", \"q1w2e3r4t5\")", npr.registerUser("%NPrilepa", "q1w2e3r4t5"));

    }

    @Test
    public void registerUser_pass_incorrect() {
        assertNull("Pass must be incorrect: registerUser(\"NPrilepa\", \"q1w2\")", npr.registerUser("NPrilepa", "q1w2"));
        assertNull("Pass must be incorrect: registerUser(\"NPrilepa\", null)", npr.registerUser("NPrilepa", null));
        assertNull("Pass must be incorrect: registerUser(\"NPrilepa\", \"\")", npr.registerUser("NPrilepa", ""));
        assertNull("Pass must be incorrect: registerUser(\"NPrilepa\", \" \")", npr.registerUser("NPrilepa", " "));
    }

    @Test
    public void registerUser_login_and_pass_incorrect() {
        String[] incorrectLogin ={null,"NP",""," ","@NPrilepa","%NPrilepa"};
        String[] incorrectPass = {null,""," ","q1w2"};
        String exceptionStr;
        for (int i=0;i<incorrectLogin.length-1;i++)
        {
            for (int j=0;j<incorrectPass.length-1;j++)
            {
                exceptionStr="Pass and Login must be incorrect: login='"+incorrectLogin[i]+"' pass='"+incorrectPass[j]+"'";
                assertNull(exceptionStr,npr.registerUser(incorrectLogin[i], incorrectPass[j]));
            }
        }
    }

    @Test
    public void registerUser_user_used() {
        assertSame("Login and pass is used", 0, npr.registerUser("NPrilepa", "q1w2e3r4t5"));
    }

    @Test
    public void registerUser_successful_register() {
        assertSame("Registration successful", 3, npr.registerUser("IIvanov", "q1w2e3r4t5"));
    }

}
