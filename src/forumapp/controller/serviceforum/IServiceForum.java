package forumapp.controller.serviceforum;

import java.util.Scanner;

public interface IServiceForum extends IServiceManagerForum {
    void showForum();
    void showPostsByDegree(String degree);
    void showPostsBySubject(String subject);
    void showPostsByUser(String user);
    void showPostsByTopic(Scanner input);
}
