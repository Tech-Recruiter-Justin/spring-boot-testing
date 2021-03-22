package justinchoi.springboot.testing.repositories;

import justinchoi.springboot.testing.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
