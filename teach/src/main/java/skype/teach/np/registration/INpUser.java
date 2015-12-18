package skype.teach.np.registration;

/**
 * @author NPrilepa
 */
public interface INpUser {

    int getId();

    void setId(int id);

    String getLogin();

    void setLogin(String login);

    void setPass(String pass);

    String getPass();
}
