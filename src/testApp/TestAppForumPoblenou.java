package testApp;


import forumapp.controller.serviceauthorization.LoginRequestDTO;
import forumapp.controller.serviceauthorization.ManagerAuth;
import forumapp.controller.servicedegree.ManagerDegree;
import forumapp.controller.serviceforum.ManagerForum;
import forumapp.controller.serviceprofileuser.ManagerProfileUser;
import forumapp.controller.serviceprofileuser.TypeOfPost;
import forumapp.controller.servicesubject.ManagerSubject;
import forumapp.models.auth.Auth;
import forumapp.models.degree.Degree;
import forumapp.models.degree.Subject;
import forumapp.models.forum.Forum;
import forumapp.models.forum.Post;
import forumapp.models.user.Student;
import forumapp.models.user.Teacher;
import forumapp.AppForum;
import forumapp.view.menu.MenuManagerView;

import java.time.LocalDate;
import java.util.Scanner;

public class TestAppForumPoblenou {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MenuManagerView menu = new MenuManagerView();

        // Create Subjects
        ManagerSubject managerSubject = new ManagerSubject();
        managerSubject.addSubject(new Subject("Programming","POO I"));
        managerSubject.addSubject(new Subject("DataBases", "DML I"));
        managerSubject.addSubject(new Subject("English", "B1"));
        managerSubject.addSubject(new Subject("History Security", "Beginner"));

        ManagerDegree managerDegree = new ManagerDegree();
        managerDegree.addDegree(new Degree("DAM","Across Platform App"));
        managerDegree.addDegree(new Degree("ASIX","Cybersecurity"));

        managerDegree.getDegree(0).getSubjects().add(managerSubject.getSubject(0));
        managerDegree.getDegree(0).getSubjects().add(managerSubject.getSubject(1));

        managerDegree.getDegree(1).getSubjects().add(managerSubject.getSubject(2));
        managerDegree.getDegree(1).getSubjects().add(managerSubject.getSubject(3));

        managerDegree.printDegrees();

        Auth auth = new Auth();
        Forum forum = new Forum();

        ManagerForum managerForum  = new ManagerForum(forum);

        ManagerAuth managerAuth = new ManagerAuth(auth);
        managerAuth.register(new Student("54910978L","Steven","nystepro@gmail.com","99999999", "123456789",managerDegree.getDegree(0)), managerForum);
        managerAuth.register(new Teacher("32923823X","Levi","levi@gmail.com","99999919", "123456789"), managerForum);

        managerAuth.usersRegistered();

        ManagerProfileUser managerProfileUser = new ManagerProfileUser();
        managerProfileUser.addNewPost( managerForum.getProfileUser(0), new Post("Need a Team For Football",managerForum.getProfileUser(0).getUser(), TypeOfPost.QUESTION, "Need somebody For a Team", LocalDate.now(), managerDegree.getDegree(0)));
        managerProfileUser.addNewPost( managerForum.getProfileUser(0), new Post("I Have a Doubt", managerForum.getProfileUser(0).getUser(), TypeOfPost.DOUBT, "Somebody About Programming?", LocalDate.now(), managerDegree.getDegree(0)));
        managerProfileUser.addNewPost( managerForum.getProfileUser(0), new Post("I've Resolved Exercise I of BBDD", managerForum.getProfileUser(0).getUser(), TypeOfPost.HELP, "Explain exercise*", LocalDate.now(), managerDegree.getDegree(0)));

        managerProfileUser.addNewPost( managerForum.getProfileUser(1), new Post("Somebody want get 1 extra point?",managerForum.getProfileUser(1).getUser(), TypeOfPost.QUESTION, "Need somebody For math", LocalDate.now(), managerDegree.getDegree(1)));
        managerProfileUser.addNewPost( managerForum.getProfileUser(1), new Post("I need help to my Laptop", managerForum.getProfileUser(1).getUser(), TypeOfPost.QUESTION, "My laptop is Crashing", LocalDate.now(), managerDegree.getDegree(1)));
        managerProfileUser.addNewPost( managerForum.getProfileUser(1), new Post("I've Resolved my proble with my Laptop", managerForum.getProfileUser(1).getUser(), TypeOfPost.HELP, "Fix my problem*", LocalDate.now(), managerDegree.getDegree(0)));

        managerForum.showForum();


        AppForum appForum = new AppForum(input,menu,managerAuth,managerForum,managerDegree,managerProfileUser,managerSubject);
        appForum.run();

    }
}
