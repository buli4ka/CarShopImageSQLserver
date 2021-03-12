package unbreakable.shop.auto.repository.car;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.car_structure.CarModel;
import unbreakable.shop.auto.entity.car_structure.Manufacturer;


public interface CarModelRepository extends JpaRepository<CarModel,Integer> {

    CarModel findByCarModelName(String name);
    CarModel findFirstByCarModelName(String name);
    CarModel findAllByManufacturer(Manufacturer manufacturer);



}
