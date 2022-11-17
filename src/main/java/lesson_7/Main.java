package lesson_7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("black", "BMW");
        String jsonFromCar = objectMapper.writeValueAsString(car);
        System.out.println(jsonFromCar);

        Car carFromJSON = objectMapper.readValue(jsonFromCar, Car.class);
        System.out.println(carFromJSON);

        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("White", "Mersedes"),
                new Car("Red", "Renault")));
        String carsListJSON = objectMapper.writeValueAsString(cars);
        System.out.println(cars);

        List<Car> carsFromJSON = objectMapper.readValue(carsListJSON, new TypeReference<ArrayList<Car>>() {
        });
        System.out.println(carsFromJSON);


    }


}
