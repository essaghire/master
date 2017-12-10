package guru.spring.sringwebapp.model.repositories;

import guru.spring.sringwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by said on 03/12/2017.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
