package forumapp.models.user;

import forumapp.models.degree.Degree;
import java.util.HashSet;

public class Teacher extends User{
    private final HashSet<Degree> degreesAssigned;

    public Teacher(String dni, String name, String email, String phoneNumber, String password) {
        super(dni, name, email, phoneNumber, password);
        degreesAssigned = new HashSet<>();
    }

    public HashSet<Degree> getDegreesAssigned() {
        return degreesAssigned;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "degreesAssigned=" +
                degreesAssigned +
                "} " + super.toString();
    }

//    public static void main(String[] args) {
//
//        Teacher teacher = new Teacher("99999993X", "Levi", "levi@gmail.com", 999999999, "12345678");
//        teacher.getDegreesAssigned().add(new Degree("ASIX"));
//        teacher.getDegreesAssigned().add(new Degree("DAM"));
//
//        teacher.getDegreesAssigned().forEach( degree -> {
//            System.out.println(degree.getDegreeType());
//        });
//
//        System.out.println(teacher);
//    }

}
