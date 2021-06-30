package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.Merk;
import wagen.auto.repository.MerkRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MerkService {
    @Autowired
    MerkRepository merkRepository;

    public List<Merk> getAllMerk(){
        List<Merk> merkList = (List<Merk>) merkRepository.findAll();
        return merkList;
    }

    public List<Merk> saveMerk(Merk merk){
        merk.setStatus(1);
        merk.setCreadate(new Date());
        merk.setModidate(new Date());
        merk.setCreaby(1);
        merk.setModiby(1);
        merkRepository.save(merk);
        return getAllMerk();
    }

    public Merk getMerkById(int id_merk){
        Optional<Merk> optional = merkRepository.findById(id_merk);
        Merk merk = null;
        if(optional.isPresent()){
            merk = optional.get();
        }else  {
            throw  new RuntimeException("Merk not found" + id_merk);
        }
        return merk;
    }

    public int update(int id_merk, Merk merk){
        Merk merks = merkRepository.findById(id_merk)
                .orElseThrow(() -> new IllegalArgumentException("Invalid merk Id:" + id_merk));
        merks.setNama_merk(merk.getNama_merk());
        merks.setAsal_negara(merk.getAsal_negara());
        merks.setModidate(new Date());
        merks.setModiby(2);
        merkRepository.save(merks);

        return 1;
    }

    public int deleteMerk(int id_merk, Merk merk){
        Merk merks = merkRepository.findById(id_merk)
                .orElseThrow(() -> new IllegalArgumentException("Invalid merk Id:" + id_merk));
        merks.setStatus(0);
        merks.setModidate(new Date());
        merks.setModiby(3);
        merkRepository.save(merks);

        return 1;
    }
}
