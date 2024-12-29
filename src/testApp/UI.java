package testApp;

import models.auth.Auth;
import models.degree.Degree;
import models.degree.Subject;
import models.forum.Forum;
import models.forum.Post;
import models.forum.Posts_User;
import models.user.Student;
import models.user.Teacher;
import models.user.User;

import java.util.Scanner;

public class UI {

    public void menuMain(){
        System.out.println("""
                    ===================Welcome to Forum of Institut Poblenou====================
                    1. Register
                    2. Login
                    3. Into without Register
                    4. Leave
                    ============================================================================
                    """);
    }

    public void menuWelcome(User looggedUser){
        System.out.printf("""
                       ======================Welcome to Forum %s===============
                       =============================%s=========================
                       1. Access your Admin
                       2. Show All Posts
                       3. Show Posts For Degree
                       4. Show Posts For Subject
                       5. Show Posts For Author(Student or Teacher)
                       6. Back
                       ========================================================
                       """,looggedUser.getName(),looggedUser.getRole());
    }

    public void menuAdminUser(){
        System.out.println("""
                ========================Admin your Profile======================
                1. Create New Post
                2. Shows your Posts
                3. Update your Post
                4. Delete your Post
                5. Back
                ========================================================
                """);
    }


    public void newRegister(Scanner input, Auth auth ){
        input.nextLine();
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

    private void selectYourUser(Scanner input, Auth auth, String inputDni,String inputName, String inputEmail, int inputNumberPhone, String inputPassword, String inputNameDegree){
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


    public User newLogin(Scanner input, Auth auth){
        input.nextLine();
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

    public User newLoginAnonymous(Auth auth){
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
        throw new IllegalArgumentException("This User doesn't exist!");
    }

    private static Posts_User searchProfile(User user, Forum forum){
        for (Posts_User postsUser: forum.getPostsUsers()){
            if (postsUser.getUser().equals(user)){
                return postsUser;
            }
        }
        throw new IllegalArgumentException("This Profile doesn't exist");
    }



    public void secondLevel(Scanner input,Forum forum, User user){
        boolean running = true;
        while (running){
            menuWelcome(user);
            System.out.print("Put your option: ");
            int inputNumberUserOption = input.nextInt();
            switch (inputNumberUserOption){
                case 1:
                    System.out.println("...acceding");
                    thirdLevel(input,searchProfile(user,forum));
                    break;
                case 2:
                    System.out.println("======================Show All Posts==================");
                    forum.showAllPosts();
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("======================Show Post for Degree=============");
                    System.out.print("Enter your Degree:");
                    String inputYourDegree = input.nextLine();
                    forum.showPostsForDegree(searchDegree(inputYourDegree,forum));
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("====================Show Post for Subject=============");
                    System.out.print("Enter your Subject:");
                    String inputYourSubject = input.nextLine();
                    forum.showPostsForSubject(searchSubject(inputYourSubject,forum));
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("=====================Show Posts of Student or Teacher");
                    System.out.print("Enter your Type of user:");
                    String inputTypeOfUser = input.nextLine();
                    forum.showPostsForAuthor(searchTypeOfUser(inputTypeOfUser,forum));
                    System.out.println("Show Post for Author");
                    break;
                case 6:
                    System.out.println("back....");
                    running = false;
                    break;
                default:
                    System.out.println("Do write correct option!...");
                    break;
            }
        }
    }


    public void thirdLevel(Scanner input, Posts_User postsUser){
        boolean running = true;
        while (running){
            menuAdminUser();
            System.out.print("Put your option: ");
            int inputNumberUserOption = input.nextInt();
            switch (inputNumberUserOption){
                case 1:
                    input.nextLine();
                    System.out.println("===============Create New Post===============");
                    System.out.print("Put your Title Post: ");
                    String inputTitle = input.nextLine();
                    System.out.println("Put your Type of Post(Doubts,Questions,Help,Events): ");
                    String inputTypeOfPost = input.nextLine();
                    System.out.print("Put your description: ");
                    String inputDescription = input.nextLine();
                    System.out.println("Put your Degree(if you are Teacher select position of Degree, Student no is necessary put 0): ");
                    int inputPositionDegree = input.nextInt();
                    postsUser.createNewPost(inputTitle,inputTypeOfPost,inputDescription,inputPositionDegree);
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("==============Shows your Posts===============");
                    postsUser.showPosts();
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("==============Update your Post===============");
                    System.out.print("Put id of your Post:");
                    int inputIdPost = input.nextInt();
                    System.out.print("Put new Title: ");
                    String inputNewTitle = input.nextLine();
                    System.out.print("Put new Description: ");
                    String inputNewDescription = input.nextLine();
                    postsUser.searchPost(inputIdPost);
                    postsUser.updatePosts(inputIdPost,inputNewTitle,inputNewDescription);
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("=============Delete your Post=================");
                    System.out.print("Put id of your Post:");
                    int inputIdPostDelete = input.nextInt();
                    postsUser.deletePost(inputIdPostDelete);
                    break;
                case 5:
                    System.out.println("back....");
                    running = false;
                    break;
                default:
                    System.out.println("Do write correct option!");
            }
        }


    }

    public void mainLevel(Scanner input,Auth auth, Forum forum){
        boolean running= true;
        while (running){
            menuMain();
            System.out.print("Put your option: ");
            int inputNumberUser = input.nextInt();
            switch (inputNumberUser) {
                case 1:
                    handleException(()->newRegister(input,auth));
                    break;
                case 2:
                    handleException(()->secondLevel(input,forum,newLogin(input,auth)));
                    break;
                case 3:
                    handleException(()->secondLevel(input,forum,newLoginAnonymous(auth)));
                    break;
                case 4:
                    System.out.println("==================Leave=================");
                    running = false;
                    break;
                default:
                    System.out.println("Error, Do put a correct number!");
            }
        }
    }



    public void handleException(Runnable action) {
        try {
            action.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
