package model;

public class Member {
    private String id;
    private String nama;
    private String tanggalLahir;
    private String alamat;
    private String email;
    private String noHP;
    
    public void setId(String id) {
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTanggalLahir(){
        return tanggalLahir;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getNoHP(){
        return noHP;
    }
}
