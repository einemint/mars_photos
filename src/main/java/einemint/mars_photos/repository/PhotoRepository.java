package einemint.mars_photos.repository;

import einemint.mars_photos.model.Photo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    @Query("SELECT imgSrc FROM Photo photo")
    List<String> findImagesSources();
}
