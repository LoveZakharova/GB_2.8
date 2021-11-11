package JC_Lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import com.fasterxml.jackson.*;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.security.SecureRandom;

public class WeatherResponse {
    final static OkHttpClient okHttpClient = new OkHttpClient();
    final static ObjectMapper objectMapper = new ObjectMapper();
    final static String host = "dataservice.accuweather.com";

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

        /*String city = objectMapper.readTree(json).get(0).at("/LocalizedName").asText();
        System.out.println(city);
        String code = objectMapper.readTree(json).get(0).at("/Key").asText();*/

        return json;

    }



}
