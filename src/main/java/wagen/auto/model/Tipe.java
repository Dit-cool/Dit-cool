package wagen.auto.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipe;
    private String nama_tipe;
    private Integer id_merk;
    private Integer status;
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

    public Integer getId_tipe() {
        return id_tipe;
    }

    public void setId_tipe(Integer id_tipe) {
        this.id_tipe = id_tipe;
    }

    public String getNama_tipe() {
        return nama_tipe;
    }

    public void setNama_tipe(String nama_tipe) {
        this.nama_tipe = nama_tipe;
    }

    public Integer getId_merk() {
        return id_merk;
    }

    public void setId_merk(Integer id_merk) {
        this.id_merk = id_merk;
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
}
