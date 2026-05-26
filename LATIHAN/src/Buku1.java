import java.util.HashMap;
import java.util.Map;

class  Buku{
    String isbn;
    String judul;
    static Map<String, Buku> daftarBuku = new HashMap<>();

    public Buku(String isbn, String judul){
        this.isbn = isbn;
        this.judul = judul;
    }
}
    public class Buku1{
    public static void main(String[] args) {

        Map<String, Buku> daftarbuku = new HashMap<>();

        daftarbuku.put("234-001", new Buku("234-001", "PBO"));
        daftarbuku.put("345-002", new Buku("345-002", "ASD"));
        daftarbuku.put("456-003", new Buku("456-003", "Daspro"));

    }   
}
