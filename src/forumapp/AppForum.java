package forumapp;

import forumapp.controller.serviceauthorization.IServiceManagerAuth;
import forumapp.controller.serviceauthorization.LoginRequestDTO;
import forumapp.controller.serviceauthorization.ManagerAuth;
import forumapp.controller.servicedegree.IServiceManagerDegree;
import forumapp.controller.servicedegree.ManagerDegree;
import forumapp.controller.serviceforum.IServiceForum;
import forumapp.controller.serviceforum.ManagerForum;
import forumapp.controller.serviceprofileuser.IServiceManagerProfileUser;
import forumapp.controller.serviceprofileuser.ManagerProfileUser;
import forumapp.controller.serviceprofileuser.TypeOfPost;
import forumapp.controller.servicesubject.IServiceManagerSubject;
import forumapp.controller.servicesubject.ManagerSubject;
import forumapp.models.degree.Degree;
import forumapp.models.degree.Subject;
import forumapp.models.forum.Post;
import forumapp.models.forum.ProfileUser;
import forumapp.models.user.Student;
import forumapp.models.user.Teacher;
import forumapp.models.user.User;
import forumapp.view.menu.IMenuTemplate;
import forumapp.view.menu.MenuManagerView;

import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;

public class AppForum {
    final private Scanner input;
    final private IMenuTemplate menu;
    final private IServiceManagerAuth managerAuth;
    final private IServiceForum managerForum;
    final private IServiceManagerDegree managerDegree;
    final private IServiceManagerProfileUser managerProfileUser;
    final private IServiceManagerSubject managerSubject;


    public AppForum(Scanner input, IMenuTemplate menu, IServiceManagerAuth managerAuth, IServiceForum managerForum, IServiceManagerDegree managerDegree, IServiceManagerProfileUser managerProfileUser, IServiceManagerSubject managerSubject) {
        this.input = input;
        this.menu = menu;
        this.managerAuth = managerAuth;
        this.managerForum = managerForum;
        this.managerDegree = managerDegree;
        this.managerProfileUser = managerProfileUser;
        this.managerSubject = managerSubject;
    }

    public AppForum() {
        input = new Scanner(System.in);
        menu = new MenuManagerView();
        managerAuth = new ManagerAuth();
        managerForum = new ManagerForum();
        managerDegree = new ManagerDegree();
        managerProfileUser = new ManagerProfileUser();
        managerSubject = new ManagerSubject();
    }

    public void run() {
        boolean running= true;
        while (running){
            menu.showMenuMain();
            System.out.print("Put your option: ");
            int inputNumberUser = input.nextInt();
            switch (inputNumberUser) {
                case 1:
                    handleException(() -> System.out.println(managerAuth.register(selectOptionUser(), managerForum)));
                    break;
                case 2:
                    handleException(() -> forumLevel(managerAuth.login(createLoginRequest())));
                    break;
                case 3:
                    System.out.println("==================Leave=================");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }
        }
    }

    private Student createStudent() {
        input.nextLine();
        System.out.println("==========Create Student==========");
        System.out.print("Enter Student DNI: ");
        String dni = input.nextLine();
        System.out.print("Enter Student Name: ");
        String name = input.nextLine();
        System.out.print("Enter Student Email: ");
        String email = input.nextLine();
        System.out.print("Enter Student Phone Number: ");
        String phoneNumber = input.nextLine();
        System.out.print("Enter Student Password: ");
        String password = input.nextLine();
        var degree = searchDegree();
        return  new Student(dni, name, email, phoneNumber, password, degree);
    }

    private Degree searchDegree() {
        System.out.println("==========Search Degree By Key==========");
        System.out.print("Enter Degree Key: ");
        int inputNameDegree = input.nextInt();
        return managerDegree.getDegree(inputNameDegree);
    }

    private Teacher createTeacher(){
        input.nextLine();
        System.out.println("==========Create Teacher==========");
        System.out.print("Enter Teacher DNI: ");
        String dni = input.nextLine();
        System.out.print("Enter Teacher Name: ");
        String name = input.nextLine();
        System.out.print("Enter Teacher Email: ");
        String email = input.nextLine();
        System.out.print("Enter Teacher Phone Number: ");
        String phoneNumber = input.nextLine();
        System.out.print("Enter Teacher Password: ");
        String password = input.nextLine();
        return new Teacher(dni, name, email, phoneNumber, password);
    }

    private Degree createDegree(){
        System.out.println("==========Create Degree==========");
        System.out.print("Enter Degree Name: ");
        String name = input.nextLine();
        System.out.print("Enter description: ");
        String description = input.nextLine();
        return new Degree(name, description);
    }

    private Subject createSubject(){
        input.nextLine();
        System.out.println("==========Create Subject==========");
        System.out.print("Enter Subject Name: ");
        String name = input.nextLine();
        System.out.print("Enter description: ");
        String description = input.nextLine();
        return new Subject(name, description);
    }

