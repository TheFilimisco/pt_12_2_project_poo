package forumapp.models.forum;


import java.util.HashSet;

public class Forum {
    final private HashSet<ProfileUser> profileUsers;

    public Forum() {
        profileUsers = new HashSet<ProfileUser>();
    }

    public HashSet<ProfileUser> getProfileUsers() {
        return profileUsers;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "profileUsers=" + profileUsers +
                '}';
    }

}
