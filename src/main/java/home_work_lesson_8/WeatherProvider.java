package home_work_lesson_8;

import home_work_lesson_8.enity.WeatherData;
import home_work_lesson_8.enums.Periods;

import java.io.IOException;

public interface WeatherProvider {
    WeatherData getWeather(Periods periods) throws IOException;

    WeatherData getAllFromDb() throws IOException;
}
