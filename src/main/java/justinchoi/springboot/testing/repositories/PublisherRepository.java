package justinchoi.springboot.testing.repositories;

import justinchoi.springboot.testing.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
