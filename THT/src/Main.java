public class Main {
    public static void main(String[] args) {
        SistemGudang gudang = new SistemGudang();

        gudang.tambahBarangBaru("B01", "Beras", "Sembako", 50);
        gudang.tambahBarangBaru("B02", "Minyak Goreng", "Sembako", 30);
        gudang.tambahBarangBaru("B03", "Laptop", "Elektronik", 10);

        gudang.tambahStok("B01", 20);
        gudang.kurangiStok("B02", 10);

        gudang.kurangiStok("B03", 50);

        gudang.cetakLaporan();
    }
}