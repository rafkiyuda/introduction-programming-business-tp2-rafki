/**
 * Menunjukkan implementasi Abstract Class dalam sistem Kepegawaian
 */

// Abstract Class: Sebagai blueprint dasar untuk semua jenis karyawan
abstract class Employee {
    private String name;
    private String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Method konkrit (sudah ada implementasi) yang bisa digunakan semua subclass
    public void displayInfo() {
        System.out.println("ID: " + employeeId + " | Nama: " + name);
    }

    // Abstract method: Setiap tipe karyawan punya cara hitung gaji yang berbeda
    public abstract double calculateSalary();

    public String getName() {
        return name;
    }
}

// Subclass untuk karyawan tetap
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, String employeeId, double monthlySalary) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Subclass untuk karyawan paruh waktu
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        // Polimorfisme: Menggunakan tipe referensi Employee untuk berbagai jenis karyawan
        Employee emp1 = new FullTimeEmployee("Budi", "FT-001", 8000000);
        Employee emp2 = new PartTimeEmployee("Siti", "PT-005", 50000, 100);

        System.out.println("=== Sistem Penggajian Karyawan ===");
        
        emp1.displayInfo();
        System.out.println("Gaji Bulanan: Rp" + emp1.calculateSalary());

        System.out.println("-----------------------------------");

        emp2.displayInfo();
        System.out.println("Gaji (Berdasarkan Jam): Rp" + emp2.calculateSalary());
    }
}
