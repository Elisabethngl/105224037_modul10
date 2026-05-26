class Tiket {
    String namaPemesan;
    Film filmDipilih;
    String nomorKursi;

    public Tiket(String namaPemesan, Film filmDipilih, String nomorKursi) {
        this.namaPemesan = namaPemesan;
        this.filmDipilih = filmDipilih;
        this.nomorKursi = nomorKursi;
    }

    public void cetakDetail() {
        System.out.println("Nama: " + namaPemesan +
                " | Film: " + filmDipilih.judul +
                " | Kursi: " + nomorKursi +
                " | Harga: Rp " + filmDipilih.harga);
    }
}