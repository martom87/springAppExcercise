package tomal.springframework.springAppExcercise.repositories;

import org.springframework.data.repository.CrudRepository;
import tomal.springframework.springAppExcercise.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
