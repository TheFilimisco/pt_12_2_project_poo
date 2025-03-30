package controller.serviceauthorization;

import controller.serviceforum.IServiceForum;
import models.user.User;

public interface IServiceManagerAuth {
    boolean register(User user, IServiceForum forum);
    User login(LoginRequestDTO user);
    void usersRegistered();
}
