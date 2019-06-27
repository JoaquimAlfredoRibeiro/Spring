package pt.home.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.home.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
