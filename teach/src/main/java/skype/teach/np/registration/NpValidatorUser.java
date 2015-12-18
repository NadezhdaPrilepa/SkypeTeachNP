package skype.teach.np.registration;

/**class implements INpValidatorUser
 * @author NPrilepa
 */
public class NpValidatorUser implements INpValidatorUser {

   public boolean isValid(String login, String pass)
    {
        if (login==null||login.isEmpty())
        {
            return false;
        }
        if (pass==null||pass.isEmpty())
        {
            return false;
        }
        if (login.length() < 5) {
            return false;
        }
        if (pass.length() < 5) {
            return false;
        }
        if (login.startsWith("@") || login.startsWith("%")) {
            return false;
        }
        return true;
    }
}
