package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.Montir;
import wagen.auto.repository.MontirRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MontirService {
    @Autowired
    MontirRepository montirRepository;

    public List<Montir> getAllMontir(){
        List<Montir> montirList = (List<Montir>) montirRepository.findAll();
        return montirList;
    }

    public List<Montir> saveMontir(Montir montir){
        montir.setStatus(1);
        montir.setCreadate(new Date());
        montir.setModidate(new Date());
        montir.setCreaby(1);
        montir.setModiby(1);
        montirRepository.save(montir);
        return getAllMontir();
    }

    public Montir getMontirById(int id_montir){
        Optional<Montir> optional = montirRepository.findById(id_montir);
        Montir montir = null;
        if(optional.isPresent()){
            montir = optional.get();
        }else  {
            throw  new RuntimeException("Montir not found" + id_montir);
        }
        return montir;
    }

    public int update(int id_montir, Montir montir){
        Montir montirs = montirRepository.findById(id_montir)
                .orElseThrow(() -> new IllegalArgumentException("Invalid montir Id:" + id_montir));
//        montirs.setNama_montir(montir.getNama_montir());
//        montirs.setTempat_lahir(montir.getTempat_lahir());
//        montirs.setTanggal_lahir(montir.getTanggal_lahir());
        montirs.setAlamat(montir.getAlamat());
        montirs.setNo_telp(montir.getNo_telp());
        montirs.setEmail(montir.getEmail());
        montirs.setModidate(new Date());
        montirs.setModiby(2);
        montirRepository.save(montirs);

        return 1;
    }

    public int deleteMontir(int id_montir, Montir montir){
        Montir montirs = montirRepository.findById(id_montir)
                .orElseThrow(() -> new IllegalArgumentException("Invalid montir Id:" + id_montir));
        montirs.setStatus(0);
        montirs.setModidate(new Date());
        montirs.setModiby(3);
        montirRepository.save(montirs);

        return 1;
    }
}
