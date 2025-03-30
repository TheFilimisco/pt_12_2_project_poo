package models.forum;

import models.user.Student;
import models.user.Teacher;
import models.user.User;
import java.time.LocalDate;
import java.util.*;

public class ProfileUser {
    final private int profileUserId;
    final private User user;
    final private HashMap<Integer, Post> posts;
    private static int counterProfileUserId = 0;

    public ProfileUser(int profileUserId, User user) {
        this.profileUserId = profileUserId;
        this.user = user;
        posts = new HashMap<>();
        counterProfileUserId++;
    }

    public int getProfileUserId() {
        return profileUserId;
    }

    public User getUser() {
        return user;
    }

    public HashMap<Integer, Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProfileUser that = (ProfileUser) o;
        return profileUserId == that.profileUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(profileUserId);
    }

    @Override
    public String toString() {
        return "ProfileUser{" +
                "profileUserId=" + profileUserId +
                ", user=" + user +
                ", posts=" + posts +
                '}';
    }
}
