package forumapp.controller.serviceauthorization;

import forumapp.controller.serviceforum.IServiceForum;
import forumapp.models.auth.Auth;
import forumapp.models.forum.ProfileUser;
import forumapp.models.user.GuestUser;
import forumapp.models.user.User;

public class ManagerAuth implements IServiceManagerAuth {
    final private Auth auth;

    public ManagerAuth(Auth auth) {
        this.auth = auth;
    }

    public ManagerAuth() {
        this.auth = new Auth();
    }

    public Auth getAuth() {
        return auth;
    }

    @Override
    public boolean register(User user, IServiceForum forum) {
        if (conditionRegister(user)){
            return false;
        }
        auth.getUsersRegistry().put(user.getUserId(), user);
        forum.addNewProfile(new ProfileUser(user.getUserId(), user));
        return true;
    }

    private boolean conditionRegister(User user) {
        for (User us: auth.getUsersRegistry().values()){
            if (us.getDni().equals(user.getDni())){
                return true;
            }
        }
        return false;
    }

    @Override
    public User login(LoginRequestDTO loginRequest) {
        for (User user : auth.getUsersRegistry().values()) {
            if ((user.getDni().equals(loginRequest.getDNI()) && (user.getPassword().equals(loginRequest.getPassword())))){
                return user;
            }

        }
        return new GuestUser();
    }

    @Override
    public void usersRegistered() {
        for (User user : auth.getUsersRegistry().values()) {
            System.out.println(user);
        }
    }
}
