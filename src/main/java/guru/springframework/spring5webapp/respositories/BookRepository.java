package guru.springframework.spring5webapp.respositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
