package home_work_lesson_8;

import home_work_lesson_6.AccuweatherModel;
import home_work_lesson_6.Period;
import home_work_lesson_6.WeatherModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApplicationGlobalState {
    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "0d1tNZJPfzzT3qGokM18FGGxAUpt7hpj";
    private final String DB_FILENAME = "application.db";

    private ApplicationGlobalState() {
    }

    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getDbFileName() {
        return DB_FILENAME;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }

    public static class Controller {
        private WeatherModel weatherModel = new AccuweatherModel();
        private Map<Integer, Period> variants = new HashMap<Integer, Period>();

        public Controller() {
            variants.put(1, Period.NOW);
            variants.put(5, Period.FIVE_DAYS);
            variants.put(2, Period.DB);
        }

        public void getWeather(String userInput, String selectedCity) throws IOException {
            Integer userIntegerInput = Integer.parseInt(userInput);

            switch (variants.get(userIntegerInput)) {
                case FIVE_DAYS:
                    throw new IOException("Метод не реализован!");
                    //weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                case DB:
                    weatherModel.getSavedToDBWeather();
            }
        }
    }
}
