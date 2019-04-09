package repository;

import entity.Parent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends CrudRepository<Parent,Long> {
}
