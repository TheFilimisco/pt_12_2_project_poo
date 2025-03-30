package view;


import controller.serviceauthorization.IServiceManagerAuth;
import controller.serviceauthorization.LoginRequestDTO;
import controller.servicedegree.IServiceManagerDegree;
import controller.serviceforum.IServiceForum;
import controller.serviceprofileuser.IServiceManagerProfileUser;
import controller.serviceprofileuser.TypeOfPost;
import models.degree.Degree;
import models.degree.Subject;
import models.forum.Post;
import models.forum.ProfileUser;
import models.user.Student;
import models.user.Teacher;
import models.user.User;
import view.menu.IMenuTemplate;


import java.time.LocalDate;
import java.util.Scanner;

public class UI {


    public void mainLevel(Scanner input, IMenuTemplate menu, IServiceManagerAuth managerAuth, IServiceForum managerForum, IServiceManagerDegree managerDegree, IServiceManagerProfileUser managerProfileUser) {
        boolean running= true;
        while (running){
            menu.showMenuMain();
            System.out.print("Put your option: ");
            int inputNumberUser = input.nextInt();
            switch (inputNumberUser) {
                case 1:
                    handleException(() -> managerAuth.register(selectOptionUser(input,managerDegree), managerForum));
                    break;
                case 2:
                    handleException(() -> secondLevel(input, menu, managerForum, managerAuth.login(createLoginRequest(input)), managerProfileUser, managerDegree));
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


    private Student createStudent(Scanner input, IServiceManagerDegree managerDegree) {
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
        var degree = searchDegree(input, managerDegree);
        return  new Student(dni, name, email, phoneNumber, password, degree);
    }

    private Degree searchDegree(Scanner input, IServiceManagerDegree managerDegree) {
        System.out.println("==========Search Degree By Key==========");
        System.out.print("Enter Degree Key: ");
        int inputNameDegree = input.nextInt();
        return managerDegree.getDegree(inputNameDegree);
    }

    private Teacher createTeacher(Scanner input){
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

    private Degree createDegree(Scanner input){
        System.out.println("==========Create Degree==========");
        System.out.print("Enter Degree Name: ");
        String name = input.nextLine();
        System.out.print("Enter description: ");
        String description = input.nextLine();
        return new Degree(name, description);
    }

    private Subject createSubject(Scanner input){
        input.nextLine();
        System.out.println("==========Create Subject==========");
        System.out.print("Enter Subject Name: ");
        String name = input.nextLine();
        System.out.print("Enter description: ");
        String description = input.nextLine();
        return new Subject(name, description);
    }

    private User selectOptionUser(Scanner input, IServiceManagerDegree managerDegree) {
        input.nextLine();
        System.out.println("==========Select Option Register==========");
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.print("Enter Option: ");
        int inputNumberOption = input.nextInt();
        switch (inputNumberOption) {
            case 1:
                return createStudent(input,managerDegree);
            case 2:
                return createTeacher(input);
            default:
                System.out.println("Invalid input, please try again");
        }
        return null;
    }

    private LoginRequestDTO createLoginRequest(Scanner input){
        input.nextLine();
        System.out.println("==========Enter your Data==========");
        System.out.print("Enter DNI: ");
        String dni = input.nextLine();
        System.out.println("Enter Password: ");
        String password = input.nextLine();
        return new LoginRequestDTO(dni, password);
    }

    private void secondLevel(Scanner input, IMenuTemplate menu, IServiceForum managerForum, User user, IServiceManagerProfileUser managerProfileUser, IServiceManagerDegree managerDegree) {
        boolean running = true;
        while (running){
            menu.showMenuForum(user);
            System.out.print("Put your option: ");
            int inputNumberUserOption = input.nextInt();
            switch (inputNumberUserOption){
                case 1:
                    System.out.println("...acceding");
                    thirdLevel(input,managerForum.getProfileUser(user.getUserId()),menu, managerProfileUser, managerDegree);

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

    private void thirdLevel(Scanner input, ProfileUser profileUser, IMenuTemplate menu, IServiceManagerProfileUser managerProfileUser, IServiceManagerDegree managerDegree){
        boolean running = true;
        while (running){
            menu.showMenuProfile();
            System.out.print("Put your option: ");
            int inputNumberUserOption = input.nextInt();
            switch (inputNumberUserOption){
                case 1:
                    input.nextLine();
                    System.out.println("===============Create New Post===============");
                    System.out.print("Put your Title Post: ");
                    String inputTitle = input.nextLine();
                    System.out.println("Put your Type of Post(Doubts,Questions,Help,Events): ");
                    TypeOfPost inputTypeOfPost = TypeOfPost.valueOf(input.nextLine());
                    System.out.print("Put your description: ");
                    String inputDescription = input.nextLine();
                    managerProfileUser.addNewPost(profileUser, new Post(inputTitle, profileUser.getUser(),inputTypeOfPost, inputDescription, LocalDate.now(), searchDegree(input,managerDegree)));
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("==============Shows your Posts===============");
                    managerProfileUser.readPosts(profileUser);
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("==============Update your Post===============");
                    System.out.print("Put your id Post: ");
                    int inputIdPost = input.nextInt();
                    managerProfileUser.updatePost(profileUser,managerProfileUser.readPost(profileUser,inputIdPost));
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("=============Delete your Post=================");
                    System.out.print("Put id of your Post:");
                    int inputIdPostDelete = input.nextInt();
                    managerProfileUser.deletePost(profileUser, inputIdPostDelete);
                case 5:
                    System.out.println("back....");
                    running = false;
                    break;
                default:
                    System.out.println("Do write correct option!");
            }
        }
    }

    private void handleException(Runnable action) {
        try {
            action.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
