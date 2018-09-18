package za.co.cjl.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.cjl.spring5webapp.model.PublisherAddress;

@Repository
public interface PublisherAddressRepository extends CrudRepository<PublisherAddress, Long> {
}
