package testApp;

import models.degree.Degree;
import models.auth.Auth;
import models.forum.Forum;
import models.forum.Posts_User;
import models.user.Student;
import models.user.Teacher;
import models.user.User;

import java.util.Scanner;

public class TestAppForumPoblenou {
    public static void main(String[] args) {
//        Student student = new Student("99999999X", "Steven", "nystepro@gmail.com",999999999,"12345678",new Degree("DAM", "Across Platform Apps"));
//        System.out.println(student);
//        Teacher teacher = new Teacher("99999999X", "Levi", "levi@gmail.com", 999999999, "12345678",new Degree("ASIX", "Security"));
//        System.out.println(teacher);
//
//

//        auth.register(student);
//        auth.register(teacher);
//
//        System.out.println(auth.login("nystepro@gmail.com", "12345678"));

        Auth auth = new Auth();
        Forum forum = new Forum();
        Scanner input = new Scanner(System.in);

        boolean runningUser= true;


        while (runningUser){
            menuMain();
            System.out.print("Put your option: ");
            int inputNumberUser = input.nextInt();
            switch (inputNumberUser) {
                case 1:
                        newRegister(input,auth);
                    break;
                case 2:
                        User us = newLogin(input,auth);
                        menuWelcome(us);
                    System.out.print("Put your Option:");
                    int inputYourOption = input.nextInt();
                        switch (inputYourOption){
                            case 1:
                                menuAdminUser();
                                System.out.print("Put your Option:");
                                int inputYourOptionAdmin = input.nextInt();
                                switch (inputYourOptionAdmin) {
                                    case 1:
                                        System.out.println("=================Create new Post=================");
                                        for (Posts_User postsUser: forum.getPostsUsers()){
                                            if (postsUser.getUser().equals(us)){
                                                postsUser.createNewPost("ASDASD","ASDASD","ASDASD",0 );
                                            }
                                        }


                                }
                                break;

                        }
                    break;
                case 3:
                        User usAnonymous =  newLoginAnonymous(auth);
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
                    ========================Welcome to Forum===============
                    1. Register
                    2. Login
                    3. Into without Register
                    4. Leave
                    =======================================================
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
                       """,looggedUser.getName(),looggedUser.getRole());
    }

    public static void menuAdminUser(){
        System.out.println("""
                ========================Admin User======================
                1. Create New Post
                2. Shows your Posts
                3. Update your Post
                4. Delete your Post
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
        System.out.println("""
                            1. Student
                            2. Teacher
                            3. Back
                            """);
        System.out.print("Put your number: ");
        int inputYourOption = input.nextInt();
        if (inputYourOption==1){
            input.nextLine();
            auth.register(new Student(inputDni,inputName, inputEmail, inputNumberPhone, inputPassword, new Degree(inputNameDegree,"XD")));
        } else if (inputYourOption==2) {
            input.nextLine();
            auth.register(new Teacher(inputDni,inputName, inputEmail, inputNumberPhone, inputPassword, new Degree(inputNameDegree,"XD")));
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
            throw new IllegalArgumentException("Don't possible!");
        }
    }

    public static User newLoginAnonymous(Auth auth){
        System.out.println("=============Login Anonymous============");
        return auth.login();
    }




}
