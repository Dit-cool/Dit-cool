package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.Karyawan;
import wagen.auto.model.Merk;
import wagen.auto.repository.KaryawanRepository;
import wagen.auto.repository.MerkRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KaryawanService {
    @Autowired
    KaryawanRepository karyawanRepository;

    public List<Karyawan> getAllKaryawan(){
        List<Karyawan> karyawanList = (List<Karyawan>) karyawanRepository.findAll();
        return karyawanList;
    }

    public List<Karyawan> saveKaryawan(Karyawan karyawan){
        karyawan.setStatus(1);
        karyawan.setCreadate(new Date());
        karyawan.setModidate(new Date());
        karyawan.setCreaby(1);
        karyawan.setModiby(1);
        karyawanRepository.save(karyawan);
        return getAllKaryawan();
    }

    public Karyawan getKaryawanById(int id_karyawan){
        Optional<Karyawan> optional = karyawanRepository.findById(id_karyawan);
        Karyawan karyawan = null;
        if(optional.isPresent()){
            karyawan = optional.get();
        }else  {
            throw  new RuntimeException("ID Karyawan not found" + id_karyawan);
        }
        return karyawan;
    }

    public int update(int id_karyawan, Karyawan karyawan){
        Karyawan karyawans = karyawanRepository.findById(id_karyawan)
                .orElseThrow(() -> new IllegalArgumentException("Invalid merk Id:" + id_karyawan));
        karyawans.setNama_karyawan(karyawan.getNama_karyawan());
        karyawans.setAlamat(karyawan.getAlamat());
        karyawans.setNo_telp(karyawan.getNo_telp());
        karyawans.setModidate(new Date());
        karyawans.setModiby(2);
        karyawanRepository.save(karyawans);

        return 1;
    }

    public int deleteKaryawan(int id_karyawan, Karyawan karyawan){
        Karyawan karyawans = karyawanRepository.findById(id_karyawan)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Karyawan Id:" + id_karyawan));
        karyawans.setStatus(0);
        karyawans.setModidate(new Date());
        karyawans.setModiby(3);
        karyawanRepository.save(karyawans);

        return 1;
    }

}
