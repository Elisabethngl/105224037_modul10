import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class SistemGudang {
    private HashMap<String, Barang> databaseBarang;
    private HashSet<String> kategoriUnik;
    private ArrayList<String> riwayat;

    public SistemGudang() {
        databaseBarang = new HashMap<>();
        kategoriUnik = new HashSet<>();
        riwayat = new ArrayList<>();
    }

    public void tambahBarangBaru(String id, String nama, String kategori, int stok) {
        Barang barang = new Barang(id, nama, kategori, stok);
        databaseBarang.put(id, barang);
        kategoriUnik.add(kategori);
        riwayat.add("Barang Masuk: " + id + " - " + nama + " ditambahkan " + stok + " unit");
        System.out.println( nama + " berhasil ditambahkan.");
    }

    public void tambahStok(String id, int jumlah) {
        if (databaseBarang.containsKey(id)) {
            Barang barang = databaseBarang.get(id);
            barang.setStok(barang.getStok() + jumlah);
            riwayat.add("Stok Bertambah: " + id + " ditambah " + jumlah + " unit");
            System.out.println("Stok " + id + " berhasil ditambah " + jumlah + " unit.");
        } else {
            System.out.println("Gagal: ID " + id + " tidak ditemukan.");
            System.out.println();
        }
    }

    public void kurangiStok(String id, int jumlah) {
        if (!databaseBarang.containsKey(id)) {
            System.out.println("Gagal: ID " + id + " tidak ditemukan.");
            return;
        }

        Barang barang = databaseBarang.get(id);

        if (barang.getStok() < jumlah) {
            System.out.println("Gagal: Stok " + id + " tidak mencukupi. Stok saat ini: " + barang.getStok());
            return;
        }

        barang.setStok(barang.getStok() - jumlah);
        riwayat.add("Stok Berkurang: " + id + " dikurangi " + jumlah + " unit");
        System.out.println("Stok " + id + " berhasil dikurangi " + jumlah + " unit.");
    }

    public void cetakLaporan() {

        System.out.println("Kategori Tersedia");
        for (String kat : kategoriUnik) {
            System.out.println("  - " + kat);
        }

        System.out.println("Sisa Stok Semua Barang");
        for (Barang b : databaseBarang.values()) {
            System.out.println("  " + b.getIdBarang() + " | " + b.getNamaBarang() + " | Stok: " + b.getStok());
        }

        System.out.println();
        System.out.println(" Riwayat Transaksi ");
        for (String r : riwayat) {
            System.out.println("  " + r);
        }

    }
}