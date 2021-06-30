package wagen.auto.repository;

import org.springframework.data.repository.CrudRepository;
import wagen.auto.model.Karyawan;


public interface KaryawanRepository extends CrudRepository<Karyawan, Integer> {
}
