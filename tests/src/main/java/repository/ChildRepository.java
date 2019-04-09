package repository;

import entity.Child;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends CrudRepository<Child,Long> {
}
