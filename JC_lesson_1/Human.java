package JC_lesson_1;

public class Human implements Player{
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpDistance;
    boolean onDistance;

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 10000;
        this.maxSwimDistance = 1000;
        this.maxJumpDistance = 2;
        this.onDistance = true;
    }

    @Override
    public void run(int distance) {
        if (distance <=maxRunDistance) {
            System.out.println(name + " " + "- успешно пройдено");
        }
        else {
            System.out.println(name + " " + "- не пройдено");
            onDistance = false;
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <=maxSwimDistance) {
            System.out.println(name + " " + "- успешно пройдено");
        }
        else {
            System.out.println(name + " " + "- не пройдено");
            onDistance = false;
        }
    }

    @Override
    public void jump(int distance) {
        if (distance <=maxJumpDistance) {
            System.out.println(name + " " + "- успешно пройдено");
        }
        else {
            System.out.println(name + " " + "- не пройдено");
            onDistance = false;
        }
    }

    @Override
    public void showResult() {
        System.out.println(name + ": " + onDistance);
    }
}
