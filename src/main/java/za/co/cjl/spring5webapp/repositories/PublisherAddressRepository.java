package za.co.cjl.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import za.co.cjl.spring5webapp.model.PublisherAddress;

public interface PublisherAddressRepository extends CrudRepository<PublisherAddress, Long> {
}
