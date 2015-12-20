package skype.teach.np.registration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author NPrilepa
 */
public class NpUserDAOTest {
    private INpUserDAO npud = new NpUserDAO();

    @Test
    public void insert() {
        assertSame("user create", 3, npud.insert("IIvanov","q1w2e3r4t5"));

    }

    @Test
    public void select() {
        assertSame("user exist", 0, npud.select("NPrilepa").getId());
        assertNull("user not exist", npud.select(" "));
    }
}
