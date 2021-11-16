package JC_Lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import com.fasterxml.jackson.*;
import okhttp3.Request;
import okhttp3.Response;
import org.sqlite.JDBC;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherResponse {
    final static OkHttpClient okHttpClient = new OkHttpClient();
    final static ObjectMapper objectMapper = new ObjectMapper();
    final static String host = "dataservice.accuweather.com";
    public final String PATH_DB = "jdbc:sqlite:C:\\Users\\RedmiBook\\IdeaProjects\\JavaCore\\src\\main\\resources\\Weather.db";

    Connection connection;
    public WeatherResponse() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        connection = DriverManager.getConnection(PATH_DB);

    }

    public static String detectCityId(String cityName) throws IOException {
        //по какому адресу (URL!!!) и с какими параметрами нужно отправить запрос GET
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(host)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "jAcv7N2lhbeF7nH6Em3oGvByhwXcNRP9 ")
                .addQueryParameter("q", cityName)
                .build();

        //на основании url сам запрос с заголовками (headers)
        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(httpUrl)
                .build();

        //Вызов запроса: запрос обрабатывается в объекте класса респонс
        Response response = okHttpClient.newCall(request).execute();

        //распарсить запрос, в данном случае только тело ответа
        String json = response.body().string();

        String city = objectMapper.readTree(json).get(0).at("/LocalizedName").asText();
        System.out.println(city);
        String code = objectMapper.readTree(json).get(0).at("/Key").asText();

        return code;

    }

    public static String getForecast (String cityCode) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(cityCode)
                .addQueryParameter("apikey", "jAcv7N2lhbeF7nH6Em3oGvByhwXcNRP9")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        //распарсить запрос, в данном случае только тело ответа
        String json = response.body().string();

        String forecastsJson = objectMapper.readTree(json).at("/DailyForecasts").toString();
        String dayForecast = objectMapper.readTree(forecastsJson).get(0).toString();
        String date= objectMapper.readTree(dayForecast).
                at("/Date").
                asText();
        String maxTemp= objectMapper.readTree(dayForecast).
                at("/Temperature").
                at("/Maximum").
                at("/Value").
                asText();
        String minTemp= objectMapper.readTree(dayForecast).
                at("/Temperature").
                at("/Minimum").
                at("/Value").
                asText();
        System.out.println(date + " " + maxTemp + " " + minTemp);
        return forecastsJson;

    }

    DayTemp dayTemp = new DayTemp(); //просит параметры, но они должны автоматически попадать
    public void addDayTemp (DayTemp dayTemp) {
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Weather('date', 'maxTemp', 'minTemp')" +
                        " VALUES(?, ?, ?)"
        )) {
            statement.setObject(1, dayTemp.date);
            statement.setObject(2, dayTemp.maxTemp);
            statement.setObject(3, dayTemp.minTemp);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<DayTemp> showWeather() throws SQLException {
        List<DayTemp> daysTemp = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Weather");
            while (resultSet.next()) {
                DayTemp dayTemp = new DayTemp(); //параметры??
                dayTemp.date = resultSet.getString("date");
                dayTemp.maxTemp = resultSet.getFloat("maxTemp");
                dayTemp.minTemp = resultSet.getFloat("minTemp");
                daysTemp.add(dayTemp);
            }
        }
        return daysTemp;
    }



}
