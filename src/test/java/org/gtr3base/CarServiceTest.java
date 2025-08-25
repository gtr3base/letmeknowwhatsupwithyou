package org.gtr3base;

import org.gtr3base.enums.Cars;
import org.gtr3base.model.Car;
import org.gtr3base.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @InjectMocks
    private CarService carService;

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
