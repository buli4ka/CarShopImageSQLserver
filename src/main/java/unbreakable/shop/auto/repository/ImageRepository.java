package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.CarStructure.Image;

public interface ImageRepository extends JpaRepository<Image,Integer> {
}
