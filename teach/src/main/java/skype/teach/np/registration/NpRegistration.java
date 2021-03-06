package skype.teach.np.registration;

import java.util.Map;

/**
 * @author NPrilepa
 */
public class NpRegistration implements INpRegistration {
    private INpUserDAO usersDAO = new NpUserDAO();
    private INpValidatorUser validatorUser = new NpValidatorUser();

    public Integer registerUser(String login, String pass) {
      /*
         If length login and pass params correct
         and pass not starts from incorrect symbol return  true, else
        return false*/
        if (!validatorUser.isValid(login, pass)) {
            System.out.println("Login and pass incorrect!");
            return null;
        }
        /* if DS already has user with the same login and pass
        * return false, else return true*/
        INpUser user = usersDAO.select(login);
        if (user != null) {
            System.out.println("Login and pass is used by " + user.getId());
            return user.getId();
        }
        /* Create user with input login and pass and set it to DS
        Return id of created user*/

        Integer id = usersDAO.insert(login, pass);
        {System.out.println("Successful registration, your id is " + id);
            return id;
        }

    }
}

