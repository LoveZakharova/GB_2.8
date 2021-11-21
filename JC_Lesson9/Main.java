package JC_Lesson9;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Learner learner1 = new Learner("Ivan", 4);
        Learner learner2 = new Learner("Olga", 1);
        Learner learner3 = new Learner("Nina", 3);
        Learner learner4 = new Learner("Fedor", 2);

        ArrayList<Learner> learners = new ArrayList<>();
        learners.add(learner1);
        learners.add(learner2);
        learners.add(learner3);
        learners.add(learner4);

        List<Learner> sortedBy = learners.stream()
                .sorted((learner1, learner2) -> learner1.curiosity - learner2.curiosity)
                .collect(Collectors.toList());

        System.out.println(sortedBy);

        /*List<Course> list = new ArrayList<Course>();
        list.add(new Course("Программирование"));
        list.add(new Course("Ин.язык"));
        list.add(new Course("Архитектура"));
        list.add(new Course("Моделирование"));*/

    }
}

