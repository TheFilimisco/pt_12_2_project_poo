package controller.serviceforum;

import models.degree.Degree;
import models.degree.Subject;
import models.forum.Forum;
import models.forum.ProfileUser;

import java.util.Scanner;

public class ManagerForum implements IServiceForum{
    final private Forum forum;

    public ManagerForum(Forum forum) {
        this.forum = forum;
    }

    public Forum getForum() {
        return forum;
    }
    @Override
    public boolean updateProfile(ProfileUser profile) {
        for (ProfileUser pro : forum.getProfileUsers()){
            if (pro.getProfileUserId() == profile.getProfileUserId()){
                deleteProfile(pro);
                return addNewProfile(profile);
            }
        }
        return false;
    }

    @Override
    public ProfileUser getProfileUser(int id) {
        return forum.getProfileUsers().stream().filter(pro -> pro.getProfileUserId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean addNewProfile(ProfileUser profile) {
        return forum.getProfileUsers().add(profile);
    }

    @Override
    public boolean deleteProfile(ProfileUser profile) {
        return forum.getProfileUsers().remove(profile);
    }

    @Override
    public void readProfiles() {
        forum.getProfileUsers().forEach(System.out::println);
    }

    @Override
    public void showForum() {
        forum.getProfileUsers().forEach(
                profileUser ->  {
                    profileUser.getPosts().values().forEach(
                            System.out::println
                    );
                }
        );
    }

    @Override
    public void showPostsByDegree(String degree) {
        forum.getProfileUsers().forEach(
                profileUser -> {
                    profileUser.getPosts().values().forEach(
                            post -> {
                                if (post.getDegree().getNameDegree().equals(degree)){
                                    System.out.println(post);
                                }
                            }
                    );
                }
        );
    }

    @Override
    public void showPostsBySubject(String subject) {
        forum.getProfileUsers().forEach(
                profileUser -> {
                    profileUser.getPosts().values().forEach(
                            post -> {
                                post.getDegree().getSubjects().forEach(
                                  sub -> {
                                      if (sub.getName().equals(subject)){
                                          System.out.println(post);
                                      }
                                  }
                                );
                            }
                    );
                }
        );
    }

    @Override
    public void showPostsByUser(String user) {
        forum.getProfileUsers().forEach(
                profileUser -> {
                    if (profileUser.getUser().getClass().getSimpleName().equals(user)){
                        profileUser.getPosts().values().forEach(
                                System.out::println
                        );
                    }
                }
        );
    }

    @Override
    public void showPostsByTopic(Scanner input) {
        while (true){
            System.out.println("Search Post (write exit for leave): ");
            String inputTitlePost = input.nextLine().toLowerCase();
            if (inputTitlePost.equals("exit")){
                break;
            }
            System.out.println("\nSearch: \n");
            forum.getProfileUsers().forEach(
                    profileUser -> {
                        profileUser.getPosts().values().forEach(
                                post -> {
                                    if (post.getTitle().toLowerCase().replace(" ", "").contains(inputTitlePost.toLowerCase().replace(" ", ""))){
                                        System.out.println(post);
                                    }
                                }
                        );
                    }
            );
        }
    }
}
