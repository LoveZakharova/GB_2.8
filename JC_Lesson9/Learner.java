package JC_Lesson9;

import java.util.List;

public class Learner {
    String name;
    int curiosity;

    public String getName() {
        return name;
    }


    public Learner(String name, int curiosity) {
        this.name = name;
        this.curiosity = curiosity;
    }

    @Override
    public String toString() {
        return name + " " + curiosity;
    }


}
