import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Menunjukkan implementasi Modern Java: Lambda, Sealed Classes, dan Final Class
 */

// --- BAGIAN B: SEALED CLASSES (Kontrol Hirarki) ---
// Saya membatasi hanya Cash dan CreditCard yang boleh mewarisi PaymentMethod
sealed interface PaymentMethod permits Cash, CreditCard {}

final class Cash implements PaymentMethod {}
final class CreditCard implements PaymentMethod {}

// class EWallet extends Cash {} // Ini akan ERROR jika Cash dideklarasikan final


// --- BAGIAN C: FINAL CLASS (Keamanan & Immutability) ---
// Kelas ini tidak bisa di-extend oleh siapapun untuk menjaga integritas logika
final class SecurityManager {
    public void validate(String token) {
        System.out.println("Sistem: Memvalidasi token keamanan '" + token + "'...");
    }
}


public class AdvancedJavaSystem {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("Laptop", "Mouse", "Keyboard");

        // --- BAGIAN A: LAMBDA EXPRESSION ---
        System.out.println("=== 1. Analisis Kode Lambda ===");
        
        // Gaya Tradisional (Anonymous Inner Class)
        System.out.println("Output (Gaya Tradisional):");
        items.forEach(new Consumer<String>() {
            @Override
            public void accept(String item) { 
                System.out.println("  > " + item); 
            }
        });

        // Gaya Modern (Lambda Expression) - Jauh lebih ringkas
        System.out.println("\nOutput (Gaya Lambda):");
        items.forEach(item -> System.out.println("  > " + item));


        // --- DEMO BAGIAN B & C ---
        System.out.println("\n=== 2. Analisis Sealed & Final Class ===");
        
        PaymentMethod payment = new CreditCard();
        if (payment instanceof CreditCard) {
            System.out.println("Status: Menggunakan metode pembayaran Kartu Kredit (Sealed Class Verified).");
        }

        SecurityManager security = new SecurityManager();
        security.validate("ABC-123-XYZ");
        System.out.println("Info: Kelas SecurityManager bersifat final, tidak dapat dimodifikasi via pewarisan.");
    }
}
