package skype.teach.np.registration;

import java.util.Map;

/**
 * @author NPrilepa
 */
public class NpRegistration {
    private INpUserDAO usersDAO=new NpUserDAO();

    public Integer Registration(String login, String pass) {

        if (!usersDAO.isValid(login, pass)) {
            System.out.println("Login and pass incorrect!");
            return null;
        }
        INpUser user = usersDAO.select(login, pass);
        if (user != null) {
            System.out.println("Login and pass is used by " + user.getId());
            return user.getId();
        }

        Integer id = usersDAO.insert(login, pass);
        {
            System.out.println("Successful registration, your id is " + id);
            return id;
        }

    }
}
