package guru.spring.sringwebapp.model.repositories;

import guru.spring.sringwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by said on 03/12/2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
