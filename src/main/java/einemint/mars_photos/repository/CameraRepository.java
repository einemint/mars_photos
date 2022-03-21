package einemint.mars_photos.repository;

import einemint.mars_photos.api.response.Camera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends CrudRepository<Camera, Integer> {
}
