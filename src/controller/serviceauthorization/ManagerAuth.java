package controller.serviceauthorization;

import controller.serviceforum.IServiceForum;
import models.auth.Auth;
import models.forum.Forum;
import models.forum.ProfileUser;
import models.user.User;

public class ManagerAuth implements IServiceManagerAuth {
    final private Auth auth;

    public ManagerAuth(Auth auth) {
        this.auth = auth;
    }

    public Auth getAuth() {
        return auth;
    }

    @Override
    public boolean register(User user, IServiceForum forum) {
        if (auth.getUsersRegistry().containsKey(user.getUserId())){
            return false;
        }
        auth.getUsersRegistry().put(user.getUserId(), user);
        forum.addNewProfile(new ProfileUser(user.getUserId(), user));
        return true;
    }


    @Override
    public User login(LoginRequestDTO loginRequest) {
        for (User user : auth.getUsersRegistry().values()) {
            if ((user.getDni().equals(loginRequest.getDNI()) && (user.getPassword().equals(loginRequest.getPassword())))){
                return user;
            }
        }
        return null;
    }

    @Override
    public void usersRegistered() {
        for (User user : auth.getUsersRegistry().values()) {
            System.out.println(user);
        }
    }
}
