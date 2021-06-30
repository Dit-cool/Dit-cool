package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.KatalogMobil;
import wagen.auto.repository.KatalogMobilRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KatalogMobilService {

    @Autowired
    KatalogMobilRepository KatalogMobilRepository;

    public List<KatalogMobil> getAllKatalogMobil(){
        List<KatalogMobil> KatalogMobilList = (List<KatalogMobil>) KatalogMobilRepository.findAll();
        return KatalogMobilList;
    }

    public List<KatalogMobil> saveKatalogMobil(KatalogMobil KatalogMobil){
        KatalogMobil.setStatus(1);
        KatalogMobil.setCreadate(new Date());
        KatalogMobil.setModidate(new Date());
        KatalogMobil.setCreaby(1);
        KatalogMobil.setModiby(1);
        KatalogMobilRepository.save(KatalogMobil);
        return getAllKatalogMobil();
    }

    public KatalogMobil getKatalogMobilById(int id_KatalogMobil){
        Optional<KatalogMobil> optional = KatalogMobilRepository.findById(id_KatalogMobil);
        KatalogMobil KatalogMobil = null;
        if(optional.isPresent()){
            KatalogMobil = optional.get();
        }else  {
            throw  new RuntimeException("KatalogMobil not found" + id_KatalogMobil);
        }
        return KatalogMobil;
    }

    public int update(int id_KatalogMobil, KatalogMobil KatalogMobil){
        KatalogMobil KatalogMobils = KatalogMobilRepository.findById(id_KatalogMobil)
                .orElseThrow(() -> new IllegalArgumentException("Invalid KatalogMobil Id:" + id_KatalogMobil));
        KatalogMobils.setHarga(KatalogMobil.getHarga());
        KatalogMobils.setModidate(new Date());
        KatalogMobils.setModiby(2);
        KatalogMobilRepository.save(KatalogMobils);

        return 1;
    }

    public int deleteKatalogMobil(int id_KatalogMobil, KatalogMobil KatalogMobil){
        KatalogMobil KatalogMobils = KatalogMobilRepository.findById(id_KatalogMobil)
                .orElseThrow(() -> new IllegalArgumentException("Invalid KatalogMobil Id:" + id_KatalogMobil));
        KatalogMobils.setStatus(0);
        KatalogMobils.setModidate(new Date());
        KatalogMobils.setModiby(3);
        KatalogMobilRepository.save(KatalogMobils);

        return 1;
    }
}
