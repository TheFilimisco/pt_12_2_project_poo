package forumapp.controller.serviceprofileuser;

import forumapp.models.forum.Post;
import forumapp.models.forum.ProfileUser;

public class ManagerProfileUser implements IServiceManagerProfileUser {

    @Override
    public Post updatePost(ProfileUser profileUser, Post post) {
        return profileUser.getPosts().put(post.getIdPost(),post);
    }


    @Override
    public Post addNewPost(ProfileUser profileUser, Post post) {
        return profileUser.getPosts().put(post.getIdPost(),post);
    }


    public Post deletePost(ProfileUser profileUser, int keyPost) {
        return profileUser.getPosts().remove(keyPost);
    }

    @Override
    public Post readPost(ProfileUser profileUser, int keyPost) {
        return profileUser.getPosts().get(keyPost);
    }

    @Override
    public void readPosts(ProfileUser profileUser) {
        profileUser.getPosts().values().forEach(System.out::println);
    }
}
