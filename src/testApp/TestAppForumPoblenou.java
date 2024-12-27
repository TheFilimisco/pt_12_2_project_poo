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

        forum.getPostsUsers().add(postsUserStudent);
        forum.getPostsUsers().add(postsUserStudent2);
        forum.getPostsUsers().add(postsUserStudent3);
        forum.getPostsUsers().add(postsUserTeacher);


        Scanner input = new Scanner(System.in);

        boolean runningUser= true;


        while (runningUser){
            menuMain();
            System.out.print("Put your option: ");
            int inputNumberUser = input.nextInt();
            switch (inputNumberUser) {
                case 1:
                    input.nextLine();
                    try {
                        newRegister(input,auth);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    input.nextLine();
                    try {
                        User us = newLogin(input,auth);
                        menuWelcome(us);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    input.nextLine();
                    try {
                        User usAnonymous =  newLoginAnonymous(auth);
                        secondLevel(input,forum,usAnonymous);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    System.out.println("==================Leave=================");
                    runningUser = false;
                    break;
                default:
                    System.out.println("Error, Do put a correct number!");
            }
        }
    }



    public static void menuMain(){
        System.out.println("""
                    ===================Welcome to Forum of Institut Poblenou====================
                    1. Register
                    2. Login
                    3. Into without Register
                    4. Leave
                    ============================================================================
                    """);
    }

    public static void menuWelcome(User looggedUser){
        System.out.printf("""
                       ======================Welcome to Forum %s===============
                       =============================%s=========================
                       1. Access your Admin
                       2. Show All Posts
                       3. Show Posts For Degree
                       4. Show Posts For Subject
                       5. Show Posts For Author(Student or Teacher)
                       6. Leave
                       ========================================================
                       """,looggedUser.getName(),looggedUser.getRole());
    }

    public static void menuWelcomeAnonymous(User looggedUser){
        System.out.printf("""
                       ======================Welcome to Forum %s===============
                       =============================%s=========================
                       1. Show All Posts
                       2. Show Posts For Degree
                       3. Show Posts For Subject
                       4. Show Posts For Author(Student or Teacher)
                       5. Leave
                       ========================================================
                       """,looggedUser.getName(),looggedUser.getRole());
    }

    public static void menuAdminUser(){
        System.out.println("""
                ========================Admin User======================
                1. Create New Post
                2. Shows your Posts
                3. Update your Post
                4. Delete your Post
                ========================================================
                """);
    }


    public static void newRegister(Scanner input, Auth auth ){
        System.out.println("=================Register===============");
        System.out.print("Put your DNI: ");
        String inputDni = input.nextLine();
        System.out.print("Put your name: ");
        String inputName = input.nextLine();
        System.out.print("Put your email: ");
        String inputEmail = input.nextLine();
        System.out.print("Put your phone number: ");
        int inputNumberPhone = input.nextInt();
        input.nextLine();
        System.out.print("Put your password: ");
        String inputPassword = input.nextLine();
        System.out.print("Put your Degree: ");
        String inputNameDegree = input.nextLine();
        try {
            selectYourUser(input,auth,inputDni,inputName,inputEmail,inputNumberPhone,inputPassword,inputNameDegree);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void selectYourUser(Scanner input, Auth auth, String inputDni,String inputName, String inputEmail, int inputNumberPhone, String inputPassword, String inputNameDegree){
        System.out.println("""
                            1. Student
                            2. Teacher
                            """);
        System.out.print("Put your number: ");
        int inputYourOption = input.nextInt();
        if (inputYourOption==1){
            input.nextLine();
            auth.register(new Student(inputDni,inputName, inputEmail, inputNumberPhone, inputPassword, new Degree(inputNameDegree)));
        } else if (inputYourOption==2) {
            input.nextLine();
            auth.register(new Teacher(inputDni,inputName, inputEmail, inputNumberPhone, inputPassword, new Degree(inputNameDegree)));
        } else {
            throw new IllegalArgumentException("Please choose a option:(1-2)");
        }
    }


    public static User newLogin(Scanner input, Auth auth){
        System.out.println("=================Login==================");
        System.out.print("Put your email: ");
        String inputYourEmail = input.nextLine();
        System.out.print("Put your password: ");
        String inputYourPassword = input.nextLine();
        User loggedInUser = auth.login(inputYourEmail,inputYourPassword);
        if (loggedInUser!=null){
            return loggedInUser;
        }else {
            throw new IllegalArgumentException("Don't possible Log in!");
        }
    }

    public static User newLoginAnonymous(Auth auth){
        System.out.println("=============Login Anonymous============");
        return auth.login();
    }


    private static Degree searchDegree(String inputDegree, Forum forum ){
        for (Posts_User postsUser: forum.getPostsUsers()){
            for (Post post : postsUser.getPosts()){
                if (post.getDegree().getDegreeType().equals(Degree.DegreeType.valueOf(inputDegree))){
                    return post.getDegree();
                }
            }
        }
        throw new IllegalArgumentException("This Degree doesn't exist!");
    }

    private static Subject searchSubject(String inputSubject, Forum forum ){
        for (Posts_User postsUser: forum.getPostsUsers()){
            for (Post post : postsUser.getPosts()){
                for (Subject subject: post.getDegree().getSubjects()){
                    if (subject.getName().equals(inputSubject)){
                        return subject;
                    }
                }
            }
        }
        throw new IllegalArgumentException("This Subject doesn't exist!");
    }

    private static User searchTypeOfUser(String inputTypeUser, Forum forum){
        for (Posts_User postsUser: forum.getPostsUsers()){
            if (postsUser.getUser().getRole().equals(inputTypeUser)){
                return postsUser.getUser();
            }
        }
        throw new IllegalArgumentException("This User doesnt exist!");
    }



    public static void secondLevel(Scanner input,Forum forum, User usAnonymous){
        boolean running = true;
        while (running){
            menuWelcomeAnonymous(usAnonymous);
        System.out.print("Put your option: ");
        int inputNumberUserOption = input.nextInt();
        switch (inputNumberUserOption){
            case 1:
                System.out.println("======================Show All Posts==================");
                forum.showAllPosts();
                break;
            case 2:
                input.nextLine();
                System.out.println("======================Show Post for Degree=============");
                System.out.print("Enter your Degree:");
                String inputYourDegree = input.nextLine();
                forum.showPostsForDegree(searchDegree(inputYourDegree,forum));
                break;
            case 3:
                input.nextLine();
                System.out.println("====================Show Post for Subject=============");
                System.out.print("Enter your Subject:");
                String inputYourSubject = input.nextLine();
                forum.showPostsForSubject(searchSubject(inputYourSubject,forum));
                break;
            case 4:
                input.nextLine();
                System.out.println("=====================Show Posts of Student or Teacher");
                System.out.print("Enter your Type of user:");
                String inputTypeOfUser = input.nextLine();
                forum.showPostsForAuthor(searchTypeOfUser(inputTypeOfUser,forum));
                System.out.println("Show Post for Author");
                break;
            case 5:
                System.out.println("back....");
                running = false;
                break;
            default:
                System.out.println("Do write correct option!...");
                break;
            }
        }
    }




}
