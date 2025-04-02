package forumapp.controller.servicesubject;

import forumapp.models.degree.Subject;

public interface IServiceManagerSubject {
    Subject addSubject(Subject subject);
    boolean deleteSubject(Subject subject);
    Subject updateSubject(Subject updateSubject);
    void printSubjects();
    Subject getSubject(Integer keySubject);
}
