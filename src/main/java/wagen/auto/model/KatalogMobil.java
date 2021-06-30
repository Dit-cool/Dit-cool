package wagen.auto.model;

import javax.persistence.*;
import java.util.Date;

@Entity

public class KatalogMobil {

    public Integer getId_katalog() {
        return id_katalog;
    }

    public void setId_katalog(Integer id_katalog) {
        this.id_katalog = id_katalog;
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

    public Integer getKapasitas_mesin() {
        return kapasitas_mesin;
    }

    public void setKapasitas_mesin(Integer kapasitas_mesin) {
        this.kapasitas_mesin = kapasitas_mesin;
    }

    public String getTransmisi_mesin() {
        return transmisi_mesin;
    }

    public void setTransmisi_mesin(String transmisi_mesin) {
        this.transmisi_mesin = transmisi_mesin;
    }

    public String getWarna_mobil() {
        return warna_mobil;
    }

    public void setWarna_mobil(String warna_mobil) {
        this.warna_mobil = warna_mobil;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_katalog;
    private Integer id_merk;
    private Integer id_tipe;
    private Integer tahun_pembuatan;
    private Integer kapasitas_mesin;
    private String transmisi_mesin;
    private String warna_mobil;
    private Integer harga;
    private Integer status;
    private Integer creaby;
    private Date creadate;
    private Integer modiby;
    private Date modidate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_merk", referencedColumnName = "id_merk", insertable = false, updatable = false)
    private Merk merkList;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipe", referencedColumnName = "id_tipe", insertable = false, updatable = false)
    private Tipe tipeList;


}
