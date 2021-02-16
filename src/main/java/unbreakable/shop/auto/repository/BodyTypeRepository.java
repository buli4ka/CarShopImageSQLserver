package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.car_structure.BodyType;


public interface BodyTypeRepository extends JpaRepository<BodyType,Integer> {

    BodyType findFirstByBodyTypeName(String bodyTypeName);
}
