package pl.kurs.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPracticeRunner {
    public static void main(String[] args) {


        List<Car> lamborghiniCars = List.of(
                new Car("Lamborghini", "Gallardo", 700000),
                new Car("Lamborghini", "Murcielago", 100000),
                new Car("Lamborghini", "Huracan", 1500000),
                new Car("Lamborghini", "Aventador", 3000000),
                new Car("Lamborghini", "Revuelto", 4000000)
        );

        List<Car> ferrariCars = List.of(
                new Car("Ferrari", "458 Italia", 800000),
                new Car("Ferrari", "488 Pista", 1800000),
                new Car("Ferrari", "812 Superfast", 2000000),
                new Car("Ferrari", "SF90 Stradale", 4000000),
                new Car("Ferrari", "296 GTB", 2000000)
        );


        lamborghiniCars.stream()
                .sorted(Comparator.comparingInt(Car::getPrice).thenComparing(Car::getModel))
                .forEach(System.out::println);

        System.out.println("------------------");

        ferrariCars.stream()
                .filter(car -> car.getPrice() >= 2000000)
                .sorted(Comparator.comparing(car -> car.getModel()))
                .forEach(System.out::println);



    }
}
