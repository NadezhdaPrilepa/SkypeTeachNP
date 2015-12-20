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
        assertNull("login must be incorrect", npr.registerUser("NP", "q1w2e3r4t5"));
        assertNull("login must be incorrect", npr.registerUser(null, "q1w2e3r4t5"));
        assertNull("login must be incorrect", npr.registerUser("", "q1w2e3r4t5"));
        assertNull("login must be incorrect", npr.registerUser(" ", "q1w2e3r4t5"));
        assertNull("login must be incorrect", npr.registerUser("@NPrilepa", "q1w2e3r4t5"));
        assertNull("login must be incorrect", npr.registerUser("%NPrilepa", "q1w2e3r4t5"));

    }

    @Test
    public void registerUser_pass_incorrect() {
        assertNull("Pass must be incorrect", npr.registerUser("NPrilepa", "q1w2"));
        assertNull("Pass must be incorrect", npr.registerUser("NPrilepa", null));
        assertNull("Pass must be incorrect", npr.registerUser("NPrilepa", ""));
        assertNull("Pass must be incorrect", npr.registerUser("NPrilepa", " "));
    }

    @Test
    public void registerUser_login_and_pass_incorrect() {
        assertNull("Pass and Login must be incorrect", npr.registerUser(null, null));
        assertNull("Pass and Login must be incorrect", npr.registerUser("NP", null));
        assertNull("Pass and Login must be incorrect", npr.registerUser("", null));
        assertNull("Pass and Login must be incorrect", npr.registerUser(" ", null));
        assertNull("Pass and Login must be incorrect", npr.registerUser("@NPrilepa", null));
        assertNull("Pass and Login must be incorrect", npr.registerUser("%NPrilepa", null));
        assertNull("Pass and Login must be incorrect", npr.registerUser("", ""));
        assertNull("Pass and Login must be incorrect", npr.registerUser("NP", ""));
        assertNull("Pass and Login must be incorrect", npr.registerUser(null, ""));
        assertNull("Pass and Login must be incorrect", npr.registerUser(" ", ""));
        assertNull("Pass and Login must be incorrect", npr.registerUser("@NPrilepa", ""));
        assertNull("Pass and Login must be incorrect", npr.registerUser("%NPrilepa", ""));
        assertNull("Pass and Login must be incorrect", npr.registerUser(" ", " "));
        assertNull("Pass and Login must be incorrect", npr.registerUser("NP", " "));
        assertNull("Pass and Login must be incorrect", npr.registerUser(null, " "));
        assertNull("Pass and Login must be incorrect", npr.registerUser("", " "));
        assertNull("Pass and Login must be incorrect", npr.registerUser("@NPrilepa", " "));
        assertNull("Pass and Login must be incorrect", npr.registerUser("%NPrilepa", " "));
        assertNull("Pass and Login must be incorrect", npr.registerUser("NP", "q1w2"));
        assertNull("Pass and Login must be incorrect", npr.registerUser("@NPrilepa", "q1w2"));
        assertNull("Pass and Login must be incorrect", npr.registerUser("%NPrilepa", "q1w2"));
        assertNull("Pass and Login must be incorrect", npr.registerUser(" ", "q1w2"));
        assertNull("Pass and Login must be incorrect", npr.registerUser(null, "q1w2"));
        assertNull("Pass and Login must be incorrect", npr.registerUser("", "q1w2"));
        assertNull("Pass and Login must be incorrect", npr.registerUser("@NPrilepa", "q1w2"));
        assertNull("Pass and Login must be incorrect", npr.registerUser("%NPrilepa", "q1w2"));

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
