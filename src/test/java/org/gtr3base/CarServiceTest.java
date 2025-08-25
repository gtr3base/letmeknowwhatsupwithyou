package org.gtr3base;

import org.gtr3base.enums.Cars;
import org.gtr3base.model.Car;
import org.gtr3base.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @InjectMocks
    private CarService carService;

    private Map<String, Car> cars;

    @BeforeEach
    void setUp(){
        cars = new HashMap<>();

        cars.put("BMW_X5", Car.builder().carName("BMW_X5").model("X5").price(60000.0).year(2023).build());
        cars.put("AUDI_A4", Car.builder().carName("AUDI_A4").model("A4").price(45000.0).year(2023).build());
        cars.put("MERCEDES_C300", Car.builder().carName("MERCEDES_C300").model("C300").price(48000.0).year(2023).build());
        cars.put("TOYOTA_CAMRY", Car.builder().carName("TOYOTA_CAMRY").model("Camry").price(28000.0).year(2023).build());

        carService.setCars(cars);
    }

    @Test
    void getCar_ShouldReturnExactMatchIfExists(){
        Car result = carService.getCar("BMW_X5");

        assertNotNull(result);
        assertEquals("BMW_X5", result.getCarName());
        assertEquals("X5", result.getModel());
    }

    @Test
    void buildCar_ShouldReturnCarWithCorrectProps(){
        Cars carEnum = Cars.BMW_X5;

        Car result = carService.addCar(buildCar(carEnum));

        assertNotNull(result);
        assertEquals(carEnum.name(), result.getCarName());
        assertEquals(carEnum.getPrice(), result.getPrice());
        assertEquals(carEnum.getYear(), result.getYear());
        assertEquals(carEnum.getModel(), result.getModel());
    }

    @Test
    void buildCar_ShouldHandleAllEnumVals(){

        for(Cars cars: Cars.values()){
            Car result = carService.addCar(buildCar(cars));

            assertNotNull(result, "Shouldnt be null for" + cars);
            assertEquals(cars.name(), result.getCarName());
            assertEquals(cars.getPrice(), result.getPrice());
            assertEquals(cars.getYear(), result.getYear());
            assertEquals(cars.getModel(), result.getModel());
        }
    }

    private Car buildCar(Cars carEnum){
        return Car
                .builder()
                .carName(carEnum.name())
                .price(carEnum.getPrice())
                .year(carEnum.getYear())
                .model(carEnum.getModel())
                .build();
    }


}
