/**
 * Contoh Program Lengkap: Mendemonstrasikan Sealed Classes dan Exhaustiveness Checking
 */

// 1. Deklarasi Sealed Interface: Hanya mengizinkan Cash dan CreditCard
sealed interface PaymentMethod permits Cash, CreditCard {}

// 2. Implementasi wajib bersifat final, sealed, atau non-sealed sesuai aturan Java
final class Cash implements PaymentMethod {
    void pay() { System.out.println("Sistem: Memproses pembayaran tunai."); }
}

final class CreditCard implements PaymentMethod {
    void pay() { System.out.println("Sistem: Mendebit saldo Kartu Kredit."); }
}

public class SealedDemo {
    public static void main(String[] args) {
        PaymentMethod myPayment = new Cash();
        
        System.out.println("=== Simulasi Desain Sistem Terkontrol ===");
        // Menggunakan Pattern Matching untuk memproses input
        if (myPayment instanceof Cash c) {
            c.pay();
        } else if (myPayment instanceof CreditCard cc) {
            cc.pay();
        }
    }
}
