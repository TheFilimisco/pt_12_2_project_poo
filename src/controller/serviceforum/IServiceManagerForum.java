package controller.serviceforum;

import models.forum.ProfileUser;

public interface IServiceManagerForum  {
    ProfileUser getProfileUser(int id);
    boolean addNewProfile(ProfileUser profile);
    boolean updateProfile(ProfileUser profile);
    boolean deleteProfile(ProfileUser profile);
    void readProfiles();
}
