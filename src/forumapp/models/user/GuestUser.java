package forumapp.models.user;

import java.time.LocalDate;

public class GuestUser extends User {
    final private LocalDate dateSession;

    public GuestUser() {
        super("", "", "", "", "");
        dateSession = LocalDate.now();
    }

    public LocalDate getDateSession() {
        return dateSession;
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "dateSession=" + dateSession +
                "} " + super.toString();
    }
}
