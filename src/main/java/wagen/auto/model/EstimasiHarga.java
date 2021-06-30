package wagen.auto.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class EstimasiHarga {

    public EstimasiHarga() {
    }

    public Integer getId_estimasi_harga() {
        return id_estimasi_harga;
    }

    public void setId_estimasi_harga(Integer id_estimasi_harga) {
        this.id_estimasi_harga = id_estimasi_harga;
    }

    public Integer getId_merk() {
        return id_merk;
    }

    public void setId_merk(Integer id_merk) {
        this.id_merk = id_merk;
    }

    public Integer getId_tipe() {
        return id_tipe;
    }

    public void setId_tipe(Integer id_tipe) {
        this.id_tipe = id_tipe;
    }

    public Integer getTahun_pembuatan() {
        return tahun_pembuatan;
    }

    public void setTahun_pembuatan(Integer tahun_pembuatan) {
        this.tahun_pembuatan = tahun_pembuatan;
    }

    public String getEstimasi_harga() {
        return estimasi_harga;
    }

    public void setEstimasi_harga(String estimasi_harga) {
        this.estimasi_harga = estimasi_harga;
    }

    public Integer getCreaby() {
        return creaby;
    }

    public void setCreaby(Integer creaby) {
        this.creaby = creaby;
    }

    public Date getCreadate() {
        return creadate;
    }

    public void setCreadate(Date creadate) {
        this.creadate = creadate;
    }

    public Integer getModiby() {
        return modiby;
    }

    public void setModiby(Integer modiby) {
        this.modiby = modiby;
    }

    public Date getModidate() {
        return modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estimasi_harga;
    private Integer id_merk;
    private Integer id_tipe;
    private Integer tahun_pembuatan;
    private String estimasi_harga;
    private Integer creaby;
    private Date creadate;
    private Integer modiby;
    private Date modidate;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_merk", referencedColumnName = "id_merk", insertable = false, updatable = false)
    private Merk merkList;

    public Merk getMerkList() {
        return merkList;
    }

    public void setMerkList(Merk merkList) {
        this.merkList = merkList;
    }

    public Tipe getTipeList() {
        return tipeList;
    }

    public void setTipeList(Tipe tipeList) {
        this.tipeList = tipeList;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipe", referencedColumnName = "id_tipe", insertable = false, updatable = false)
    private Tipe tipeList;


}
