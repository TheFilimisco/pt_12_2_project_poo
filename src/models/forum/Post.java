package models.forum;

import models.degree.Degree;
import models.user.User;

import java.time.LocalDate;

public class Post {
    private int idPost;
    private String title;
    private User author;
    private TypeOfPost typeOfPost;
    private String description;
    private LocalDate date;
    private Degree degree;
    private static int counterPost = 0;

    public Post(String title, User author, String typeOfPost, String description, LocalDate date, Degree degree) {
        this.idPost = counterPost++;
        this.title = title;
        this.author = author;
        switch (typeOfPost){
            case "Doubts":
                this.typeOfPost = TypeOfPost.Doubts;
                break;
            case "Questions":
                this.typeOfPost = TypeOfPost.Questions;
                break;
            case "Help":
                this.typeOfPost = TypeOfPost.Help;
                break;
            case "Events":
                this.typeOfPost = TypeOfPost.Events;
                break;
            default:
                throw new IllegalArgumentException("Do write correct Type of Post");
        }
        this.description = description;
        this.date = date;
        this.degree = degree;
    }

    public enum TypeOfPost{
        Doubts,
        Questions,
        Help,
        Events
    }


    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public TypeOfPost getTypeOfPost() {
        return typeOfPost;
    }

    public void setTypeOfPost(TypeOfPost typeOfPost) {
        this.typeOfPost = typeOfPost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static int getCounterPost() {
        return counterPost;
    }

    public static void setCounterPost(int counterPost) {
        Post.counterPost = counterPost;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "=======================================================" +
                "\nPost{" +
                "idPost=" + idPost +
                "\ntitle='" + title + '\'' +
                "\nauthor=" + author.getName() +
                "\ntypeOfPost=" + typeOfPost +
                "\ndescription='" + description + '\'' +
                "\ndate=" + date +
                "\ndegree=" + degree.getDegreeType() +
                '}' + "\n";
    }



}
