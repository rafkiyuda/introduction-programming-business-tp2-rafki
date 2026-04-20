import java.util.Scanner;

/**
 * Menunjukkan implementasi Exception Handling dan Pattern Matching
 */
public class ExceptionAndPatternSystem {
    public static void main(String[] args) {
        demonstrateExceptionHandling();
        System.out.println("-----------------------------------");
        demonstratePatternMatching("Halo Dunia");
        demonstratePatternMatching(100);
    }

    // Bagian b: Contoh try-catch-finally untuk menangani kesalahan input
    public static void demonstrateExceptionHandling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Sistem Input Nominal Transaksi ===");
        System.out.print("Masukkan jumlah transfer (angka): ");
        
        // Simulasi input (karena di lingkungan otomatis, kita asumsikan input "abc" untuk menunjukkan error)
        String inputStr = "abc"; // Anggap user mengetik teks bukan angka
        System.out.println("(Simulasi input: '" + inputStr + "')");

        try {
            int amount = Integer.parseInt(inputStr);
            System.out.println("Berhasil! Jumlah transfer: Rp" + amount);
        } catch (NumberFormatException e) {
            // Menangkap kesalahan jika input bukan angka
            System.out.println("Kesalahan: Input yang Anda masukkan bukan angka yang valid!");
        } finally {
            // Selalu dijalankan untuk membersihkan resource
            System.out.println("Proses input selesai.");
            // scanner.close(); // Dalam aplikasi nyata, tutup scanner di sini
        }
    }

    // Bagian c: Contoh Pattern Matching dalam instanceof
    public static void demonstratePatternMatching(Object obj) {
        System.out.println("Mengecek tipe data objek...");

        // Pattern matching: Langsung mendeklarasikan variabel 's' atau 'i' jika tipe cocok
        if (obj instanceof String s) {
            // Tidak perlu casting manual: String s = (String) obj;
            System.out.println("Objek adalah String: \"" + s + "\" dengan panjang " + s.length());
        } else if (obj instanceof Integer i) {
            System.out.println("Objek adalah Integer: " + i + " (Hasil kuadrat: " + (i * i) + ")");
        } else {
            System.out.println("Tipe data tidak dikenal.");
        }
    }
}
