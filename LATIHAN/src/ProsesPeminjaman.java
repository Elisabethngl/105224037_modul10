import java.util.*;

public class ProsesPeminjaman {
    static Map<String, String> bukuSedangDipinjam = new HashMap<>();
    static Set<Anggota> daftarAnggota;

    public static void setDaftarAnggota(Set<Anggota> daftar) {
        daftarAnggota = daftar;
    }

    public static boolean cekAnggotaTerdaftar(String idAnggota) {
        for (Anggota a : daftarAnggota) {
            if (a.getIdAnggota().equals(idAnggota)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cekBukuTersedia(String isbn) {
        return Buku.daftarBuku.containsKey(isbn);
    }

    public static boolean cekBukuBelumDipinjam(String isbn) {
        return !bukuSedangDipinjam.containsKey(isbn);
    }

    public static void prosesSemua() {
        String data;
        while ((data = AntreanPeminjaman.proses()) != null) {
            String[] parts = data.split("#");
            String idAnggota = parts[0];
            String isbn = parts[1];
            if (!cekAnggotaTerdaftar(idAnggota)) {
                System.out.println("GAGAL: Anggota " + idAnggota + " tidak terdaftar");
                continue;
            }
            if (!cekBukuTersedia(isbn)) {
                System.out.println("GAGAL: Buku ISBN " + isbn + " tidak ada di katalog");
                continue;
            }
            if (!cekBukuBelumDipinjam(isbn)) {
                System.out.println("GAGAL: Buku ISBN " + isbn + " sedang dipinjam oleh " + bukuSedangDipinjam.get(isbn));
                continue;
            }
            bukuSedangDipinjam.put(isbn, idAnggota);
            System.out.println("BERHASIL: " + idAnggota + " meminjam buku ISBN " + isbn);
        }
    }

    public static void tampilkanBukuSedangDipinjam() {
        System.out.println("=== BUKU SEDANG DIPINJAM ===");
        for (Map.Entry<String, String> entry : bukuSedangDipinjam.entrySet()) {
            System.out.println("ISBN: " + entry.getKey() + " | Dipinjam oleh: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Buku.daftarBuku.put("234-001", new Buku("234-001", "PBO"));
        Buku.daftarBuku.put("345-002", new Buku("345-002", "ASD"));
        Buku.daftarBuku.put("456-003", new Buku("456-003", "Daspro"));

        Set<Anggota> daftar = new HashSet<>();
        daftar.add(new Anggota("2345", "sabeth", "dosen"));
        daftar.add(new Anggota("3456", "neila",  "mahasiswa"));
        daftar.add(new Anggota("4567", "intan",  "dosen"));
        daftar.add(new Anggota("5678", "silvi",  "mahasiswa"));
        setDaftarAnggota(daftar);

        AntreanPeminjaman.tambah("2345", "234-001", "Mahasiswa");
        AntreanPeminjaman.tambah("3456", "345-002", "Dosen");
        AntreanPeminjaman.tambah("4567", "456-003", "Mahasiswa");
        AntreanPeminjaman.tambah("5678", "234-001", "Dosen");

        prosesSemua();
        tampilkanBukuSedangDipinjam();
    }
}