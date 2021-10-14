public class Line extends Obstacle{
    private int distance;

    public Line(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Player player) {
        player.jump(distance);
    }

}
