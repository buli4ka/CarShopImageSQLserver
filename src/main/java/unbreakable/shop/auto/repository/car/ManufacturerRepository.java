package unbreakable.shop.auto.repository.car;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.car_structure.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer,Integer> {

    Manufacturer findFirstByManufacturerName(String name);

    Manufacturer deleteAllByManufacturerName(String manufacturer);


}
