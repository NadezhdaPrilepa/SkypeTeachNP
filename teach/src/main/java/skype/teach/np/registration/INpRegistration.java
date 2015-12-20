package skype.teach.np.registration;

/**
 * @author NPrilepa
 */
public interface INpRegistration {
    /**
     * Create user in DS with input login and pass
     * Before creation method checks existing user with
     * input login and pass. If the user exist return null.
     * Input params must be defined(not null and not empty)
     * If some params are not defined, the method returns null.
     * If some params not valid by length(<5) or starts from invalid
     * symbols("@","%"), the method returns null
     *
     * @param login Login of user.
     *              Can not be null or empty or invalid length(<5)or starts from invalid
     *              symbols("@","%")
     * @param pass  Password of user.
     *              Can not be null or empty or invalid length(<5)
     * @return id of the created user or null if the user was not created
     */
    Integer registerUser(String login, String pass);
}
