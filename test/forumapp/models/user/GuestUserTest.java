package forumapp.models.user;

import forumapp.controller.serviceauthorization.LoginRequestDTO;
import forumapp.controller.serviceauthorization.ManagerAuth;
import forumapp.controller.serviceforum.ManagerForum;
import forumapp.controller.serviceprofileuser.ManagerProfileUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GuestUserTest {
    private GuestUser guestUser;
    private ManagerAuth managerAuth;
    private ManagerForum managerForum;
    private ManagerProfileUser managerProfileUser;


    @BeforeEach
    void setUp() {
        guestUser = new GuestUser();
        managerAuth = new ManagerAuth();
        managerForum = new ManagerForum();
    }

    @Test
    void createGuestUser() {
        assertEquals("", guestUser.getDni());
        assertEquals("", guestUser.getPassword());
        assertEquals("", guestUser.getPhoneNumber());
        assertEquals("", guestUser.getEmail());
        assertEquals("", guestUser.getName());
        assertEquals(LocalDate.now(),guestUser.getDateSession());
    }

    @Test
    void loginGuestUser() {
        // Automatically login like a GuestUser
        var getUser = managerAuth.login(new LoginRequestDTO("", ""));
        assertEquals(GuestUser.class, getUser.getClass());
    }

    @Test
    void accessProfileUser(){
        //Is null by auth register, it instead add ProfileUser just access to Forum, but not rise towards ProfileUser
        var accessProfileUser = managerForum.getProfileUser(guestUser.getUserId());
        assertNull(accessProfileUser);
    }
}