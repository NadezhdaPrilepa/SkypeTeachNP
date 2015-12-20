package skype.teach.np.registration;


import java.util.*;

/**
 * @author NPrilepa
 */

public class NpUserDAO implements INpUserDAO {
    private Map<Integer, INpUser> users = new HashMap<Integer, INpUser>();

    public NpUserDAO() {

        insert("NPrilepa", "q1w2e3r4t5");
        insert("login1", "q1w2e3r4t5");
        insert("login", "password1");

    }

    public Integer insert(String login, String pass) {

        INpUser user = new NpUser(users.size(), login, pass);
        users.put(user.getId(), user);
        return user.getId();

    }


    public INpUser select(String login) {
        Iterator i = users.values().iterator();
        while (i.hasNext()) {
            INpUser user = (INpUser) i.next();
            if ((user).getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}


