package forumapp.controller.servicedegree;

import forumapp.models.degree.Degree;

public interface IServiceManagerDegree {
    Degree addDegree(Degree degree);
    boolean deleteDegree(Degree degree);
    Degree updateDegree(Degree updateDegree);
    void printDegrees();
    Degree getDegree(Integer keyDegree);
}
