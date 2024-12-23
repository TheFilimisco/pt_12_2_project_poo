package models.forum;

import models.auth.Auth;
import models.degree.Degree;
import models.user.Student;
import models.user.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forum {
    private ArrayList<Post> posts;

    public Forum() {
        posts = new ArrayList<>();
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }


    public void addNewPost(User user, Post post){
        posts.add(post);
    }

    public void showYourPosts(User user) {
        for (Post pos : posts) {
            if (pos.getAuthor().equals(user)){
                System.out.println(pos);
            }
        }
    }

    public void updateYourPosts(User user, int idYourPost, String changeTitle, String changeDescription) {
        for (Post pos: posts) {
            if (pos.getAuthor().equals(user)){
                if (pos.getIdPost()==idYourPost){
                    pos.setTitle(changeTitle);
                    pos.setDescription(changeDescription);
                }
                System.out.println("Modified successful!");
            }
        }
    }

    public void deleteYourPost(User user, int idYourPost){
        for (Post pos : posts) {
            if (pos.getAuthor().equals(user)){
                if (pos.getIdPost()==idYourPost){
                    System.out.print("Removing: " + pos);
                    posts.remove(idYourPost);
                }
            }
        }
    }




    public static void main(String[] args) {
        Student student = new Student("99999999X", "Steven", "nystepro@gmail.com",999999999,"12345678",new Degree("DAM", "Across Platform Apps"));
        Forum forum = new Forum();
        forum.addNewPost(student,new Post("Alguien me puede ayudar en matematicas", student, "Dudas", "Hola, alguien me puede ayudar como puedo hacer el ejercicio 1", LocalDate.now()));
        forum.showYourPosts(student);
        forum.updateYourPosts(student, 0, "Ya no quiero ayuda en matematica sino en Ciencias", "Hola necesito ayuda en algo");
        forum.showYourPosts(student);
        forum.deleteYourPost(student,0);
//        forum.showYourPosts(student);
    }
}
