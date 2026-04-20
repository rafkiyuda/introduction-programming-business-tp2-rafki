import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Contoh Program Lengkap: Mendemonstrasikan Lambda Expression vs Anonymous Inner Class
 */
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> daftarBelanja = Arrays.asList("Apel", "Susu", "Roti");

        // 1. PENDEKATAN TRADISIONAL (Menggunakan Anonymous Inner Class)
        System.out.println("=== Output Tanpa Lambda ===");
        daftarBelanja.forEach(new Consumer<String>() {
            @Override
            public void accept(String item) {
                // Saya harus menulis ulang struktur class dan method di sini
                System.out.println("Beli item: " + item);
            }
        });

        System.out.println("\n---------------------------\n");

        // 2. PENDEKATAN MODERN (Menggunakan Lambda Expression)
        System.out.println("=== Output Dengan Lambda ===");
        // Java secara otomatis mengenali parameter 'item' dan memetakan logikanya
        daftarBelanja.forEach(item -> System.out.println("Beli item: " + item));
    }
}
