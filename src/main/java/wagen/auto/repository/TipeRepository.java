package wagen.auto.repository;

import org.springframework.data.repository.CrudRepository;
import wagen.auto.model.Tipe;

public interface TipeRepository extends CrudRepository<Tipe, Integer> {
}
