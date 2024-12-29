package testApp;

import models.degree.Degree;
import models.auth.Auth;
import models.degree.Subject;
import models.forum.Forum;
import models.forum.Post;
import models.forum.Posts_User;
import models.user.Student;
import models.user.Teacher;
import models.user.User;

import java.util.Scanner;

public class TestAppForumPoblenou {
    public static void main(String[] args) {


        // Create some Users

        // Student
        Student student = new Student("99999999X", "Steven", "nystepro@gmail.com",999999999,"12345678", new Degree("DAM"));
        Student student2 = new Student("99999990X", "Manolito", "nystepro@gmail.com",999999999,"12345678", new Degree("ASIX"));
        Student student3 = new Student("99999991X", "Vegeta777", "nystepro@gmail.com",999999999,"12345678", new Degree("SMIX"));
        // Teacher
        Teacher teacher = new Teacher("99999993X", "Levi", "levi@gmail.com", 999999999, "12345678",new Degree("ASIX"));

        Auth auth = new Auth();
        // Generate Some posts for Student
        Posts_User postsUserStudent =new Posts_User(student);
        postsUserStudent.createNewPost("I need Infomation of DAM","Doubts", "I have a lot of doubts",0);
        postsUserStudent.createNewPost("I have QUESTION!","Questions", "I have a questions",0);
        postsUserStudent.createNewPost("I need a TEAM","Events", "I need a events",0);

        Posts_User postsUserStudent2 =new Posts_User(student2);
        postsUserStudent2.createNewPost("I need Infomation of DAM student2","Doubts", "I have a lot of doubts",0);
        postsUserStudent2.createNewPost("I have QUESTION! student2","Questions", "I have a questions",0);
        postsUserStudent2.createNewPost("I need a TEAM student2","Events", "I need a events",0);

        Posts_User postsUserStudent3 =new Posts_User(student3);
        postsUserStudent3.createNewPost("I need Infomation of DAM student3","Doubts", "I have a lot of doubts",0);
        postsUserStudent3.createNewPost("I have QUESTION! student3","Questions", "I have a questions",0);
        postsUserStudent3.createNewPost("I need a TEAM student3","Events", "I need a events",0);


        // Generate some Posts for Teacher
        Posts_User postsUserTeacher = new Posts_User(teacher);
        postsUserTeacher.createNewPost("Need students for a project","Events", "Need students of DAM or ASIX, for a project",0);
        postsUserTeacher.createNewPost("Second call for project","Events", "Need students of DAM or ASIX, for a project",0);
        postsUserTeacher.createNewPost("Need a Frontend Developer","Events", "Need students of DAM or ASIX, for a project",0);

        auth.register(student);
        auth.register(teacher);
        auth.register(student2);
        auth.register(student3);

        Forum forum = new Forum();
        UI ui = new UI();

        forum.getPostsUsers().add(postsUserStudent);
        forum.getPostsUsers().add(postsUserStudent2);
        forum.getPostsUsers().add(postsUserStudent3);
        forum.getPostsUsers().add(postsUserTeacher);

        Scanner input = new Scanner(System.in);

        ui.mainLevel(input,auth,forum);
    }



}
