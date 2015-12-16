package skype.teach.np.registration;

/**
 * @author NPrilepa
 */
public class NpUser implements INpUser{
    private int id;
    private String login;
    private String pass;

    public NpUser(int id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setId(int id) {
        this.id = id;
    }
}

interface INpUser {
    public int getId();

    public void setId(int id);

    public String getLogin();

    public void setLogin(String login);

    public void setPass(String pass);

    public String getPass();
}
