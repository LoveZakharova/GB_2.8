package JC_Lesson7;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String cityCode = WeatherResponse.detectCityId("Kazan");
        System.out.println(cityCode);
        String forecast = WeatherResponse.getForecast(cityCode);
        System.out.println(forecast);


    }

}
