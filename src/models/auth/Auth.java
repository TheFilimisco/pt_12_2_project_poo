package models.auth;

import models.user.Student;
import models.user.Teacher;
import models.user.User;

import java.util.ArrayList;
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
