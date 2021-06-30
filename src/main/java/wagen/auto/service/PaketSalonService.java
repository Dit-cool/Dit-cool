package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.Merk;
import wagen.auto.model.PaketSalon;
import wagen.auto.repository.MerkRepository;
import wagen.auto.repository.PaketSalonRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PaketSalonService {
    @Autowired
    PaketSalonRepository paketSalonRepository;

    public List<PaketSalon> getAllPaketSalon(){
        List<PaketSalon> paketSalonList = (List<PaketSalon>) paketSalonRepository.findAll();
        return paketSalonList;
    }

    public List<PaketSalon> savePaketSalon(PaketSalon paketSalon){
        paketSalon.setStatus(1);
        paketSalon.setCreadate(new Date());
        paketSalon.setModidate(new Date());
        paketSalon.setCreaby(1);
        paketSalon.setModiby(1);
        paketSalonRepository.save(paketSalon);
        return getAllPaketSalon();
    }

    public PaketSalon getPaketSalonById(int id_paket){
        Optional<PaketSalon> optional = paketSalonRepository.findById(id_paket);
        PaketSalon paketSalon = null;
        if(optional.isPresent()){
            paketSalon = optional.get();
        }else  {
            throw  new RuntimeException("Paket salon not found" + id_paket);
        }
        return paketSalon;
    }

    public int update(int id_paket, PaketSalon paketSalon){
        PaketSalon paketSalons = paketSalonRepository.findById(id_paket)
                .orElseThrow(() -> new IllegalArgumentException("Invalid paket salon Id:" + id_paket));
        paketSalons.setNama_paket(paketSalon.getNama_paket());
        paketSalons.setDeskripsi(paketSalon.getDeskripsi());
        paketSalons.setHarga(paketSalon.getHarga());
        paketSalons.setModidate(new Date());
        paketSalons.setModiby(2);
        paketSalonRepository.save(paketSalons);

        return 1;
    }

    public int deletePaketSalon(int id_paket, PaketSalon paketSalon){
        PaketSalon paketSalons = paketSalonRepository.findById(id_paket)
                .orElseThrow(() -> new IllegalArgumentException("Invalid paket salon Id:" + id_paket));
        paketSalons.setStatus(0);
        paketSalons.setModidate(new Date());
        paketSalons.setModiby(3);
        paketSalonRepository.save(paketSalons);

        return 1;
    }
}
