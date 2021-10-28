package JC_lesson_1;

public class Course{

    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        Player[] players = team.getPlayers();
        if(players.length > 0) {
            for (Player player : players) {
                for (Obstacle obstacle : obstacles) {
                    obstacle.doIt(player);
                    if (!player.isOnDistance()) break;
                }
            }
        } else {
                System.out.println("Команда не участвует");
        }

    }


}
