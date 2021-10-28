package JC_lesson_1;

public class Water extends Obstacle{
    private int distance;

    public Water(int distance) { this.distance = distance; }

    @Override
    public void doIt(Player player) {
        player.swim(distance);
    }
}
