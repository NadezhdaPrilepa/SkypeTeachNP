package skype.teach.np.registration;

/**
 * @author NPrilepa
 */
interface INpValidatorUser {
    /**
     * Check input params login and pass. If some params is not defined(null or empty) return false
     * If length of params <5 return false. If login of user starts from incorrect
     * symbol("@","%") return false
     * @param login Login of user
     * @param pass Password of user
     * @return true if params correct, else false
     */
    boolean isValid(String login, String pass);
}
