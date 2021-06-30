package wagen.auto.repository;

import org.springframework.data.repository.CrudRepository;
import wagen.auto.model.KatalogMobil;


public interface KatalogMobilRepository extends CrudRepository<KatalogMobil, Integer> {
}
