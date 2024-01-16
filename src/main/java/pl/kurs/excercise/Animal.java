package pl.kurs.excercise;

import java.util.Random;

public class Animal {
    private String name;
    private int age;
    private boolean sterilized;


    public Animal(String name, int age, boolean sterilized) {
        this.name = name;
        this.age = age;
        this.sterilized = sterilized;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sterilized=" + sterilized +
                '}';
    }

    public static class Generator {
        private static String[] names = {"Gacuś", "Bari", "Marian", "Staś", "Garfield", "Czaruś", "Ludomir", "Borowik", "Kedi"};

        private static Random random = new Random();

        public static Animal generate() {
            String generatedName = names[random.nextInt(names.length)];
            int generatedAge = random.nextInt(25) + 1;
            boolean generatedBoolean = random.nextBoolean();
//            if(random.nextBoolean()) {
//                return new Dog(generatedName, generatedAge, generatedBoolean);
//            }
//            else
//                return new Cat(generatedName, generatedAge, generatedBoolean);
            return random.nextBoolean() ? new Dog(generatedName, generatedAge, generatedBoolean) : new Cat(generatedName, generatedAge, generatedBoolean);
        }
    }
}
