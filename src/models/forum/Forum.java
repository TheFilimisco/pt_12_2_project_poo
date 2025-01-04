package models.forum;

import models.auth.Auth;
import models.degree.Degree;
import models.degree.Subject;
import models.user.Student;
import models.user.Teacher;
import models.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Forum {
    private ArrayList<Posts_User> postsUsers;

    public Forum() {
        postsUsers = new ArrayList<>();
    }


    public ArrayList<Posts_User> getPostsUsers() {
        return postsUsers;
    }

    public void setPostsUsers(ArrayList<Posts_User> postsUsers) {
        this.postsUsers = postsUsers;
    }


    public void showAllPosts(){
        for (Posts_User postsUser: postsUsers){
            postsUser.showPosts();
        }
    }

    public void showPostsForDegree(Degree inputDegree){
        for (Posts_User postsUser: postsUsers){
            for (Post post: postsUser.getPosts()){
                if (post.getDegree().equals(inputDegree)){
                    System.out.println(post);
                }
            }
        }
    }

    public void showPostsForSubject(Subject inputSubject){
        for (Posts_User postsUser: postsUsers){
            for (Post post: postsUser.getPosts()){
                for (Subject subject: post.getDegree().getSubjects()){
                    if (subject.equals(inputSubject)){
                        System.out.println(post);
                    }
                }
            }
        }
    }

    public void showPostsForAuthor(User user){
        for (Posts_User postsUser: postsUsers){
            for (Post post: postsUser.getPosts()){
                if (user.getRole().equals(post.getAuthor().getRole())){
                    System.out.println(post);
                }
            }
        }
    }

    public void searchPostTotal(Scanner input){
        while (true){
            System.out.println("Search Post (write exit for leave): ");
            String inputTitlePost = input.nextLine().toLowerCase();

            if (inputTitlePost.equals("exit")){
                break;
            }

            System.out.println("\nSearch: \n");
            for (Posts_User postsUser: postsUsers){
                for (Post post: postsUser.getPosts()){
                    if (post.getTitle().toLowerCase().replace(" ", "").contains(inputTitlePost.toLowerCase().replace(" ", ""))){
                        System.out.println(post);
                    }
                }
            }
        }
    }

}
