package home_work_lesson_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();
        String responseBody;
        String cityCode = "295212";
        try (Response response = client.newCall(getWeather(cityCode)).execute()) {
            responseBody = response.body() != null ? Objects.requireNonNull(response.body()).string() : "0";
        }
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        Weather forecast = mapper.readValue(responseBody, Weather.class);
        DailyForecast[] forecastTemp = forecast.getDailyForecasts().toArray(new DailyForecast[0]);
        for (DailyForecast df : forecastTemp) {
            System.out.println("In Saint Petersburg on date " + df.getDate() +
                    " will be " + df.getDay().getIconPhrase() +
                    ", temperature: " + df.getTemperature().getMaximum().getValue());
        }
    }

    static Request getWeather(String postCode) {
        String apiKey = "3X1p7320ePjXvllDmokQ4nd63pt4GQpk";
        return new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + postCode + "?apikey=" + apiKey + "&language=en-us&details=false&metric=true")
                .build();
    }

}
