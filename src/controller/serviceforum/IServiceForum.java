package controller.serviceforum;

import models.degree.Degree;
import models.degree.Subject;

import java.util.Scanner;

public interface IServiceForum extends IServiceManagerForum {
    void showForum();
    void showPostsByDegree(String degree);
    void showPostsBySubject(String subject);
    void showPostsByUser(String user);
    void showPostsByTopic(Scanner input);
}
