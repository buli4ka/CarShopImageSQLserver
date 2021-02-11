package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.CarStructure.BodyType;


public interface BodyTypeRepository extends JpaRepository<BodyType,Integer> {

    BodyType findFirstByBodyTypeName(String bodyTypeName);
}
