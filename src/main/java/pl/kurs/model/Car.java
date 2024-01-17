package pl.kurs.model;

import java.util.Objects;

public class Car {
    private String producer;
    private String model;
    private int price;

    private CarCetagory category;

    public Car(String producer, String model, int price, CarCetagory category) {
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarCetagory getCategory() {
        return category;
    }

    public void setCategory(CarCetagory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(producer, car.producer) && Objects.equals(model, car.model) && category == car.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, price, category);
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
