package pt.home.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.home.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
