package skype.teach.np.registration;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author NPrilepa
 */
public class NPRegistrationTest {
    private INpRegistration npr = new NpRegistration();


    @Test
    public void registerUser_login_incorrect_test() {
        assertSame("login must be incorrect", null, npr.registerUser("NP", "q1w2e3r4t5"));
        assertSame("login must be incorrect", null, npr.registerUser(null, "q1w2e3r4t5"));
        assertSame("login must be incorrect", null, npr.registerUser("", "q1w2e3r4t5"));
    }
    @Test
    public void registerUser_pass_incorrect_test() {
        assertSame("Pass must be incorrect", null, npr.registerUser("@NPrilepa", "q1w2e3r4t5"));
        assertSame("Pass must be incorrect", null, npr.registerUser("%NPrilepa", "q1w2e3r4t5"));
        assertSame("Pass must be incorrect", null, npr.registerUser("NPrilepa", "q1w2"));
        assertSame("Pass must be incorrect", null, npr.registerUser("NPrilepa", null));
        assertSame("Pass must be incorrect", null, npr.registerUser("NPrilepa", ""));
    }
    @Test
    public void registerUser_login_and_pass_incorrect_test() {
        assertSame("Pass and Login must be incorrect", null, npr.registerUser(null, null));
        assertSame("Pass and Login must be incorrect", null, npr.registerUser("", ""));

    }
    @Test
    public void registerUser_user_used_test() {
        assertSame("Login and pass is used", 0, npr.registerUser("NPrilepa", "q1w2e3r4t5"));
    }
    @Test
    public void registerUser_successful_register_test() {
        assertSame("Registration successful", 3, npr.registerUser("IIvanov", "q1w2e3r4t5"));
    }

}
