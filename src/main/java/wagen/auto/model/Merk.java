package wagen.auto.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Merk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_merk;
    private String nama_merk;
    private String asal_negara;
    private Integer status;
    private Integer creaby;
    private Date creadate;
    private Integer modiby;
    private Date modidate;

    public Integer getId_merk() {
        return id_merk;
    }

    public void setId_merk(Integer id_merk) {
        this.id_merk = id_merk;
    }

    public String getNama_merk() {
        return nama_merk;
    }

    public void setNama_merk(String nama_merk) {
        this.nama_merk = nama_merk;
    }

    public String getAsal_negara() {
        return asal_negara;
    }

    public void setAsal_negara(String asal_negara) {
        this.asal_negara = asal_negara;
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
