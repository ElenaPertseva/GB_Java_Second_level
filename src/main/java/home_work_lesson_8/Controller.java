package home_work_lesson_8;

import home_work_lesson_8.enums.Functionality;
import home_work_lesson_8.enums.Periods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static home_work_lesson_8.enums.Functionality.GET_CURRENT_WEATHER;
import static home_work_lesson_8.enums.Functionality.GET_WEATHER_IN_NEXT_5_DAYS;

public class Controller {
    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, GET_CURRENT_WEATHER);
        variantResult.put(2, GET_WEATHER_IN_NEXT_5_DAYS);
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
        }
    }

    public void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(Periods.NOW);
    }

    public void getWeatherIn5Days() {
        throw new RuntimeException("Implement in h/w");
    }
}
