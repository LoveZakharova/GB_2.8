package JC_lesson_1;

public class Cross extends Obstacle{
    private int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Player player) {
        player.run(distance);
    }

}
