package models.forum;

import models.user.User;

import java.time.LocalDate;

public class Post {
    private int idPost;
    private String title;
    private User author;
    private String typeOfPost;
    private String description;
    private LocalDate date;
    private static int counterPost = 0;

    public Post(String title, User author, String typeOfPost, String description, LocalDate date) {
        this.idPost = counterPost++;
        this.title = title;
        this.author = author;
        this.typeOfPost = typeOfPost;
        this.description = description;
        this.date = date;
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

    public String getTypeOfPost() {
        return typeOfPost;
    }

    public void setTypeOfPost(String typeOfPost) {
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

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", typeOfPost='" + typeOfPost + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
