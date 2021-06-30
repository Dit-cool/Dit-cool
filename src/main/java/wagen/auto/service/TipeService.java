package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.Tipe;
import wagen.auto.repository.TipeRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TipeService {

    @Autowired
    TipeRepository tipeRepository;


    public List<Tipe> getAllTipe(){
        List<Tipe> tipeList = (List<Tipe>) tipeRepository.findAll();
        return tipeList;
    }

    public List<Tipe> saveTipe(Tipe tipe){
        tipe.setStatus(1);
        tipe.setCreadate(new Date());
        tipe.setModidate(new Date());
        tipe.setCreaby(1);
        tipe.setModiby(1);
        tipeRepository.save(tipe);
        return getAllTipe();
    }
    public Tipe getTipeById(int id_tipe){
        Optional<Tipe> optional = tipeRepository.findById(id_tipe);
        Tipe tipe = null;
        if(optional.isPresent()){
            tipe = optional.get();
        }else  {
            throw  new RuntimeException("Tipe not found" + id_tipe);
        }
        return tipe;
    }

    public int update(int id_tipe, Tipe tipe){
        Tipe tipess = tipeRepository.findById(id_tipe)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tipe Id:" + id_tipe));
        tipess.setNama_tipe(tipe.getNama_tipe());
        tipess.setModidate(new Date());
        tipess.setModiby(2);
        tipeRepository.save(tipess);

        return 1;
    }
    public int deleteTipe(int id_tipe, Tipe tipe){
        Tipe tipess = tipeRepository.findById(id_tipe)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Tipe Id:" + id_tipe));
        tipess.setStatus(0);
        tipess.setModidate(new Date());
        tipess.setModiby(3);
        tipeRepository.save(tipess);

        return 1;
    }

}
