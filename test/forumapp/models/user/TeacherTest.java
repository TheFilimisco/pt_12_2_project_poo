package forumapp.models.user;

import forumapp.controller.serviceauthorization.IServiceManagerAuth;
import forumapp.controller.serviceauthorization.LoginRequestDTO;
import forumapp.controller.serviceauthorization.ManagerAuth;
import forumapp.controller.serviceforum.IServiceForum;
import forumapp.controller.serviceforum.IServiceManagerForum;
import forumapp.controller.serviceforum.ManagerForum;
import forumapp.models.degree.Degree;
import forumapp.models.forum.Forum;
import forumapp.models.forum.ProfileUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    private Teacher teacher;
    private IServiceManagerAuth managerAuth;
    private IServiceForum managerForum;

    @BeforeEach
    void setUp() {
        teacher = new Teacher("54910923X", "Levi", "levi@gmail.com", "999999999", "12345678");
        managerAuth = new ManagerAuth();
        managerForum = new ManagerForum();
    }

    @Test
    void createTeacher() {
        assertEquals("54910923X", teacher.getDni());
        assertEquals("Levi", teacher.getName());
        assertEquals("levi@gmail.com", teacher.getEmail());
        assertEquals("999999999", teacher.getPhoneNumber());
        assertEquals("12345678", teacher.getPassword());
    }

    @Test
    void registerTeacher() {
        managerAuth.register(teacher, managerForum);
        var profileUser = managerForum.getProfileUser(teacher.getUserId());
        assertEquals(ProfileUser.class, profileUser.getClass());
    }

    @Test
    void loginTeacher() {
        managerAuth.login(new LoginRequestDTO("54910923X", "12345678"));
        assertEquals(Teacher.class, teacher.getClass());
    }

    @Test
    void addDegreeTeacher() {
        teacher.getDegreesAssigned().add(new Degree("DAM","Dam"));
        teacher.getDegreesAssigned().add(new Degree("ASIX","Dam"));
        assertEquals(2, teacher.getDegreesAssigned().size());
    }

}