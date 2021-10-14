public class LessonOne {
    public static void main(String[] args) {
        Player[] players = {new Human("Иван"),
                new Human("Мария"),
                new Human("Борис"),
                new Human("Ольга")};
        Obstacle[] obstacles = {new Cross(4000), new Water(250), new Line(1)};
        Team team = new Team("Команда мечты", players);

        System.out.println("Команда создана");
        System.out.println(team.getTeamName());
        //team.showResults();

        //создаем новую полосу препятствий для конкретного раунда
        Course course = new Course(obstacles);
        System.out.println("Команда вышла на старт");
        course.doIt(team);

        System.out.println("Результаты команды");
        team.showResults();
        team.distanceOk();

    }
}
