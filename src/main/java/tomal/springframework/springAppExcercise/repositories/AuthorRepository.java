package tomal.springframework.springAppExcercise.repositories;

import org.springframework.data.repository.CrudRepository;
import tomal.springframework.springAppExcercise.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
