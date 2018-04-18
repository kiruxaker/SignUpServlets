package servlet.dao;


import java.util.List;

/**
 *
 * @param <T> type of stored entity
 *
 * @author kirillparolys
 * @version 1.1
 */
public interface Dao<T> {

    /**
     * Searches for all stored entities in the database
     *
     * @see servlet.model.User
     *
     * @return list of all entities stored in the database
     */
    List<T> findAll();

    /**
     * Saves object to the database
     *
     * @param obj obj which will be saved later
     *
     * @see servlet.model.User
     *
     * @return saved object
     */
    T save(T obj);

    /**
     * Searches for user in the database
     *
     * @param email is the email of the user we are searching for
     *
     * @see servlet.model.User
     *
     * @return
     */
    T findByEmail(String email);

}
