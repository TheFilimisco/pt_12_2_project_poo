package controller.serviceprofileuser;

import models.forum.Post;
import models.forum.ProfileUser;

public interface IServiceManagerProfileUser {
    Post addNewPost(ProfileUser profileUser, Post post);
    Post updatePost(ProfileUser profileUser, Post post);
    Post deletePost(ProfileUser profileUser, int keyPost);
    Post readPost(ProfileUser profileUser, int keyPost);
    void readPosts(ProfileUser profileUser);
}
