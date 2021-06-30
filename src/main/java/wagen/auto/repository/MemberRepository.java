package wagen.auto.repository;

import org.springframework.data.repository.CrudRepository;
import wagen.auto.model.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {
}


