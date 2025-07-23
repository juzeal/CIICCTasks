package tasks.task13;

public class task13 {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Camry", 2022, 4);
        car.displayDetails();
    }
}

abstract class Vehicle {
    String make;
    String model;
    int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    abstract public void displayDetails();
}

class Car extends Vehicle {
    int numberOfDoors;

    public Car(String make, String model, int year, int numberOfDoors){
        super(make, model, year);
        this.numberOfDoors = numberOfDoors; 
    }

    @Override
    public void displayDetails() {
        System.out.println(
            "Make: " + make + "\n" +
            "Model: " + model + "\n" +
            "Year: " + year + "\n" +
            "# of Doors: " + numberOfDoors + "\n"
        );
    }

}
