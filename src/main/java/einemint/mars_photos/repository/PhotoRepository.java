package einemint.mars_photos.repository;

import einemint.mars_photos.api.response.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
