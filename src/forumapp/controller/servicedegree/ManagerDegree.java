package forumapp.controller.servicedegree;

import forumapp.models.degree.Degree;

import java.util.HashMap;

public class ManagerDegree implements IServiceManagerDegree {
    final private HashMap<Integer, Degree> degrees;

    public ManagerDegree() {
        degrees = new HashMap<>();
    }

    @Override
    public Degree addDegree(Degree degree) {
        return degrees.put(degree.getIdDegree(), degree);
    }

    @Override
    public boolean deleteDegree(Degree degree) {
        return degrees.remove(degree.getIdDegree(), degree);
    }

    @Override
    public Degree updateDegree(Degree updateDegree) {
        return degrees.put(updateDegree.getIdDegree(),updateDegree);
    }

    @Override
    public void printDegrees() {
        System.out.println("============Degrees===========");
        degrees.forEach((k,v)->{
            System.out.println(k + " : " + v.getNameDegree() + " : " + v.getDescription());
            System.out.printf("==============%s' Subjects========== ", v.getNameDegree());
            System.out.println();
            v.getSubjects().forEach(sub -> {
                System.out.println(sub.getIdSubject() + " : " + sub.getName());
            });
        });
    }

    @Override
    public Degree getDegree(Integer keyDegree) {
        return degrees.get(keyDegree);
    }
}
