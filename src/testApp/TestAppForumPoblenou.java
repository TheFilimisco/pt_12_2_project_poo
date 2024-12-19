package testApp;

import models.degree.Degree;
import models.auth.Auth;
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
        Auth auth = new Auth();
//        auth.register(student);
//        auth.register(teacher);
//
//        System.out.println(auth.login("nystepro@gmail.com", "12345678"));


        Scanner input = new Scanner(System.in);

        boolean runningUser= true;


        while (runningUser){
            System.out.println("""
                    ========================Welcome to Forum===============
                    1. Register
                    2. Login
                    3. Into without Register
                    4. Leave
                    =======================================================
                    """);
            System.out.print("Put your option: ");
            int inputNumberUser = input.nextInt();
            switch (inputNumberUser) {
                case 1:
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
                    } else {
                        break;
                    }
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("=================Login==================");
                    System.out.print("Put your email: ");
                    String inputYourEmail = input.nextLine();
                    System.out.print("Put your password: ");
                    String inputYourPassword = input.nextLine();
                    User loggedInUser = auth.login(inputYourEmail,inputYourPassword);
                    if (loggedInUser == null){
                        break;
                    } else {
                        System.out.printf("""
                                ======================Welcome to Forum %s===============
                                =============================%s=========================
                                1. Watch General Posts
                                2. Watch Posts of Questions
                                3. Watch Posts of Helps
                                4. Watch Posts of Events
                                5. Leave
                               """,loggedInUser.getName(),loggedInUser.getRole());
                    }
                    break;
                case 3:
                    System.out.println("=============Login Anonymous============");
                    User loggedInUserAnonymous = auth.login();
                    System.out.printf("""
                                ======================Welcome to Forum %s===============
                                =============================%s=========================
                                1. Watch General Posts
                                2. Watch Posts of Questions
                                3. Watch Posts of Helps
                                4. Watch Posts of Events
                                5. Leave
                               """,loggedInUserAnonymous.getName(),loggedInUserAnonymous.getRole());
                    break;
                case 4:
                    System.out.println("==================Leave=================");
                    runningUser = false;
                    break;
                case 5:
                    for (User user : auth.getUsers()){
                        System.out.println(user);
                    }
                    break;
                default:
                    System.out.println("Error, Do put a correct number!");
            }
        }

    }

}
