package forumapp.models.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GuestUserTest {
    private GuestUser guestUser;

    @BeforeEach
    void setUp() {
        guestUser = new GuestUser();
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


}