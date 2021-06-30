package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.Merk;
import wagen.auto.model.Model;
import wagen.auto.repository.MerkRepository;
import wagen.auto.repository.ModelRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    @Autowired
    ModelRepository modelRepository;

    public List<Model> getAllModel(){
        List<Model> modelList = (List<Model>) modelRepository.findAll();
        return modelList;
    }

    public List<Model> saveMerk(Model model){
        model.setStatus(1);
        model.setCreadate(new Date());
        model.setModidate(new Date());
        model.setCreaby(1);
        model.setModiby(1);
        modelRepository.save(model);
        return getAllModel();
    }

    public Model getModelById(int id_model){
        Optional<Model> optional = modelRepository.findById(id_model);
        Model model = null;
        if(optional.isPresent()){
            model = optional.get();
        }else  {
            throw  new RuntimeException("Model not found" + id_model);
        }
        return model;
    }

    public int update(int id_model, Model model){
        Model models = modelRepository.findById(id_model)
                .orElseThrow(() -> new IllegalArgumentException("Invalid merk Id:" + id_model));
        models.setNama_model(model.getNama_model());
        models.setModidate(new Date());
        models.setModiby(2);
        modelRepository.save(models);

        return 1;
    }

    public int deleteMerk(int id_model, Model merk){
        Model models = modelRepository.findById(id_model)
                .orElseThrow(() -> new IllegalArgumentException("Invalid merk Id:" + id_model));
        models.setStatus(0);
        models.setModidate(new Date());
        models.setModiby(3);
        modelRepository.save(models);

        return 1;
    }

}
