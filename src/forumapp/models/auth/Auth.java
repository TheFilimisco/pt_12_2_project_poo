package forumapp.models.auth;

import forumapp.models.user.User;

import java.util.HashMap;

public class Auth {
    final private HashMap<Integer, User> usersRegistry;

    public Auth() {
        usersRegistry = new HashMap<>();
    }

    public HashMap<Integer, User> getUsersRegistry() {
        return usersRegistry;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "usersRegistry=" + usersRegistry +
                '}';
    }

}
