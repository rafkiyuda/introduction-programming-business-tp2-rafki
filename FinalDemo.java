/**
 * Contoh Program Lengkap: Mendemonstrasikan Karakteristik Final Class untuk Keamanan
 * 
 * Kelas ini saya deklarasikan sebagai FINAL agar tidak ada yang bisa
 * menyabotase konfigurasi database utama saya melalui pewarisan.
 */
final class DatabaseSecurity {
    private final String dbUrl = "jdbc:mysql://secure-server:3306/finance";

    public void connect() {
        System.out.println("Status: Berhasil terhubung ke " + dbUrl);
    }
}

// Jika ada yang mencoba: 'class Malicious extends DatabaseSecurity {}'
// Maka Java akan mengeluarkan ERROR kompilasi saat proses build.

public class FinalDemo {
    public static void main(String[] args) {
        System.out.println("=== Simulasi Implementasi Final Class ===");
        
        DatabaseSecurity sec = new DatabaseSecurity();
        sec.connect();
        
        System.out.println("Detail: Objek dijamin aman karena kelas aslinya tidak dapat dimodifikasi.");
    }
}
