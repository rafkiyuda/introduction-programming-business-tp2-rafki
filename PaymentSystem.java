/**
 * Menunjukkan implementasi Polymorphism dalam sistem Ride-Hailing
 */

// Superclass atau Abstract Class untuk Polimorfisme Runtime
abstract class Payment {
    // Method yang akan di-override (Runtime Polymorphism)
    public abstract void processPayment(double amount);

    // Method Overloading (Compile-time Polymorphism)
    // Versi 1: Bayar tanpa diskon
    public void printReceipt(double amount) {
        System.out.println("Struk: Total Bayar Rp" + amount);
    }

    // Versi 2: Bayar dengan kode voucher (Overloaded)
    public void printReceipt(double amount, String voucher) {
        System.out.println("Struk: Total Bayar Rp" + amount + " [Voucher: " + voucher + "]");
    }
}

// Subclass untuk Tunai
class CashPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Memproses bayar tunai: Harap terima uang Rp" + amount);
    }
}

// Subclass untuk E-Wallet
class EWalletPayment extends Payment {
    private String walletId;

    public EWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Memproses saldo E-Wallet (" + walletId + "): Memotong Rp" + amount);
    }
}

// Subclass untuk Kartu Kredit
class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Memproses Kartu Kredit (" + cardNumber + "): Mendebit Rp" + amount);
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        // Mendemonstrasikan Polimorfisme: Berbagai bentuk pembayaran dalam satu tipe referensi
        Payment p1 = new CashPayment();
        Payment p2 = new EWalletPayment("USER_001_OVO");
        Payment p3 = new CreditCardPayment("1234-5678-9012");

        System.out.println("=== Simulasi Pembayaran Ride-Hailing ===");

        // Runtime Polymorphism: Objek yang berbeda memanggil implementasi method masing-masing
        p1.processPayment(25000);
        p2.processPayment(50000);
        p3.processPayment(75000);

        System.out.println("\n=== Simulasi Overloading ===");
        // Compile-time Polymorphism: Kompiler memilih method berdasarkan parameter
        p1.printReceipt(25000);
        p1.printReceipt(20000, "HEMAT30");
    }
}
