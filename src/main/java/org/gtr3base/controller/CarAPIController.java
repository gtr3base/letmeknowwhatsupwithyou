package org.gtr3base.controller;

import org.gtr3base.model.Car;
import org.gtr3base.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarAPIController {
    private final CarService carService;

    public CarAPIController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{name}")
    public Car getCar(@PathVariable String name){
        System.out.println("getCar:"+name);
        return carService.getCar(name);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carService.addCar(car);
    }

    @DeleteMapping
    public boolean deleteCar(@RequestParam String name){
        return carService.deleteCar(name);
    }

    @GetMapping("/all")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/year")
    public List<Car> getCarsByYear(@RequestParam int year){
        return carService.getCarByYear(year);
    }

    @GetMapping("/price")
    public List<Car> getCarsByPriceRange(@RequestParam int min, @RequestParam int max){
        return carService.getCarByPriceRange(min, max);
    }

    @GetMapping("/price/min")
    public List<Car> getCarsByPriceRange(@RequestParam int min){
        return carService.getCarByPriceRange(min);
    }

    @GetMapping("/price/max")
    public List<Car> getCarsByPRange(@RequestParam String max){
        return carService.getCarByPriceRange(max);
    }

    @GetMapping("/total")
    public int getCarsTotal(){
        return carService.getTotalCars();
    }

    @GetMapping("/names")
    public List<String> getCarNames(){
        return carService.getAllCarNames();
    }

}
