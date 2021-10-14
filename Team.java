public class Team {
    String teamName;
    Player[] players = new Player[4];

    public Team(String teamName, Player[] players) {
        this.teamName = teamName;
        this.players = players;
    }

    public String getTeamName() {
        return "Название команды: " + teamName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void showResults () {
        for (Player player : players) {
            player.showResult();
        }
    }

    public void distanceOk() {
        for (Player player : players) {
            if (player.isOnDistance()) player.showResult();
        }
    }


}
