package ru.itis.javalab.repositories;

//import ru.itis.javalab.models.Client;
import ru.itis.javalab.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User> {
    boolean containsUser(String login, String password);
    Long getUserId(String login, String password);
    boolean containsLogin(String login);
    List<User> findByUuid(String uuid);
    List<User> findByData(String login);
}
