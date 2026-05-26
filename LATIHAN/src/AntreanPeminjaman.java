import java.util.LinkedList;

public class AntreanPeminjaman {
    static LinkedList<String> antrean = new LinkedList<>();

    public static void tambah(String idAnggota, String isbn, String tipe) {
        String data = idAnggota + "#" + isbn;
        if (tipe.equalsIgnoreCase("Dosen")) {
            antrean.addFirst(data);
        } else {
            antrean.addLast(data);
        }
    }

    public static String proses() {
        if (antrean.isEmpty())
            return null;
        return antrean.removeFirst();
    }

    public static void tampilkan() {
        System.out.println("\n=== ANTREAN ===");
        int no = 1;
        for (String item : antrean) {
            System.out.println(no++ + ". " + item);
        }
    }

    public static void main(String[] args) {
        tambah("2345", "234-001", "Mahasiswa");
        tambah("3456", "345-002", "Dosen");
        tambah("4567", "456-003", "Mahasiswa");
        tambah("5678", "234-001", "Dosen");

        tampilkan();
    }
}