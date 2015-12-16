package skype.teach.np.registration;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * @author NPrilepa
 */
public class NPRegistrationTest {

    @Test
    public void RegistrationTest()
    {
        NpRegistration npr = new NpRegistration();

        assertSame("login must be incorrect",null,npr.Registration("NP","q1w2e3r4t5"));
        assertSame("Pass must be incorrect", null, npr.Registration("NPrilepa", "q1w2"));
        assertSame("Login and pass is used", 0, npr.Registration("NPrilepa", "q1w2e3r4t5"));
        assertSame("Registration successful", 3, npr.Registration("IIvanov", "qwerty"));
    }
}
