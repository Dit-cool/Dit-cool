package wagen.auto.repository;

import org.springframework.data.repository.CrudRepository;
import wagen.auto.model.Model;

public interface ModelRepository extends CrudRepository<Model, Integer> {
}
