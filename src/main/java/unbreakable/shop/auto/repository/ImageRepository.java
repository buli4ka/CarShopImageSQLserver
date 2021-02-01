package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import unbreakable.shop.auto.entity.Image;

public interface ImageRepository extends CrudRepository<Image,Integer> {
}
