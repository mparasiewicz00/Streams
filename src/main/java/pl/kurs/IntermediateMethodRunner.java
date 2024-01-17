package pl.kurs;

import pl.kurs.model.Car;
import pl.kurs.model.CarCetagory;
import pl.kurs.model.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateMethodRunner {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Kamil", "Wacław", "Karol", null);
        list.forEach(System.out::println);

        //filter()
        System.out.println("------------------------");
        List<String> collected = list.stream()
                .filter(Objects::nonNull)
                //.forEach(System.out::println);
                .collect(Collectors.toList());
        System.out.println(collected);
        System.out.println("-----------------------------------------");

        //map()
        List<Employee> employeeList = List.of(
                new Employee("Wojciech", "Szczęsny", 200_000.0D),
                new Employee("Robert", "Lewandowski", 300_000.0D),
                new Employee("Michał", "Pazdan", 300_000.0D)
        );

        List<Double> salaries = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.toList());

        salaries.forEach(System.out::println);

        System.out.println("-----------------------------------------");

        //limit()
        IntStream intStream = IntStream.rangeClosed(0, 5);
        int[] ints = intStream.limit(4)
                .toArray();
        System.out.println(Arrays.toString(ints));

        System.out.println("-------------------------------------");
        //distinct()
        List<Car> carList = List.of(
                new Car("Audi", "RS4 B7", 100000, CarCetagory.SPORTS_CAR),
                new Car("BMW", "M3 e92",100000, CarCetagory.SPORTS_CAR),
                new Car("BMW", "M3 e92",100000, CarCetagory.SPORTS_CAR),
                new Car("Mercedes-Benz", "C63 AMG",200000, CarCetagory.SPORTS_CAR)
        );

        carList.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        //sorted()
        List<Integer> integerList = List.of(1, 2, 3, 4, 19, 5, 10);

        integerList.stream()
                .sorted()
                .forEach(System.out::println);

//        employeeList.stream()
//                .sorted()
//                .forEach(System.out::println);

        employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getLastName))
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        //peek()
        employeeList.stream()
                .peek(x -> System.out.println("Jebac piłke nożną"))
                .peek(x -> x.setSalary(x.getSalary() * 1.2))
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        //skip()
        integerList.stream()
                .skip(4)
                .forEach(System.out::println);

        System.out.println("---------------------------------------");

        //boxed()
        IntStream intStream1 = IntStream.rangeClosed(0, 10);
        List<Integer> integers = intStream1
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integers);

        System.out.println("--------------------------------------------");

        //flatMap()
        Car[] sportCarArray = {
                new Car("Ferrari", "488 GTB",2000000, CarCetagory.SUPER_CAR),
                new Car("Lamborghini", "Huracan EVO", 2000000, CarCetagory.SUPER_CAR)
        };

        Car[] suvCarArray = {
                new Car("BMW", "X5M", 500000, CarCetagory.SUV),
                new Car("Lamborghini", "Urus",1500000, CarCetagory.SUV)
        };
        List<Car[]> carsArraysList = List.of(sportCarArray, suvCarArray);
        System.out.println(carsArraysList);
        List<Car> collect = carsArraysList.stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
