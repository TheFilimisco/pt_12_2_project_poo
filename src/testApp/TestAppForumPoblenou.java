package testApp;

import models.Degree.Degree;
import models.auth.Auth;
import models.user.Student;
import models.user.Teacher;

public class TestAppForumPoblenou {
    public static void main(String[] args) {
        Student student = new Student("99999999X", "Steven", "nystepro@gmail.com",999999999,"12345678",new Degree("DAM", "Across Platform Apps"));
        System.out.println(student);
        Teacher teacher = new Teacher("99999999X", "Levi", "levi@gmail.com", 999999999, "12345678",new Degree("ASIX", "Security"));
        System.out.println(teacher);


        Auth auth = new Auth();
        auth.register(student);
        auth.register(teacher);

        System.out.println(auth.login("nystepro@gmail.com", "12345678"));



    }

}
