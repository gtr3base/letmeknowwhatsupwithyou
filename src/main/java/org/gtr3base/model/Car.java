package org.gtr3base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Car {
    private String carName;
    private String model;
    private int year;
    private double price;
}
