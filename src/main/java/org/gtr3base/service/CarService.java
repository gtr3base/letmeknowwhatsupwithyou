package org.gtr3base.service;

import org.gtr3base.Cars;
import org.gtr3base.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarService {
    private static final Map<String, Car> cars = new HashMap<>();
    static {
        for(Cars c : Cars.values()){
            cars.put(c.name(), buildCar(c));
        }
    }

    public Car getCar(String carName){
        String carNameUp = carName.toUpperCase();

        if(cars.containsKey(carNameUp)){
            return cars.get(carNameUp);
        }

        return cars.values().stream()
                .filter(c -> c.getCarName().toUpperCase().contains(carNameUp)
                    || c.getModel().toUpperCase().contains(carNameUp))
                .findAny().orElse(null);
    }

    private static Car buildCar(Cars carEnum){
        Car car = Car
                .builder()
                .carName(carEnum.name())
                .price(carEnum.getPrice())
                .year(carEnum.getYear())
                .model(carEnum.getModel())
                .build();
        return car;
    }

    public Car updateCar(Car car){
        String key = car.getCarName().toUpperCase();
        if(cars.containsKey(key)){
            cars.put(key, car);
            return car;
        }
        return null;
    }

    public Car addCar(Car car){
        car.setCarName(car.getCarName().toUpperCase());
        cars.put(car.getCarName(), car);
        return car;
    }

    public boolean deleteCar(String carName){
        return cars.remove(carName.toUpperCase()) != null;
    }

    public List<Car> getAllCars(){
        return new ArrayList<>(cars.values());
    }

    public List<Car> getCarByYear(int year){
        return cars.values()
                .stream()
                .filter(c -> c.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Car> getCarByPriceRange(int min, int max){
        return cars.values()
                .stream()
                .filter(c -> c.getPrice() >= min && c.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<Car> getCarByPriceRange(int min){
        return cars.values()
                .stream()
                .filter(c -> c.getPrice() >= min)
                .collect(Collectors.toList());
    }

    public List<Car> getCarByPriceRange(String max){
        return cars.values()
                .stream()
                .filter(c -> c.getPrice() <= Integer.parseInt(max))
                .collect(Collectors.toList());
    }

    public int getTotalCars(){
        return cars.size();
    }

    public List<String> getAllCarNames(){
        return cars.values()
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
