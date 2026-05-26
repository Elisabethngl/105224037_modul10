import java.util.*;

    class Anggota {
    private String idAnggota;
    private String nama;
    private String tipe;

    public Anggota(String idAnggota, String nama, String tipe) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    public String getIdAnggota(){ 
        return idAnggota; 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Anggota anggota = (Anggota) o;
        return Objects.equals(idAnggota, anggota.idAnggota);
    } 

    @Override
    public int hashCode() {
        return Objects.hash(idAnggota);
    } 
}
    public class Anggota1{
        public static void main (String[]args){
            Set<Anggota> daftarAnggota = new HashSet<>();
            daftarAnggota.add (new Anggota("2345", "sabeth", "dosen"));
            daftarAnggota.add (new Anggota("3456", "neila", "mahasiswa"));
            daftarAnggota.add (new Anggota("4567", "intan", "dosen"));
            daftarAnggota.add (new Anggota("5678", "silvi", "mahasiswa"));

            System.out.println(daftarAnggota.size()); 
        }
    }
