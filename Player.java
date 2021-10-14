public interface Player {
    void run(int dist);
    void swim(int dist);
    void jump(int dist);
    boolean isOnDistance();
    void showResult();
}