    private User selectOptionUser() {
        input.nextLine();
        System.out.println("==========Select Option Register==========");
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.print("Enter Option: ");
        int inputNumberOption = input.nextInt();
        switch (inputNumberOption) {
            case 1:
                return createStudent();
            case 2:
                return createTeacher();
            default:
                System.out.println("Invalid input, please try again");
        }
        throw new IllegalArgumentException("Invalid option");
    }

    private LoginRequestDTO createLoginRequest(){
        input.nextLine();
        System.out.println("==========Enter your Data==========");
        System.out.print("Enter DNI: ");
        String dni = input.nextLine();
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        return new LoginRequestDTO(dni, password);
    }

    private void forumLevel(User user) {
        boolean running = true;
        while (running){
            menu.showMenuForum(user);
            System.out.print("Put your option: ");
            int inputNumberUserOption = input.nextInt();
            switch (inputNumberUserOption){
                case 1:
                    System.out.println("...acceding");
                    handleException(() -> profileLevel(managerForum.getProfileUser(user.getUserId())));
                    break;
                  case 2:
                      System.out.println("======================Show All Posts==================");
                      managerForum.showForum();
                    break;
                  case 3:
                      input.nextLine();
                      System.out.println("======================Show Post for Degree=============");
                      System.out.print("Enter your Degree:");
                      String inputYourDegree = input.nextLine();
                      managerForum.showPostsByDegree(inputYourDegree);
                    break;
                  case 4:
                      input.nextLine();
                      System.out.println("====================Show Post for Subject=============");
                      System.out.print("Enter your Subject:");
                      String inputYourSubject = input.nextLine();
                      managerForum.showPostsBySubject(inputYourSubject);
                    break;
                  case 5:
                      input.nextLine();
                      System.out.println("=================Show Posts of Student or Teacher======");
                      System.out.print("Enter your Type of user:");
                      String inputTypeOfUser = input.nextLine();
                      managerForum.showPostsByUser(inputTypeOfUser);
                    break;
                  case 6:
                      input.nextLine();
                      System.out.println("=================Search Post================");
                      managerForum.showPostsByTopic(input);
                    break;
                  case 7:
                      System.out.println("back....");
                      running = false;
                      break;
                  default:
                      System.out.println("Do write right option!...");
            }
        }
    }

    private void profileLevel(ProfileUser profileUser){
        if (validationProfileUser(profileUser)){
            return;
        }
        boolean running = true;
        while (running){
            menu.showMenuProfile();
            System.out.print("Put your option: ");
            int inputNumberUserOption = input.nextInt();
            switch (inputNumberUserOption){
                case 1:
                    input.nextLine();
                    System.out.println("===============Create New Post===============");
                    System.out.println( managerProfileUser.addNewPost(profileUser,createPost(profileUser)));
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("==============Shows your Posts===============");
                    managerProfileUser.readPosts(profileUser);
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("==============Update your Post===============");
                    handleException(() -> managerProfileUser.updatePost(profileUser,updatePost(profileUser)));
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("=============Delete your Post=================");
                    System.out.print("Put Key Post:");
                    int inputIdPostDelete = input.nextInt();
                    handleException(() -> managerProfileUser.deletePost(profileUser,inputIdPostDelete));
                case 5:
                    System.out.println("back....");
                    running = false;
                    break;
                default:
                    System.out.println("Do write correct option!");
            }
        }
    }

    private boolean validationProfileUser(ProfileUser profileUser){
        if (profileUser == null){
            System.out.println("You are not logged in");
            return true;
        }
        return false;
    }

    private Post createPost(ProfileUser profileUser){
        System.out.print("Enter your title: ");
        String inputTitle = input.nextLine();
        System.out.print("Enter your Type of Post(Doubt,Question,Help,Event): ");
        TypeOfPost inputTypeOfPost = TypeOfPost.valueOf(input.nextLine());
        System.out.print("Enter your description: ");
        String inputDescription = input.nextLine();
        return new Post(inputTitle,profileUser.getUser(),inputTypeOfPost,inputDescription,LocalDate.now(),searchDegree());
    }

    private Post updatePost(ProfileUser profileUser){
        System.out.println("Enter your Key Post: ");
        int inputKeyPost = input.nextInt();
        var getPost = managerProfileUser.readPost(profileUser,inputKeyPost);
        if (getPost == null){
            throw new IllegalStateException("getPost returned null");
        }
        input.nextLine();
        System.out.println("Enter your new title: ");
        String inputNewTitle = input.nextLine();
        getPost.setTitle(inputNewTitle);
        System.out.print("Enter your new description: ");
        String inputNewDescription = input.nextLine();
        getPost.setDescription(inputNewDescription);
        System.out.println("Enter your new TypeOfPost(Doubt,Question,Help,Event): ");
        getPost.setTypeOfPost(TypeOfPost.valueOf(input.nextLine()));
        System.out.println("Enter your new Key Post: ");
        getPost.setDegree(searchDegree());
        getPost.setDate(LocalDate.now());
        return getPost;
    }

    private void handleException(Runnable action) {
        try {
            action.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
