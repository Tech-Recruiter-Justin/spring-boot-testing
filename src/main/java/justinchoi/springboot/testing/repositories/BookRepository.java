package justinchoi.springboot.testing.repositories;

import justinchoi.springboot.testing.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
