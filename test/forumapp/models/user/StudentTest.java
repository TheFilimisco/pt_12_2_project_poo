package forumapp.models.user;

import forumapp.controller.serviceauthorization.IServiceManagerAuth;
import forumapp.controller.serviceauthorization.LoginRequestDTO;
import forumapp.controller.serviceauthorization.ManagerAuth;
import forumapp.controller.serviceforum.IServiceForum;
import forumapp.controller.serviceforum.ManagerForum;
import forumapp.models.degree.Degree;
import forumapp.models.forum.ProfileUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;
    private IServiceManagerAuth managerAuth;
    private IServiceForum managerForum;
    private Degree degree;

    @BeforeEach
    void setUp() {
        degree = new Degree("DAM", "dam");
        student = new Student("54910978l", "Steven", "nystepro@gmail.com", "999329323", "12345678",degree);
        managerAuth = new ManagerAuth();
        managerForum = new ManagerForum();
    }

    @Test
    void createStudent() {
        assertEquals("54910978l", student.getDni());
        assertEquals("Steven", student.getName());
        assertEquals("nystepro@gmail.com", student.getEmail());
        assertEquals("999329323", student.getPhoneNumber());
        assertEquals("12345678", student.getPassword());
        assertEquals(degree,student.getAssignedDegree());
    }

    @Test
    void registerStudent() {
        managerAuth.register(student, managerForum);
        var profileUser = managerForum.getProfileUser(student.getUserId());
        assertEquals(ProfileUser.class, profileUser.getClass());
    }

    @Test
    void loginTeacher() {
        managerAuth.login(new LoginRequestDTO("54910978l", "12345678"));
        assertEquals(Student.class, student.getClass());
    }

    //Student just allows to have one Degree, by the way just you could modify
    @Test
    void addDegreeTeacher() {
        Degree newDegreee = new Degree("DAM2", "dam2");
        student.setAssignedDegree(newDegreee);
        assertEquals(newDegreee,student.getAssignedDegree());
    }


}