package forumapp.controller.serviceauthorization;

import forumapp.controller.serviceforum.IServiceForum;
import forumapp.models.user.User;

public interface IServiceManagerAuth {
    boolean register(User user, IServiceForum forum);
    User login(LoginRequestDTO user);
    void usersRegistered();
}
