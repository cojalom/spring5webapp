package za.co.cjl.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.cjl.spring5webapp.model.Publisher;

public interface PublisherRepoistory extends CrudRepository<Publisher, Long> {
}
