package org.gtr3base;

public enum Cars {
    BMW_X5("X5",2023,60000, "Luxury Suv"),
    HONDA_CIVIC("Civic", 2023, 22000, "Popular compact car"),
    BMW_M5_COMPETITION("M5", 2025, 80000, "Fast and Comfort"),
    MERCEDES_CLS63("CLS63", 2024, 78000, "Beautiful and Fast");

    private final String model;
    private final int year;
    private final double price;
    public final String description;

    Cars(String model, int year, double price, String description) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.description = description;
    }

    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
}
