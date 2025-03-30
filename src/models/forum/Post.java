package models.forum;

import controller.serviceprofileuser.TypeOfPost;
import models.degree.Degree;
import models.user.User;

import java.time.LocalDate;
import java.util.Objects;

public class Post {
    final private int idPost;
    final private String title;
    final private User author;
    private TypeOfPost typeOfPost;
    private String description;
    private LocalDate date;
    private Degree degree;
    private static int counterPost = 0;

    public Post(String title, User author, TypeOfPost typeOfPost, String description, LocalDate date, Degree degree) {
        this.title = title;
        this.author = author;
        this.typeOfPost = typeOfPost;
        this.description = description;
        this.date = date;
        this.degree = degree;
        idPost = counterPost++;
    }

    public int getIdPost() {
        return idPost;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
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

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return idPost == post.idPost;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPost);
    }

    @Override
    public String toString() {
        return "\nPost{" +
                "====================================================="+
                "\nidPost=" + idPost +
                "\ntitle='" + title + '\'' +
                "\nauthor=" + author.getName() +
                "\ntypeOfPost=" + typeOfPost +
                "\ndescription='" + description + '\'' +
                "\ndate=" + date +
                "\ndegree=" + degree.getNameDegree() +
                "\n======================================================"+
                '}';
    }
}
