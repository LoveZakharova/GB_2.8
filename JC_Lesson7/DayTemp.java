package JC_Lesson7;

public class DayTemp {
    String date;
    float maxTemp;
    float minTemp;

    public DayTemp(String date, float maxTemp, float minTemp) {
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    @Override
    public String toString() {
        return "[" +date +", " + maxTemp + ", " + minTemp + "]";
    }

}
