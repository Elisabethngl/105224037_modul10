import java.util.*;

public class Bioskop {
    public static void main(String[] args) {
        Map<String, Film> jadwal = new HashMap<>();
        jadwal.put("F01", new Film("Harry Potter", 55000));
        jadwal.put("F02", new Film("The Twilight", 50000));
        jadwal.put("F03", new Film("The Vampire Diaries", 45000));

        Set<String> kursiTerpakai = new HashSet<>();
        List<Tiket> riwayatTiket = new ArrayList<>();

        pesanTiket("Neila",  "F01", "A1", jadwal, kursiTerpakai, riwayatTiket);
        pesanTiket("Zakia",  "F02", "B2", jadwal, kursiTerpakai, riwayatTiket);
        pesanTiket("Elisabeth",  "F03", "C3", jadwal, kursiTerpakai, riwayatTiket);
        pesanTiket("Intan",  "F01", "A1", jadwal, kursiTerpakai, riwayatTiket);

        for (Tiket t : riwayatTiket) {
            t.cetakDetail();
        }
    }

    public static void pesanTiket(String nama, String kodeFilm, String kursi,
            Map<String, Film> jadwal, Set<String> kursiTerpakai, List<Tiket> riwayat) {
        if (!jadwal.containsKey(kodeFilm)) {
            System.out.println("Kode film " + kodeFilm + " tidak valid.");
            return;
        }

        Film filmDipilih = jadwal.get(kodeFilm);

        if (!kursiTerpakai.add(kursi)) {
            System.out.println("Kursi " + kursi + " sudah dipesan untuk film " + filmDipilih.judul + ".");
            return;
        }

        Tiket tiketBaru = new Tiket(nama, filmDipilih, kursi);
        riwayat.add(tiketBaru);
        System.out.println("Berhasil memesan kursi " + kursi + " untuk film " + filmDipilih.judul + ".");
    }
}