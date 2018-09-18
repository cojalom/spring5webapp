package za.co.cjl.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.cjl.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
