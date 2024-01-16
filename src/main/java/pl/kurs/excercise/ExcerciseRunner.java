package pl.kurs.excercise;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ExcerciseRunner {
    public static void main(String[] args) {
        List<Animal> animals = generateList(100, () -> Animal.Generator.generate());
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println();

        long catsNumber = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .count();

        System.out.println("Number of cats: " +catsNumber);

        List<Animal> notSterileCats = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .map(cat -> (Cat) cat)
                .filter(cat -> !cat.isSterilized())
                .collect(Collectors.toList());

        System.out.println("Found " +notSterileCats.size()+ " cats to sterilisation");

        notSterileCats.stream()
                .map(cat -> (Cat) cat)
                .forEach(cat -> cat.setSterilized(true));

        System.out.println(notSterileCats.size()+" cats sterilised.");

        long dogsNumber = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .count();

        System.out.println("Number of dogs: " +dogsNumber);

        List<Animal> notSterileDogs = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .map(dog -> (Dog) dog)
                .filter(dog -> !dog.isSterilized())
                .collect(Collectors.toList());

        System.out.println("Found " +notSterileDogs.size()+ " dogs to sterilisation");

        notSterileDogs.stream()
                .map(dog -> (Dog) dog)
                .forEach(dog -> dog.setSterilized(true));

        System.out.println(notSterileDogs.size()+" dogs sterilised");
        
        Animal oldestCat = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .max(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println("Oldest cat: " +oldestCat);

        animals.stream()
                .filter(animal -> animal instanceof Dog)
                .max(Comparator.comparingInt(Animal::getAge))
                .ifPresent(x -> System.out.println("Oldest dog: " + x));

        animals.stream()
                .filter(animal -> animal instanceof Cat)
                .min(Comparator.comparingInt(Animal::getAge))
                .ifPresent(x -> System.out.println("Youngest kot: " + x));

        Animal youngestDog = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .min(Comparator.comparingInt(Animal::getAge))
                .orElseThrow();
        System.out.println(youngestDog);

        System.out.println("Age difference between oldest cat called " +oldestCat.getName()+
                " and youngest dog called " +youngestDog.getName()+ " is: " + ageDifference(oldestCat.getAge(), youngestDog.getAge()));

    }
    public static int ageDifference (int firstAge, int secondAge) {
        return firstAge - secondAge;
    }

    public static <T> List<T> generateList(int size, Supplier<T> supplier) {
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i, supplier.get());
        }
        return list;
    }
}
