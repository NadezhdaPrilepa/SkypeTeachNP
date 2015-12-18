package skype.teach.np.registration;

/**
 * @author NPrilepa
 */
interface INpUserDAO {
    /**
     * Create user in DS with input login and pass
     * Before creation method checks existing user with
     * input login and pass. If the user exist return null.
     * Input params must be defined(not null and not empty)
     * If some params are not defined, the method returns null.
     *
     * @param login Login of user.
     *              Can not be null or empty or invalid length
     * @param pass  Password of user.
     *              Can not be null or empty or invalid length
     * @return id of the created user or null if the user was not created
     */
    Integer insert(String login, String pass);

    /**
     * Select from DS user with the input login
     * @param login Login of user.
     * @return user with input login
     */

    INpUser select(String login);

}
