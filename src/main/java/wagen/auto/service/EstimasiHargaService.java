package wagen.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wagen.auto.model.EstimasiHarga;
import wagen.auto.repository.EstimasiHargaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstimasiHargaService {

    @Autowired
    EstimasiHargaRepository EstimasiHargaRepository;

    public List<EstimasiHarga> getAllEstimasiHarga(){
        List<EstimasiHarga> EstimasiHargaList = (List<EstimasiHarga>) EstimasiHargaRepository.findAll();
        return EstimasiHargaList;
    }

    public List<EstimasiHarga> saveEstimasiHarga(EstimasiHarga EstimasiHarga){

        EstimasiHarga.setCreadate(new Date());
        EstimasiHarga.setModidate(new Date());
        EstimasiHarga.setCreaby(1);
        EstimasiHarga.setModiby(1);
        EstimasiHargaRepository.save(EstimasiHarga);
        return getAllEstimasiHarga();
    }

    public EstimasiHarga getEstimasiHargaById(int id_EstimasiHarga){
        Optional<EstimasiHarga> optional = EstimasiHargaRepository.findById(id_EstimasiHarga);
        EstimasiHarga EstimasiHarga = null;
        if(optional.isPresent()){
            EstimasiHarga = optional.get();
        }else  {
            throw  new RuntimeException("EstimasiHarga not found" + id_EstimasiHarga);
        }
        return EstimasiHarga;
    }

    public int update(int id_EstimasiHarga, EstimasiHarga EstimasiHarga){
        EstimasiHarga EstimasiHargas = EstimasiHargaRepository.findById(id_EstimasiHarga)
                .orElseThrow(() -> new IllegalArgumentException("Invalid EstimasiHarga Id:" + id_EstimasiHarga));
        EstimasiHargas.setEstimasi_harga(EstimasiHarga.getEstimasi_harga());
        EstimasiHargas.setModidate(new Date());
        EstimasiHargas.setModiby(2);
        EstimasiHargaRepository.save(EstimasiHargas);

        return 1;
    }

    public int deleteEstimasiHarga(int id_EstimasiHarga, EstimasiHarga EstimasiHarga){
        EstimasiHarga EstimasiHargas = EstimasiHargaRepository.findById(id_EstimasiHarga)
                .orElseThrow(() -> new IllegalArgumentException("Invalid EstimasiHarga Id:" + id_EstimasiHarga));
        EstimasiHargaRepository.delete(EstimasiHargas);

        return 1;
    }
}
