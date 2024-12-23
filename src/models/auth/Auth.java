package models.auth;

import models.user.Student;
import models.user.Teacher;
import models.user.User;

import java.util.ArrayList;

public class Auth {
    private ArrayList<User> users;


    public Auth() {
        this.users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void register(User user){
        for (User us: users) {
            if (us.getDni().equals(user.getDni())){
                System.out.println("User is registered!");
            }
        }
        users.add(user);
        System.out.println("Register successful!...");
    }


    public User login(String email, String password){
        for (User user: users){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                System.out.println("Login successful!..." + user.getRole());
                return user;
            }
        }
        System.out.println("Error, don't found this user!");
        return null;
    }

    public User login(){
        User userAnonymous = new User();
        users.add(userAnonymous);
        return userAnonymous;
    }


    @Override
    public String toString() {
        return "Auth{" +
                "users=" + users +
                '}';
    }
}
