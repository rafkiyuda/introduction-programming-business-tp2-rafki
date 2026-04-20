/**
 * Menunjukkan implementasi Inheritance dan Encapsulation
 */

// Superclass
class Vehicle {
    private String brand;
    private int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Method umum yang akan diwarisi
    public void startEngine() {
        System.out.println("Mesin " + brand + " dinyalakan...");
    }

    // Encapsulation: Getter dan Setter untuk melindungi data
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }
}

// Subclass: Car mewarisi Vehicle
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year); // Memanggil constructor superclass
        this.numberOfDoors = numberOfDoors;
    }

    public void openTrunk() {
        System.out.println("Bagasi mobil " + getBrand() + " dibuka.");
    }
}

// Subclass: Motorbike mewarisi Vehicle
class Motorbike extends Vehicle {
    private boolean hasSidecar;

    public Motorbike(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    public void wheelie() {
        System.out.println("Motor " + getBrand() + " melakukan wheelie!");
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2022, 4);
        Motorbike myBike = new Motorbike("Honda", 2023, false);

        // Menunjukkan Code Reusability: Method startEngine() hanya ditulis di Vehicle
        // tapi bisa dipanggil oleh Car dan Motorbike.
        myCar.startEngine();
        myBike.startEngine();

        myCar.openTrunk();
        myBike.wheelie();
    }
}
