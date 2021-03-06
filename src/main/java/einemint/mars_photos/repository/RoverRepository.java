package einemint.mars_photos.repository;

import einemint.mars_photos.model.Rover;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoverRepository extends CrudRepository<Rover, Integer> {
}
