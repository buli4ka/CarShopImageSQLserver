package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.CarStructure.Car;
import unbreakable.shop.auto.entity.CarStructure.CarModel;
import unbreakable.shop.auto.entity.CarStructure.Manufacturer;

import java.util.List;
import java.util.Set;


public interface CarModelRepository extends JpaRepository<CarModel,Integer> {

    CarModel findByCarModelName(String name);
    CarModel findFirstByCarModelName(String name);
    CarModel findAllByManufacturer(Manufacturer manufacturer);



}
