package models.forum;

import models.user.Student;
import models.user.Teacher;
import models.user.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Posts_User {
    private int idPostsUser;
    private User user;
    private ArrayList<Post> posts;
    private static int counterPostsUser = 0;

    public Posts_User(User user) {
        idPostsUser = counterPostsUser++;
        this.user = user;
        posts = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public static int getCounterPostsUser() {
        return counterPostsUser;
    }

    public static void setCounterPostsUser(int counterPostsUser) {
        Posts_User.counterPostsUser = counterPostsUser;
    }

    public void createNewPost(String title, String typeOfPost, String description, int inputYourDegree){
        if (user instanceof Student){
            posts.add(new Post(title,user,typeOfPost,description,LocalDate.now(),((Student) user).getAssignedDegree()));
            System.out.println("Successful!");
        } else if (user instanceof Teacher) {
            posts.add(new Post(title,user,typeOfPost,description,LocalDate.now(),((Teacher) user).getAssignedDegrees().get(inputYourDegree)));
            System.out.println("Successful!");
        } else {
            throw new IllegalArgumentException("Just if you're Student or Teacher, Please return to Register...");
        }
    }

    public void showPosts(){
        for (Post post: posts){
            System.out.println(post);
        }
    }

    public void searchPost(int idPost){
        for (Post post: posts){
            if (post.getIdPost()==idPost){
                System.out.println(post);
            }
        }
    }

    public void updatePosts(int inputYourPost, String newTitle, String newDescription){
        for (Post post: posts){
            if (post.getIdPost() == inputYourPost){
                post.setTitle(newTitle);
                post.setDescription(newDescription);
                post.setDate(LocalDate.now());
            }
        }
    }

    public void deletePost(int inputIdYourPost){
        posts.remove(inputIdYourPost);
    }


    @Override
    public String toString() {
        return "\nPosts_User{" +
                "\nidPostsUser=" + idPostsUser +
                "\nuser=" + user +
                "\nposts=" + posts +
                '}';
    }

//    public static void main(String[] args) {
//        Posts_User newPostsUser = new Posts_User(new User());
//        newPostsUser.createNewPost("1Dudas dudas", "Doubts", "DUDAS DUDAS");
//        newPostsUser.createNewPost("2Dudas dudas", "Doubts", "DUDAS DUDAS");
//        newPostsUser.createNewPost("3Dudas dudas", "Doubts", "DUDAS DUDAS");
//        newPostsUser.showPosts();
//        System.out.println("===========================================================================");
//        newPostsUser.updatePosts(0,"Ya no quiero dudas", "No quiero mas dudas");
//        newPostsUser.showPosts();
//
//        System.out.println("===========================================================================");
//        newPostsUser.deletePost(0);
//        newPostsUser.showPosts();
//    }
}
