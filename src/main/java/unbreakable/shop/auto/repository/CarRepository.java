package unbreakable.shop.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unbreakable.shop.auto.entity.car_structure.Car;
import unbreakable.shop.auto.entity.car_structure.Image;


public interface CarRepository extends JpaRepository<Car,Integer> {



}
